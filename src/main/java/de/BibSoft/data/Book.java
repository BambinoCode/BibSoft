package de.BibSoft.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
public class Book {
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String Id;
	private String speicherort;
	private String dateiname;
	private String dateiendung;
	
	public Book(){};
	
	public Book(String speicherort, String dateiname, String dateiendung) {
		this.speicherort = speicherort;
		this.dateiname   = dateiname;
		this.dateiendung = dateiendung;
	}
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	
	public String getSpeicherort() {
		return speicherort;
	}
	public void setSpeicherort(String speicherort) {
		this.speicherort = speicherort;
	}
	
	public String getDateiname() {
		return dateiname;
	}
	public void setDateiname(String dateiname) {
		this.dateiname = dateiname;
	}
	
	public String getDateiendung() {
		return dateiendung;
	}
	public void setDateiendung(String dateiendung) {
		this.dateiendung = dateiendung;
	}

}
