package com.example.demo.dao;

import java.util.ArrayList;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Note;


@Repository
public class NoteDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	// getCurrentSession : mevcut session üzerinde iþlem yapar..iþlem kapsamýna baglýdýr.
	// iþlem bittiginde oturumu otomatik olarak siler ve kapatýr, böylece harici olarak yapmanýz gerekmez..
	public long insert(Note note)
	{
		return (long) sessionFactory.getCurrentSession().save(note);
		
	}
	
	public void uptade(Note note)
	{
		sessionFactory.getCurrentSession().update(note);
	}
	
	
	// burada gönderdigimiz notun içerisinde id varsa buna bakýyor güncelleme yapýyor yoksa id ekleme yapýyor..
//	public void persist (Note note)
//	{
//		sessionFactory.getCurrentSession().persist(note);
//	}
	
	
	public void delete(Note note)
	{
		sessionFactory.getCurrentSession().delete(note);
	}
	
	public ArrayList<Note> getAll()
	{
		Query query = sessionFactory.getCurrentSession().createQuery("From Note");
		return (ArrayList<Note>) query.getResultList();
	}
	
	
}
