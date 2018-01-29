<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>User management - Add</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="resources/js/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<ul class="breadcrumb" style="margin: 0px;">
			<li>User Management</li>
			<li>Add User</li>
		</ul>
	</div>
	<form action="userinfo/add.do" class="form-horizontal">
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">Personal Info</h5>
		<!-- 开始1 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">Name</label>
					<div class="col-xs-9 ">
						<input type="text" class="form-control" name="userName" placeholder="Enter user name" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">Type</label>
					<div class="col-xs-9 ">
						<select class="form-control" name="userType">
							<option>Admin</option>
							<option>Visitor</option>
						</select>
					</div>
				</div>
			</div>
		</div>
		<!--结束1 -->



		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">Account Info</h5>
		<!-- 开始5 -->
		<div class="row">
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">Account</label>
					<div class="col-xs-9">
						<input type="text" class="form-control" name="userNumber" placeholder="Enter user account" />
					</div>
				</div>
			</div>
			<div class="col-xs-5">
				<div class="form-group ">
					<label class="col-xs-3 control-label">Password</label>
					<div class="col-xs-9 ">
						<input type="text" class="form-control" name="userPw" placeholder="Enter user password" />
					</div>
				</div>
			</div>
		</div>
		<!--结束5 -->

		<div class="row">
			<div class="col-xs-3 col-xs-offset-4">
				<input type="submit" class="btn btn-success" value="Submit" /> <input
					type="reset" class="btn btn-danger" value="Reset" />
			</div>

		</div>

	</form>
</body>
</html>