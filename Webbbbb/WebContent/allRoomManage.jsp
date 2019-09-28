<%@ page language="java" contentType="text/html; charset=utf-8"
 pageEncoding="utf-8"%>
 <%@ page import="DAO.*" %>
  <%@ page import="model.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>网站后台内容管理系统</title>
<link href="ManagerLoginCss/css/base.css" rel="stylesheet" type="text/css">
<link href="ManagerLoginCss/css/login.css" rel="stylesheet" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body text="center">

<div class="col-md-6"  style=" color:#FFF">
				<div class="heading">房屋信息管理</div>
				<form method="post" action="#">
					<input type="text" name="nameUser" placeholder="输入用户姓名查询房间">
					<input type="submit"  placeholder="查询">  
				</form>
				<table border="1" id="myTable">
				<tr>
			<td>房间ID</td>
			<td>地址</td>
			<td>价格</td>
			<td>房东姓名</td>
			<td>联系电话</td>
			
			</tr>	
<%  
    int num=4;
	int pages;//当前页
	int totalPage;//总页数
	int sumRow=UserDB.sumRow();//总行数
	
	if(sumRow%num==0)
		totalPage=sumRow/num;
	else
		totalPage=sumRow/num+1;
    if(request.getParameter("pages")!=null)
	pages=Integer.parseInt(request.getParameter("pages"));
    else
 	pages=1;
   //(pages-1)*num
    List<Room> list =RoomDB.allRoom();
    for (int i=(pages-1)*num; i<(pages-1)*num+num&&i<list.size(); i++) {			
    	Room ms=list.get(i);		
%>
			
			
			<tr>
			<td><%=ms.getRoom_id() %></td>
			<td><%=ms.getRoom_adress() %></td>
			<td><%=ms.getRoom_price() %></td>
			<td><%=UserDB.getUserById(UserRoomDB.getUserId(ms.getRoom_id())).getUser_name()  %></td>
			<td><%=UserDB.getUserById(UserRoomDB.getUserId(ms.getRoom_id())).getUser_mobile()  %></td>
			<td><a href="#">删除</a></td>
			
			</tr>
<% 	}%>


	</table>
    
    <%for(int q=1;q<=totalPage;q++) {%>
			<a href="allUserManage.jsp?pages=<%=q %> ">[<%=q%>]</a>	
<%} %>
      当前页：<%=pages%> &nbsp&nbsp&nbsp 页面总数：<%=totalPage%>  &nbsp&nbsp&nbsp  
    <hr>
	
    <a href="Backstage.jsp">返回主页</a>	
						
						
				</div>

</body>
</html>
