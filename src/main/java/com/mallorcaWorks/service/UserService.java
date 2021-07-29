package com.mallorcaWorks.service;

import com.mallorcaWorks.model.User;
import com.mallorcaWorks.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

public class UserService{
    @Autowired
    private UserRepo repository;

    public void save(User obj){
        repository.save(obj);
    }

    public void saveAll(List<User> list){
        repository.saveAll(list);
    }

    public List<User> getAll() {
        return (List<User>) repository.findAll();
    }

    public User getById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public void updateUser(User user) {
    }

}