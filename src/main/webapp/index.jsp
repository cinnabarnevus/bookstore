<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
<style>
body {
	color: #656667;
	font-family: "Akzidenz-Grotesk BQ Light";
}

h2 {
	line-height: 1.25;
	font-size: 2.825em;
	font-weight: 300;
	color: #006633;
}

.sub{
    background: #32bd40;
    color: #fff;
    font-size: 1.25em;
    width:50%;
    line-height:1.5em;
    outline: none;border: none;
}
</style>
</head>
<body>
<form action="AddBook" method="post"  >
	<div align="center">
		<h2>Add Book</h2>
		书名: <input type="text" name="name" /><br/><br/>
		价格: <input type="text" name="price" /><br/><br/>
		数量: <input type="text" name="bookCount"/><br/><br/>
		作者: <input type="text" name="author" /><br/><br/>
		<input type="submit" value="Add" class="sub"><br/><br/>
	</div>
</form>
<form action="bookStorage.jsp" method="post" >
	<div align="center">
		<input type="submit" value="show All Books" class="sub"><br/><br/>
	</div>
</form>
</body>
</html>