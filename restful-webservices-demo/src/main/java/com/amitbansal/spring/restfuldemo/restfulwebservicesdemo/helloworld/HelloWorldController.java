package com.amitbansal.spring.restfuldemo.restfulwebservicesdemo.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

//@GetMapping(path="/hello-world")
//@RequestMapping(method = RequestMethod.GET, path = "/hello-world")	
	@GetMapping(path="/hello-world")
	public String helloWorld(){
	return "Hello World!";
	}
	//create a bean and return it
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean(){
		return new HelloWorldBean("Hello World!");
	}
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldBean(@PathVariable String name){
		return new HelloWorldBean(String.format("Hello World!,%s",name));
	}
}