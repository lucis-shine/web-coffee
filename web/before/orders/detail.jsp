<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单详情页</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/before/base.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/before/orders/detail.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/before/cart/list.js"></script>
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
                     	 <table id="orderInfo" class="table table-striped" style="text-align: center;">
                     	 	<tr>
                     	 	   <td class="tr_left">地址：</td>
                     	 	   <td>${ordersVO.addressName }</td>
                     	 	</tr>
                     	 	<tr>
                     	 	   <td class="tr_left">联系电话：</td>
                     	 	   <td>${ordersVO.phone }</td>
                     	 	</tr>
                     	 	<tr>
                     	 	   <td class="tr_left">联系人：</td>
                     	 	   <td>${ordersVO.linkman }</td>
                     	 	</tr>
                     	 	<tr>
                     	 	   <td class="tr_left">状态：</td>
                     	 	   <td>${ordersVO.status }</td>
                     	 	</tr>
                     	 </table>
                     
                     </div>
                 </div>
            </div>
		    
             <div class="row">
                 <div class="col-md-12 column">
                     <div class="page-header" style="margin: 0px 0 20px;">
						    <table class="table table-striped" style="text-align: center;">
				               <tr>
				                   <th>咖啡</th>
				                   <th>咖啡名称</th>
				                   <th>购买数量</th>
				                   <th>价格</th>
				                   <th>价格小计</th>
				               </tr>
				               <c:forEach items="${orderdetailList }" var="orderdetail">
					              <tr>
					                    <td style="vertical-align: middle" class="coffImg">
					                        <a href="${pageContext.request.contextPath}/before/coffee?m=detail&&id=${orderdetail.coffeeid}">				                        
					                    		<img alt="" src="${pageContext.request.contextPath}/image/before/${orderdetail.picture}">
					                        </a>
					                    </td>
					         			<td style="vertical-align: middle" class="coffName">
					         				<a href="${pageContext.request.contextPath}/before/coffee?m=detail&&id=${orderdetail.coffeeid}">	
					         				${orderdetail.coffeeName}
					         				</a>
					         			</td>
					         			<td style="vertical-align: middle" class="coffName">
					         				${orderdetail.num }
					         			</td>
					         			
					         			<td style="vertical-align: middle" class="coffName">
					         				${orderdetail.price}
					         			</td>
					         			
					         			<td style="vertical-align: middle" class="coffName">
					         				${orderdetail.num * orderdetail.price}
					         			</td>
					         			
					               </tr>
				                   
				               </c:forEach>
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