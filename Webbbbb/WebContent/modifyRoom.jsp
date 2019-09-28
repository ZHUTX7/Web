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
	<div id="page-content" class="single-page">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<div class="heading"><h2>修改房屋信息</h2></div>
					<% request.setCharacterEncoding("utf-8");
					 int room_id=Integer.parseInt(request.getParameter("room_id"));
 						Room rm=RoomDB.getRoomById(room_id);
 						
					   if(rm!=null){ %>
  						<form method="post"	 action="modifyRoom"	>
  						<input type="hidden" name="room_id" value=<%=rm.getRoom_id() %>>
  						<div class="form-group">
							<p>地址:<input type="text" name="room_adress" value=<%=rm.getRoom_adress() %> class="form-control" required>
						</div>
						<div class="form-group">
							<p>面积(平方米):<input type="number" name="room_area" value=<%=rm.getRoom_area()  %>  class="form-control" required>
						</div>
						<div class="form-group">
							<p>楼层:<input type="number" name="room_floor" value=<%=rm.getRoom_floor()  %> class="form-control" required>
						</div>
						
						<div class="form-group">
							<p>租金/月:<input type="number" name="room_price" value=<%=rm.getRoom_price()  %> class="form-control" required>
						</div>
						<div class="form-group">
							<p>卧室数量:<select   name="room_type"  required>
						<option value="<%=rm.getRoom_type()%>" selected>请选择卧室数量</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">更多</option>
										</select>
						</div>
						<div class="form-group">
							<p>朝向:<select   name="room_toward"  required>
						<option value="<%=rm.getRoom_toward() %>" selected>请选择朝向</option>
						<option value="东">东</option>
						<option value="西">西</option>
						<option value="南">南</option>
						<option value="北">北</option>
										</select>
						</div>
						<div class="form-group">
							<p>装修情况:<select   name="room_decorate"  required>
						<option value=<%=rm.getRoom_decorate()  %> selected>请选择装修类型</option>
						<option value="简单装修">简单装修</option>
						<option value="毛坯房" >毛坯房</option>
						<option value="精品装修">精品装修</option>
						<option value="豪华装修">豪华装修</option>
										</select>
						</div>
						
						<div class="form-group">
							<p>出租方式:<select   name="room_way"  required>
						<option value=<%=rm.getWay()  %> selected>请选择出租方式</option>
						<option value="1">单间出租</option>
						<option value="2" >整间出租</option>
						
										</select>
						</div>
						<div class="form-group">
							<p>备注:<input type="text" name="room_note"  class="form-control" required>
						</div>
						
						<div class="form-group">
							<input type="submit" class="btn"  value="提交" >
						</div>
						</form>
						</div>
						<%} %>
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