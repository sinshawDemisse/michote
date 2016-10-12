/**
 * 
 */
package com.michote.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aberehamwodajie
 *
 * Oct 11, 2016
 */

@RestController
public class michoteController {
	
	@RequestMapping("/test")
	public String test(){
		
		return "Hello from Michote";
	}

}
