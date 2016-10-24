package com.hidalgo.financial.chat.test;

import com.hidalgo.financial.chat.service.IUserService;
import com.hidalgo.financial.chat.spring.config.FinancialChatFactory;

public class TestFindUserByFirstName {
	
public static void main(String[] args) {
		
		try {
			IUserService userService = (IUserService) FinancialChatFactory.getInstancia().getBean("userService");
			System.out.println("Customer found with findByFirstName('Alice'):");
			System.out.println("--------------------------------");
			System.out.println(userService.findByFirstName("Alice"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
