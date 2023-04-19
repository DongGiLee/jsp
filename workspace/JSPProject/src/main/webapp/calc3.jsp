<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
int x = 3;
int y = 4;
%>
<%--

[코드블록]

<%   %>	: 자바 코드 자체를 출력해야할경우 사용, 이구간안에 선언된것이 service에 들어간다.
<%=  %>	: 다양한 자료형을 출력하게 해준다.
<%!  %>	: 메소드 정의할때 사용한다. 첫번째 코드블럭을 사용하게되면 service 함수에들어가기때문에 안된다.
<%@ page ... %> : 지시 블럭, 어떠한 코드보다도 앞서서 실행된다.
	이전엔 <% response.setCharacterEncoding("UTF-8")%> ... 이렇게 사용했다.
	어떠한 코드보다도 먼저들어가야하는데 jsp가 서블릿으로 컴파일되면서 service 함수안에들어가기때문에 에러발생한다.


[내장객체]

pageContext
session		: getID , setAttribute(name,attr) , removeAttribute(name) 등등...
application	: setAttribute , getAttribute 등등...
config		:
out : jsp 를 사용하는이상 직접사용할일이 별로없다
page
  
--%>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
<style type="text/css">
input {
	width: 50px;
	height: 50px;
}
.output {
	height: 50px;
	background: #e9e9e9;
	font-weight: bold;
	font-size: 20px;
	text-align:right;
	padding : 0 10px 0 0;
	
}
</style>
<script type="text/javascript">

</script>
</head>
<body>
<div>
request.getMethod(): <%= request.getMethod() %>
</div>
<div>
request.getSession():<%= request.getSession() %>
</div>
<div>
request.getRemoteAddr():<%= request.getRemoteAddr() %>
</div>
<div>
request.getHeaderNames():<%= request.getHeaderNames() %>
</div>
<div>
request.getQueryString():<%= request.getQueryString() %>
</div>


	<div>
		<form action="/calc3" method="post">
			<table>
				<tr>
				<td class="output" colspan=4><%= x+y %></td>
				</tr>
				<tr>
					<td><input type="submit" name="operator" value="CE"></td>
					<td><input type="submit" name="operator" value="C"></td>
					<td><input type="submit" name="operator" value="←"></td>
					<td><input type="submit" name="ope0rator" value="÷"></td>
				</tr>
				<tr>
					<td><input type="submit" name="value" value="7"></td>
					<td><input type="submit" name="value" value="8"></td>
					<td><input type="submit" name="value" value="9"></td>
					<td><input type="submit" name="operator" value="×"></td>
				</tr>
				<tr>
					<td><input type="submit" name="value" value="4"></td>
					<td><input type="submit" name="value" value="5"></td>
					<td><input type="submit" name="value" value="6"></td>
					<td><input type="submit" name="operator" value="－"></td>
				</tr>
				<tr>
					<td><input type="submit" name="value" value="1"></td>
					<td><input type="submit" name="value" value="2"></td>
					<td><input type="submit" name="value" value="3"></td>
					<td><input type="submit" name="operator" value="＋"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" name="value" value="0"></td>
					<td><input type="submit" name="dot" value="."></td>
					<td><input type="submit" name="operator" value="="></td>
				</tr>
				
			</table>

			
		</form>
	</div>
</body>
</html>