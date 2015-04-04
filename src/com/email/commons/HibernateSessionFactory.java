package com.email.commons;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateSessionFactory {
	
	private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";
	
	private static final ThreadLocal<Session> threadLocal = 
		new ThreadLocal<Session>();
	private static Configuration configuration = new Configuration();
	
	private static SessionFactory sessionFactory;
	
	private static String configFile = CONFIG_FILE_LOCATION;
	
	static {
		try {
			configuration.configure(configFile);
			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private HibernateSessionFactory() {}
	
	public static Session getSession() 
	         throws HibernateException {
		Session session = (Session) threadLocal.get();
	    
		if (session == null || !session.isOpen()) {
			if (sessionFactory == null) {
				rebuildSessionFactory();
			}
			session = (sessionFactory != null) ? sessionFactory.openSession()
					: null;
			threadLocal.set(session);
		}
		
		return session;
	}
	
	public static void rebuildSessionFactory() {
		try {
			configuration.configure(configFile);
			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void closeSession() throws HibernateException {
		Session session = (Session) threadLocal.get();
		threadLocal.set(null);
		if (session != null)
			session.close();
	}

	public static Configuration getConfiguration() {
		return configuration;
	}

	public static void setConfiguration(Configuration configuration) {
		HibernateSessionFactory.configuration = configuration;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void setSessionFactory(SessionFactory sessionFactory) {
		HibernateSessionFactory.sessionFactory = sessionFactory;
	}

	public static String getConfigFile() {
		return configFile;
	}

	public static void setConfigFile(String configFile) {
		HibernateSessionFactory.configFile = configFile;
	}
}
