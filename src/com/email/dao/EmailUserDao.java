package com.email.dao;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.email.commons.HibernateSessionFactory;
import com.email.models.EmailUser;

public class EmailUserDao {
	
	public boolean saveEmailUser(EmailUser emailUser) {
		
		boolean result = false;
		if (existEmailUser(emailUser.getUserEmail()))
			return result;
		else {
			result = true;
		}
		
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			 session.save(emailUser);
			transaction.commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}
		
		return result;
	}
	
	public boolean existEmailUser(String userEmail) {
		EmailUser emailUser = new EmailUser();
		boolean exist = false;
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			String hql = "select user from EmailUser user where user.userEmail = :userEmail";
			 emailUser = (EmailUser)session.createQuery(hql)
			                .setString("userEmail", userEmail)
			                .uniqueResult();
			 
			 transaction.commit();
			                
			if (emailUser != null) {
				exist = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return exist;
	}
	
	public boolean findEmailUser(String userEmail, String password) {
		boolean find = false;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			String hql = "select user from EmailUser user where user.userEmail = :userEmail and user.password = :password";
			EmailUser emailUser = (EmailUser)session.createQuery(hql)
			                            .setString("userEmail", userEmail)
			                            .setString("password", password)
			                            .uniqueResult();
			
			transaction.commit();
			System.out.println(emailUser.getUserName());
			if (emailUser != null)
				find = true;
			else 
				find = false;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}
		return find;
	}
	
	public List<EmailUser> getEmailUsers() {
		List<EmailUser> emailUsers = new ArrayList<EmailUser>();
		
		Session session = null;
		try {
			session = HibernateSessionFactory.getSession();
			emailUsers = session.createQuery("from EmailUser order by userEmailId").list();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}
		
		return emailUsers;
	}
	
	public int getUserIdByEmail(String userEmail) {
		int userId = 0;
		EmailUser emailUser = new EmailUser();
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			String hql = "select user from EmailUser user where user.userEmail = :userEmail";
			 emailUser = (EmailUser)session.createQuery(hql)
			                .setString("userEmail", userEmail)
			                .uniqueResult();
			 
			 transaction.commit();
			 
			 userId = emailUser.getUserId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return userId;
	}

}
