package com.hidalgo.financial.chat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hidalgo.financial.chat.entity.Message;
import com.hidalgo.financial.chat.exception.FinancialChatException;
import com.hidalgo.financial.chat.repository.MessageRepository;
import com.hidalgo.financial.chat.service.IMessageService;

/**
 * Implementation of services allowed with messages
 * 
 * @version 1.0 - 13/10/2016
 * @author Marcelo Hidalgo
 */
@SuppressWarnings("serial")
@Service
public class MessageService implements IMessageService {

	private MessageRepository messageRepository;

	@Autowired
	public MessageService(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	@Override
	public void saveMessage(Message message) throws FinancialChatException {
		try {
			this.messageRepository.save(message);
		} catch (Exception e) {
			throw new FinancialChatException("Error: something wrong happen trying to save message");
		}
	}

	@Override
	public void deleteAll() throws FinancialChatException {
		try {
			this.messageRepository.deleteAll();
		} catch (Exception e) {
			throw new FinancialChatException("Error: something wrong happen trying to delete all Messages");
		}
	}

	@Override
	public List<Message> findLastMessagesOrderByTimeAsc(String idUser, Pageable pageable)
			throws FinancialChatException {
		try {
			return this.messageRepository.findByUserIdOrderByTimeAsc(idUser, pageable);
		} catch (Exception e) {
			throw new FinancialChatException("Error: something wrong happen trying to find the last messages by user");
		}
	}
}
