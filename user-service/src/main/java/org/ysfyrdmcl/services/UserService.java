package org.ysfyrdmcl.services;
import org.springframework.data.domain.*;
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

    /**
     * Geçerli sayfa ve sayfa uzunluğuna göre pageable nesnesi üretip
     * sayfa döner
     * @param currentPage
     * @param pageSize
     * @return
     */
    public Page<UserProfile> findAllPage(int currentPage, int pageSize, String sortParameter, String direction){
        Sort sort = Sort.by(Sort.Direction.fromString(direction),sortParameter);
        Pageable pageable = PageRequest.of(currentPage,pageSize,sort);
        return repository.findAll(pageable);
    }
    public Slice<UserProfile> findAllSlice(int currentPage, int pageSize, String sortParameter, String direction){
        Sort sort = Sort.by(Sort.Direction.fromString(direction),sortParameter);
        Pageable pageable = PageRequest.of(currentPage,pageSize,sort);
        return repository.findAll(pageable);
    }

//    public void clearCache(String key, String parameter){
//        cacheManager.getCache(key).evict(parameter);
//    }

    /**
     * [Method Adı] :: [Değer] -> id
     * Clear ->
     * @return
     */
//    @Cacheable(value = "userprofile_getall")
//    public List<UserProfile> getAllCache(){
//        return repository.findAll();
//    }
}