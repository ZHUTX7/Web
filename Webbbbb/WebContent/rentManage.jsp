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
						<li><a href="personalInfo.jsp">个人主页</a></li>
						<li><a href="rentManage.jsp">租房记录</a></li>
					</ul>
				</div>
			</div>
			<div class="row">
			<div class="col-md-6">
			<div class="heading"><h2>租房记录</h2></div>
			
			<% List<Rent> list1=RentDB.getOrderByCustomer(user.getUser_id());
			if(list1!=null){
						for (int i=0; i<list1.size(); i++) {			
							Rent o1=list1.get(i);	 %>
					    <div >
							<p>位置:<%=o1.getRoom_adress() %>
							<p>价格:<%=o1.getRoom_price() %>
							<p>起始时间:<%=o1.getBegin_date() %>
							<p>到期时间:<%=o1.getEnd_date() %>
							<p>房东:<%=UserDB.getUserById(o1.getSeller_id()).getUser_name()%>
							<p>联系电话:<%=UserDB.getUserById(o1.getSeller_id()).getUser_mobile() %>
						</div>
			
						<hr>
					<%}} %>	
			</div>
					<div class="col-md-6">
			<div class="heading"><h2>出租记录</h2></div>
			
			<% List<Rent> list2=RentDB.getOrderBySeller(user.getUser_id());
			if(list2!=null){ 
				for (int i=0; i<list2.size(); i++) {			
							Rent o2=list2.get(i);	 %>
					    <div >
							<p>位置:<%=o2.getRoom_adress() %>
							<p>价格:<%=o2.getRoom_price() %>
							<p>起始时间:<%=o2.getBegin_date() %>
							<p>到期时间:<%=o2.getEnd_date() %>
							<p>租客姓名:<%=UserDB.getUserById(o2.getCustomer_id()).getUser_name()%>
							<p>联系电话:<%=UserDB.getUserById(o2.getCustomer_id()).getUser_mobile() %>
						</div>
			
						<hr>
					<%}} %>	
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