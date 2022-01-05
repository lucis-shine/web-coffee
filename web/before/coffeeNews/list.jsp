<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻列表页</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/before/base.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/before/coffeeNews/list.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-3.6.0.min.js"></script>
</head>
<body>
<div id="container">
	<jsp:include page="/common/before/header.jsp"></jsp:include>
	<jsp:include page="/common/before/menu.jsp"></jsp:include>
	<div id="content">
		<div id="coffeeNews">
			<h3>新闻咨询</h3>
			<c:forEach items="${coffeeNewsList }" var="news">
				<div class="newsContent">
					<div class="title">
						<a href="${pageContext.request.contextPath}/before/coffeeNews?m=detail&id=${news.id}">${news.title}</a>
					</div>
					<div class="time">
						${news.addtime}
					</div>
				</div>
			</c:forEach>
			<div class="pageContent">
				<ul class="pagination">
					<li class="disabled"><a href="#">上一页</a></li>
					<li class="active"><a href="#">1</a></li>
					<li class="disabled"><a href="#">下一页</a></li>
				</ul>
			</div>
		</div>
	</div>
	<jsp:include page="/common/before/footer.jsp"></jsp:include>
</div>
	
</body>
</html>