package com.omer.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.omer.entity.Konu;
import com.omer.entity.Kurs;
import com.omer.entity.Ogretmen;
import com.omer.entity.OgretmenDetay;

public class HibernateOneToManyPrint {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Ogretmen.class)
				.addAnnotatedClass(OgretmenDetay.class)
				.addAnnotatedClass(Kurs.class)
				.addAnnotatedClass(Konu.class)
				.buildSessionFactory();
		// create session
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Ogretmen ogr = session.get(Ogretmen.class, 6);
		for (Kurs kurs : ogr.getKurslar()) {	
			System.out.println("Kurs: "+kurs.getKursAdi());
			
			for (Konu konu : kurs.getKonular()) {
				System.out.println("\t\t-"+konu.getKonuBasligi());		
			}
		}
		session.getTransaction().commit();
		session.close();
	}
}
