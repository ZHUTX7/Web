<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
<div style="position:relative;">
       <span style="margin-left:100px;width:18px;overflow:hidden;">
        <select  style="width:118px;margin-left:-100px" onchange="this.parentNode.nextSibling.value=this.value">
        <div style="display:none;">        
         <option value="1">1        </option>
         <option value="2"> 2         </option>     
         <option value="3"> 3      </option>
        </div>
        </select></span><input  style="width:100px;position:absolute;left:0px;" >
       </div>

</body>

</html>