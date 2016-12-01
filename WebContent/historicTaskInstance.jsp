<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="it" uri="/date-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>查询历史任务实例</title>
</head>
<body>
	<center><h2>查询历史任务实例</h2></center><hr/>
	<table border="1" align="center" width="80%">
		<tr>
			<th>任务ID</th>
			<th>任务名称</th>
			<th>任务处理人</th>
			<th>开始时间</th>
			<th>结束时间</th>
			<th>一共花费的时间毫秒数</th>
			<th>领取时间</th>
			<th>工作花费的时间毫秒数</th>
		</tr>
		<c:forEach items="${htiLists}" var="p">
			<tr>
				<td>${p.id}</td>
				<td>${p.name}</td>
				<td>${p.assignee }</td>
				<td><fmt:formatDate value="${p.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
				<td><fmt:formatDate value="${p.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td><it:formatDate value="${p.durationInMillis}"/></td>
				<td><fmt:formatDate value="${p.claimTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td><it:formatDate value="${p.workTimeInMillis}"/></td>
			</tr>
		</c:forEach>
		
		
	</table>
	
</body>
</html>