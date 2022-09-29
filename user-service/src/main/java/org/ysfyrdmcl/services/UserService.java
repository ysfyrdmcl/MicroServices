package org.ysfyrdmcl.services;

import org.springframework.stereotype.Service;
import org.ysfyrdmcl.dto.request.EditProfileRequestDto;
import org.ysfyrdmcl.dto.request.NewUserCreateDto;
import org.ysfyrdmcl.mapper.IUserProfileMapper;
import org.ysfyrdmcl.repository.IUserProfileRepository;
import org.ysfyrdmcl.repository.entity.UserProfile;
import org.ysfyrdmcl.utility.ServiceManager;

import java.util.Optional;

@Service
public class UserService extends ServiceManager<UserProfile,Long> {
    private final IUserProfileRepository repository;

    public UserService(IUserProfileRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public UserProfile createUserProfile(NewUserCreateDto dto) {
        return save(UserProfile.builder()
                .authid(dto.getAuthId())
                .username(dto.getUsername())
                .email(dto.getEmail())
                .build());
    }

    public Boolean updateUserProfile(EditProfileRequestDto dto, Long authid) {
        UserProfile userProfile = IUserProfileMapper.INSTANCE.toUserProfile(dto);
        Optional<UserProfile> optionalUserProfile = repository.findOptionalByAuthid(authid);
        if (optionalUserProfile.isEmpty()) return false;
        try {
            userProfile.setId(optionalUserProfile.get().getId());
            update(userProfile);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}