package org.ysfyrdmcl.services;

import org.springframework.stereotype.Service;
import org.ysfyrdmcl.repository.IAuthRepository;
import org.ysfyrdmcl.repository.entity.Auth;
import org.ysfyrdmcl.utility.ServiceManager;


@Service
public class AuthService  extends ServiceManager<Auth,Long> {
    private final IAuthRepository authRepository;

    public AuthService(IAuthRepository authRepository) {
        super(authRepository);
        this.authRepository = authRepository;
    }
}
