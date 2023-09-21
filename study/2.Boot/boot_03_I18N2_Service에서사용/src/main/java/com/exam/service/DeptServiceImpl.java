package com.exam.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service("xxx")
public class DeptServiceImpl {
	
	@Autowired
	MessageSource ctx;
	
	public void mesg() {
		String mesg = ctx.getMessage("greeting", null, null, Locale.KOREA);
		String mesg2 = ctx.getMessage("greeting", null, null, Locale.US);
		String mesg3 = ctx.getMessage("greeting", null, null, Locale.ITALY);
		
		System.out.println(mesg+" "+mesg2+" "+mesg3); 
		// spring.messages.fallback-to-system-locale=true : 안녕하세요 hello 안녕하세요
		// spring.messages.fallback-to-system-locale=false : 안녕하세요 hello default
	}
}
