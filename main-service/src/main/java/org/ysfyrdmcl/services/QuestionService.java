package org.ysfyrdmcl.services;


import org.ysfyrdmcl.dto.request.AnswerRequestDto;
import org.ysfyrdmcl.dto.request.QuestionPackageDto;
import org.ysfyrdmcl.dto.request.QuestionRequestDto;
import org.ysfyrdmcl.repository.QuestionRepository;

import org.springframework.stereotype.Service;
import org.ysfyrdmcl.repository.entity.Question;

import java.util.List;

@Service
public class QuestionService extends ServiceManager<Question,Long> {
    private final QuestionRepository questionRepository;
//    private final AnswerService answerService;

    public QuestionService(QuestionRepository questionRepository,AnswerService answerService) {
        super(questionRepository);
        this.questionRepository = questionRepository;
       // this.answerService=answerService;
    }

//    public void save(QuestionPackageDto questionPackageDto){
//        QuestionRequestDto questionRequestDto = questionPackageDto.getQue();
//        List<AnswerRequestDto> answerRequestDtolist= questionPackageDto.getAnswers();
////        if(questionRequestDto.getQuestion()==null){
////
////        }
//        Question question = Question.builder()
//                .question(questionRequestDto.getQuestion())
//                .createdByUserId(questionRequestDto.getCreatedByUserId())
//                .howManyOption(answerRequestDtolist.size())
//                .questiontime(questionRequestDto.getQuestiontime())
//                .build();
//        save(question);
//
//        answerService.save(answerRequestDtolist,question.getId());
//
//
//    }
}
