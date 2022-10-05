package org.ysfyrdmcl.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class AuthServiceSecurity {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .addFilterBefore(null,null)
                .authorizeHttpRequests((requests) -> requests
                        .antMatchers("/v3/api/docs/**", "/swagger-ui/**").permitAll()
                        .anyRequest().authenticated())

                .formLogin();
        return http.build();
    }
}
