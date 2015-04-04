package com.email.actions;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.email.dao.EmailDao;
import com.email.models.Email;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailAction extends ActionSupport {
	
	private Email email;
	EmailDao emailDao = new EmailDao();
	private List<Email> emailList;
	
	
	
	public Email getEmail() {
		return email;
	}
	public void setEmail(Email email) {
		this.email = email;
	}
	public EmailDao getEmailDao() {
		return emailDao;
	}
	public void setEmailDao(EmailDao emailDao) {
		this.emailDao = emailDao;
	}
	public List<Email> getEmailList() {
		return emailList;
	}
	public void setEmailList(List<Email> emailList) {
		this.emailList = emailList;
	}
	
	/**
	 * 验证用户名和密码，配置Email对话
	 * @param username 
	 * @param password
	 * @return Session 邮件对话
	 */
	public Session configEmail(final String username, final String password) {
		Properties props = System.getProperties();
		props.put("mail.smtp.host", "localhost");
		//props.put("mail.smtp.host", "wetoband.com");
		props.put("mail.smtp.port", "25");
		props.put("mail.smtp.auth", "true");
		props.put("mail.transport.protocol", "smtp"); 
		
		Session session = null;
		//创建邮件对话
		try {
		    session = Session.getDefaultInstance(props, new Authenticator(){
			@Override
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return session;
	}
	
	public String sendEmail() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession httpSession = request.getSession(true);
		
		final String userEmail = httpSession.getAttribute("userEmail").toString();
		final String password = httpSession.getAttribute("password").toString();
		final String username = userEmail.substring(0, userEmail.length() - 13);
		
		String receiver = request.getParameter("receiver");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");

		Session session = configEmail(username, password);
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(userEmail));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
			message.setSubject(subject);
			message.setText(content);
			Transport.send(message);
			
			int folderId = 3;
			Date date = new Date();
			Email email = new Email(folderId, receiver, false, subject, content,
					false, date);
			
			emailDao.saveEmail(email);
			
			System.out.println("email sends successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public void getMail() throws Exception {
		Properties properties = new Properties();
		
		//String host = "wetoband.com";
		String host = "localhost";
		final String username = "wu";
		final String password = "wu";
		
		//创建对话
		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			@Override
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		
		try {
			Store store = session.getStore("pop3");
			store.connect(host, username, password);
			
			Folder folder = store.getFolder("INBOX");
			folder.open(Folder.READ_ONLY);
			if (folder.hasNewMessages()) {
				Message messages[] = folder.getMessages();
				for (int i = 0; i < messages.length; i++) {
					String from = messages[i].getFrom().toString();
					String subject = messages[i].getSubject();
					String content = messages[i].getContent().toString();
				}
			}
			
			folder.close(true);
			store.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
