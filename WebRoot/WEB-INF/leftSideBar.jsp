<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>Wetoband Email</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		<meta name="keywords"
			content="Flat Profile Menu Responsive Templates, Iphone Compatible Templates, Smartphone Compatible Templates, Ipad Compatible Templates, Flat Responsive Templates" />
		<link rel="stylesheet" href="css/dropdownMenuStyle.css"
			type="text/css"></link>
		<script type="js/javascript"
			src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/script.js"></script>
		<link href='http://fonts.googleapis.com/css?family=Montserrat'
			rel='stylesheet' type='text/css'>
		<link href='http://fonts.googleapis.com/css?family=Exo+2:400,700,100'
			rel='stylesheet' type='text/css'>
	</head>
	<body>
		<div id="sidebar">
			<h1>
				Wetoband Email
			</h1>
			<ul class="content">
				<li class="menu">
					<ul>
						<li class="button">
							<a href="#">通讯<span class="icon"></span> </a>
						</li>
						<li class="dropdown">
							<ul class="icon-navigation">
								<li>
									<a href="contact.jsp">通讯录</a>
								</li>
								<li>
									<a href="blacklist.jsp">黑名单</a>
								</li>
							</ul>
						</li>
					</ul>
				</li>
				<li class="menu">
					<ul>
						<li class="button">
							<a href="#">邮件<span class="icon stat"></span><i>13</i> </a>
						</li>
						<li class="dropdown">
							<ul class="icon-navigation">
								<li>
									<a href="redirectToSendEmail.action">发送邮件</a>
								</li>
								<li>
									<a href="getMail.action">收件箱<span> [09]</span> </a>
								</li>
								<li>
									<a href="getOutBox.action">发件箱<span> [02]</span> </a>
								</li>
								<li>
									<a href="getTrashBox.action">垃圾箱</a>
								</li>
							</ul>
						</li>
					</ul>
				</li>
				<li class="menu">
					<ul>
						<li class="button">
							<a href="#">设置<span class="icon msg"></span> </a>
						</li>
						<li class="dropdown">
							<ul class="icon-navigation">
								<li>
									<a href="#">签名</a>
								</li>
								<li>
									<a href="userInfo.action">用户信息</a>
								</li>
							</ul>
						</li>
					</ul>
				</li>
				<li class="menu">
				  <ul>
				    <li class="button">
				      <a href="login.action">退出<span class="icon signout"> </span> </a>
				    </li>
				  </ul>
				</li>
			</ul>
		</div>
	</body>
</html>
