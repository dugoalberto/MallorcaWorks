package com.mallorcaWorks.model;

import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "Teachers")
public class Teacher extends User{
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @OneToOne(mappedBy = "")
    private User user;
}