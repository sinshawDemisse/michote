package com.michote.service.imp;

import com.michote.dao.UserDao;
import com.michote.entity.User;
import com.michote.responseObjects.UserResponse;
import com.michote.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by jtq603 on 10/23/16.
 */
@Component
public class UserServiceImp implements UserServiceInterface {

    @Autowired
    private UserDao userDao;

    @Override
    public String create(UserResponse userResponse) {
        User user = null;
        try {
            user = new User();
            user.setEmail(userResponse.getEmail());
            user.setPassword(userResponse.getPassword());
            user.setFirstName(userResponse.getFirstName());
            user.setLastName(userResponse.getLastName());
            user.setContactPreference(userResponse.getContactPreference());
            user.setSecondaryPhone(userResponse.getSecondaryPhone());
            user.setUserId(userResponse.getUserId());
            user.setPhoneNo(userResponse.getPhoneNo());
            userDao.save(user);
        } catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created! (id = " + user.getUserId() + ")";

    }
}
