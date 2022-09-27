package org.ysfyrdmcl.services;

import org.springframework.stereotype.Service;
import org.ysfyrdmcl.dto.request.DoLoginRequest;
import org.ysfyrdmcl.dto.request.RegisterRequestDto;
import org.ysfyrdmcl.repository.IAuthRepository;
import org.ysfyrdmcl.repository.entity.Auth;
import org.ysfyrdmcl.repository.enums.Roles;
import org.ysfyrdmcl.utility.ServiceManager;

@Service
public class AuthService extends ServiceManager<Auth,Long> {
    private final IAuthRepository authRepository;

    public AuthService(IAuthRepository authRepository) {
        super(authRepository);
        this.authRepository = authRepository;
    }
    public boolean doLogin(DoLoginRequest dto){
        return authRepository.isExists(dto.getUsername(),
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
        return save(auth);
    }


}
