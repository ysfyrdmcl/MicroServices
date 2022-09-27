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
@Table(name = "tbluserprofile")
@Entity
public class UserProfile {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Long authid;
    String name;
    String username;
    String surname;
    String email;
    String phone;
    String photo;
    @Column(length = 1000)
    String address;
    @Column(length = 5000)
    String about;
    Long created;
    Long updated;
    boolean isactive;
}
