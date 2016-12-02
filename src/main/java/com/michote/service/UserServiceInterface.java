/**
 * 
 */
package com.michote.service;

import org.springframework.stereotype.Service;

import com.michote.responseObjects.LoginRequestObject;
import com.michote.responseObjects.UserResponse;

/**
 * @author aberehamwodajie
 *
 * Oct 11, 2016
 */

@Service
public interface UserServiceInterface {

   public String create(UserResponse userResponse);
   public UserResponse Login(LoginRequestObject loginObject);

}
