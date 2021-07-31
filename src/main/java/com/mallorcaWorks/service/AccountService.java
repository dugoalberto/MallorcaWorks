package com.mallorcaWorks.service;

import com.mallorcaWorks.model.Account;
import com.mallorcaWorks.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepo accountRepository;

    public void save(Account obj){
        accountRepository.save(obj);
    }

    public void saveAll(List<Account> list){
        accountRepository.saveAll(list);
    }

    public List<Account> getAll() {
        return (List<Account>) accountRepository.findAll();
    }

    public Account getById(int id) {
        return accountRepository.findById(username).orElse(null);
    }

    public void delete(int id) {
        accountRepository.deleteById(id);
    }

    public void updateUser(Account account) {
        Account account1 = accountRepository.findById(account.getId()).orElse(null);
        if(account1 != null) {

        }
    }
}
