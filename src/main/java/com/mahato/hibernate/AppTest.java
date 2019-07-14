package com.mahato.hibernate;

import org.hibernate.Session;

public class AppTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
        session.beginTransaction();
        for ( int i=0; i<100; i++ ) {
	        User user = new User();
	        user.setName("PrasenjitMahato"+i);
	        user.setEmail("PrasenjitMahato"+i+"@yopmail.com");
	        session.persist(user);
	        if( i % 50 == 0 ) {
	               session.flush();
	               session.clear();
	            }
	        
        }
        session.getTransaction().commit();
        session.close();
        
	}

}
