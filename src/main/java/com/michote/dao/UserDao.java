package com.michote.dao;


import com.michote.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by jtq603 on 10/15/16.
 */

@Repository
public interface UserDao extends CrudRepository<User, Long> {

    /**
     * Return the user having the passed userId or null if no user is found.
     *
     * @param userId the user userId.
     */
    public User findByUserId(long userId);

    /**
     * Return the user having the passed email or null if no user is found.
     *
     * @param email the user email.
     */
    public User findByEmail(String email);


}

