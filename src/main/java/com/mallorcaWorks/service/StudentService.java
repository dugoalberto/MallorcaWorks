package com.mallorcaWorks.service;

import com.mallorcaWorks.model.Student;
import com.mallorcaWorks.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Student updatedUser = repository.findById(user.getId()).orElse(null);
        if(updatedUser != null) {
            updatedUser.setLanguageLevel(user.getLanguageLevel());
            updatedUser.setWeeks(user.getWeeks());
            updatedUser.setDateOfBirth(user.getDateOfBirth());
            updatedUser.setName(user.getName());
            updatedUser.setNationality(user.getNationality());
            updatedUser.setSurname(user.getSurname());
            updatedUser.setImage(user.getImage());
            repository.save(updatedUser);
        }
    }

}