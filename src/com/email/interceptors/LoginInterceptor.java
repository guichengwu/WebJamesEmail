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
			System.out.println("没有进入拦截器");
			return arg.invoke();
		}
		else {
			System.out.println("进入拦截器了");
			session.put("errorMsg", "用户未登录");
			return null;
		}
	}

}
