package com.amitbansal.spring.restfuldemo.restfulwebservicesdemo.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@RestController
public class UserResourceJpaController {
	
	@Autowired	
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping(path = "/jpa/users")
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}
	@GetMapping(path = "/jpa/user/{id}")
	public Resource<User> retrieveUser(@PathVariable int id) {
		Optional<User> user =  userRepository.findById(id);
		if(!user.isPresent()){
			throw new UserNotFoundException("id is"+id);
		}
		Resource<User> resource = new Resource<User>(user.get());
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		resource.add(linkTo.withRel("all-users"));
		
		return resource;
	}
	
	@DeleteMapping(path = "/jpa/user/{id}")
	public void deleteUser(@PathVariable int id) {
		Optional<User> user =  userRepository.findById(id);
		if(!user.isPresent()){
			throw new UserNotFoundException("id is"+id);
		}
		userRepository.deleteById(id);		
		
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
		User savedUser  = userRepository.save(user);
		//created
		//expose the URI of the created user in the response.
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savedUser.getId())
		.toUri();
		return ResponseEntity.created(location).build();
		
	}
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrievePosts(@PathVariable int id){
		Optional<User> userOptional = userRepository.findById(id);
		if(!userOptional.isPresent()){
			throw new UserNotFoundException("id is "+ id);
		}
		return userOptional.get().getPosts();
		
	}
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post){
		Optional<User> userOptional = userRepository.findById(id);
		if(!userOptional.isPresent()){
			throw new UserNotFoundException("id is "+ id);
		}
		
		User user = userOptional.get();
		post.setUser(user);
		postRepository.save(post);
		//created
		//expose the URI of the created user in the response.
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(post.getId())
		.toUri();
		return ResponseEntity.created(location).build();
		
	}	
}
