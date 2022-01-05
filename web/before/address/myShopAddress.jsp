<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物地址页</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/before/base.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/before/collects/list.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/before/address/myShopAddress.js"></script>
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
						    <table class="table table-striped" style="text-align: center;">
				               <tr>
				                   <th>选择</th>
				                   <th>联系人</th>
				                   <th>收货地址</th>
				                   <th>联系电话</th>
				               </tr>
				               <c:forEach items="${addressList }" var="address">
					              <tr>
					                    <td style="vertical-align: middle" class="coffName">
					                       <c:if test="${address.def eq '是' }">
					         				  <input type="radio" name="def" checked="checked" value="${address.id}">					                       
					                       </c:if>
					                       <c:if test="${address.def eq '否' }">
					         				  <input type="radio" name="def" value="${address.id}">					                       
					                       </c:if>
					         			</td>
					         			<td style="vertical-align: middle" class="coffName">
					         				${address.linkman}
					         			</td>
					         			<td style="vertical-align: middle" class="coffName">
					         				${address.addressname}
					         			</td>
					         			<td style="vertical-align: middle" class="coffName">
					         				${address.phone}
					         			</td>
					               </tr>
				               </c:forEach>
				              	   <tr>
				                   		<td style="vertical-align: middle;text-align: right" colspan="4">
											<a href="javascript:submitCart()" class="btn btn-danger">我要提交</a>
										</td>
				                   </tr>
				       		</table>
				        </div>
			        </div>
	        	</div>
     		</div>
	</div>
	<jsp:include page="/common/before/footer.jsp"></jsp:include>
</div>
</body>
</html>