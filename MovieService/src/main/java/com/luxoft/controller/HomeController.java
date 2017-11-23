package com.luxoft.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Home Controller
 *
 * @author Jitender Kumar
 */

@RestController
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "MovieService application deployed successfully!!";
	}

}
