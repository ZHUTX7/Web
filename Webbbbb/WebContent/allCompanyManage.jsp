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
				<div class="heading">广告方信息管理</div>
				
				<table border="1" id="myTable">
				<tr>
			<td>ID</td>
			<td>公司名称</td>
			<td>联系方式</td>
			
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
    List<Company> list =CompanyDB.allCompany();
    for (int i=(pages-1)*num; i<(pages-1)*num+num&&i<list.size(); i++) {			
    	Company ms=list.get(i);		
%>
			
			
			<tr>
			<td><%=ms.getUser_id() %></td>
			<td><%=ms.getCompany_name() %></td>
			<td><%=ms.getCompany_mobile()  %></td>
			
			<td><a href="#">删除</a></td>
			
			</tr>
<% 	}%>


	</table>
    
    <%for(int q=1;q<=totalPage;q++) {%>
			<a href="allCompanyManage.jsp?pages=<%=q %> ">[<%=q%>]</a>	
<%} %>
      当前页：<%=pages%> &nbsp&nbsp&nbsp 页面总数：<%=totalPage%>  &nbsp&nbsp&nbsp  
    <hr>
	
    <a href="Backstage.jsp">返回主页</a>	
						
						
				</div>

</body>
</html>
