<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
$(function () {
	$("#pageNo").change(function () {
		var val = $("#pageNo").val();
		if(checkPage(val)){
			//3. 页面跳转
			toOrderListPage(val);
		}
	})
})
</script>

<h1>我的订单</h1>
<div class="shopping_cart">
	<c:if test="${!empty items }">
		<c:forEach items="${items }" var="item">
			<div class="cart_box">
				<div class="message">
					<div class="list_img" style="border: none;">
						<img src="images/${item.imgUrl }" class="img-responsive" alt="" width="100px" height="140px" />
					</div>
					<div class="list_desc">
						<h3>
							<a href="#">${item.proName }</a>
						</h3>
						${item.proNum } x
						<span class="actual"> ￥${item.price }</span>
						总价：
						<span class="actual"> ￥${item.price*item.proNum }</span>
						颜色：
						<span class="actual"> ${item.colorType }</span>
						尺码：
						<span class="actual"> ${item.sizeType }</span>
						<br>
						地址：
						<span class="actual"> ${item.sheng }</span>
						<span class="actual"> ${item.shi }</span>
						<span class="actual"> ${item.qu }</span>
						<span class="actual"> ${item.userAddress }</span>
						<br>
						电话：
						<span class="actual"> ${item.userPhone }</span>
						<br>
						订单状态：
						<span class="actual"> ${item.conditionType }</span>
						<br>
						下单时间：
						<span class="actual"> ${item.orderTime }</span>
					</div>
					<div class="login_button">
						<c:if test="${2 eq item.orderConditionPkid}">
							<c:if test="${0 eq item.commentPkid}">

								<a href="comment.html?proId=${item.proId}&orderPkid=${item.orderPkid}">去评价</a>

							</c:if>
							<c:if test="${0 != item.commentPkid}">

								<a>已评价</a>
								<br>
								
								
							</c:if>
						</c:if>
					</div>
					<c:if test="${!empty item.commentDes }">
					我的评论：<br>
						<span class="actual"> ${item.commentDes }</span>
					</c:if>
					<br>

					<div class="clearfix"></div>
				</div>
			</div>
		</c:forEach>
	</c:if>

	<br>
	<center>
		<br>
		共${requestScope.page.maxPage }页，当前第${requestScope.page.pageNo }页
		<br>
		<br>
		<a href="#" onclick="toOrderListPage(${requestScope.page.fristPage })">首页</a>
		&nbsp;&nbsp;
		<a href="#" onclick="toOrderListPage(${requestScope.page.beforePage })">上一页</a>
		&nbsp;&nbsp;
		<a href="#" onclick="toOrderListPage(${requestScope.page.nextPage })">下一页</a>
		&nbsp;&nbsp;
		<a href="#" onclick="toOrderListPage(${requestScope.page.maxPage })">末页</a>
		&nbsp;&nbsp;转到<input type="text" size="1" id="pageNo">页
		<br>
	</center>
</div>
