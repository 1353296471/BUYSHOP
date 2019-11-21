<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form action="toPay" method="post">
	<div class="shopping_cart">
		<c:set var="sum" value="0"></c:set>
		<!-- 判断有itemList的时候，再循环生成购物车项 -->
		<c:if test="${!empty itemList }">
			<c:forEach items="${itemList }" var="item">
				<div class="cart_box">
					<div class="message">
						<div class="alert-close" onclick="deletePro(${item.showProduct.pro.id })"></div>
						<div class="list_img" style="border: none;">
							<img src="images/${item.showProduct.mainImg.imgUrl }" class="img-responsive" alt="" width="50px" height="67px" />
						</div>
						<div class="list_desc">
							<h4>
								<a href="#">${item.showProduct.pro.proName }</a>
							</h4>
							<input type="button" name="remove" value="-" onclick="remove(${item.showProduct.pro.id })">
							${item.num }
							<input type="button" name="add" value="+" onclick="add(${item.showProduct.pro.id })">
							x
							<span class="actual"> $${item.showProduct.pro.price }</span>
						</div>
						<br>
						<input type="checkbox" name="buyProId" value="${item.showProduct.pro.id }" checked="checked" />
						<div class="login_button">
							<a href="">单个结算</a>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
				<c:set var="sum" value="${sum + item.showProduct.pro.price*item.num }" />
			</c:forEach>
		</c:if>
	</div>
	<div class="total">
		<div class="total_left">CartSubtotal :</div>
		<div class="total_right">$${sum }</div>
		<div class="clearfix"></div>
	</div>
	<div class="login_buttons">
		<div class="login_button">
			<input type="button" value="全部结算">
		</div>
		<div class="clearfix"></div>
	</div>
	<div class="clearfix"></div>
</form>