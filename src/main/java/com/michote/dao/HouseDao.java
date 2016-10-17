package com.michote.dao;


import com.michote.entity.House;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by jtq603 on 10/15/16.
 */

@Transactional
public interface HouseDao extends CrudRepository<House, Long> {

    /**
     * Return the user having the passed houseId or null if no house is found.
     *
     * @param houseId the house houseId.
     */
    public House findByHouseId(long houseId);



}

