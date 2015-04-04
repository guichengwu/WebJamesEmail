package com.email.actions;

import com.opensymphony.xwork2.ActionSupport;

public class RedirectAction extends ActionSupport{
	
	public String redirectToSendEmail() throws Exception {
		
		return SUCCESS;
	}
	
	public String redirectToRegister() throws Exception {
		return SUCCESS;
	}
	
	public String redirectToLogin() throws Exception {
		return SUCCESS;
	}

}
