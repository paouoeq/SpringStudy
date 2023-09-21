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
<form action="login" method="get"><br>
아이디:<input type="text" name="userid"><br>
비번:<input type="text" name="passwd"><br>

<!-- name값 하나에 두개의 정보 저장 -->
phone1:<input type="text" name="phone"><br>
phone2:<input type="text" name="phone"><br>

<!-- name값 하나에 두개의 정보 저장 -->
email1:<input type="text" name="email"><br>
email2:<input type="text" name="email"><br>

<input type="submit" value="로그인">
</form>
</body>
</html>