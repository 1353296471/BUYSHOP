<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
$(function () {
	$("#pageNo").change(function () {
		var val = $(this).val();
		val = $.trim(val);
		//1. 校验 val 是否为数字 1, 2, 而不是 a12, b
		var flag = false;
		var reg = /^\d+$/g;
		var pageNo = 0;
		
		if(reg.test(val)){
			//2. 校验 val 在一个合法的范围内： 1-maxPage
			pageNo = parseInt(val);
			if(pageNo >= 1 && pageNo <= parseInt("${requestScope.page.maxPage }")){
				flag = true;
			}
		}
		
		
		if(!flag){
			alert("输入的不是合法的页码.");
			$(this).val("");
			return;
		}
		
		//3. 页面跳转
		toOrderListPage(pageNo);
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
						<h4>
							<a href="#">${item.proName }</a>
						</h4>
						${item.proNum } x
						<span class="actual"> $${item.price }</span>
						总价：
						<span class="actual"> $${item.price*item.proNum }</span>
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
