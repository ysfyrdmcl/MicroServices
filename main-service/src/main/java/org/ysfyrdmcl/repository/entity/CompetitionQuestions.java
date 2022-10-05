package org.ysfyrdmcl.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table
public class CompetitionQuestions extends SuperClass{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long questionid;
    Long competitionid;
    Long timeperquestion;
   // int howManyChoice;
//    @Transient
//    List<User>trueanswersbyusers;
//    @Transient
//    List<User> wronganswersbyusers;
}
