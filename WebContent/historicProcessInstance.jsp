<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="it" uri="/date-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>查询历史流程实例</title>
</head>
<body>
	<center><h2>查询历史流程实例</h2></center><hr/>
	<table border="1" align="center" width="80%">
		<tr>
			<th>历史流程实例ID</th>
			<th>流程定义ID</th>
			<th>开始时间</th>
			<th>结束时间</th>
			<th>一共花费的时间毫秒数</th>
			<th>删除原因</th>
			<th colspan="1">操作</th>
		</tr>
		<c:forEach items="${hpiLists}" var="p">
			<tr>
				<td>${p.id}</td>
				<td>${p.processDefinitionId}</td>
				<td><fmt:formatDate value="${p.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
				<td><fmt:formatDate value="${p.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td><it:formatDate value="${p.durationInMillis}"/></td>
				<td>${p.deleteReason}</td>
				<td><a href="queryHistoricTaskInstance.action?hpiId=${p.id }">查看历史任务</a></td>
			</tr>
		</c:forEach>
		
		
	</table>
	
</body>
</html>