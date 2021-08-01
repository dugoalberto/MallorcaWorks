package com.mallorcaWorks.service;

import com.mallorcaWorks.model.GrandMaster;
import com.mallorcaWorks.repository.GrandMasterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrandMasterService {

    @Autowired
    private GrandMasterRepo repository;

    public void save(GrandMaster obj) {
        repository.save(obj);
    }

    public void saveAll(List<GrandMaster> list){
        repository.saveAll(list);
    }

    public List<GrandMaster> getAll() {
        return (List<GrandMaster>) repository.findAll();
    }

    public GrandMaster getById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public void updateUser(GrandMaster user) {
        GrandMaster updatedUser = repository.findById(user.getId()).orElse(null);
        if (updatedUser != null){
            updatedUser.setName(user.getName());
            updatedUser.setSurname(user.getSurname());
            repository.save(updatedUser);
        }
    }

}
