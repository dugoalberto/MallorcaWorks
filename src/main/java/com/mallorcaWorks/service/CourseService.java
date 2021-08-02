package com.mallorcaWorks.service;

import com.mallorcaWorks.model.Course;
import com.mallorcaWorks.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseService{
    @Autowired
    private CourseRepo repository;

    public void save(Course obj){
        repository.save(obj);
    }

    public void saveAll(List<Course> list){
     repository.saveAll(list);
     }

     public List<Course> getAll() {
        return (List<Course>) repository.findAll();
     }

     public Course getById(int id) {
        return repository.findById(id).orElse(null);
     }

     public void delete(int id) {
        repository.deleteById(id);
     }

    public void updateCourse(Course course) {
        Course course1 = repository.findById(course.getId()).orElse(null);
        if(course1 != null) {
            course1.setLevel(course.getLevel());
            repository.save(course1);
        }
    }
}
