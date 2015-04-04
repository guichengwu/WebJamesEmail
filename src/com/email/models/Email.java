package com.email.models;

import java.util.Date;

public class Email {
	private int emailId;
	private int folderId;
	private String emailAddress;
	private boolean unread;
	private String subject;
	private String emailContent;
	private boolean hasAttach;
	private Date sendDate;

	public Email() {}
	
	public Email(int folderId, String emailAddress, boolean unread, String subject,
			     String emailContent, boolean hasAttach, Date sendDate) {
		this.folderId = folderId;
		this.emailAddress = emailAddress;
		this.unread = unread;
		this.subject = subject;
		this.emailContent = emailContent;
		this.hasAttach = hasAttach;
		this.sendDate = sendDate;
	}
	
	public int getEmailId() {
		return emailId;
	}
	public void setEmailId(int emailId) {
		this.emailId = emailId;
	}
	public int getFolderId() {
		return folderId;
	}
	public void setFolderId(int folderId) {
		this.folderId = folderId;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public boolean getUnread() {
		return unread;
	}

	public void setUnread(boolean unread) {
		this.unread = unread;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEmailContent() {
		return emailContent;
	}
	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}
	public boolean getHasAttach() {
		return hasAttach;
	}
	public void setHasAttach(boolean hasAttach) {
		this.hasAttach = hasAttach;
	}
	
	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
}
