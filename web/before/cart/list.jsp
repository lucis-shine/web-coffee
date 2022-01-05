<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车列表页</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/js/bootstrap/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/before/base.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/before/collects/list.css">
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
						    <table class="table table-striped" style="text-align: center;">
				               <tr>
				                   <th>咖啡</th>
				                   <th>咖啡名称</th>
				                   <th>购买数量</th>
				                   <th>价格</th>
				                   <th>价格小计</th>
				                   <th>操作</th>
				               </tr>
				               <c:forEach items="${cartItemList }" var="cart">
					              <tr>
					                    <td style="vertical-align: middle" class="coffImg">
					                        <a href="${pageContext.request.contextPath}/before/coffee?m=detail&&id=${cart.coffeeid}">				                        
					                    		<img alt="" src="${pageContext.request.contextPath}/image/before/${cart.coffeePicture}">
					                        </a>
					                    </td>
					         			<td style="vertical-align: middle" class="coffName">
					         				<a href="${pageContext.request.contextPath}/before/coffee?m=detail&&id=${cart.coffeeid}">	
					         				${cart.coffeeName}
					         				</a>
					         			</td>
					         			<td style="vertical-align: middle" class="coffName">
					         				<input onchange="changeNum(${cart.id},${cart.num},this)" 
					         				oninput="value=value.replace(/^(0+)|[^\d]+/g,'')" type="text" name="num" value="${cart.num }" style="width: 50px;">
					         			</td>
					         			
					         			<td style="vertical-align: middle" class="coffName">
					         				${cart.coffeePrice}
					         			</td>
					         			
					         			<td style="vertical-align: middle" class="coffName">
					         				${cart.num*cart.coffeePrice}
					         			</td>

					                    <td style="vertical-align: middle" class="operator">
					                       <a href="javascript:remove(${cart.id })" onClick="return confirm('确定删除?');" class="btn btn-default">删&nbsp;&nbsp;除</a> 
					                    </td>
					               </tr>
				                   
				               </c:forEach>
				                   <tr>
				                      <td colspan="6" align="right" style="font-size: 20px;font-weight: 900;color: red;">
				                      	总价格：${totalPrice }
				                      </td>
				                   </tr>
				                   <tr>
				                   		<td style="vertical-align: middle;text-align: right" colspan="6">
											<span id="resultInfo"></span>
										</td>
				                   </tr>
				                   <tr>
				                   		<td style="vertical-align: middle;text-align: right" colspan="6">
											<a href="${pageContext.request.contextPath}/filter/before/address?m=myAddress" class="btn btn-danger">提交订单</a>
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