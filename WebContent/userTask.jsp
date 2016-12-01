<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>用户任务</title>
	
</head>
<body>
	<center><h2>用户任务</h2></center><hr/>
	<table border="1" align="center" width="80%">
		<tr>
			<th>任务ID</th>
			<th>任务名称</th>
			<th>任务处理人</th>
			<th>任务创建时间</th>
			<th>流程定义ID</th>
			<th>流程实例ID</th>
			<th colspan="1">操作</th>
		</tr>
		<c:forEach items="${taskLists}" var="t">
			<tr>
				<td>${t.id}</td>
				<td>${t.name}</td>
				<td>${t.assignee}</td>
				<td><fmt:formatDate value="${t.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
				<td>${t.processDefinitionId}</td>
				<td>${t.processInstanceId}</td>
				<td><a href="completeUserTask.action?taskId=${t.id}">完成任务</a></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>