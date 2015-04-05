package com.email.dao;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.email.models.Email;
import com.email.commons.*;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<Email> getEmailForOutbox(int folderId) {
		List<Email> outboxEmail = new ArrayList<Email>();
		
		Session session = null;
		Transaction transaction = null;
		
		try {
		   session = HibernateSessionFactory.getSession();
		   transaction = session.beginTransaction();
		   String hql = "select email from Email email where email.folderId = :folderId";
		   outboxEmail = session.createQuery(hql)
		                    .setLong("folderId", folderId).list();
		   
		   transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return outboxEmail;
	}

}
