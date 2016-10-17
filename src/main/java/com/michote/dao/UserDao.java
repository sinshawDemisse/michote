package com.michote.dao;


import com.michote.entity.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by jtq603 on 10/15/16.
 */

@Transactional
public interface UserDao extends CrudRepository<User, Long> {

    /**
     * Return the user having the passed email or null if no user is found.
     *
     * @param email the user email.
     */
    public User findByEmail(String email);
    /**
     * Return the user having the passed name or null if no user is found.
     *
     * @param name the user name.
     */
    public User findByName(String name);

} // class UserDao
