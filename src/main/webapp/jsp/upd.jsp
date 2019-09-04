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
		var id=${param.id};
		alert(id);
		$.post(
			"<%=request.getContextPath() %>/toadd",
			function (obj) {
				alert(obj);
				for ( var i in obj) {
					$("select").append("<option value="+obj[i].fid+">"+obj[i].fname+"</option>");					
				}
			},"json");
		
		$.post(
			"<%=request.getContextPath() %>/toupd",
			{"id":id},
			function (arr) {
				alert("111"+arr)
				$("[name=name]").val(arr.name);
				$("[name=js]").val(arr.js);
				$("[name=daoyan]").val(arr.daoyan);
				$("[name=shijian]").val(arr.shijian);
				$("[name=fenlei.fid]").val(arr.fenlei.fid);
			},"json")
		
		
		
	})
	
	function upd() {
		var param= $("form").serialize();
		$.post(
			"<%=request.getContextPath() %>/upd",
			$("form").serialize(),
			function (msg) {
				if(msg>0){
					alert("编辑成功");
					location="<%=request.getContextPath() %>/list";
				}else{
					alert("编辑失败");
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
					<input type="hidden" name="id" value="${param.id }">
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
					<input type="button" value="提交" onclick="upd()">
				</td>
			</tr>
		
		</table>
	
	</form>


</body>
</html>