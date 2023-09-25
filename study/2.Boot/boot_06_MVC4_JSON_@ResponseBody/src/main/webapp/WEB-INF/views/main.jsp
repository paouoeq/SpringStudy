<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
   
     $(document).ready(function(){
    	 
    	 //aaa이벤트
    	 $("#aaa").on("click", function(){
    		 //ajax
    		 $.ajax({
    			 url:'aaa', // 컨트롤러의 어떤 메서드?
    			 type:"get",
    			 dataType:"text", // json이 아닌 text
    			 success:function(data,status,xhr){
    				 console.log(data, typeof data);
    				 $("#result").text(data);
    			 },
    			 error:function(xhr, status, error){
    				 
    			 }
    		 });//end ajax
    	 });//end aaa
    	 
    	 //bbb이벤트
    	 $("#bbb").on("click", function(){
    		 //ajax
    		 $.ajax({
    			 url:'bbb', // 컨트롤러의 어떤 메서드?
    			 type:"get",
    			 dataType:"json",
    			 success:function(data,status,xhr){
    				 console.log(data, typeof data);
    				 var str_obj = JSON.stringify(data);
    				 $("#result2").text(str_obj);
    			 },
    			 error:function(xhr, status, error){
    				 
    			 }
    		 });//end ajax
    	 });//end bbb
    	 
    	 //ccc이벤트
    	 $("#ccc").on("click", function(){
    		 //ajax
    		 $.ajax({
    			 url:'ccc', // 컨트롤러의 어떤 메서드?
    			 type:"get",
    			 dataType:"json",
    			 success:function(data,status,xhr){
    				 console.log(data, typeof data);
    				 var tag = `<table border="1">`;
    				 tag += `<tr>
    				 			<th>부서번호</th>
    				 			<th>부서명</th>
    				 			<th>위치</th>
    				 		 </tr>`;
    				 // 데이터 반복
    				 $.each(data, function(idx, dto){ // 배열에서 데이터 하나 꺼내 함수로 전달(인덱스, 값)
    					tag += `<tr>
	    							<td>\${dto.deptno}</td> 
	    							<td>\${dto.dname}</td>
	    							<td>\${dto.loc}</td>
    							</tr>
    						   `; // jquery에서 $가 jquery를 나타내는지 백틱을 나타내는지 구분이 안되기 때문에 백틱에 변수값을 삽입할 때 \를 붙인다.
    				 });
    				 tag += `</table>`;
    				 $("#result3").html(tag);
    			 },
    			 error:function(xhr, status, error){
    				 
    			 }
    		 });//end ajax
    	 });//end ccc

    	 //ddd이벤트
    	 $("#ddd").on("click", function(){
    		 //ajax
    		 $.ajax({
    			 url:'ddd', // 컨트롤러의 어떤 메서드?
    			 type:"get",
    			 dataType:"html",
    			 success:function(data,status,xhr){
    				 $("#result4").html(data);
    			 },
    			 error:function(xhr, status, error){
    				 
    			 }
    		 });//end ajax
    	 });//end ddd

    	 //eee이벤트
    	 $("#eee").on("click", function(){
    		 //ajax
    		 $.ajax({
    			 url:'eee', // 컨트롤러의 어떤 메서드?
    			 type:"get",
    			 dataType:"xml",
    			 success:function(data,status,xhr){
    				 $("#result5").text(data);
    			 },
    			 error:function(xhr, status, error){
    				 
    			 }
    		 });//end ajax
    	 });//end eee
     });//end ready

</script>
</head>
<body>
<h1>main.jsp</h1>
<button id="aaa">String반환</button>
<span id="result"></span>
<br>
<button id="bbb">DTO반환(JSON)</button>
<span id="result2"></span>
<br>
<button id="ccc">List반환(JSON)</button>
<span id="result3"></span> 
<br>
<button id="ddd">html반환</button> <!-- html 태그를 반환하면 jsp에서 html 처리 -->
<span id="result4"></span> 
<br>
<button id="eee">xml반환</button>
<span id="result5"></span> 
<br>
</body>
</html>