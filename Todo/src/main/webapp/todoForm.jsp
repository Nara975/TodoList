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
	<form action="http://localhost:8080/todoAddSerlvet" accept-charset="UTF-8"
	name = "todo_form" method="POST">
		<label for="todoWhat">어떤 일인가요?</label>
		<input type="text" id="todoWhat" name="todoWhat">
		
		<label for="todoWhat">누가 할일인가요?</label>
		<input type="text" id="todoWho" name="todoWho">
		
		<label>우선순위를 선택하세요</label>
		<div class="priority_container">
			<input type="radio" id="1st" name="priority" value="1st">
			<label for="1st">1순위 </label>
			
			<input type="radio" id="2nd" name="priority" value="2nd">
			<label for="2nd">2순위 </label>
			
			<input type="radio" id="3rd" name="priority" value="3rd">
			<label for="3rd">3순위 </label>
		</div>
		<div class="button_container">
			<div class = "back_btn"><a href="http://localhost:8080/Todo">이전</a></div>
			<button type="submit">제출</button>
			<button type="reset">내용 지우기</button>
		</div>
	</form>
	</div>
	
</body>
</html>