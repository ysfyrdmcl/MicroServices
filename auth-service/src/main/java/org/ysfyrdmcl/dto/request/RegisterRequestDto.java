package org.ysfyrdmcl.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ysfyrdmcl.repository.enums.Roles;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RegisterRequestDto {
    @NotNull
    @Size(min=3, max=20,message = "Kullanıcı adı en az 3 en fazla 20 karakter olabilir")
    String username;
    @NotNull
    String password;
    @NotNull
    @Email(message = "Email formata uygun değil")
    String email;
    Roles role;
    String roleAdminPassword;
}
