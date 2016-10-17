/**
 * 
 */
package com.michote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author aberehamwodajie
 *
 * Oct 11, 2016
 */
@Controller
public class AngularTest {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String homepage(){
        return "index.html";
    }

}
