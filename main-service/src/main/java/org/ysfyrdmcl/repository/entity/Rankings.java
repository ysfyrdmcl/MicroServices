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
@Table(name = "rankings")
@Entity
public class Rankings extends SuperClass{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        Long competitionid;
        Long userid;
        int userpoint;
        int rank;

}
