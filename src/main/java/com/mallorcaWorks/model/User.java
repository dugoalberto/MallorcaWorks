package com.mallorcaWorks.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idNumber")
    private int idNumber;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "level")
    private int level;

    @Column(name = "weeks")
    private int weeks;

    @Column(name = "nationality", nullable = false )
    private int nationality;

    @Column(name = "dateOfBirth", columnDefinition = "date default null")
    private Date dateOfBirth;

    @Override
    public String toString() {
        return "User{" +
                "idNumber=" + idNumber +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", level=" + level +
                ", weeks=" + weeks +
                ", nationality=" + nationality +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
