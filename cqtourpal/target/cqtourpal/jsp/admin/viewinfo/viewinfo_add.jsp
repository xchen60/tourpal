<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>View Management - Add</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="resources/js/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
</head>
<body>
<div>
		<ul class="breadcrumb" style="margin: 0px;">
			<li>View Management</li>
			<li>Add View</li>
		</ul>
	</div>
<form action="viewinfo/add.do" method="post" enctype="multipart/form-data" class="form-horizontal">
		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">Required Info</h5>
		<!-- 开始1 -->
		<div class="row">
			<div class="col-xs-9">
				<div class="form-group ">
					<label class="col-xs-3 control-label">View Name</label>
					<div class="col-xs-9 ">
						<input type="text" name="viewName" class="form-control" placeholder="Enter view name" />
					</div>
				</div>
			</div>
		</div>
		<!--结束1 -->
		<!-- 开始1 -->
		<div class="row">
			<div class="col-xs-9">
				<div class="form-group ">
					<label class="col-xs-3 control-label">Picture</label>
					<div class="col-xs-9 ">
						<input type="file" name="file"  />
					</div>
				</div>
			</div>
		</div>
		<!--结束1 -->


		<h5 class="page-header alert-info"
			style="margin: 0px; padding: 10px; margin-bottom: 10px;">More Info</h5>
		<!-- 开始5 -->
		<div class="row">
			<div class="col-xs-9">
				<div class="form-group ">
					<label class="col-xs-3 control-label">Description</label>
					<div class="col-xs-9">
						<textarea rows="" cols="" name="viewDesc" placeholder="Enter description"  class="form-control"></textarea>
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