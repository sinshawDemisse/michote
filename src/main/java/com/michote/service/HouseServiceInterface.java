package com.michote.service;

import com.michote.responseObjects.HouseResponse;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

/**
 * Created by jtq603 on 10/23/16.
 */
@Service
public interface HouseServiceInterface {

    public String create(HouseResponse houseResponse);
    
    public List<HouseResponse> viewHouseByZip(int zip);

}
