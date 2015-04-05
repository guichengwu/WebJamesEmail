package com.email.tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Iterator;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import com.email.dao.EmailDao;
import com.email.models.Email;


public class EmailDaoTests {
	
/*	@Test
	public void testSaveEmail() {
		//GregorianCalendar calendar = new GregorianCalendar();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
        System.out.println(dateFormat.format(date));
		Email email= new Email(1,"878100317@qq",false,"fuck you",
				"add email", false, date);
		EmailDao emailDao = new EmailDao();
		emailDao.saveEmail(email);
	}*/
	
	@Test
	public void testGetEmailForOutbox() {
		List<Email> emails = new ArrayList<Email>();
		
		EmailDao emailDao = new EmailDao();
		emails = emailDao.getEmailForOutbox(27);
		
		for (Iterator<Email> i = emails.iterator(); i.hasNext();) {
			Email email = i.next();
			System.out.println(email.getSubject());
			System.out.println(email.getEmailAddress());
			System.out.println(email.getEmailContent());
		}
	}

}
