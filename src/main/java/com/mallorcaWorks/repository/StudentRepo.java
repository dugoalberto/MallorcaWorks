package com.mallorcaWorks.repository;

import com.mallorcaWorks.model.Course;
import com.mallorcaWorks.model.Student;
import com.mallorcaWorks.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends CrudRepository<Student, Integer> {
}
