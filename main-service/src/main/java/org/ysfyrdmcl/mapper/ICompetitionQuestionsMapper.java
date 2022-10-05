package org.ysfyrdmcl.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.ysfyrdmcl.dto.request.CompetitionQuestionRequestDto;

import org.ysfyrdmcl.repository.entity.CompetitionQuestions;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICompetitionQuestionsMapper {
    ICompetitionQuestionsMapper INSTANCE = Mappers.getMapper(ICompetitionQuestionsMapper.class);


//@Mapping(target = "howManyChoice", source = "howManyOption")
    CompetitionQuestions toCompetitionQuestions(CompetitionQuestionRequestDto dto);
}
