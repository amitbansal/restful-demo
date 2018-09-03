package com.amitbansal.spring.restfuldemo.restfulwebservicesdemo.jpa.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.amitbansal.spring.restfuldemo.restfulwebservicesdemo.jpa.entities.UserEntity;

@Repository
@Transactional
public class UserEntityDaoService {
	@PersistenceContext
	private EntityManager entityManager;
	
	public long insert(UserEntity user){
		
		entityManager.persist(user);
		return user.getId();
	}
}
