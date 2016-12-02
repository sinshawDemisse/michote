package com.michote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.michote.responseObjects.LoginRequestObject;
import com.michote.responseObjects.UserResponse;
import com.michote.service.UserServiceInterface;

/**
 * Created by jtq603 on 10/23/16.
 */

@RestController
public class UserController {
    /**
     * /create  --> Create a new user and save it in the database.
     *
     * @param userResponse
     * @return A string describing if the user is succesfully created or not.
     */
    @Autowired
    private UserServiceInterface userServiceInterface;

    @RequestMapping(value = "user/create", method = RequestMethod.POST)
    public String create(@RequestBody UserResponse userResponse) {
        return userServiceInterface.create(userResponse);
    }
    
    
    @RequestMapping(value = "user/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse login(@RequestBody LoginRequestObject loginObject){	
		return userServiceInterface.Login(loginObject);
    	
    }
    
    
    
}
