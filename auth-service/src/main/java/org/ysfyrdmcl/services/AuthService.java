package org.ysfyrdmcl.services;

import org.springframework.stereotype.Service;
import org.ysfyrdmcl.dto.request.DoLoginRequest;
import org.ysfyrdmcl.dto.request.NewUserCreateDto;
import org.ysfyrdmcl.dto.request.RegisterRequestDto;
import org.ysfyrdmcl.manager.IUserManager;
import org.ysfyrdmcl.repository.IAuthRepository;
import org.ysfyrdmcl.repository.entity.Auth;
import org.ysfyrdmcl.repository.enums.Roles;
import org.ysfyrdmcl.utility.ServiceManager;

import java.util.Optional;

@Service
public class AuthService extends ServiceManager<Auth,Long> {
    private final IAuthRepository authRepository;
    private final IUserManager userManager;
    public AuthService(IAuthRepository authRepository, IUserManager userManager) {
        super(authRepository);
        this.authRepository = authRepository;
        this.userManager = userManager;
    }
    public Optional<Auth> dologin(DoLoginRequest dto){
        return authRepository.findOptionalByUsernameIgnoreCaseAndPassword(dto.getUsername(),
                dto.getPassword());
    }
    public Auth register(RegisterRequestDto dto){
        Auth auth;
        auth = Auth.builder()
                .password(dto.getPassword())
                .username(dto.getUsername())
                .build();
        if(dto.getRoleAdminPassword()!=null)
            if(dto.getRoleAdminPassword().equals("123456"))
                auth.setRole(dto.getRole()==null ? Roles.ADMIN : dto.getRole());
            else
                auth.setRole(Roles.USER);
        save(auth);
        userManager.NewUserCreate(
                NewUserCreateDto.builder()
                        .authId(auth.getId())
                        .email(dto.getEmail())
                        .username(dto.getUsername())
                        .build()
        );
        return auth;
    }


}