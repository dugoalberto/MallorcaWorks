package com.mallorcaWorks.repository;

import com.mallorcaWorks.model.Account;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends CrudRepository<Account, String> { }
