<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>咖啡列表页</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/before/base.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/before/coffee/coffeeListByType.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div id="container">
	<jsp:include page="/common/before/header.jsp"></jsp:include>
	<jsp:include page="/common/before/menu.jsp"></jsp:include>
	<div id="content">
		<div class="container con1_css">
		<div class="row">
			<div class="col-md-12 col12_css">
				<div class="widget">
					<div class="text-center titz_css">
						<h3>咖啡列表</h3>
					</div>
					<div class="tab-content">
					   <c:forEach items="${coffeeList }" var="coffee">
						   <div class="wrapper-thumbnail col-lg-3">
								<a
									href="${pageContext.request.contextPath}/before/coffee?m=detail&id=${coffee.id}"
									class="thumbnail">
									<div class="thumbnail-image">
										<img src="${pageContext.request.contextPath}/image/before/${coffee.picture}"
											class="product-image">
									</div>
									<div class="text-center caption">
										<h5 class="name_css">${coffee.name}</h5>
										<p class="price_css">
											单价<span>￥${coffee.price}</span>
										</p>
									</div>
								</a>
							</div>
					   </c:forEach>
					</div>
				</div>
			</div>
			<div class="text-center">
                 <ul class="pagination">
                 <li  class="disabled">
                         <span>上一页</span>
                     </li>
                         <li class="active"><span>1</span></li>
                 <li  class="disabled">
                     <span>下一页</span>
                 </li>
                 </ul>
             </div>
		</div>
		</div>
	</div>
	<jsp:include page="/common/before/footer.jsp"></jsp:include>
</div>
	
</body>
</html>