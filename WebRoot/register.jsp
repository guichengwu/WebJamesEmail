<%@ page language="java" pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
	
	<script type="text/javascript">
	   function checkInput() {
	        var userEmail = document.getElementById("userEmail").value; 
	        var userName = document.getElementById("userName").value;
            var password = document.getElementById("password").value;
        if (userEmail == "") {
            alert("email cannot be empty, please input your email.");
        } else if (userName == "") {
           alert("username cannot be empty, please input your username.");
        }
         else if (password == "") {
            alert("password cannot be empty, please input your password");
        }
	   }
	</script>
		<title>Wetoband Email</title>
		<link rel="stylesheet" href="css/style.css" type="text/css"></link>
		<!-- Custom Theme files -->
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport"
			content="width=device-width, initial-scale=1, maximum-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords"
			content="Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
		<!--Google Fonts-->
		<link
			href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic'
			rel='stylesheet' type='text/css'>
		<!--Google Fonts-->
	</head>
	<body>
		<div class="login">
			<div class="login-main">
				<div class="login-top">
					<img src="images/head-img.png" />
					<h1>
						Register
						<span class="anc-color"> your Email</span>
					</h1>


					<s:form action="registerUser" namespace="/" method="post">
						<input Name="userEmail" id="userEmail" type="text" placeHolder="Email" />
						<input Name="userName" id="userName" type="text" placeHolder="user Name" />
						<input Name="password" id="password" type="password" placeHolder="password" />
						<div class="login-bottom">
							<div class="login-check">
								<label class="checkbox">
									<input type="checkbox" name="checkbox" checked />
									<i> </i> Remember Me
								</label>
							</div>
							<div class="clear"></div>
						</div>
						<input type="submit" value="Register Email" onClick="checkInput()" />
					</s:form>
				</div>
			</div>
		</div>
		<div class="copyright">
			<p>
				Template by <a href="http://www.wetoband.com">Wetoband</a>
			</p>
		</div>
	</body>
</html>