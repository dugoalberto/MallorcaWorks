package com.mallorcaWorks.repository;

import com.mallorcaWorks.model.Teacher;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo extends CrudRepository<Teacher, String> { }
