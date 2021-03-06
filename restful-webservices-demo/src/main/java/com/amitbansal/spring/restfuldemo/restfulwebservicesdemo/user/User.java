package com.amitbansal.spring.restfuldemo.restfulwebservicesdemo.user;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description ="All details about the user.")
@Entity
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	@Size(min=2, message ="Name should be atleast 2 chars")
	@ApiModelProperty(notes = "Name should be atleast 2 chars")
	private String name;
	
	@Past
	@ApiModelProperty(notes = "Birth date should be in past")
	private Date birthDate;
	
	@OneToMany(mappedBy="user")
	private List<Post> posts;
	
	protected User(){
		
	}
	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
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
