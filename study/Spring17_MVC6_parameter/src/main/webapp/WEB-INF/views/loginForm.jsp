<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>GET-로그인화면</h1>
<form action="login" method="get">
아이디:<input type="text" name="userid">
비번:<input type="text" name="passwd">
<input type="submit" value="로그인">
</form>

<h1>POST-로그인화면</h1>
<form action="login" method="post">
아이디:<input type="text" name="userid">
비번:<input type="text" name="passwd">
<input type="submit" value="로그인">
</form>
</body>
</html>