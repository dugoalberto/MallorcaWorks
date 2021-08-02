package com.mallorcaWorks.model;

import java.util.Collection;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("TEACHER")
public class Teacher extends User {
    
    @OneToMany(mappedBy = "teacher")
    private Collection<Course> courses;

    @Override
    public Role getRole() {
        return Role.TEACHER;
    }

}