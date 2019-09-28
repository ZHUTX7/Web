<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
        <%@ page import="model.*" %>
<%@ page import="DAO.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>综合信息网站</title>
	<!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css"  type="text/css">
	<!-- Custom CSS -->
    <link rel="stylesheet" href="css/style.css">
	<!-- Custom Fonts -->
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css"  type="text/css">
    <link rel="stylesheet" href="fonts/font-slider.css" type="text/css">
	<!-- 引用了jQuery的轮播-->
	<script src="js/jquery-2.1.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
    
   
</head>

<body>
	<!--顶部-->
	<nav id="top">
		<div class="container">
			<div class="row">
				<div class="col-xs-6">
					<select class="language">
						<option value="English" selected>English</option>
						<option value="Chinese">中文</option>
						
					</select>
					
				</div>
				<div class="col-x444
				449s-6">
					<ul class="top-link">
						<li><a href="checkUser"><span class="glyphicon glyphicon-user"></span> My Account</a></li>
						<li><a href="offLine"><span class="glyphicon glyphicon-envelope"></span> 注销</a></li>
					</ul>
				</div>
			</div>
		</div>
	</nav>
	<!--头部导航栏s-->
	<header class="container">
		<div class="row">
			<div class="col-md-4">
				<div id="logo"><a href=""><img src="images/logo.gif" /></a></div>
			</div>
			<div class="col-md-4">
				<!-- 这个DIV使log和购物车隔一段距离 -->
			</div>
			
		</div>
	</header>
	<!--导航栏-->
    <nav id="menu" class="navbar" >
		<div class="container">
			<div class="navbar-header"><span id="heading" class="visible-xs">Categories</span>
			  <button type="button" class="btn btn-navbar navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse"><i class="fa fa-bars"></i></button>
			</div>
			<div class="collapse navbar-collapse navbar-ex1-collapse" style="color:#666">
				<ul class="nav navbar-nav">
					<li><a href="index.jsp">主页</a></li>
					<li ><a href="allRoom.jsp" >租房</a></li>
					<li ><a href="allGoods.jsp" >淘一淘</a></li>
					
					<li class="dropdown"><a href="allGoods.jsp" class="dropdown-toggle" data-toggle="dropdown">其他</a>
						<div class="dropdown-menu">
							<div class="dropdown-inner">
								<ul class="list-unstyled">
									<li><a href="allGoods.jsp">电子产品</a></li>
									<li><a href="allGoods.jsp">电器</a></li>
									<li><a href="allGoods.jsp">服饰鞋包</a></li>
									<li><a href="allGoods.jsp">电动车</a></li>
								</ul>
							</div> 
						</div>
					</li><!-- 淘一淘 -->
					
				</ul>
			</div>
		</div>
	</nav>
	<!--//////////////////////////////////////////////////-->
	<!--///////////////////Account Page///////////////////-->
	<!--//////////////////////////////////////////////////-->
	<% request.setCharacterEncoding("utf-8");
			Object us=session.getAttribute("user") ;
 			User user = (User)us;
 			if(user!=null){ %>
	<div id="page-content" class="single-page">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<ul class="breadcrumb">
						<li><a href="index.jsp">主页</a></li>
						<li><a href="personalInfo.jsp">个人功能页面</a></li>
						<li><a href="#">订单管理</a></li>
					</ul>
				</div>
			</div>
			<div class="row">
			<div class="col-md-6">
			<div class="heading"><h2>购物订单</h2></div>
			<form action="#" method="post">
			<p>查询：
			<p>年：<input type="number" name="year" >
			<p>月：<input type="number" name="month" >
			<p>日：<input type="number" name="day" >	
			<p><input type="submit" class="btn"  value="查询" ><input type="reset" class="btn"  value="重置" >
			</form>
			<% List<Order> list1;
			if(request.getParameter("year")==null&&request.getParameter("month")==null&&request.getParameter("day")==null){
			    list1 =OrderDB.getOrderByCustomer(user.getUser_id());}
			else{
				 list1 =OrderDB.OrderFind(user.getUser_id(), request.getParameter("year"), request.getParameter("month"), request.getParameter("day"));}
						for (int i=0; i<list1.size(); i++) {			
							Order o1=list1.get(i);	 %>
					    <div >
							<p>商品名称:<%=o1.getGoods_name() %>
							<p>价格:<%=o1.getGoods_price() %>
							<p>时间:<%=o1.getYear() %>年<%=o1.getMonth() %>月<%=o1.getDay() %>日
							<p><a href="orderInfo.jsp?order_id=<%=o1.getId()  %>">查看交易详情</a>
						</div>
			
						<hr>
					<%} %>	
			</div>
					<div class="col-md-6">
			<div class="heading"><h2>转让订单</h2></div>
			<form action="#" method="post">
			<p>查询：
			<p>年：<input type="number" name="year2" >
			<p>月：<input type="number" name="month2" >
			<p>日：<input type="number" name="day2" >	
			<p><input type="submit" class="btn"  value="查询" ><input type="reset" class="btn"  value="重置" >
			</form>
			<% List<Order> list2;
			if(request.getParameter("year2")==null&&request.getParameter("month2")==null&&request.getParameter("day2")==null){
			    list2 =OrderDB.getOrderBySeller(user.getUser_id());}
			else{
				 list2 =OrderDB.OrderFindBySeller(user.getUser_id(), request.getParameter("year2"), request.getParameter("month2"), request.getParameter("day2"));}
						for (int i=0; i<list2.size(); i++) {			
							Order o2=list2.get(i);	 %>
					    <div >
							<p>商品名称:<%=o2.getGoods_name() %>
							<p>价格:<%=o2.getGoods_price() %>
							<p>时间:<%=o2.getYear() %>年<%=o2.getMonth() %>月<%=o2.getDay() %>日
							<p><a href="orderInfo.jsp?order_id=<%=o2.getId()  %>">查看交易详情</a>
						</div>
			
						<hr>
					<%} %>	
			</div>
					
			</div><!-- row -->
		</div>
	</div>
	</div>
	<footer>
		<div class="container">
			<div class="wrap-footer">
				<div class="row">
					<div class="col-md-3 col-footer footer-1">
						<img src="images/logofooter.png" />
						<p>友情链接</p>
					</div>
					<div class="col-md-3 col-footer footer-2">
						<div class="heading"><h4>帮助中心</h4></div>
						<ul>
							<li><a href="https://about.58.com/help.html">常见问题</a></li>
							<li><a href="https://about.58.com/?utm_source=sem-baidu-pc&spm=105916146663.26840108911">更多帮助</a></li>
							<li><a href="https://about.58.com/webAdvice/pc">意见反馈</a></li>
							<li><a href="https://about.58.com/395.html">隐私权条款</a></li>
						</ul>
					</div>
					<div class="col-md-3 col-footer footer-3">
						<div class="heading"><h4>关注我们</h4></div>
						<ul>
							<li><a href="https://weibo.com/">新浪微博</a></li>
							<li><a href="https://weixin.qq.com/">官网微信</a></li>
						</ul>
					</div>
					<div class="col-md-3 col-footer footer-4">
						<div class="heading"><h4>服务支持</h4></div>
						<ul>
							<li><a href="https://e.58.com/?from=90005&PGTID=0d100000-0029-dff2-0a6f-a504ccd2bcd6&ClickID=2"><span class="glyphicon glyphicon-earphone"></span>推广服务</a></li>
							<li><a href="https://e.58.com/zhaoshang.html?PGTID=0d000000-0000-0853-a5a8-3fc8b50fa3a7&ClickID=1"><li><span class="glyphicon glyphicon-earphone"></span>渠道招商</a></li>
							
						</ul>
					</div>
				</div>
			</div>
		</div>
		
	</footer>
	<%} %>
</body>
</html>