package com.michote.service;

import com.michote.responseObjects.HouseResponse;
import org.springframework.stereotype.Service;

/**
 * Created by jtq603 on 10/23/16.
 */
@Service
public interface HouseServiceInterface {

    public String create(HouseResponse houseResponse);

}
