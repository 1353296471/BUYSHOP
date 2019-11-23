<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>我的订单</h1>
<div class="shopping_cart">
	<c:if test="${!empty items }">
		<c:forEach items="${items }" var="item">
			<div class="cart_box">
				<div class="message">
					<div class="list_img" style="border: none;">
						<img src="images/${item.mainImg.imgUrl }" class="img-responsive" alt="" width="100px" height="140px" />
					</div>
					<div class="list_desc">
						<h4>
							<a href="#">${item.pro.proName }</a>
						</h4>
						${item.orderList.proNum } x
						<span class="actual"> $${item.pro.price }</span>
						总价：<span class="actual"> $${item.pro.price*item.orderList.proNum }</span>
						<br>
						地址：
						<span class="actual"> ${item.receive.sheng }</span>
						<span class="actual"> ${item.receive.shi }</span>
						<span class="actual"> ${item.receive.qu }</span>
						<span class="actual"> ${item.receive.userAddress }</span>
						<br>
						电话：<span class="actual"> ${item.receive.userPhone }</span>
						<br>
						订单状态：<span class="actual"> ${item.conditionType }</span>
						<br>
						下单时间：<span class="actual"> ${item.orderList.orderTime }</span>
					</div>


					<br>

					<div class="clearfix"></div>
				</div>
			</div>
		</c:forEach>
	</c:if>
</div>
