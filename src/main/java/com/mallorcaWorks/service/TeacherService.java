package com.mallorcaWorks.service;

import com.mallorcaWorks.model.Teacher;
import com.mallorcaWorks.repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
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

    public Teacher getById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public void updateTeacher(Teacher teacher) {
    }

}