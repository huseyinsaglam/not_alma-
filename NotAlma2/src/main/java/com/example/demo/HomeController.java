package com.example.demo;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Kisi;

@Controller
public class HomeController {
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model , HttpServletRequest req) {

		String message="huseyin_saglam";
		model.addAttribute("serverTime", message );
		
		return "home";
	}
	
	
	@RequestMapping(value = "/hs", method = RequestMethod.GET)
	public String home(Model model) throws HibernateException , PropertyVetoException , SQLException{

		
		String message="huseyin_saglam";
		model.addAttribute("serverTime", message );
		
		return "home";
	}
	
	
	@RequestMapping(value = "/error_404", method = RequestMethod.GET)
	public String error(Model model) {
		
		return "error_404";
	}
	
}
