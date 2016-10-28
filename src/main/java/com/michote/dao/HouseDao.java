package com.michote.dao;


import com.michote.entity.House;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

/**
 * Created by jtq603 on 10/15/16.
 */

@Repository
public interface HouseDao extends CrudRepository<House, Long> {

    /**
     * Return the user having the passed houseId or null if no house is found.
     *
     * @param houseId the house houseId.
     */
    public House findByHouseId(long houseId);

    public List<House> findByZip(String zip);

}

