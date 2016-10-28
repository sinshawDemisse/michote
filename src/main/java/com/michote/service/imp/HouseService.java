package com.michote.service.imp;

import com.michote.dao.HouseDao;
import com.michote.dao.UserDao;
import com.michote.entity.House;
import com.michote.entity.User;
import com.michote.responseObjects.HouseResponse;
import com.michote.service.HouseServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jtq603 on 10/23/16.
 */
@Component
public class HouseService implements HouseServiceInterface {
    @Autowired
    private UserDao userDao;

    @Autowired
    private HouseDao houseDao;

    SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    Date date;

    @Override
    public String create(HouseResponse houseResponse) {
        House house = null;
        try {
            User user = userDao.findByUserId(houseResponse.getUserId());
            house = new House();
            house.setAddress1(houseResponse.getAddress1());
            house.setCountry(houseResponse.getCountry());
            house.setUser(user);
            house.setAddress2(houseResponse.getAddress2());
            if(houseResponse.getAvailableDate() != null){
                date = sdf.parse(houseResponse.getAvailableDate());
                house.setAvailableDate(new Timestamp(date.getTime()));
            }
            house.setCat(houseResponse.getCat());
            house.setCity(houseResponse.getCity());
            house.setDescription(houseResponse.getDescription());
            house.setDog(houseResponse.getDog());
            house.setFurnished(houseResponse.getFurnished());
            house.setLaundry(houseResponse.getLaundry());
            house.setWheelChairAccessible(houseResponse.getWheelChairAccessible());
            house.setZip(houseResponse.getZip());
            house.setTitle(houseResponse.getTitle());
            house.setState(houseResponse.getState());
            house.setSex(houseResponse.getSex());
            house.setSmoking(houseResponse.getSmoking());
            house.setRent(houseResponse.getRent());
            if(houseResponse.getPostingDate() != null){
                date = sdf.parse(houseResponse.getPostingDate());
                house.setPostingDate(new Timestamp(date.getTime()));
            }
            house.setParking(houseResponse.getParking());
            houseDao.save(house);

        } catch (Exception ex) {
            return "Error creating the house for a user: " + ex.toString();
        }


        return "created" + house.getHouseId();
    }
}
