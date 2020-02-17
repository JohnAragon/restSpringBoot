package com.init.ittalent.users;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.init.ittalent.entitys.User;
import com.init.ittalent.users.dao.UsersDAO;

@RestController
@RequestMapping("users")

public class UsersRest {
	
	//Listar usuarios
	@Autowired
	private UsersDAO userDAO;
	@GetMapping
	public ResponseEntity<List<User>> getUsers(){
		List<User> users= userDAO.findAll();
		return ResponseEntity.ok(users);
	}
	
	//Ver un usuario
	@RequestMapping(value="{userId}", method = RequestMethod.GET)
	public ResponseEntity<User> getUserById(@PathVariable("userId") Integer UserId){
		Optional<User> optionalUser = userDAO.findById(UserId);
		if(optionalUser.isPresent()){
			return ResponseEntity.ok(optionalUser.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//Crear un usuario
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User newUser = userDAO.save(user);
		return ResponseEntity.ok(newUser);
	}
	

}
