package com.mallorcaWorks.service;

import com.mallorcaWorks.model.Course;
import com.mallorcaWorks.model.Student;
import com.mallorcaWorks.model.User;
import com.mallorcaWorks.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
@Service
public class StudentService{
    @Autowired
    private StudentRepo repository;

    public void save(Student obj){
        repository.save(obj);
    }

    public void saveAll(List<Student> list){
        repository.saveAll(list);
    }

    public List<Student> getAll() {
        return (List<Student>) repository.findAll();
    }

    public Student getById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public void updateUser(Student user) {
        Student user1 = repository.findById(user.getId()).orElse(null);
        if(user1 != null) {
            user1.setLanguageLevel(user.getLanguageLevel());
            user1.setWeeks(user.getWeeks());
            user1.setDateOfBirth(user.getDateOfBirth());
            user1.setName(user.getName());
            user1.setNationality(user.getNationality());
            user1.setSurname(user.getSurname());
            repository.save(user1);
        }
    }

}