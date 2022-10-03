package org.ysfyrdmcl.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GroupNameRequestDto {
    @NotNull
    private String token;
    @NotNull @NotBlank @NotEmpty
    private String groupName;

}
