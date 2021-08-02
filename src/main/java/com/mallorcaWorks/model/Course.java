package com.mallorcaWorks.model;


import java.sql.Date;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "level")
    private String level;

    @Column(name = "begin_date")
    private Date beginDate;

    @Column(name = "end_date")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "teacher", referencedColumnName = "username")
    private Teacher teacher;

    @ManyToMany
    @JoinTable(
        name = "CoursesStudents",
        joinColumns =  @JoinColumn(name = "course", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "student", referencedColumnName = "id")
    )
    private Collection<Student> students;

}