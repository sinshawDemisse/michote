package com.michote.dao;

import com.michote.entity.HouseAddress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jtq603 on 10/16/16.
 */
@Transactional
public interface HouseAddressDao extends CrudRepository<HouseAddress, Long> {

    /**
     * Return the user having the passed houseAddressId or null if no user is found.
     *
     * @param houseAddressId the user houseAddressId.
     */
    public HouseAddress findByHouseAddressId(long houseAddressId);

}
