package org.ysfyrdmcl.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CompetitionQuestionRequestDto {
    String token;
    Long questionid;
    Long competitionid;
    Long timeperquestion;
    //int howManyOption;
}
