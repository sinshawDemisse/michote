package com.michote.controller;

import com.michote.dao.UserDao;
import com.michote.entity.User;
import com.michote.responseObjects.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jtq603 on 10/23/16.
 */

@Controller
public class UserController {
    /**
     * /create  --> Create a new user and save it in the database.
     *
     * @param userResponse
     * @return A string describing if the user is succesfully created or not.
     */
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "user/create", method = RequestMethod.POST)

    public String create(@RequestBody UserResponse userResponse) {
        User user = null;
        try {
            user = new User();
            user.setEmail(userResponse.getEmail());
            user.setPassword(userResponse.getPassword());
            user.setFirstName(userResponse.getFirstName());
            userDao.save(user);
        } catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "SampleUser succesfully created! (id = " + user.getUserId() + ")";
    }
}
