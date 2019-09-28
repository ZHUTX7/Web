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
				<div class="heading">已发布的广告信息管理</div>
				
				<table border="1" id="myTable">
				<tr>
			<td>广告ID</td>
			<td>价格/月</td>
			<td>点击量</td>
			<td>用户id</td>
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
    List<PublishAdvertisement> list =PublishAdDB.allAd();
    for (int i=(pages-1)*num; i<(pages-1)*num+num&&i<list.size(); i++) {			
    	PublishAdvertisement ms=list.get(i);		
%>
			
			
			<tr>
			<td><%=ms.getAd_id() %></td>
			<td><%=ms.getAd_price()  %></td>
			<td><%=ms.getClickSum() %></td>
			<td><%=ms.getUser_id() %></td>
			<td><%=CompanyDB.getCompanyById(ms.getUser_id()).getCompany_name() %></td>
			<td><%=CompanyDB.getCompanyById(ms.getUser_id()).getCompany_mobile() %></td>
			
			<td><a href="delPublishedAd?ad_id=<%=ms.getAd_id()  %>">撤销广告</a></td>
			
			</tr>
<% 	}%>

			<tr><td> 月入总金额：</td><td> 月入总金额：<%=PublishAdDB.getSumMoney() %></td></tr>
	</table>
    
    <%for(int q=1;q<=totalPage;q++) {%>
			<a href="allPublishAdManage.jsp?pages=<%=q %> ">[<%=q%>]</a>	
<%} %>
      当前页：<%=pages%> &nbsp&nbsp&nbsp 页面总数：<%=totalPage%>  &nbsp&nbsp&nbsp  
    <hr>
	
    <a href="Backstage.jsp">返回主页</a>	
						
						
				</div>

</body>
</html>
