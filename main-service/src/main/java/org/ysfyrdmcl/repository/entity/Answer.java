package org.ysfyrdmcl.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "answer")
@Entity
public class Answer extends SuperClass{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String answer;
    Long questionid;
    boolean istrue;
}
