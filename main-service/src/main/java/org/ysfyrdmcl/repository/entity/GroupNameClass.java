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
@Table(name = "tbl_group_name")
public class GroupNameClass extends SuperClass{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
}
