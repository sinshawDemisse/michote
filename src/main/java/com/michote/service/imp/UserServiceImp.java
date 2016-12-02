package com.michote.service.imp;

import java.sql.Timestamp;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.michote.dao.UserDao;
import com.michote.entity.User;
import com.michote.responseObjects.LoginRequestObject;
import com.michote.responseObjects.UserResponse;
import com.michote.service.UserServiceInterface;

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
            user.setCreatedDate(new Timestamp(new Date().getTime()));
            user.setUpdatedDate(new Timestamp(new Date().getTime()));
            userDao.save(user);
        } catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created! (id = " + user.getUserId() + ")";

    }

	private static final Logger log = LoggerFactory.getLogger(UserServiceImp.class);


	@Override
	public UserResponse Login(LoginRequestObject loginObject) {

		String username = loginObject.getEmail();
		String password = loginObject.getPassword();

		if (username == null || password == null) {
			log.error("Misseing username or password");
			throw new IllegalArgumentException("Misseing username or password");
		}

		log.debug("email: " + username);
		log.error("password: " + password);
		log.error("username: " + username);

		if (!username.contains("@")) {
			log.debug("Invalid email: " + username);
			throw new IllegalArgumentException("Invalid Email");
		}

		/*UserResponse user = new UserResponse();

		user.setEmail("Abrishges@yahoo.com");
		user.setPassword("password");

		log.error("email: " + username);
		log.error("password: " + password);*/
		
		  //hashing password
		/*
		 * String passwordStr = (username + "." + password); final String
		 * hashedPassword = Hashing.sha256().hashString(passwordStr,
		 * StandardCharsets.UTF_8).toString(); log.debug("Hashed salt: " +
		 * hashedPassword.length());
		 */

		 User user = userDao.findByEmail(username);
		 UserResponse userRespose = new UserResponse();
		 
		 userRespose.setEmail(user.getEmail());
		 userRespose.setPassword(user.getPassword());
		 userRespose.setFirstName(user.getFirstName());
		 userRespose.setLastName(user.getLastName());
		 userRespose.setSecondaryPhone(user.getSecondaryPhone());
		 userRespose.setUserId(user.getUserId());
		 userRespose.setCreatedDate(user.getCreatedDate().toString());
		 userRespose.setUpdatedDate(user.getUpdatedDate().toString());

		
		if (!user.getPassword().equals(password)) {
			log.error("Invalid  password" + password);
			throw new IllegalArgumentException("Invalid username or password");
		}
		return userRespose;
	}

}
