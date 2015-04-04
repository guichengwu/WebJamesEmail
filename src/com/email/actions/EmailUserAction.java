package com.email.actions;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.apache.struts2.ServletActionContext;
import com.email.dao.EmailUserDao;
import com.email.dao.FolderDao;
import com.email.models.EmailUser;
import com.email.models.Folder;
import com.opensymphony.xwork2.ActionSupport;

public class EmailUserAction extends ActionSupport {
	private EmailUser emailUser;
	EmailUserDao emailUserDao = new EmailUserDao();
	FolderDao folderDao = new FolderDao();
	//����һ��Session���ڴ洢�û����������
	HttpSession session;
	

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	private List<EmailUser> emailUserList;
	
	public FolderDao getFolderDao() {
		return folderDao;
	}

	public void setFolderDao(FolderDao folderDao) {
		this.folderDao = folderDao;
	}
	
	public EmailUserDao getEmailUserDao() {
		return emailUserDao;
	}

	public void setEmailUserDao(EmailUserDao emailUserDao) {
		this.emailUserDao = emailUserDao;
	}

	public EmailUser getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(EmailUser emailUser) {
		this.emailUser = emailUser;
	}

	public List<EmailUser> getEmailUserList() {
		return emailUserList;
	}

	public void setEmailUserList(List<EmailUser> emailUserList) {
		this.emailUserList = emailUserList;
	}

	public String getUsers() {
		emailUserList = emailUserDao.getEmailUsers();
		for (EmailUser e : emailUserList) {
			System.out.println("User e: "+ e.getPassword());
		}
		
		return "list";
	}
	
	public String execute() throws Exception {
		System.out.println("whether get data: " + emailUser.getUserEmail());
		System.out.println("whether get data: " + emailUser.getPassword());
		System.out.println("whether get data: " + emailUser.getUserName());
		emailUserDao.saveEmailUser(emailUser);
		return SUCCESS;
	}
	
	public String register() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String userEmail = request.getParameter("userEmail");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		emailUser = new EmailUser(userEmail, userName, password);
		
		boolean result = emailUserDao.saveEmailUser(emailUser);
		
		if (result) {
			//ע���û�ʱ��Ϊ�û����������ļ�:�ֱ�Ϊ�ռ���,������,������
			Folder inbox = new Folder(emailUser.getUserId(), "�ռ���");
			Folder outBox = new Folder(emailUser.getUserId(), "������");
			Folder trashBox = new Folder(emailUser.getUserId(), "������");
			folderDao.addFolder(inbox);
			folderDao.addFolder(outBox);
			folderDao.addFolder(trashBox);
		    
			//�������������Ϣ�洢��session��
			storeSessionInfo(userEmail, password);
		    return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String login() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
		
		String userEmail = request.getParameter("userEmail");
		String password = request.getParameter("password");
		
		if (emailUserDao.findEmailUser(userEmail, password)) {
			storeSessionInfo(userEmail, password);
		   return SUCCESS;
		} else {
			this.addFieldError("user", "�û������������");
			return LOGIN;
		}
		
	}
	
	public void storeSessionInfo(String userEmail, String password) {
		HttpServletRequest request = ServletActionContext.getRequest();
		session = request.getSession(true);
	    session.setAttribute("userEmail", userEmail);
		session.setAttribute("password", password);
	}
}
