package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;
import com.example.demo.model.User;
@RestController
@RequestMapping("/user")
public class UserController {
	
private final UserService userService;
	

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
