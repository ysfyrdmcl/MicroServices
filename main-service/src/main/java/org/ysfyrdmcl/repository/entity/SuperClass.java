package org.ysfyrdmcl.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuperClass {
    @Enumerated(EnumType.STRING)
    State state;
    @Temporal(TemporalType.TIMESTAMP)
    Date createdDate=new Date();
    @Temporal(TemporalType.TIMESTAMP)
    Date updatedDate=new Date();
}
