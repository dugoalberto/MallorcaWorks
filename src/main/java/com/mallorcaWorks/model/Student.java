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
@Table(name = "Students")
public class Student{
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "language_level")
    private int languageLevel;

    @Column(name = "weeks")
    private int weeks;

    @Column(name = "nationality", nullable = false )
    private int nationality;

    @Column(name = "date_of_birth", columnDefinition = "date default null")
    private Date dateOfBirth;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", languageLevel=" + languageLevel +
                ", weeks=" + weeks +
                ", nationality=" + nationality +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
