<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>추가 화면</h1>
<form action="add" method="post">
	번호 : <input type="text" name="no"><br>
	이름 : <input type="text" name="name"><br>
	장소 : <input type="text" name="loc"><br>
	<input type="submit" value="추가">
</form>
</body>
</html>