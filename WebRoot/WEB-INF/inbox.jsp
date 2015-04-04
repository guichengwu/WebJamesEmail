<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
		<link rel="stylesheet" href="css/mainPageStyle.css" type="text/css"></link>
		<title>Inbox here</title>
	</head>
	<body>
		<jsp:include page="leftSideBar.jsp" />
		<div class="rightContent">
			<table id="emailList">
				<thead>
					<tr>
						<th>发件人</th>
						<th>主题</th>
						<th>内容</th>
						<th>日期</th>
					</tr>
				</thead>
				<tbody>
				 <s:iterator value="emailList">
				   <tr>
				      <td><s:property value="emailAddress" /></td>
				      <td><s:property value="subject" /></td>
				      <td><s:property value="emailContent" /></td>
				      <td><br></td>
				   </tr>
				 </s:iterator>
				</tbody>
			</table>
		</div>
	</body>
</html>