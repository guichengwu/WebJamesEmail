package com.email.tests;


import org.junit.Test;

import com.email.dao.EmailUserDao;
import com.email.models.EmailUser;

public class EmailUserDaoTests {
	
	@Test
	public void testSaveUser() {
		EmailUser user = new EmailUser("878100317", "wuguichenglllll", "230703");
		EmailUserDao userDao = new EmailUserDao();
		boolean result = userDao.saveEmailUser(user);
		System.out.println(result);
	}
	
	@Test
	public void testExistUser() {
		EmailUserDao userDao = new EmailUserDao();
		boolean result = userDao.existEmailUser("878100317@qq.com");
		
		System.out.println(result);
	}
	
	@Test
	public void getUserIdByEmail() {
		EmailUserDao userDao = new EmailUserDao();
		int userId = userDao.getUserIdByEmail("wu@wetoband.com");
		System.out.println("userId: " + userId);
	}
	
	
}
