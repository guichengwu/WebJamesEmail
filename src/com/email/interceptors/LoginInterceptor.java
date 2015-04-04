package com.email.interceptors;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation arg) throws Exception {
		Map session = arg.getInvocationContext().getSession();
		String userEmail = (String) session.get("userEmail");
		if (userEmail != null && !userEmail.equals("")) {
			System.out.println("û�н���������");
			return arg.invoke();
		}
		else {
			System.out.println("������������");
			session.put("errorMsg", "�û�δ��¼");
			return null;
		}
	}

}
