<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스파게티</title>
</head>
<% pageContext.setAttribute("result", "RESULT"); %>
<body>
	<%= request.getAttribute("model") %>입니다.
	<h2>${model}</h2>
	<h2>${names[0]}</h2>
	<h2>${notice.local}</h2>
	<h2>${notice.age}</h2>
	<h2>${result}</h2>
	<h2>${requestScope.result}</h2>
	<h2>${param.n }</h2>
	<h2>${header.accept }</h2>
	<h2>${pageContext.request.method}</h2>
	<%-- 연산자 --%>
	<h2>${1 > (4/2)}</h2>2
	<h2>n > 3? ${param.n gt 3}</h2>
	<h2>empty n : ${empty param.n?"값이 비어있음":param.n}</h2>
</body>
</html>