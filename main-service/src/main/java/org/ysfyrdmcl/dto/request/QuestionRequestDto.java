package org.ysfyrdmcl.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class QuestionRequestDto {


        String question;
        Long createdByUserId;
        Long questiontime;
        int totalanswer;
}
