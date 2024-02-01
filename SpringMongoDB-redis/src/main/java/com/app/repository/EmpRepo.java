package com.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.entity.Emp;

public interface EmpRepo extends MongoRepository<Emp, String>{

}
