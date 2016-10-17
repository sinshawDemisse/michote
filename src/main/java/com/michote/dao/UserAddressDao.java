package com.michote.dao;

import com.michote.entity.UserAddress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jtq603 on 10/16/16.
 */
@Transactional
public interface UserAddressDao extends CrudRepository<UserAddress, Long> {

    /**
     * Return the user having the passed userAddressId or null if no userAddress is found.
     *
     * @param userAddressId the userAddress userAddressId.
     */
    public UserAddress findByUserAddressId(long userAddressId);

}
