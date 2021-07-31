package com.mallorcaWorks.service;

import com.mallorcaWorks.model.Account;
import com.mallorcaWorks.repository.AccountRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepo accountRepository;

    public void save(Account obj) {
        accountRepository.save(obj);
    }

    public void saveAll(List<Account> list) {
        accountRepository.saveAll(list);
    }

    public List<Account> getAll() {
        List<Account> accounts = Collections.emptyList();
        accountRepository.findAll().iterator().forEachRemaining(accounts::add);
        return accounts;
    }

    public Account getByUsername(String username) {
        return accountRepository.findById(username).orElse(null);
    }

    public void delete(String username) {
        accountRepository.deleteById(username);
    }

    public void updateUser(Account account) {
        // TODO
        Account account1 = accountRepository.findById(account.getUsername()).orElse(null);
        if(account1 != null) {

        }
    }
}
