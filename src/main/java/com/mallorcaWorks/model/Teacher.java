package com.mallorcaWorks.model;

import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNumber")
    private int idNumber;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Override
    public String toString() {
        return "Teacher{" +
                "idNumber=" + idNumber +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}