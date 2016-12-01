<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>流程定义部署</title>
</head>
<body>
	<center><h2>流程定义部署</h2></center><hr/>
	<form action="deploy.action" method="post" enctype="multipart/form-data">
		流程定义名称：<input type="text" name="processName"/><br/>
		请选择流程定义文件：<input type="file" name="bpmn"/><br/>
		<input type="submit" value="部署"/>
	</form>
</body>
</html>