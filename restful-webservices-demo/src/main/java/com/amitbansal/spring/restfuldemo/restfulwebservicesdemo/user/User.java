package com.amitbansal.spring.restfuldemo.restfulwebservicesdemo.user;

import java.util.Date;

public class User {
	private Integer id;
	private String name;
	
	protected User(){
		
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	private Date birthDate;
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

}
