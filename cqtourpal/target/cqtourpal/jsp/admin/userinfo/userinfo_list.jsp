<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="d" uri="http://displaytag.sf.net"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>User management - Query</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="resources/js/jquery.min.js"></script>
<script type="text/javascript"
	src="resources/js/bootstrap.min.js"></script>
</head>

<body>
	<div>
		<ul class="breadcrumb" style="margin: 0px;">
			<li>User Management</li>
			<li>User List</li>
		</ul>
	</div>
	<form action="userinfo/list.do" class="form-inline" id="cxt">

		<div class="row alert alert-info" style="margin: 0px; padding: 5px;">
			<div class="form-group">
				<label>Name:</label> 
				<input type="text" name="userName" class="form-control" placeholder="Enter name" />
				<label>Type:</label>
				<select name="userType" class="form-control">
					<option value="">None</option>
					<option value="admin">Admin</option>
					<option value="vistor">Vistor</option>
				</select>
				
			</div>
			<input type="submit" class="btn btn-danger" value="Search"> <a
				href="jsp/admin/userinfo/userinfo_add.jsp" class="btn btn-success">Add user</a>
		</div>
		
		<div class="row" style="padding: 15px; align="right"">
			<d:table name="${list }" class="table table-hover table-condensed" pagesize="8" requestURI="userinfo/list.do">
				<d:column property="userNumber" title="Account" />
				<d:column property="userPw" title="Password" />
				<d:column property="userName" title="Name" />
				<d:column property="userType" title="Type" />
				<d:column paramId="userNumber" paramProperty="userNumber" value="change"
					href="userinfo/load.do" title="Change" />
				<d:column paramId="userNumber" paramProperty="userNumber" value="delete"
					href="userinfo/delete.do" title="Delete" />
			</d:table>
		</div>
	</form>
</body>
</html>