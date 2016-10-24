package com.hidalgo.financial.chat.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hidalgo.financial.chat.entity.Profile;

/**
 * Services allowed for profile
 * 
 * @version 1.0 - 13/10/2016
 * @author Marcelo Hidalgo
 */
public interface ProfileRepository extends MongoRepository<Profile, String> {

}
