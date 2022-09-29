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
@Entity
@Table
public class ViewClass extends SuperClass{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long userid;
    Long questionid;
    Long viewdate;
}
