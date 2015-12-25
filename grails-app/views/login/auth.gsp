<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<meta name="layout" content="main" />
		<title>Login</title>
<style type="text/css" media="screen">
#login {
	margin:15px 0px; padding:0px;
	text-align:center;
}
#login .inner {
	width:260px;
	margin:0px auto;
	text-align:left;
	padding:10px;
	border:1px solid #000;
}

#login .inner .cssform p{
	clear: left;
	margin: 0;
	padding: 5px 0 8px 0;
	padding-left: 105px;
	margin-bottom: 10px;
	height: 1%;
	
}

#login .inner .cssform label{
	font-weight: bold;
	float: left;
	margin-left: -105px; 
	width: 100px;
}
#login .inner .login_message {color:red;}
#login .inner .text_ {width:120px;}
#login .inner .chk {height:12px;}


</style>
	</head>
	<body>
		<div id="login">
			<div class="inner">
			<g:if test="${flash.message}">
				<div class="login_message">${flash.message}</div>
			</g:if>
			<form action="../j_acegi_security_check" method="POST" id="loginForm" class="cssform">
				<p>
					<label for="j_username">Username:</label>
					<input type='text' class="text_" name='j_username' value='' />
				</p>
				<p>
					<label for="j_password">Password:</label>
					<input type='password' class="text_" name='j_password' value='' />
				</p>
				<p>
					<label for="remember_me">&nbsp;</label>
					<input type="checkbox" class="chk" name="_acegi_security_remember_me">
					Remember me
				</p>
				<p>
					<input type="submit" value="Login" />
				</p>
			</form>
			</div>
		</div>
<script type="text/javascript" language="JavaScript">
<!--
(function(){
	var usernameElm = document.forms["loginForm"].elements["j_username"];
	usernameElm.focus();
})();
// -->
</script>
	</body>
</html>