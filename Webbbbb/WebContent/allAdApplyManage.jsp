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
				<div class="heading">申请投放广告信息管理</div>
				<form method="post" action="#">
					<input type="number" name="nameUser" placeholder="输入广告方ID号查询">
					<input type="submit"  >  查询
				</form>
				<table border="1" id="myTable">
				<tr>
			<td>ID</td>
			<td>租金 </td>
			<td>广告方ID</td>
			<td>公司名称</td>
			<td>联系方式</td>
			
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
    List<Adervertisement> list =AdvertisementDB.allAd();
    for (int i=(pages-1)*num; i<(pages-1)*num+num&&i<list.size(); i++) {			
    	Adervertisement ms=list.get(i);		
%>
			
			
			<tr>
			<td><%=ms.getAd_id() %></td>
			<td><%=ms.getAd_price()  %></td>
			
			<td><%=ms.getUser_id() %></td>
			<td><%=CompanyDB.getCompanyById(ms.getUser_id()).getCompany_name() %></td>
			<td><%=CompanyDB.getCompanyById(ms.getUser_id()).getCompany_mobile() %></td>
			
			<td><a href="agreeAd?ad_id=<%=ms.getAd_id()  %>">同意申请</a></td>
			<td><a href="refuseAd?ad_id=<%=ms.getAd_id()  %>">拒绝申请</a></td>
			
			</tr>
<% 	}%>


	</table>
    
    <%for(int q=1;q<=totalPage;q++) {%>
			<a href="allAdApplyManage.jsp?pages=<%=q %> ">[<%=q%>]</a>	
<%} %>
      当前页：<%=pages%> &nbsp&nbsp&nbsp 页面总数：<%=totalPage%>  
    <hr>
	
    <a href="Backstage.jsp">返回主页</a>	
						
						
				</div>

</body>
</html>
