<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap-datetimepicker.min.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/before/base.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/before/user/register.css">

<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jQuery.validate/jquery.validate.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap/js/moment-with-locales.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/before/user/register.js"></script>
</head>
<body>
<div id="container">
	<jsp:include page="/common/before/header.jsp"></jsp:include>
	<jsp:include page="/common/before/menu.jsp"></jsp:include>
	<div id="content">
		<form id="register-form" role="form" class="form-horizontal" method="get">
			<div class="form-group">
				<label class="col-sm-2 control-label" for="username">用户名：</label>
				<div class="col-sm-5">
					<input class="form-control" id="username" name="username" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="password">密码：</label>
				<div class="col-sm-5">
					<input class="form-control" id="password" name="password" type="password" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="confirm_password">确认密码：</label>
				<div class="col-sm-5">
					<input class="form-control" id="confirm_password" name="confirm_password" type="password" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="name">姓名：</label>
				<div class="col-sm-5">
					<input class="form-control" id="name" name="name" type="text" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="confirm_password">性别：</label>
				<div class="col-sm-5"> 
					<label class="radio-inline">
					  <input type="radio" name="sex" id="man" value="男" checked="checked"> 男
					</label>
					<label class="radio-inline">
					  <input type="radio" name="sex" id="woman" value="女"> 女
					</label>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="email">E-Mail：</label>
				<div class="col-sm-5">
					<input class="form-control" id="email" name="email" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="phone">联系方式：</label>
				<div class="col-sm-5">
					<input class="form-control" id="phone" name="phone" />
				</div>
			</div>
			<!-- <div class="form-group">
				<label class="col-sm-2 control-label" for="tel">固定电话：</label>
				<div class="col-sm-5">
					<input class="form-control" id="tel" name="tel" />
				</div>
			</div> -->
			
			<div class="form-group">
				<label class="col-sm-2 control-label">生日：</label>
				<div class="col-sm-5">
					<div class="input-group date" id="datetimepicker1">
						<input name="birthday" class="form-control" value="" id="birthday"/> 
						<span class="input-group-addon"> 
							<span class="glyphicon glyphicon-calendar"></span>
						</span>
					</div>
				</div>
			</div> 
			
			<div class="form-group">
				<label class="col-sm-2 control-label" for="address">头像：</label>
				<div class="col-sm-5">
					<input class="form-control"  id="picture" name="picture" type="file"/>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label" for="address">家庭住址：</label>
				<div class="col-sm-5">
					<input class="form-control" id="address" name="address" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="money">账户余额：</label>
				<div class="col-sm-5">
					<input class="form-control" id="money" name="money" oninput="value=value.replace(/^(0+)|[^\d]+/g,'')"/>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-5" style="text-align: center;">
					<span id="resultInfo"></span>
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-offset-2 col-md-10">
					<button type="submit" class="btn btn-primary btn-sm">注册</button>
					<button type="reset" class="btn btn-primary btn-sm" style="margin-left: 50px;">重置</button>
				</div>
			</div>
		</form>
			
	</div>
</div>
	
</body>
</html>