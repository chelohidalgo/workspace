package com.hidalgo.financial.chat.test;

import com.hidalgo.financial.chat.service.IUserService;
import com.hidalgo.financial.chat.spring.config.FinancialChatFactory;

/**
 * Test beans configuration file
 * 
 * @version 1.0 - 13/10/2016
 * @author Marcelo Hidalgo
 */
public class TestFinancialFactory {

	public static void main(String[] args) {
		
		try {
			IUserService userService = (IUserService) FinancialChatFactory.getInstancia().getBean("userService");
			userService.consumir();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
