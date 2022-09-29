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
@Table(name = "competition")
@Entity
public class Competition extends SuperClass{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String competitiontitle;
    @Transient
    List<Question> questionlist;

    Long rankid;
//    @Transient
//     List<User> userlist;
    @Column(name ="creator_id")
    Long creatorid;
}
