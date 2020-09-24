package com.marcelohidalgo.myMongoMicroservice.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.marcelohidalgo.myMongoMicroservice.entity.User;

public interface UserRepository extends MongoRepository<User, String> {

}
