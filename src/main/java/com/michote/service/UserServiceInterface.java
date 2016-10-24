/**
 * 
 */
package com.michote.service;

import com.michote.responseObjects.UserResponse;
import org.springframework.stereotype.Service;

/**
 * @author aberehamwodajie
 *
 * Oct 11, 2016
 */

@Service
public interface UserServiceInterface {

   public String create(UserResponse userResponse);

}
