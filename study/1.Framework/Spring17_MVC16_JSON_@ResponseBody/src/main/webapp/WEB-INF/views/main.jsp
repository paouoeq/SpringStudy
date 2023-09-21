<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		// yyy 이벤트
		$("#yyy").on("click", function() {
			//ajax 통신
			//ajax
    		 $.ajax({
    			 url:'yyy', // 요청 url
    			 type:"get", // get/post
    			 dataType:"json", // 응답받을 데이터 타임
    			 success:function(data,status,xhr){ // 성공시 
    				 console.log(data);
    				 console.log(data.userid);
    				 var str = JSON.stringify(data); // JSON을 String으로 변경하는 함수
    				 console.log(str)
    			 },
    			 error:function(xhr, status, error){ // 에러 발생시
    				 
    				 
    			 }
    		 });//end ajax
		}); // end yyy
		
		// zzz 이벤트
		$("#zzz").on("click", function() {
			//ajax 통신
			//ajax
    		 $.ajax({
    			 url:'zzz', // 요청 url
    			 type:"get", // get/post
    			 dataType:"json", // 응답받을 데이터 타임
    			 success:function(data,status,xhr){ // 성공시 
    				 console.log(data);
    			 	
    				//배열 반복
    				 $.each(data, function(idx,ele){
    					 console.log(ele);
    					 console.log(ele.userid);
    				 });
    			 
    				 var str = JSON.stringify(data); // JSON을 String으로 변경하는 함수
    			 },
    			 error:function(xhr, status, error){ // 에러 발생시
    				 
    				 
    			 }
    		 });//end ajax
		}); // end zzz
		
	}); // end ready
</script>
</head>
<body>
<button id="yyy">yyy</button> <!-- Controller의 yyy() 호출할 것 -->
<button id="zzz">zzz</button> <!-- Controller의 zzz() 호출할 것 -->
</body>
</html>