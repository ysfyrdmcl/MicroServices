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
@Table(name = "question")
@Entity
public class Question extends SuperClass{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @OneToOne @JoinColumn(referencedColumnName = "name")
    GroupNameClass groupNameClass;
    @Column(nullable = false, length = 750)
    String question;
    int howManyOption;
    @Column(name = "created_by_user_id")
    Long createdByUserId;
    Long questiontime;
}
