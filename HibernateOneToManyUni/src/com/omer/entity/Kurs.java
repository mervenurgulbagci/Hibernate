package com.omer.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Kurs")
public class Kurs {

	@Id
	@Column(name="Id")
	@SequenceGenerator(name="kurs_seq",sequenceName="KURS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="kurs_seq")
	private Integer id;
	
	@Column(name="kurs_adi")
	private String kursAdi;
	
	@Column(name="saat")
	private Integer saat;
	
	
	@ManyToOne
	@JoinColumn(name="ogretmen_id")
	private Ogretmen ogretmen;


	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="kurs_id")
	private List<Konu> konular;
	
	public void addKonu(Konu konu) {
		if(konular==null) {
			konular= new ArrayList<Konu>();
		}
		konular.add(konu);
	}
	
	
	public List<Konu> getKonular() {
		return konular;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getKursAdi() {
		return kursAdi;
	}


	public void setKursAdi(String kursAdi) {
		this.kursAdi = kursAdi;
	}


	public Integer getSaat() {
		return saat;
	}


	public void setSaat(Integer saat) {
		this.saat = saat;
	}


	public Ogretmen getOgretmen() {
		return ogretmen;
	}


	public void setOgretmen(Ogretmen ogretmen) {
		this.ogretmen = ogretmen;
	}


	public Kurs(String kursAdi, Integer saat, Ogretmen ogretmen) {
		super();
		this.kursAdi = kursAdi;
		this.saat = saat;
		this.ogretmen = ogretmen;
	}


	public Kurs() {
		super();
	}
	
	
}
