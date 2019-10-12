<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>您好Springboot</title>
<script type="text/javascript" src="/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		/* 		$.get(url,data,callback,dataType) */
		//$.getJSON("/findAjax",function(result){
		/* each(①data需要遍历的数据②遍历之后的数据需要做的操作) */
		/* index 代表下表 user代表当前下表的元素 */
		/* $.each(result,function(index,user){
			// var user = result[index]; 
			var id = user.id;
			var name = user.name;
			var age = user.age;
			var sex = user.sex;
			var tr="<tr align='center'><td>"+id+"</td><td>"+name+"</td><td>"+age+"</td><td>"+sex+"</td></tr>";
			$("#t1").append(tr); */
		refreshList();
		//$("#t1").on("click","button",doDelete);		
	});
	function refreshList() {
		$.ajax({
			type : "get",
			url : "/findAjax",
			dataType : "json",
			success : function(result) {
				$.each(result, function(index, user) {
					var id = user.id;
					var name = user.name;
					var age = user.age;
					var sex = user.sex;
					var tr = "<tr align='center'><td>" + (id+1) + "</td>"+ 
							 "<td>" + name + "</td>"+
							 "<td>" + age +  "</td>"+
							 "<td>"	+ sex + "</td>" +
							 "<td><button id="+id+">删除</button></td>"+
							 "</tr>";
					$("#t1").append(tr);
				})
				$("button").click(doDelete);				
			}
		});
	}
	function doDelete(){
		var id=$(this).parent().siblings().first().text()-1;
		$.get("/doDelete",{"id":id});
		$(this).parent().parent().remove();
		//$(this).parent.		
		
	}
	//$.load(); 负责加载远程html代码
</script>
</head>
<body>
	<table id="t1" border="1px" width="65%" align="center">
		<tr id="tt1">
			<td colspan="6" align="center"><h3>学生信息</h3></td>
		</tr>
		<tr>
			<th>编号</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>性别</th>
			<th></th>
		</tr>
	</table>
</body>
</html>