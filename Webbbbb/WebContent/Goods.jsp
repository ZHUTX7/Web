<%@ page import="DAO.*" %>
<%@ page import="model.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<!--///////////////////Product Page///////////////////-->
	<!--//////////////////////////////////////////////////-->
	<%	 request.setCharacterEncoding("utf-8");
	     int goods_id=Integer.parseInt(request.getParameter("goods_id"));
	     Goods gs=GoodsDB.getGoodsById(goods_id);
	     
	     %>
	<div id="page-content" class="single-page">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<ul class="breadcrumb">
						<li><a href="index.jsp">主页</a></li>
						<li><a href="Goods.jsp">商品</a></li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div id="main-content" class="col-md-8">
					<div class="product">
						<div class="col-md-6">
							<div class="image">
								<img src="<%=gs.getGoods_img() %>" alt="暂时没有图片😭"/>
								
							</div>
						</div>
						<div class="col-md-6">
							<div class="caption">
								<div class="name"><h3><%=gs.getGoods_name() %></h3></div>
								<div class="info">
								
										
								</div>
								<div class="price">$<%=gs.getGoods_price() %></div>
								
								<div class="rating"><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star-empty"></span></div>
								<div ><a href="buyGoods.jsp?goods_id=<%=gs.getGoods_id() %>" class="btn btn-2 " >购买</a></div>
									<a class="btn wishlist" href="addWish?goods_id=<%=gs.getGoods_id() %>">加入收藏—><span class="glyphicon glyphicon-heart"></span></a>
									<%if(request.getParameter("WishResult")!=null){ %>
									 <%=request.getParameter("WishResult") %>
									<%} %>
								<div class="share well">
									<strong style="margin-right: 13px;">Share :</strong>
									<a href="#" class="share-btn" target="_blank">
										<i class="fa fa-twitter"></i>
									</a>
									<a href="#" class="share-btn" target="_blank">
										<i class="fa fa-facebook"></i>
									</a>
									<a href="#" class="share-btn" target="_blank">
										<i class="fa fa-linkedin"></i>
									</a>
								</div>
							</div>
						</div>
						<div class="clear"></div>
					</div>	
					<div class="product-desc">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#description">商品详情</a></li>
						</ul>
						<div class="tab-content">
						<% int ui=UserGoodsDB.getUserId(goods_id) ;// userID卖家ID
									
								%>
							<div id="description" class="tab-pane fade in active">
								<h4><%=gs.getGoods_name() %></h4><!-- 标题 -->
								<p>价格:<%=gs.getGoods_price() %></p>
								<p>类型:<%=gs.getGoods_type() %>
								<p>卖家昵称:<%=UserDB.getUserById(ui).getUser_name() %></p>
								<p>联系电话:<%=UserDB.getUserById(ui).getUser_mobile() %></p>
								<hr>
								<p>说明:<%=gs.getGoods_note() %></p>
								
							</div>
							
						</div>
					</div>
					
				</div>
				
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
	
	<!-- IMG-thumb -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">         
          <div class="modal-body">                
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
	
	<script>
	$(document).ready(function(){
		$(".nav-tabs a").click(function(){
			$(this).tab('show');
		});
		$('.nav-tabs a').on('shown.bs.tab', function(event){
			var x = $(event.target).text();         // active tab
			var y = $(event.relatedTarget).text();  // previous tab
			$(".act span").text(x);
			$(".prev span").text(y);
		});
	});
	</script>
</body>
</html>
