package com.angular.springboot.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "livre")
public class Livre {
	
	private long isbn;
	private String titre;
	private String adddate ;
	
	
	public Livre() {
		
	}
	
	
	
	public Livre(long isbn,String titre, String adddate) {
		super();
		this.isbn=isbn;
		this.titre = titre;
		this.adddate = adddate;
	}
	
	@Id
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	
	@Column(name = "titre", nullable = false)
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	

	@Column(name = "adddate", nullable = false)
	public String getadddate() {
		return adddate;
	}

	public void setadddate(String adddate) {

	this.adddate = adddate ;
	}



	@Override
	public String toString() {
		return "Livre [livre=" + titre + ", adddate=" + adddate + "]";
	}

	
	
	
}
