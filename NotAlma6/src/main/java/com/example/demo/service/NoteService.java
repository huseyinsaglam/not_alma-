package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.NoteDAO;
import com.example.demo.entity.Note;

@Service
@Transactional
public class NoteService {
	
	@Autowired
	private NoteDAO noteDAO;

	
	public Long createNote(Note note)
	{
		return noteDAO.insert(note);
	}


	

	
}
