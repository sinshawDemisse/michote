package com.michote.service.imp;

import com.michote.dao.HouseDao;
import com.michote.dao.UserDao;
import com.michote.entity.House;
import com.michote.entity.User;
import com.michote.responseObjects.HouseResponse;
import com.michote.service.HouseServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by jtq603 on 10/23/16.
 */
@Component
public class HouseService implements HouseServiceInterface {
    @Autowired
    private UserDao userDao;

    @Autowired
    private HouseDao houseDao;

    @Override
    public String create(HouseResponse houseResponse) {
        House house = null;
        try {
            User user = userDao.findByUserId(houseResponse.getUserId());
            house = new House();
            house.setAddress1(houseResponse.getAddress1());
            house.setCountry(houseResponse.getCountry());
            house.setUser(user);
            houseDao.save(house);

        } catch (Exception ex) {
            return "Error creating the house for a user: " + ex.toString();
        }


        return "created" + house.getHouseId();
    }
}
