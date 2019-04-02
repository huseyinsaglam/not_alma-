package com.example.demo;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {

		String message="huseyin_saglam";
		model.addAttribute("serverTime", message );
		
		return "index";
	}
	
	
	@RequestMapping(value = "/detay", method = RequestMethod.GET)
	public String detay(Model model) {

		
		return "detail";
	}
	
	@RequestMapping(value = "/error_404", method = RequestMethod.GET)
	public String error(Model model) {
		
		return "error_404";
	}
	
}
