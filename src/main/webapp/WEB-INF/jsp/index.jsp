<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="box_1">
	<div class="col-md-7">
		<div class="section group">
			<c:forEach items="${showProducts }" var="pro">
				<div class="col_1_of_3 span_1_of_3">
					<div class="shop-holder">
						<div class="product-img">
							<a href="tosingle/${pro.pro.id}"> <img width="225" height="265"
								src="images/${pro.mainImg.imgUrl }" class="img-responsive" alt="item4">
							</a> <a id="addShopCarItem"  class="button"  onclick="toAddShopCar(${pro.pro.id})"></a>
						</div>
					</div>
					<div class="shop-content" style="height: 80px;">
						<div>
							<a href="single.html" rel="tag">${pro.pro.proName }</a>
						</div>
						<h3>
							<a href="single.html">Non-charac</a>
						</h3>
						<span><span class="amount">$${pro.pro.price }</span></span>
					</div>
				</div>
			</c:forEach>
			<div class="clearfix"></div>
		</div>
	</div>
	<div class="col-md-5 row_3">
		<div class="about-block-content">
			<div class="border-add"></div>
			<h4>About Us</h4>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
				Obcaecati beatae quam voluptatibus deleniti ipsa consequatur!</p>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing.</p>
			<p></p>
		</div>
		<img src="images/pic9.jpg" class="img-responsive" alt="" />
	</div>
	<div class="clearfix"></div>
</div>