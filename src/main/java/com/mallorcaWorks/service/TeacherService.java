package com.mallorcaWorks.service;

import com.mallorcaWorks.model.Teacher;
import com.mallorcaWorks.repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService{
    @Autowired
    private TeacherRepo repository;

    public void save(Teacher obj){
        repository.save(obj);
    }

    public void saveAll(List<Teacher> list){
        repository.saveAll(list);
    }

    public List<Teacher> getAll() {
        return (List<Teacher>) repository.findAll();
    }

    public Teacher getByUsername(String username) {
        return repository.findById(username).orElse(null);
    }

    public void delete(String username) {
        repository.deleteById(username);
    }

    public void updateTeacher(Teacher teacher) {
        Teacher updatedTeacher = repository.findById(teacher.getUsername()).orElse(null);
        if(updatedTeacher != null ){
            updatedTeacher.setName(teacher.getName());
            updatedTeacher.setSurname(teacher.getSurname());
            repository.save(updatedTeacher);
        }
    }

}