<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.connect.TodoList.dto.TodoDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TODO</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/index.css">
</head>
<body>
	<header>
		<h1 class="work_todo">나의 해야할 일들</h1>
		<div class="new_todo_btn"><a href="http://localhost:8080/Todo/TodoFormServlet">새로운 TODO 등록</a></div>
	</header>
	 <div class="lists">
    <ul class="todo_list">
    	<li class = "todo_title title"><h2>TODO</h2></li>
    	<c:forEach var="todo" items="${dtolist}">
    		<c:if test="${todo.getType() eq 'TODO'}">
       			<li class="todo component">
					<h3>${todo.getTitle()}</h3>
					<span>${todo.getRegDate() }, 우선순위 ${todo.getSequence()}</span>
					<button class="change_button">→</button>
        		</li>
    		</c:if>
    	</c:forEach> 
    </ul>
    <ul class="doing_list">
    	<li class = "doing_title title"><h2>DOING</h2></li>
        <li class="doing component">
			<h3>자바스크립트 공부하기</h3>
			<span>등록날짜:2023.11.27, 우선순위1</span>
			<button class="change_button">→</button>
        </li>
    </ul>
    <ul class="done_list">
    	<li class = "done_title title"><h2>DONE</h2></li>
        <li class="done component">
            <h3>자바스크립트 공부하기</h3>
			<span>등록날짜:2023.11.27, 우선순위1</span>
        </li>
    </ul>
    </div>
</body>
</html>