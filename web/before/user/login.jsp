<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/before/base.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/before/user/login.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jQuery.validate/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/before/user/login.js"></script>
</head>
<body>
<div id="container">
	<jsp:include page="/common/before/header.jsp"></jsp:include>
	<jsp:include page="/common/before/menu.jsp"></jsp:include>
	<div id="content">
		<form id="login-form" role="form" class="form-horizontal" method="get">
			<div class="form-group">
				<label class="col-sm-2 control-label" for="username">用户名：</label>
				<div class="col-sm-5">
					<input class="form-control" id="username" name="username" placeholder="请输入用户名"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="password">密码：</label>
				<div class="col-sm-5">
					<input class="form-control" id="password" name="password" type="password"  placeholder="请输入密码"/>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-5" style="text-align: right;">
					<span id="resultInfo"></span>
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-offset-2 col-md-10">
					<button type="submit" class="btn btn-primary btn-sm" style="margin-left:80px;">登录</button>
					<button type="reset" class="btn btn-primary btn-sm" style="margin-left: 50px;">重置</button>
				</div>
			</div>
		</form>
			
	</div>
	<jsp:include page="/common/before/footer.jsp"></jsp:include>
</div>
</body>
</html>