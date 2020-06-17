package com.omer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="KONU")
public class Konu {
	@Id
	@Column(name="ID")
	@SequenceGenerator(name="konu_seq",sequenceName = "konu_seq",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="konu_seq")
	private int id;
	
	@Column(name="konu_basligi")
	private String konuBasligi;
	
	@Column(name="konu_detay")
	private String konuDetay;
	
	

	public int getId() {
		return id;
	}

	public String getKonuBasligi() {
		return konuBasligi;
	}

	public void setKonuBasligi(String konuBasligi) {
		this.konuBasligi = konuBasligi;
	}

	public String getKonuDetay() {
		return konuDetay;
	}

	public void setKonuDetay(String konuDetay) {
		this.konuDetay = konuDetay;
	}

	

	public Konu() {
		super();
	}

	public Konu( String konuBasligi, String konuDetay) {
		super();
		
		this.konuBasligi = konuBasligi;
		this.konuDetay = konuDetay;
	}
}
