package com.amitbansal.spring.restfuldemo.restfulwebservicesdemo.jpa.runner;

import org.slf4j.Logger;
//import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.amitbansal.spring.restfuldemo.restfulwebservicesdemo.jpa.entities.UserEntity;
import com.amitbansal.spring.restfuldemo.restfulwebservicesdemo.jpa.service.UserEntityDaoService;

@Component
public class UserEntityDaoServiceCommandLineRunner implements CommandLineRunner{

	@Autowired
	private UserEntityDaoService userEntityDaoService; 
	
	private static final Logger log = LoggerFactory.getLogger(UserEntityDaoService.class);
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		UserEntity user = new UserEntity("Jack", "Admin");
		long id = userEntityDaoService.insert(user);
		log.info("New user is created"+user);
	}

}
