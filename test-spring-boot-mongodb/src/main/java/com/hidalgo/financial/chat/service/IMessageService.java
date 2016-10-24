package com.hidalgo.financial.chat.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.hidalgo.financial.chat.entity.Message;
import com.hidalgo.financial.chat.exception.FinancialChatException;

/**
 * Interface for services allowed with messsage
 * 
 * @version 1.0 - 13/10/2016
 * @author Marcelo Hidalgo
 */
public interface IMessageService extends Serializable {

	/**
	 * Save a message in the database
	 * 
	 * @version 1.0 - 13/10/2016
	 * @author Marcelo Hidalgo
	 * @param message
	 *            : object message
	 * @throws FinancialChatException
	 *             : exception in case of error
	 */
	public void saveMessage(Message message) throws FinancialChatException;

	/**
	 * Delete all the message in the database
	 * 
	 * @version 1.0 - 13/10/2016
	 * @author Marcelo Hidalgo
	 * @throws FinancialChatException
	 *             : exception in case of error
	 */
	public void deleteAll() throws FinancialChatException;

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
	 * @throws FinancialChatException
	 *             : exception in case of error
	 */
	public List<Message> findLastMessagesOrderByTimeAsc(String idUser, Pageable pageable) throws FinancialChatException;

}
