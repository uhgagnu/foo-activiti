<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>查询流程部署</title>
</head>
<body>
	<center><h2>查询流程部署</h2></center><hr/>
	<table border="1" align="center" width="60%">
		<tr>
			<th>部署ID</th>
			<th>部署名称</th>
			<th>部署分类</th>
			<th>部署时间</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${deployements}" var="d">
			<tr>
				<td>${d.id}</td>
				<td>${d.name}</td>
				<td>${d.category}</td>
				<td> <fmt:formatDate value="${d.deploymentTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
				<td><a href="deleteProcessDeployment.action?id=${d.id}">删除</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>