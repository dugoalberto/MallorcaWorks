package com.mallorcaWorks.repository;

import com.mallorcaWorks.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends CrudRepository<Course, Integer> {
    Course findByIdNumber(int idNumber);
}
