package org.ysfyrdmcl.rabbitmq.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateUser implements Serializable {
    Long authid;
    String username;
    String password;
    String email;
}
