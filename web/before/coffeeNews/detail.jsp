<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/before/base.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/before/coffeeNews/detail.css">
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
		<div class="container">
		<div class="row">
		    <div class="col-md-12 column">
		        <div class="show_page">
				    <div class="col-md-2"></div>
				    <div class="col-md-8">
				        <div class="page-header text-center">
				            <h4>
				                ${coffeeNewsVO.title }
				            </h4>
				            <p><span style="color: gray;">${coffeeNewsVO.addtime }</span></p>
				        </div>
				        <div class="page-header">
				            <div class="text-center detail_pic">
				                <img src="${pageContext.request.contextPath}/image/before/${coffeeNewsVO.picture }" style="width: 300px;height: 200px">
				            </div>
				            <div class="page-header">
				            <h4 class="boxbg">主要内容</h4>
				            </div>
				            <div style="margin-top: 20px;line-height: 26px;text-indent: 2em;">${coffeeNewsVO.content }
				            </div>
				        </div>
				        <div class="text-center"></div>
				    </div>
				    <div class="col-md-2"></div>
			   </div>
			</div>
		</div>
		</div>
	</div>
	<jsp:include page="/common/before/footer.jsp"></jsp:include>
</div>

</body>
</html>