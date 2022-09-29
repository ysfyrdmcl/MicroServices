package org.ysfyrdmcl.services;

import org.springframework.stereotype.Service;
import org.ysfyrdmcl.dto.request.AnswerRequestDto;
import org.ysfyrdmcl.repository.AnswerRepository;
import org.ysfyrdmcl.repository.entity.Answer;


import java.util.List;


@Service
public class AnswerService extends ServiceManager<Answer,Long> {
    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        super(answerRepository);
        this.answerRepository = answerRepository;
    }

//    public void save(List<AnswerRequestDto>dto, Long answerid){
//        dto.stream().forEach(x->save(Answer.builder()
//                .answer(x.getAnswer())
//                .istrue(x.isIstrue())
//                .questionid(answerid)
//                .build()));
//
//    }
}
