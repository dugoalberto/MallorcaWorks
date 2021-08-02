package com.mallorcaWorks.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Data
@NoArgsConstructor
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

    @ManyToMany(mappedBy = "students")
    private Collection<Course> courses;
}
