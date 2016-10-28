package com.michote.service.imp;

import com.michote.dao.HouseDao;
import com.michote.dao.UserDao;
import com.michote.entity.House;
import com.michote.entity.User;
import com.michote.responseObjects.HouseResponse;
import com.michote.service.HouseServiceInterface;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.DateTimeAtProcessing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.assertj.core.api.Assertions.setRemoveAssertJRelatedElementsFromStackTrace;

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

	@Override
	public List<HouseResponse> viewHouseByZip(int zip) {
		List<House> houses = houseDao.findByZip(Integer.toString(zip));
		List<HouseResponse> houseResponses = new ArrayList<>();
		for (House house : houses) {
			HouseResponse houseResponse = new HouseResponse();
			houseResponse.setDescription(house.getDescription());
			houseResponse.setAddress1(house.getAddress1());
			houseResponse.setAddress2(house.getAddress2());
			if (house.getAvailableDate() != null) {
				houseResponse.setAvailableDate(sdf.format(house.getAvailableDate()));
			}
			houseResponse.setCat(house.getCat());
			houseResponse.setCity(house.getCity());
			houseResponse.setCountry(house.getCountry());
			houseResponse.setDog(house.getDog());
			houseResponse.setFurnished(house.getFurnished());
			houseResponse.setLaundry(house.getLaundry());
			houseResponse.setParking(house.getParking());
			if (house.getPostingDate() != null) {
				houseResponse.setPostingDate(sdf.format(house.getPostingDate()));
			}
			houseResponse.setRent(house.getRent());
			houseResponse.setSex(house.getSex());
			houseResponse.setSmoking(house.getSmoking());
			houseResponse.setState(house.getState());
			houseResponse.setTitle(house.getTitle());
			if (house.getUpdatedDate() != null) {
				houseResponse.setUpdatedDate(sdf.format(house.getUpdatedDate()));
			}
			houseResponse.setWheelChairAccessible(house.getWheelChairAccessible());
			houseResponse.setZip(houseResponse.getZip());
			houseResponses.add(houseResponse);
		}
		return houseResponses;
	}
}
