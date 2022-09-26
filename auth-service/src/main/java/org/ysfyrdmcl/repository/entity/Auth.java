package org.ysfyrdmcl.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ysfyrdmcl.repository.enums.Roles;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name ="tblauth")
public class Auth {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    Roles role;

}
