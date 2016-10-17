package com.michote.dao;

import com.michote.entity.HousePreference;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by jtq603 on 10/16/16.
 */
@Transactional
public interface HousePreferenceDao extends CrudRepository<HousePreference, Long> {

    /**
     * Return the user having the passed housePreferenceId or null if no house is found.
     *
     * @param housePreferenceId the user housePreferenceId.
     */
    public HousePreference findByHousePreferenceId(long housePreferenceId);

}
