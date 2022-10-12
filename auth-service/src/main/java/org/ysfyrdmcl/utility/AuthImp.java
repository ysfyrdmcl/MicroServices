package org.ysfyrdmcl.utility;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.ysfyrdmcl.dto.request.RegisterRequestDto;
import org.ysfyrdmcl.repository.enums.Roles;
import org.ysfyrdmcl.services.AuthService;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class AuthImp {
    private final AuthService authService;
  //  @PostConstruct
    public void init() {
        authService.register(RegisterRequestDto.builder()
                .username("admin")
                .email("admin@admin.com")
                .password("123456")
                .role(Roles.ADMIN)
                .roleAdminPassword("123456")
                .build());
        authService.register(RegisterRequestDto.builder()
                .username("luffy")
                .email("luffy@op.com")
                .password("123456")
                .role(Roles.ADMIN)
                .roleAdminPassword("123456")
                .build());
        authService.register(RegisterRequestDto.builder()
                .username("nami")
                .email("nami@op.com")
                .password("12345")
                .role(Roles.USER)
                .roleAdminPassword("12345")
                .build());
        authService.register(RegisterRequestDto.builder()
                .username("usopp")
                .email("usopp@op.com")
                .password("12345")
                .role(Roles.USER)
                .roleAdminPassword("12345")
                .build());
        authService.register(RegisterRequestDto.builder()
                .username("zoro")
                .email("zoro@op.com")
                .password("12345")
                .role(Roles.USER)
                .roleAdminPassword("12345")
                .build());
        authService.register(RegisterRequestDto.builder()
                .username("sanji")
                .email("sanji@op.com")
                .password("12345")
                .role(Roles.USER)
                .roleAdminPassword("12345")
                .build());
        authService.register(RegisterRequestDto.builder()
                .username("brook")
                .email("brook@op.com")
                .password("12345")
                .role(Roles.USER)
                .roleAdminPassword("12345")
                .build());
        authService.register(RegisterRequestDto.builder()
                .username("chopper")
                .email("tonytony@op.com")
                .password("12345")
                .role(Roles.USER)
                .roleAdminPassword("12345")
                .build());
        authService.register(RegisterRequestDto.builder()
                .username("robin")
                .email("robin@op.com")
                .password("54321")
                .role(Roles.USER)
                .roleAdminPassword("54321")
                .build());
        authService.register(RegisterRequestDto.builder()
                .username("golDRoger")
                .password("12345")
                .email("roger@op.com")
                .role(Roles.USER)
                .roleAdminPassword("12345")
                .build());

    }
}
