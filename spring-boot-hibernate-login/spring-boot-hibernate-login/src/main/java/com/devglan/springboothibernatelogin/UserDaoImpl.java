package com.devglan.springboothibernatelogin;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository


public class UserDaoImpl {
	
	 @Autowired
	    private EntityManager em;
	 
	 private SessionFactory sessionFactory;
	
	
	 public User save(User user) {
	        Session session = em.unwrap(Session.class);
	        session.persist(user);
	        return user;
	    }
	

}


