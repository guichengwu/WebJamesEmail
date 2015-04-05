package com.email.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.email.models.EmailUser;
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
	
	public int getFolderIdByUserIdAndFolderName(int userId, String folderName) {
        int folderId = 0;
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			String hql = "select folder from Folder folder where folder.userId = :userId and folder.folderName = :folderName";
			Folder folder = (Folder)session.createQuery(hql)
			                            .setLong("userId", userId)
			                            .setString("folderName", folderName)
			                            .uniqueResult();
			transaction.commit();
			folderId = folder.getFolderId();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return folderId;
	}

}
