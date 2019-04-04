package com.example.demo;

import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.Note;
import com.example.demo.service.NoteService;

@Controller
public class HomeController {
	
	@Autowired
    private NoteService noteService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model , HttpServletRequest req) {

		System.out.println(req.getRemoteAddr());
		model.addAttribute("baslik", "Not alma Web Sitesi");
		String message="huseyin_saglam";
		model.addAttribute("serverTime", message );
		
		model.addAttribute("notlar", noteService.getAll(1l));
		return "index";
	}
	
	
	@RequestMapping(value = "/detay", method = RequestMethod.GET)
	public String detay(Model model) {

//		Note note = new Note();
//		note.setTitle("Hello");
//		note.setContent("How_are_you");
//		note.setUser_id(1l);
//		
//		noteService.createNote(note);
		
		for(Note note : noteService.getAll())
		{
			System.out.println(note.getContent());
		}		
		return "detail";
	}
	
	
	@RequestMapping(value = "/ekle", method = RequestMethod.GET)
	public String ekle(Model model) {

		return "addNote";
	}
	
	// Notu kayýt ettikten sonra ön tarafa kayýt etme mesajý 
	// Ön tarafa istek attým bu ön tarafta requestbody istegi alýyorum
	@RequestMapping(value="/addNote", method=RequestMethod.POST)
	public ResponseEntity<String> addNote(@RequestBody Note note, HttpServletRequest request)
	{
		System.out.println(note.toString());
		noteService.createNote(note,request);
		return new ResponseEntity<>("OK",HttpStatus.OK);
	}
	

	@RequestMapping(value = "/error_404", method = RequestMethod.GET)
	public String error(Model model) {
		
		return "error_404";
	}
	
	@RequestMapping(value="/getNotes", method=RequestMethod.POST)
	public ResponseEntity<ArrayList<Note>> getNotes( HttpServletRequest request)
	{
		
		return new ResponseEntity<>(noteService.getAll(1l),HttpStatus.CREATED);
	}
	
}
