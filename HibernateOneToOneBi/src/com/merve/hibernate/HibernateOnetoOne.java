package com.merve.hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.merve.Entity.Ogretmen;
import com.merve.Entity.OgretmenDetay;

public class HibernateOnetoOne {
	public static void main(String[] args) {
		SessionFactory sessionFactory
		= new Configuration()
			.configure("hibernate-config.xml")
			.addAnnotatedClass(Ogretmen.class)
			.addAnnotatedClass(OgretmenDetay.class)
			.buildSessionFactory();
		
		//create session
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		OgretmenDetay ogrDty=session.get(OgretmenDetay.class, 1);				
		session.getTransaction().commit();	
		session.close();
		System.out.println(ogrDty);
		System.out.println(ogrDty);
	}
}