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
				<div class="heading">用户信息管理</div>
				<form method="post" action="#">
					<input type="text" name="nameUser" placeholder="输入用户姓名">
					<input type="submit"  placeholder="查询">  
				</form>
				<table border="1" id="myTable">
				<tr>
			<td>用户ID</td>
			<td>昵称 </td>
			<td>性别</td>
			<td>手机号</td>
			<td>Email</td>
			<td>地址</td>
			</tr>	
<%  request.setCharacterEncoding("utf-8");
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
    List<User> list;
    if(request.getParameter("nameUser")!=null){
    	String key=request.getParameter("nameUser");
    	  list=UserDB.findUser(key);
    }
    else
    	list =UserDB.allUser();
    for (int i=(pages-1)*num; i<(pages-1)*num+num&&i<list.size(); i++) {			
    	User ms=list.get(i);		
%>
			
			
			<tr>
			<td><%=ms.getUser_id()%></td>
			<td><%=ms.getUser_name() %></td>
			<td><%=ms.getUser_sex() %></td>
			<td><%=ms.getUser_mobile() %></td>
			<td><%=ms.getUser_email() %></td>
			<td><%=ms.getUser_adress() %></td>
			<td><a href="#">删除</a></td>
			
			</tr>
<% 	}%>


	</table>
    
    <%for(int q=1;q<=totalPage;q++) {%>
			<a href="allUserManage.jsp?pages=<%=q %> ">[<%=q%>]</a>	
<%} %>
      当前页：<%=pages%> &nbsp&nbsp&nbsp 页面总数：<%=totalPage%>  
    <hr>
	
    <a href="Backstage.jsp">返回主页</a>	
						
						
				</div>

</body>
</html>
