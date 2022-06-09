package com.example.market.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.market.model.Container;
import com.example.market.model.StoreRequest;
import com.example.market.model.User;
import com.example.market.repo.ContainerRepository;
import com.example.market.repo.ImageRepository;
import com.example.market.repo.UserRepository;
import com.example.market.service.ContainerService;
import com.example.market.service.UserService;
import com.example.market.service.UtilityService;
@RestController
@RequestMapping("/user")
public class UserController {
	
@Autowired
private UtilityService utilityService;
private final UserService userService;

@Autowired
private UserRepository userRepository;
@Autowired
private ContainerRepository containerRepository;



	

    public UserController(UserService userService) {
        this.userService = userService;
    }
	
	/*@RequestMapping(value="/getUrl", method=RequestMethod.GET)
	  public User getURL() {
		User user = new User();
		user.setContainers(1,"c1");
		  
}*/
	// create image
    @PostMapping("/add")
    public ResponseEntity<User >addUser(@RequestBody User u) {
    
    	userService.addUser(u);
        ResponseEntity<User> user= new ResponseEntity<User>(u,HttpStatus.OK);
        return user;


    }
    
   
	

}
