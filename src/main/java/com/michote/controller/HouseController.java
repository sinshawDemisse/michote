package com.michote.controller;

import com.michote.responseObjects.HouseResponse;
import com.michote.service.HouseServiceInterface;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jtq603 on 10/23/16.
 */

@Controller
public class HouseController {

    /**
     * /create  --> Create a new user and save it in the database.
     *
     * @param houseResponse
     * @return A string describing if the user is succesfully created or not.
     */
    @Autowired
    private HouseServiceInterface houseServiceInterface;

    @RequestMapping(value = "house/create", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody HouseResponse houseResponse) {
        return houseServiceInterface.create(houseResponse);
    }
    @RequestMapping(value = "house/viewhousebyzip/{zip}",method = RequestMethod.GET)
    @ResponseBody
    public List<HouseResponse> houseListByZip(@PathVariable String zip){
    	return houseServiceInterface.viewHouseByZip(Integer.parseInt(zip));
    }
    
}
