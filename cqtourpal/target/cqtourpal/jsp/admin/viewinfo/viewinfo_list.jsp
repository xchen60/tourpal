<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>View Management - Query</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="resources/js/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
</head>
<body>
<div>
		<ul class="breadcrumb" style="margin: 0px;">
			<li>View Management</li>
			<li>View Query</li>
		</ul>
	</div>
	<form action="viewinfo/list.do" class="form-inline">
		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<div class="form-group">
				<label>Name:</label><input type="text" name="viewName" class="form-control" placeholder="Enter view name" />
			</div>
			<input type="submit" class="btn btn-danger" value="Search"> <a
				href="jsp/admin/viewinfo/viewinfo_add.jsp" class="btn btn-success">Add view</a>
		</div>
		<div class="row" style="padding: 15px;">
			<table class="table table-hover table-condensed">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Picture</th>
					<th>Date</th>
					<td>Operation</td>
				</tr>
			
				<c:forEach items="${list }" var="view" >
				<tr>
					<td>${view.viewId }</td>
					<td>${view.viewName }</td>
					<td><img alt="" src="upload/${view.viewPhoto }" width="50" height="50"></td>
					<td><fmt:formatDate value="${view.viewTime }" type="both"/>  </td>
					<td>
					<a href="viewinfo/load.do?viewId=${view.viewId }">Change</a> 
					
					<a href="javascript:window.location='viewinfo/delete.do?viewId=${view.viewId }'">Delete</a>
					</td>
				</tr>
				</c:forEach>
						
		
			</table>
		</div>
	</form>
</body>
</html>