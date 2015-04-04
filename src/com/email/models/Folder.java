package com.email.models;

public class Folder {
	
	private int folderId;
	private int userId;
	private String folderName;
	
	public Folder() {}
	
	public Folder(int userId, String folderName) {
		this.userId = userId;
		this.folderName = folderName;
	}

	public int getFolderId() {
		return folderId;
	}

	public void setFolderId(int folderId) {
		this.folderId = folderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

}
