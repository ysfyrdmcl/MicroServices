package org.ysfyrdmcl.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class QuestionPackageDto {
    private QuestionRequestDto que;
    private List<AnswerRequestDto> answers;
}
