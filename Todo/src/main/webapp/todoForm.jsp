<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo-Form</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/todoForm.css">
</head>
<body>
	<h1>할일 등록</h1>
	<div class="form_container">
	<form action="${pageContext.request.contextPath}/TodoAddServlet" 
	name = "todo_form" method="POST">
		<label for="title">어떤 일인가요?</label>
		<input type="text" id="title" name="title">
		
		<label for="name">누가 할일인가요?</label>
		<input type="text" id="name" name="name">
		
		<label>우선순위를 선택하세요</label>
		<div class="priority_container">
			<input type="radio" id="1st" name="sequence" value="1">
			<label for="1st">1순위 </label>
			
			<input type="radio" id="2nd" name="sequence" value="2">
			<label for="2nd">2순위 </label>
			
			<input type="radio" id="3rd" name="sequence" value="3">
			<label for="3rd">3순위 </label>
		</div>
		<div class="button_container">
			<div class = "back_btn"><a href="${pageContext.request.contextPath}/main">이전</a></div>
			<input type="submit" value="제출">
			<button type="submit">제출</button>
			<button type="reset">내용 지우기</button>
		</div>
	</form>
	</div>
	
</body>
</html>