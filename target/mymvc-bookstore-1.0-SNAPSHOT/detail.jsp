<%@ page import="java.nio.charset.StandardCharsets" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%request.setCharacterEncoding("utf-8");	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail.jsp</title>
<style>
body{
	color:#656667;
	font-family: "Akzidenz-Grotesk BQ Light";
	}
	h1{
		line-height:1.25;
		font-size: 4.5em;
		font-weight: 300;
	}
	p{font-weight:normal;font-size:1.5em;}
	.paid,.back{
		background: #32bd40;
		color: #fff;
		font-size: 1.25em;
		width:50%;
		line-height:1.5em;
		outline: none;border: none;
	}
	.num{
		width:4%
	}
</style>
</head>
<body align="center">
	<br />
	<br />
	<%
		int id= Integer.parseInt(request.getParameter("id"));
		String name=new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8");
		String price=new String(request.getParameter("price").getBytes("iso-8859-1"),"utf-8");
		String author=new String(request.getParameter("author").getBytes("iso-8859-1"),"utf-8");
		int bookCount=Integer.parseInt(request.getParameter("bookCount"));
		System.out.println("id="+id);
	%>

	<h1 style="color:#006633 ">Detail</h1>
	<p>书名：<%=name%></p>
	<p>价格： <%=price%></p>
	<p>作者： <%=author%></p>
	<form action="AddCart" method="post">
	<p>
		库存： <%=bookCount%>
	</p>
	<p>
		<input type="hidden" name="check" value=<%=id%> >
		购买数量：<input type="text" class="num" name="num">
	</p>
	<input type="submit" class="paid" value="Add cart" >
	</form>
	<br/>
	<br/>
	<form action="showBook.jsp" method="post" onsubmit="return check(this)">
	<input type="hidden" name="start" value="1">
	<input type="submit" class="back" value="Back">
	</form>
</body>
</html>