<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<!-- CDM 방식으로 jquery 추가 -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
		<script>
			$(document).ready(function(){
				$("button").on("click", function(){
					var num = $(this).attr("data-num");
					alert(num+"번이 삭제되었습니다.");
					location.href="del?no="+num;
				})
			});
		</script>
	</head>
	<body>
		<c:set var="pageDTO" value="${PageDTO}"/>
		<c:set var="list" value="${pageDTO.list}"/>
		<table border=1>
		<!----------------------- 검색 ------------------------>
			<tr>
				<td colspan="5">
					<form action="findAll" method="get">
						<select name="searchName">
							<option value="sNo">번호</option>
							<option value="sName">이름</option>
						</select>
						<input type="text" name="searchValue">
						<input type="submit" value="검색">
					</form>
				</td>
			</tr>
		<!----------------------- 검색 ------------------------>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>장소</th>
				<th>삭제</th>
				<th>수정</th>
			</tr>
		<c:forEach var="ex" items="${list}">
			<tr>
				<td>${ex.no}</td>
				<td>${ex.name}</td>
				<td>${ex.loc}</td>
				<td><a href="findNo?no=${ex.no}">수정</a></td>
				<td><button data-num="${ex.no}">삭제</button></td>
			</tr>
		</c:forEach>
		
		<!----------------------- 페이지 추가 ----------------------->
			<c:set var="perPage" value="${pageDTO.perPage}"/>
			<c:set var="curPage" value="${pageDTO.curPage}"/>
			<c:set var="totalCount" value="${pageDTO.totalCount}"/>
			<c:set var="totalNum" value="${totalCount / perPage}" />
		
			<c:if test="${totalCount % perPage != 0}">
				<c:set var="totalNum" value="${totalNum+1}" />
			</c:if>
		
			<c:set var="searchName" value="${pageDTO.searchName}" />
			<c:set var="searchValue" value="${pageDTO.searchValue}" />
			
			<tr>
				<td colspan="5">
					<c:forEach var="i" begin="1" end="${totalNum}">
						<c:if test="${curPage == i}">
							${i}
						</c:if>
						<c:if test="${curPage != i}">
							<a href=" <c:url value='findAll?curPage=${i}&searchName=${searchName}&searchValue=${searchValue}'/> "> ${i} </a>
						</c:if>
					</c:forEach>
				</td>
			</tr>
		<!----------------------- 페이지 추가 ----------------------->
		
		</table> <br>
		<a href="addForm">추가</a>
	</body>
</html>