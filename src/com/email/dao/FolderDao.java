package com.email.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.email.models.Folder;
import com.email.commons.*;


public class FolderDao {
	
	public void addFolder(Folder folder) {
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			session.save(folder);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}
		
	}

}
