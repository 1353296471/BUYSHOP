<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<div class="shopping_cart">
		<c:if test="${!empty items }">
			<c:forEach items="${items }" var="item">
				<div class="cart_box">
					<div class="message">
						<div class="list_img" style="border: none;">
							<img src="images/${item.mainImg.imgUrl }" class="img-responsive" alt="" width="50px" height="67px" />
						</div>
						<div class="list_desc">
							<h4>
								<a href="#">${item.pro.proName }</a>
							</h4>
							${item.orderList.proNum }
							x
							<span class="actual"> $${item.pro.price }</span>
							地址：
							<span class="actual"> ${item.receive.sheng }</span>
							<span class="actual"> ${item.receive.shi }</span>
							<span class="actual"> ${item.receive.qu }</span>
							<span class="actual"> ${item.receive.userAddress }</span>
							电话：
							<span class="actual"> ${item.receive.userPhone }</span>
						</div>
						<br>
						
						<div class="clearfix"></div>
					</div>
				</div>
			</c:forEach>
		</c:if>
	</div>
