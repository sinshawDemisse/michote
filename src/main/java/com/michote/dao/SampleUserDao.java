package com.michote.dao;


import com.michote.entity.SampleUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by jtq603 on 10/15/16.
 */

@Repository
public interface SampleUserDao extends CrudRepository<SampleUser, Long> {

    /**
     * Return the user having the passed email or null if no user is found.
     *
     * @param email the user email.
     */
    public SampleUser findByEmail(String email);
    /**
     * Return the user having the passed name or null if no user is found.
     *
     * @param name the user name.
     */
    public SampleUser findByName(String name);

} // class SampleUserDao
