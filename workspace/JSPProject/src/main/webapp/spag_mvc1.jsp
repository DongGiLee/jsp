<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- 입력 Control --%>
<%
	int num = 0;
	String model;
	String num_ = request.getParameter("n");
	
	if (num_ != null && !num_.equals("")) {
		num = Integer.parseInt(num_);
	}
	if (num % 2 ==0) model = "짝수";		
	else model = "홀수";
%>

<%-- model = Model --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스파게티</title>
</head>

<body>
	<%-- 출력 View --%>
	<%= model %>입니다.
</body>
</html>