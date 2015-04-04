package com.email.tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import com.email.dao.EmailDao;
import com.email.models.Email;


public class EmailDaoTests {
	
	@Test
	public void testSaveEmail() {
		//GregorianCalendar calendar = new GregorianCalendar();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
        System.out.println(dateFormat.format(date));
		Email email= new Email(1,"878100317@qq",false,"fuck you",
				"add email", false, date);
		EmailDao emailDao = new EmailDao();
		emailDao.saveEmail(email);
	}

}
