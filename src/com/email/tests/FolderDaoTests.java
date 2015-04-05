package com.email.tests;


import org.junit.Test;
import com.email.dao.FolderDao;
import com.email.models.Folder;

public class FolderDaoTests {
	
	@Test
	public void testAddFolder() {
		Folder folder = new Folder(31, "�ռ���");
		FolderDao folderDao = new FolderDao();
		folderDao.addFolder(folder);
	}
	
	@Test public void TestFolderIdByUserIdAndFolderName() {
		FolderDao folderDao = new FolderDao();
		int folderId = folderDao.getFolderIdByUserIdAndFolderName(37, "������");
		System.out.println("Folder Id :" + folderId);
	}

}
