package com.michote.dao;

import com.michote.entity.HouseContact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jtq603 on 10/16/16.
 */
@Transactional
public interface HouseContactDao extends CrudRepository<HouseContact, Long> {

    /**
     * Return the user having the passed houseContactId or null if no house is found.
     *
     * @param houseContactId the house userAddressId.
     */
    public HouseContact findByHouseContactId(long houseContactId);

}
