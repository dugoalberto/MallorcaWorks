package com.mallorcaWorks.repository;

import com.mallorcaWorks.model.GrandMaster;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrandMasterRepo extends CrudRepository<GrandMaster, Integer> { }
