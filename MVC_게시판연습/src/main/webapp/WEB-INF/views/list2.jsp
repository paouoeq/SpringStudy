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
	<form action="update" method="post">
	번호 : ${ex.no}
	<input type="hidden" name="no" value="${ex.no}"> <br>
	이름 : <input type="text" value="${ex.name}" name="name"> <br>
	장소 : <input type="text" value="${ex.loc}" name="loc"> <br>
	<input type="submit" value="수정">
	</form>
</body>
</html>