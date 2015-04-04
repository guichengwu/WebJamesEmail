package com.email.tests;


import org.junit.Test;
import com.email.dao.FolderDao;
import com.email.models.Folder;

public class FolderDaoTests {
	
	@Test
	public void testAddFolder() {
		Folder folder = new Folder(31, "ÊÕ¼şÏä");
		FolderDao folderDao = new FolderDao();
		folderDao.addFolder(folder);
	}

}
