<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加地址页</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/before/base.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/before/collects/list.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jQuery.validate/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/before/address/add.js"></script>
</head>
<body>
<div id="container">
	<jsp:include page="/common/before/header.jsp"></jsp:include>
	<jsp:include page="/common/before/menu.jsp"></jsp:include>
	<div id="content">
		<div class="container" style="margin-top: 10px; background-color: #f0f0f0; min-height: 750px;">
             <div class="row">
                 <div class="col-md-12 column">
                     <div class="page-header" style="margin: 0px 0 20px;">
						<form id="add-form" role="form" class="form-horizontal" method="get">
							<div class="form-group">
								<label class="col-sm-4 control-label" for="addressname">联系地址：</label>
								<div class="col-sm-5">
									<input class="form-control" id="addressname" name="addressname" placeholder="请输入联系地址"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label" for="phone">联系电话：</label>
								<div class="col-sm-5">
									<input class="form-control" id="phone" name="phone" type="text"  placeholder="请输入联系电话"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label" for="linkman">联系人：</label>
								<div class="col-sm-5">
									<input class="form-control" id="linkman" name="linkman" type="text"  placeholder="请输入联系人"/>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-5" style="text-align: right;">
									<span id="resultInfo"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-offset-4 col-md-8">
									<button type="submit" class="btn btn-primary btn-sm" style="margin-left:80px;">保存</button>
									<button type="reset" class="btn btn-primary btn-sm" style="margin-left: 50px;">重置</button>
								</div>
							</div>
						</form>    
				     </div>
			      </div>
	          </div>
       </div>
	</div>
	<jsp:include page="/common/before/footer.jsp"></jsp:include>
</div>
</body>
</html>