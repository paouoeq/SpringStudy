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
		// yyy 이벤트 : json -> LoginDTO
		// ** 그냥 json이 아닌 문자열로된 json을 보내야 한다. **
		$("#yyy").on("click", function() {
			//ajax 통신
			//ajax
    		 $.ajax({
    			 url:'yyy', // 요청 url
    			 type:"post", // get/post
    			 dataType:"text", // 응답받을 데이터 타임
    			 headers: {     // 요청 데이터 타입
    				 "Content-Type":"application/json" // 전달할 ContextType은 application/json이다.
    			 },
    			 data:JSON.stringify({userid:"홍길동",passwd:"1234"}), // 보내는 데이터, 키값은 DTO의 변수명
    			 success:function(data,status,xhr){ // 성공시 
    				 
    			 },
    			 error:function(xhr, status, error){ // 에러 발생시
    				 
    			 }
    		 });//end ajax
		}); // end yyy
		
		 //zzz 이벤트  "json"--> LoginDTO
	   	 $("#zzz").on("click", function(){
	   		 //ajax
	   		 $.ajax({
	   			 url:'zzz',
	   			 type:"post",
	   			 dataType:"text",  //응답데이터 타입
	   			 headers:{     // 요청 데이터 타입
	   				 "Content-Type":"application/json"
	   			 },
	   			 data:JSON.stringify([{userid:"홍길동1",passwd:"1234"},{userid:"홍길동2",passwd:"9999"}]),
	   			 success:function(data,status,xhr){
	   				 
	   			 },
	   			 error:function(xhr, status, error){
	   				 
	   			 }
	   		 });//end ajax
	   	 });//end yyy
		
	}); // end ready
</script>
</head>
<body>
<button id="yyy">yyy</button>
<button id="zzz">zzz</button>
</body>
</html>