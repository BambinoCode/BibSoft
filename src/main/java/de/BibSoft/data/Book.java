package de.BibSoft.data;

import org.springframework.data.relational.core.mapping.Column;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Table(name="Bücher")
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	@Column
	private String speicherort;
	@Column
	private String dateiname;
	@Column
	private String dateiendung;
	
	public Book(){};
	
	public Book(String speicherort, String dateiname, String dateiendung) {
		this.speicherort = speicherort;
		this.dateiname   = dateiname;
		this.dateiendung = dateiendung;
	}
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
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
