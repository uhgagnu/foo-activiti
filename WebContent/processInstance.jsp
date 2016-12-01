<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>查询流程实例</title>
	<script type="text/javascript">
		/** 显示流程图 */
		var showDiagramFn = function(piId){
			document.getElementById("diagram").src = "seeProcessDiagram.action?piId=" + piId;
			
		};
	</script>
</head>
<body>
	<center><h2>查询流程实例</h2></center><hr/>
	<table border="1" align="center" width="80%">
		<tr>
			<th>流程实例ID</th>
			<th>流程实例ID</th>
			<th>流程定义ID</th>
			<th>活动节点</th>
			<th>流程定义名称</th>
			<th>流程定义版本</th>
			<th>部署ID</th>
			<th colspan="4">操作</th>
		</tr>
		<c:forEach items="${piLists}" var="p">
			<tr>
				<td>${p.id}</td>
				<td>${p.processInstanceId}</td>
				<td>${p.processDefinitionId}</td>
				<td>${p.activityId}</td>
				<td>${p.processDefinitionName}</td>
				<td>${p.processDefinitionVersion}</td>
				<td>${p.deploymentId}</td>
				<td><a href="deleteProcessInstance.action?piId=${p.id}&pdId=${p.processDefinitionId}">删除流程实例</a></td>
				<td><a href="javascript:showDiagramFn(${p.id})">查看流程图</a></td>
				<td><a href="signalProcessInstance.action?piId=${p.id}&pdId=${p.processDefinitionId}">走一步</a></td>
				<td><a href="queryTask.action?piId=${p.id}">查看任务</a></td>
			</tr>
		</c:forEach>
	</table>
	<center>
		<img id="diagram"/>
	</center>
</body>
</html>