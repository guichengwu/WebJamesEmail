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
       <span>Welcome, ${userEmail}</span>
       <img src="images/main.jpg"></img>
  </div>
</body>
</html>