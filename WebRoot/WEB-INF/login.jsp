<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<html>
	<head>
<script type="text/javascript">
   function checkInput() {
     var userEmail = document.getElementById("userEmail").value; 
     var password = document.getElementById("password").value;
        if (userEmail == "") {
            alert("email cannot be empty, please input your email.");
        } else if (password == "") {
            alert("password cannot be empty, please input your password");
        }     
   }
</script>
	
		<title>Wetoband Email</title>
		<link rel="stylesheet" href="css/style.css" type="text/css"></link>
		<!-- Custom Theme files -->
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
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
				 <img src="images/head-img.png"  />
				 <font color="red" style="font-size : 12px"><s:property value="#session.errorMsg" /></font>
				 <h1>Login <span class="anc-color"> to your Email</span></h1>
				 <h2>Login with</h2>
				 <ul>
				    <li><a class="fa" href="#"></a></li>
				    <li><a class="tw" href="#"></a></li>
				    <li><a class="g" href="#"></a></li>
				 </ul>
				 <h3> or</h3>
					<s:form action="loginUser" namespace="/" method="post">
						<input Name="userEmail" id="userEmail" type="text" placeHolder="Email"  />
						<input Name="password" id="password" type="password" placeHolder="password" />
						<div class="login-bottom">
							<div class="login-check">
								<label class="checkbox">
									<input type="checkbox" name="checkbox" checked />
									<i> </i> Remember Me
								</label>
							</div>
							<div class="login-para">
								<p>
									<a href="#"> Forgot Password</a>
								</p>
							</div>
							<div class="clear"></div>
						</div>
						<input type="submit" value="login" onClick="checkInput()" />
					</s:form>
					<h4>Don't have an account? <a href="redirectToRegister.action">Register Now! </a></h4>
				</div>
			</div>
		</div>
		<div class="copyright">
		   <p>Template by <a href="www.wetoband.com">Wetoband</a></p>
		</div>
	</body>
</html>
