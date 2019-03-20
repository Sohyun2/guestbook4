<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%pageContext.setAttribute("newline", "\n");%>

<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">

</head>
<body>
	<form action="${pageContext.servletContext.contextPath }/insert" method="post">		
		<table border="1" width="500">
			<tr>
				<td>이름</td><td><input type="text" name="name"></td>
				<td>비밀번호</td><td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan=4><textarea name="message" id="message"></textarea></td>
			</tr>
			<tr>
				<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
			</tr>
		</table>
	</form>
	<c:set var="count" value="${fn:length(list) }"/>
	<c:forEach items="${list }" var="vo" varStatus="status">
		<table width="510" border="1">
			<tr>
				<td>[${count-status.index } ]</td>
				<td>${vo.name }</td>
				<td>${vo.regDate }</td>
				<td><a href="${pageContext.servletContext.contextPath }/delete?no=${vo.no }">삭제</a></td>
			</tr>
			<tr>
				<td colspan=4>
					${fn:replace(vo.message, newline, "<br>") }
				</td>
			</tr>
		</table>
		<br>
	</c:forEach>
</body>
</html>