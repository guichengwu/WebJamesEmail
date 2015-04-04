package com.email.dao;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.email.models.Email;
import com.email.commons.*;

public class EmailDao {
	
	public void saveEmail(Email email) {
		Session session = null;
		
		Transaction transaction = null;
		
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			session.save(email);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}

}
