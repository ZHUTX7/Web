<%@ page language="java" contentType="text/html; charset=utf-8"
 pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>网站后台内容管理系统</title>
<link href="ManagerLoginCss/css/base.css" rel="stylesheet" type="text/css">
<link href="ManagerLoginCss/css/login.css" rel="stylesheet" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="login">
<form action="Backstage.jsp" method="post"  >
	<div class="logo"></div>
    <div class="login_form">
    	<div class="user">
        	<input class="text_value" value="" name="manager_id" type="text" id="username">
            <input class="text_value" value="" name="manager_password" type="password" id="password">
        </div>
        <button class="button" id="submit" type="submit">登录</button>
    </div>
    
    <div id="tip"></div>
    <div class="foot">
    	综合信息管理网站 © 2019    版权所有:ztx 
    </div>
    </form>
</div>

</body>
</html>
