package org.ysfyrdmcl.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CompetitionRequestDto {
    String token;
    @NotNull
    Long creatorid;
    @NotNull
    String competitiontitle;

    @NotNull
    String image;
    @NotNull
    int winners;
}