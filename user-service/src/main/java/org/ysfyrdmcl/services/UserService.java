package org.ysfyrdmcl.services;

import org.springframework.stereotype.Service;
import org.ysfyrdmcl.dto.request.NewUserCreateDto;
import org.ysfyrdmcl.repository.IUserProfileRepository;
import org.ysfyrdmcl.repository.entity.UserProfile;
import org.ysfyrdmcl.utility.ServiceManager;

@Service
public class UserService extends ServiceManager<UserProfile,Long> {
   private final IUserProfileRepository iUserProfileRepository;

    public UserService(IUserProfileRepository iUserProfileRepository) {
        super(iUserProfileRepository);
        this.iUserProfileRepository = iUserProfileRepository;
    }

    public UserProfile createUserProfile(NewUserCreateDto dto){
        return save(UserProfile.builder()
                .authid(dto.getAuthId())
                .username(dto.getUsername())
                .email(dto.getEmail())
                .build());
    }
}
