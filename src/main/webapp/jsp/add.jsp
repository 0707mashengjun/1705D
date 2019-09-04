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
	$(function () {
		
		$.post(
			"<%=request.getContextPath() %>/toadd",
			function (obj) {
				alert(obj);
				for ( var i in obj) {
					$("select").append("<option value="+obj[i].fid+">"+obj[i].fname+"</option>");					
				}
			},"json")
		
	})
	
	function add() {
		$.post(
			"<%=request.getContextPath() %>/add",
			$("form").serialize(),
			function (msg) {
				if(msg){
					alert("添加成功");
					location="<%=request.getContextPath() %>/list";
				}else{
					alert("添加失败");
				}
			}
		)
	}
	
	

</script>

<body>
	<form>
		<table>
		
			<tr>
				<th>电影名称：</th>
				<td>
					<input type="text" name="name">
				</td>
			</tr>
			
			<tr>
				<th>电影介绍：</th>
				<td>
					<input type="text" name="js">
				</td>
			</tr>
			
			<tr>
				<th>电影导演：</th>
				<td>
					<input type="text" name="daoyan">
				</td>
			</tr>
			
			<tr>
				<th>上映时间：</th>
				<td>
					<input type="date" name="shijian">
				</td>
			</tr>
			
			
			<tr>
				<th>电影类型：</th>
				<td>
					<select name="fenlei.fid">
						<option value="">请选择</option>
					</select>
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="button" value="提交" onclick="add()">
				</td>
			</tr>
		
		</table>
	
	
	</form>


</body>
</html>