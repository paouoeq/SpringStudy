package com.exam;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		String mesg = ctx.getMessage("greeting", null, null, Locale.KOREA);
		String mesg2 = ctx.getMessage("greeting", null, null, Locale.US);
		String mesg3 = ctx.getMessage("greeting", null, null, Locale.ITALY);
		
		System.out.println(mesg+" "+mesg2+" "+mesg3); 
		// spring.messages.fallback-to-system-locale=true : 안녕하세요 hello 안녕하세요
		// spring.messages.fallback-to-system-locale=false : 안녕하세요 hello default
	}

}