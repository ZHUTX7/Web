<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<!--///////////////////Category Page//////////////////-->
	<!--//////////////////////////////////////////////////-->
	<% 
	request.setCharacterEncoding("utf-8");
	String room_toward;
	int k=0;//用来循环而已
	int room_type,room_way,room_price1,room_price2;
	List<Room> list2;
	if(request.getParameter("room_way")==null&&
	request.getParameter("room_price1")==null&&
	request.getParameter("room_price2")==null&&
	request.getParameter("room_type")==null&&
	request.getParameter("room_adress")==null&&
	request.getParameter("room_toward")==null&&
	request.getParameter("room_decorate")==null){
		list2=RoomDB.allRoom();room_toward="";
	}//if
	else{
		if(request.getParameter("room_price1")==null||request.getParameter("room_price1")==""){
			room_price1=0;
		}
		else{
			 room_price1=Integer.parseInt(request.getParameter("room_price1"));
		}
		if(request.getParameter("room_price2")==null||request.getParameter("room_price2")==""){
			 room_price2=99999999;
		}
		else{
		 room_price2=Integer.parseInt(request.getParameter("room_price2"));
		}
		if(request.getParameter("room_way")==null||request.getParameter("room_way")==""){
			 room_way=0;
		}
		else
		{
			 room_way=Integer.parseInt(request.getParameter("room_way"));
		}
		if(request.getParameter("room_type")==null||request.getParameter("room_type")==""){
			 room_type=0;
		}
		else
		{
			 room_type=Integer.parseInt(request.getParameter("room_type"));
		}
	
	String room_adress=request.getParameter("room_adress");
	 room_toward=request.getParameter("room_toward");
    String room_decorate=request.getParameter("room_decorate");
	 list2 =RoomDB.findRoomByString(room_price1, room_price2, room_adress, room_type, room_toward, room_decorate, room_way);
	}//else
	

	
	
	%>
	
	<div id="page-content" class="single-page">
		<div class="container">
		
			<div class="row">
				<div class="col-lg-12">
					<ul class="breadcrumb">
					
						<li><a href="index.jsp">主页<%=room_toward %></a></li>
						<li><a href="allGoods.jsp">租房信息</a></li>
					</ul>
				</div>
			</div>
			<form action="#" method="post">
			<p>地址:<input type="text" name="room_adress"   >
			  租金/月:最低<input type="number" name="room_price1"  >——最高<input type="number" name="room_price2">
			<p>朝向:<select   name="room_toward"  >
						<option value="" selected>请选择朝向</option>
						<option value="东">东</option>
						<option value="西">西</option>
						<option value="南">南</option>
						<option value="北">北</option>
										</select>
				装修情况:<select    name="room_decorate"  >
						<option value="" selected>请选择装修类型</option>
						<option value="简单装修">简单装修</option>
						<option value="毛坯房" >毛坯房</option>
						<option value="精品装修">精品装修</option>
						<option value="豪华装修">豪华装修</option>
							</select>
					    <p>出租方式:<select   name="room_way"  >
						<option value="" selected>请选择出租方式</option>
						<option value="1">单间出租</option>
						<option value="2" >整间出租</option>
						</select>
						卧室数量:<select   name="room_type"  >
						<option value="0" selected>请选择卧室数量</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">更多</option>
										</select>
						<input type="submit" class="btn"  value="查询" >
						
						</form>
						<hr>
			<div class="row">
			</div>
			<div class="row">
				<div id="main-content" class="col-md-8">
				
	   		<%   for (int i=0; i<list2.size(); i++) {	//列数	%>	
	   			<div class="row"><!-- 一行 -->
						<div class="col-md-12">
							<div class="products">
							<%for(int j=0;j<3&&k<list2.size();j++){  //行数
	    	    					Room rm=list2.get(k);  k++;%>
								<div class="col-lg-4 col-md-4 col-xs-12"><!-- 一个-->
									<div class="product">
										<div class="image"><a href="Room.jsp?room_id=<%=rm.getRoom_id()%>"><img src="<%=rm.getRoom_img() %>" /></a></div>
										
										<div class="caption">
											<div class="name"><h3><a href="Room.jsp?room_id=<%=rm.getRoom_id()%>"><%=rm.getRoom_adress()%></a></h3></div>
											<div class="price">$<%=rm.getRoom_price() %><span>月</span></div>
										</div>
									</div>
									
								</div><% }  //循环完3个 %>
							</div><!-- product --> 
						</div>
					</div>	
					<br><% } %> 
					<div class="row text-center">
						<ul class="pagination">
						  <li class="active"><a href="#">1</a></li>
						
						</ul>
					</div>
				</div>
				<div id="sidebar" class="col-md-4">
					
					<div class="widget wid-product">
						<h4>广告区域</h4>
						<hr>
						<div class="content">
							<div class="product">
								<a href="#"><img src="images/galaxy-note.jpg" /></a>
								<div class="wrapper">
									<h5><a href="https://item.jd.com/100007381674.html?cu=true&utm_source=baidu-nks&utm_medium=cpc&utm_campaign=t_262767352_baidunks&utm_term=71072678603_0_b65070c913154b4da03433459e9e8a44">Samsung Galaxy Tab</a></h5>
									<div class="price">$122</div>
									<div class="rating"><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star-empty"></span></div>
								</div>
							</div>
							<div class="product">
								<a href="#"><img src="images/galaxy-s4.jpg" /></a>
								<div class="wrapper">
									<h5><a href="https://item.jd.com/100007381674.html?cu=true&utm_source=baidu-nks&utm_medium=cpc&utm_campaign=t_262767352_baidunks&utm_term=71072678603_0_b65070c913154b4da03433459e9e8a44">Samsung Galaxy Tab</a></h5>
									<div class="price">$122</div>
									<div class="rating"><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star-empty"></span></div>
								</div>
							</div>
							<div class="product">
								<a href="#"><img src="images/Z1.png" /></a>
								<div class="wrapper">
									<h5><a href="https://item.jd.com/100007381674.html?cu=true&utm_source=baidu-nks&utm_medium=cpc&utm_campaign=t_262767352_baidunks&utm_term=71072678603_0_b65070c913154b4da03433459e9e8a44">Samsung Galaxy Tab</a></h5>
									<div class="price">$122</div>
									<div class="rating"><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star-empty"></span></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div><!-- row -->
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
</body>
</html>
