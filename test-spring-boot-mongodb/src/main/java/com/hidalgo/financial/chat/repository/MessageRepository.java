package com.hidalgo.financial.chat.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.hidalgo.financial.chat.entity.Message;
import com.hidalgo.financial.chat.exception.DAOException;

/**
 * Services over messages
 * 
 * @version 1.0 - 13/10/2016
 * @author Marcelo Hidalgo
 */
public interface MessageRepository extends MongoRepository<Message, String> {

	/**
	 * Return the last messages founded by user
	 * 
	 * @version 1.0 - 13/10/2016
	 * @author Marcelo Hidalgo
	 * @param idUser
	 *            : id user
	 * @param pageable
	 *            : object in order to get a specific amount of messages
	 * @return List<Message> : messages founded
	 * @throws DAOException
	 *             : exception in case of error
	 */
	@Query("{'userId' : ?0}")
	public List<Message> findByUserIdOrderByTimeAsc(String idUser, Pageable pageable) throws DAOException;
}
