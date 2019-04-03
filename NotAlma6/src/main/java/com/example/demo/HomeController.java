package com.example.demo;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Note;
import com.example.demo.service.NoteService;

@Controller
public class HomeController {
	
	@Autowired
    private NoteService noteService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {

		String message="huseyin_saglam";
		model.addAttribute("serverTime", message );
		
		return "index";
	}
	
	
	@RequestMapping(value = "/detay", method = RequestMethod.GET)
	public String detay(Model model) {

		Note note = new Note();
		note.setTitle("Hello");
		note.setContent("How_are_you");
		note.setUser_id(1l);
		
		noteService.createNote(note);
		
		return "detail";
	}
	
	

	@RequestMapping(value = "/error_404", method = RequestMethod.GET)
	public String error(Model model) {
		
		return "error_404";
	}
	
}
