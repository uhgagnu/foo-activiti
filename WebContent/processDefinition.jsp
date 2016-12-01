<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>查询流程定义</title>
</head>
<body>
	<center><h2>查询流程定义</h2></center><hr/>
	<table border="1" align="center" width="80%">
		<tr>
			<th>流程定义ID</th>
			<th>流程定义Key</th>
			<th>流程定义名称</th>
			<th>版本号</th>
			<th>资源文件名称</th>
			<th>资源图片名称</th>
			<th>部署ID</th>
			<th colspan="3">操作</th>
		</tr>
		<c:forEach items="${pdLists}" var="p">
			<tr>
				<td>${p.id}</td>
				<td>${p.key}</td>
				<td>${p.name}</td>
				<td>${p.version}</td>
				<td>${p.resourceName}</td>
				<td>${p.diagramResourceName}</td>
				<td>${p.deploymentId}</td>
				<td><a href="startProcessInstanceById.action?pdId=${p.id}">根据id开启流程实例</a></td>
				<td><a href="startProcessInstanceByKey.action?pdKey=${p.key}">根据key开启流程实例</a></td>
				<td><a href="queryProcessInstance.action?pdId=${p.id}">查询流程实例</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>