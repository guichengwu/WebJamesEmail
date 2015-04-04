<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<link rel="stylesheet" href="css/mainPageStyle.css" type="text/css"></link>
<title>Insert title here</title>
</head>
<body>
   <jsp:include page="leftSideBar.jsp" />
  <div class="rightContent">
    <!--<span>Welcome, ${userEmail}</span>-->
    <s:form action="sendEmail" namespace="/" method="post">
			<span>收件人:</span><input Name="receiver" type="text" placeHolder="Email" />
			<span>主题:</span><input Name="subject" type="text" placeHolder="subject" />
			<span>内容：</span><textarea name="content"></textarea>
			<input type="submit" value="发送邮件" />
			<input type="reset" value="重置" />
   </s:form>
  </div>
</body>
</html>