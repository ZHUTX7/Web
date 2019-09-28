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
	
	
	<% 
	  String id=(String)session.getAttribute("rid");
	
	%>
    添加图片的ID为：<%=id %>
	<form name="form2" action="uploadImg" method="post"
		enctype="multipart/form-data">
      
			Input文件：&nbsp<input type="file" name="file"
				style="width: 160px;"><input  type="submit"  value="上传" />
		</div>
		
	</form>
</body>
</html>