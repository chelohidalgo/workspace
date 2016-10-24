package com.hidalgo.financial.chat.spring.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class FinancialChatFactory {

	private ApplicationContext applicationContext;
	private static final FinancialChatFactory INSTANCIA = new FinancialChatFactory();
	
	public FinancialChatFactory() {
		applicationContext  = new ClassPathXmlApplicationContext("/com/hidalgo/financial/chat/spring/config/applicationContext.xml");
	}
	
	public static FinancialChatFactory getInstancia()
	  {
	    return INSTANCIA;
	  }
	  
	  public Object getBean(String bean) throws Exception {
	    return INSTANCIA.applicationContext.getBean(bean);
	  }
	
}
