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
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/before/coffee/coffeeDetail.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/before/coffee/coffeeDetail.js"></script>
</head>
<body>
<div id="container">
	<jsp:include page="/common/before/header.jsp"></jsp:include>
	<jsp:include page="/common/before/menu.jsp"></jsp:include>
	<div id="content">
	    <input type="hidden" name="user" value="${webUserLogin}" id="user">
	    <input type="hidden" name="hiddenCoffeeid" value="${coffeeDetail.id}" id="hiddenCoffeeid">
		<div class="container main_center po2_css">
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<div class="colb_css">
						<div class="text-center divl_css">
							<img class="img-rounded"
								src="${pageContext.request.contextPath}/image/before/${coffeeDetail.picture}">
						</div>
						<div class="divr_css">
							<h4>${coffeeDetail.name}</h4>
							<hr>
							<div class="">
								<p class="pc_css">
									<span>咖啡类型 : ${coffeeDetail.coffeetypeid}</span>
									<span>库存 : ${coffeeDetail.num}</span>
									<span>净含量 : ${coffeeDetail.netweight}</span>
								<%--	<span>保质期 : ${coffeeDetail.qualitydate}</span>--%>
									<span>口味 : ${coffeeDetail.tasteName}</span>
									<span>品牌 : ${coffeeDetail.brand}</span>
									<span>储藏方法 : ${coffeeDetail.storage}</span>
								</p>
								<p class="p1_css">
									商品价格：<span class="glyphicon glyphicon-yen">${coffeeDetail.price}</span>
								</p>
							</div>
							<hr>
							<div>
								<p class="text-center">
									<form modelattribute="cart" action="${pageContext.request.contextPath}/filter/before/cart" style="float:left;"
										id="toorder" method="post">
										<input type="hidden" name="m" value="addCart" /> 
										<input type="hidden" name="coffeeid" value="${coffeeDetail.id}" /> 
										<input type="text" oninput="value=value.replace(/^(0+)|[^\d]+/g,'')" name="num" class="input_text" value="1"> 
										<a onclick="document:toorder.submit()"
												href="javascript:void(0);" class="btn btn1_css" role="button" style="width: 73%;"> 
												<span class="glyphicon glyphicon-menu-right"></span> 加 入 购 物 车 
										</a> 
									</form>
									<c:if test="${collectsCoffee eq false}">
											<input type="hidden" id="coffeeid" name="coffeeid" value="${coffeeDetail.id}" />
											<a href="javascript:void(0);"  onclick="addOrRemoveCollects()" id="collectsArea" class="btn sc_css">
											   <span class="glyphicon glyphicon-heart"></span>
											</a>
									</c:if>
									<c:if test="${collectsCoffee eq true}">
											<input type="hidden" id="coffeeid" name="coffeeid" value="${coffeeDetail.id}" />
											<a href="javascript:void(0);"  onclick="addOrRemoveCollects()" id="collectsArea"  class="btn sc_css_active">
											   <span class="glyphicon glyphicon-heart"></span>
											</a>
									</c:if>
									
								</p>
							</div>
						</div>
					</div>
					<script type="text/javascript">
						$("input[name='num']").change(function(){
							if($(this).val()==''){
								$(this).val('1');
							}
						});
						</script>
					<div class="delivery_css">
						<h4 class="boxbg">咖啡简介</h4>
						<div class="more_css">${coffeeDetail.detail}</div>
					</div>
					<div class="comment_div">
						<div class="page-header">
							<h4 class="boxbg">评论</h4>
								<input type="hidden" name="coffeeobj.coffeeid" value="4">
								<textarea class="form-control" name="commentsContent" id="commentsContent" required
									style="min-height: 100px; margin-bottom: 10px"></textarea>
								<button class="btn btn3_css" onclick="addComments(${coffeeDetail.id})">
									<span class="glyphicon glyphicon-comment"></span> 发表评论
								</button>
							<p class="text-success" id="res"></p>
						</div>
						
						<c:forEach items="${commentsList}" var="comments">
							<div>
								<div style="float: left; width: 100%">
									<p>
										评论人：${comments.userRealName}<span style="color: #9e9e9e; margin-left: 10px;">
										发布时间：${comments.addtime}</span>
									</p>
									<div>${comments.content}</div>
									<hr>
								</div>
							</div>
						</c:forEach>
						<div class="text-center"></div>
					</div>
				</div>
				<div class="col-md-2"></div>
			</div>
		</div>
	</div>
	<jsp:include page="/common/before/footer.jsp"></jsp:include>
</div>
	
</body>
</html>