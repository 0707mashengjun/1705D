<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <link href="<%=request.getContextPath()%>/css/css.css" rel="stylesheet"> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.3.js"></script> 
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function add() {
		alert("加载");
		location="<%=request.getContextPath() %>/jsp/add.jsp";
	}
	
	function upd(id) {
		alert(id)
		location="<%=request.getContextPath() %>/jsp/upd.jsp?id="+id;
	}
	
	
</script>

<body>
	<form action="<%=request.getContextPath() %>/list" method="post">
	
		<input type="text" name="mohu1">
		<input type="submit" value="提交">
	</form>


	<table>
		<tr>
			<th>编号</th>
			<th>电影名称</th>
			<th>电影介绍</th>
			<th>导演</th>
			<th>上映时间</th>
			<th>类型</th>
			<th>添加
				<input type="button" value="添加" onclick="add()">
			</th>
		</tr>
		<c:forEach items="${list }" var="s">
			<tr>
				<td>${s.id }</td>
				<td>${s.name }</td>
				<td>${s.js }</td>
				<td>${s.daoyan }</td>
				<td>${s.shijian }</td>
				<td>${s.fname }</td>
				<td>
					<input type="button" value="编辑" onclick="upd(${s.id})">
					<input type="button" value="删除" onclick="upd(${s.id})">
				</td>
			</tr>
		</c:forEach>
		
		<tr>
			<td colspan="8">
				${page2 }
			</td>
		</tr>
	</table>
	

</body>
</html>