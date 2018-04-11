package com.hidalgo.sicpa.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {
private static final Logger LOG = Logger.getLogger(WebController.class);
	
	@RequestMapping(value="/",method = RequestMethod.GET)
    public String getLoginPage(){
		LOG.info("entroooooooooooooooooo");
        return "index";
    }
	
}