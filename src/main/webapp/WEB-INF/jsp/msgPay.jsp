<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Checkout</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Flatro Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 















</script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<!--webfont-->
<link href='#css?family=Lato:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>
	$(document).ready(function() {
		$(".megamenu").megamenu();
	});
</script>

<script>
	function isLogin() {
		var flag = false;
		$.ajax({
			async : false,
			//async. 默认是 true，即为异步方式，$.ajax执行后，会继续执行ajax后面的脚本，
			//直到服务器端返回数据后，触发$.ajax里的success方法，这时候执行的是两个线程。
			//async 设置为 false，则所有的请求均为同步请求，在没有返回值之前，
			//同步请求将锁住浏览器，用户其它操作必须等待请求完成才可以执行。
			type : 'post',
			url : 'isLogin',
			success : function(msg) {
				if (msg == "isLogin") {
					flag = true;
				} else {
					flag = false;
				}
			}
		});
		return flag;
	}

	function updateBuyList() {
		$.ajax({
			type : 'post',
			url : 'updateBuyList',
			success : function(msg) {
				$("#buyList").html(msg);
			}
		});
	}

	$(document).ready(function() {
		updateBuyList();
		if (isLogin()) {
			$.ajax({
				type : 'post',
				url : 'getUser',
				success : function(user) {
					$("#account").html(user.userName);
				}
			});

		}
	})

	function remove(proId) {
		$.ajax({
			type : 'post',
			url : 'removeShopCarItem/' + proId,
			success : function(countMsg) {
				if (countMsg == "操作成功！") {
					updateBuyList();
				}
			}
		});
	}

	function add(proId) {
		$.ajax({
			type : 'post',
			url : 'addShopCarItem/' + proId,
			success : function(countMsg) {
				if (countMsg == "操作成功！") {
					updateBuyList();
				}
			}
		});
	}

	function deletePro(proId) {
		var r = confirm("确定要删除购物项吗？");
		if (r == true) {
			$.ajax({
				type : 'post',
				url : 'deleteShopCarItem/' + proId,
				success : function(countMsg) {
					if (countMsg == "操作成功！") {
						alert("删除成功！");
						updateBuyList();
					} else {
						alert("删除失败！");
					}
				}
			});
		}
	}

	function toShowShopCarItem() {
		if (isLogin()) {
			$.ajax({
				type : 'post',
				url : 'showShopCar',
				success : function(msg) {
					$("#shopCarItemListDiv").html(msg);
				}
			});
		} else {
			var txt = "";
		}
	}
</script>

</head>
<body>
	<div class="header_top">
		<div class="container">
			<div class="one-fifth column row_1">
				<span class="selection-box">
					<select class="domains valid" name="domains">
						<option>English</option>
						<option>French</option>
						<option>German</option>
					</select>
				</span>
			</div>
			<div class="cssmenu">
				<ul>
					<li class="active"><a href="login.html" id="account">My
							Account</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="header_bottom men_border">
		<div class="container">
			<div class="col-xs-9 header-bottom-left">
				<div class="col-xs-2 logo">
					<h1>
						<a href="index.html">
							<span>Buy</span>
							shop
						</a>
					</h1>
				</div>
				<div class="col-xs-7 menu">
					<ul class="megamenu skyblue">
						<li>
							<a class="color1" href="index.html">Men</a>
							<div class="megapanel">
								<div class="row">
									<div class="col1">
										<div class="h_nav">
											<ul>
												<li>
													<a href="men.html">Accessories</a>
												</li>
												<li>
													<a href="men.html">Bags</a>
												</li>
												<li>
													<a href="men.html">Caps & Hats</a>
												</li>
												<li>
													<a href="men.html">Hoodies & Sweatshirts</a>
												</li>
												<li>
													<a href="men.html">Jackets & Coats</a>
												</li>
												<li>
													<a href="men.html">Jeans</a>
												</li>
												<li>
													<a href="men.html">Jewellery</a>
												</li>
												<li>
													<a href="men.html">Jumpers & Cardigans</a>
												</li>
												<li>
													<a href="men.html">Leather Jackets</a>
												</li>
												<li>
													<a href="men.html">Long Sleeve T-Shirts</a>
												</li>
												<li>
													<a href="men.html">Loungewear</a>
												</li>
											</ul>
										</div>
									</div>
									<div class="col1">
										<div class="h_nav">
											<ul>
												<li>
													<a href="men.html">Shirts</a>
												</li>
												<li>
													<a href="men.html">Shoes, Boots & Trainers</a>
												</li>
												<li>
													<a href="men.html">Shorts</a>
												</li>
												<li>
													<a href="men.html">Suits & Blazers</a>
												</li>
												<li>
													<a href="men.html">Sunglasses</a>
												</li>
												<li>
													<a href="men.html">Sweatpants</a>
												</li>
												<li>
													<a href="men.html">Swimwear</a>
												</li>
												<li>
													<a href="men.html">Trousers & Chinos</a>
												</li>
												<li>
													<a href="men.html">T-Shirts</a>
												</li>
												<li>
													<a href="men.html">Underwear & Socks</a>
												</li>
												<li>
													<a href="men.html">Vests</a>
												</li>
											</ul>
										</div>
									</div>
									<div class="col1">
										<div class="h_nav">
											<h4>Popular Brands</h4>
											<ul>
												<li>
													<a href="men.html">Levis</a>
												</li>
												<li>
													<a href="men.html">Persol</a>
												</li>
												<li>
													<a href="men.html">Nike</a>
												</li>
												<li>
													<a href="men.html">Edwin</a>
												</li>
												<li>
													<a href="men.html">New Balance</a>
												</li>
												<li>
													<a href="men.html">Jack & Jones</a>
												</li>
												<li>
													<a href="men.html">Paul Smith</a>
												</li>
												<li>
													<a href="men.html">Ray-Ban</a>
												</li>
												<li>
													<a href="men.html">Wood Wood</a>
												</li>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</li>
						<li class="grid">
							<a class="color2" href="#">Women</a>
							<div class="megapanel">
								<div class="row">
									<div class="col1">
										<div class="h_nav">
											<ul>
												<li>
													<a href="men.html">Accessories</a>
												</li>
												<li>
													<a href="men.html">Bags</a>
												</li>
												<li>
													<a href="men.html">Caps & Hats</a>
												</li>
												<li>
													<a href="men.html">Hoodies & Sweatshirts</a>
												</li>
												<li>
													<a href="men.html">Jackets & Coats</a>
												</li>
												<li>
													<a href="men.html">Jeans</a>
												</li>
												<li>
													<a href="men.html">Jewellery</a>
												</li>
												<li>
													<a href="men.html">Jumpers & Cardigans</a>
												</li>
												<li>
													<a href="men.html">Leather Jackets</a>
												</li>
												<li>
													<a href="men.html">Long Sleeve T-Shirts</a>
												</li>
												<li>
													<a href="men.html">Loungewear</a>
												</li>
											</ul>
										</div>
									</div>
									<div class="col1">
										<div class="h_nav">
											<ul>
												<li>
													<a href="men.html">Shirts</a>
												</li>
												<li>
													<a href="men.html">Shoes, Boots & Trainers</a>
												</li>
												<li>
													<a href="men.html">Shorts</a>
												</li>
												<li>
													<a href="men.html">Suits & Blazers</a>
												</li>
												<li>
													<a href="men.html">Sunglasses</a>
												</li>
												<li>
													<a href="men.html">Sweatpants</a>
												</li>
												<li>
													<a href="men.html">Swimwear</a>
												</li>
												<li>
													<a href="men.html">Trousers & Chinos</a>
												</li>
												<li>
													<a href="men.html">T-Shirts</a>
												</li>
												<li>
													<a href="men.html">Underwear & Socks</a>
												</li>
												<li>
													<a href="men.html">Vests</a>
												</li>
											</ul>
										</div>
									</div>
									<div class="col1">
										<div class="h_nav">
											<h4>Popular Brands</h4>
											<ul>
												<li>
													<a href="men.html">Levis</a>
												</li>
												<li>
													<a href="men.html">Persol</a>
												</li>
												<li>
													<a href="men.html">Nike</a>
												</li>
												<li>
													<a href="men.html">Edwin</a>
												</li>
												<li>
													<a href="men.html">New Balance</a>
												</li>
												<li>
													<a href="men.html">Jack & Jones</a>
												</li>
												<li>
													<a href="men.html">Paul Smith</a>
												</li>
												<li>
													<a href="men.html">Ray-Ban</a>
												</li>
												<li>
													<a href="men.html">Wood Wood</a>
												</li>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</li>
						<li>
							<a class="color4" href="about.html">About</a>
						</li>
						<li class="active grid">
							<a class="color5" href="404.html">Blog</a>
						</li>
						<li>
							<a class="color6" href="contact.html">Support</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="col-xs-3 header-bottom-right">
				<ul class="icon1 sub-icon1 profile_img">
					<li>
						<a class="active-icon c1" onmouseover="toShowShopCarItem()" href="#"> </a>
						<ul class="sub-icon1 list" id="shopCarItemListDiv">
							<div class="login_buttons">
								<div class="login_button">
									<a href="login.html">Login</a>
								</div>
								<div class="clearfix"></div>
							</div>
						</ul>
					</li>
				</ul>
				<div class="search">
					<input type="text" name="s" class="textbox" value="Search" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}"> <input type="submit" value="Subscribe" id="submit" name="submit">
					<div id="response"></div>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>

	<script src="js/location.js"></script>
	<script type="text/javascript">
	$(function() {
		$("#province").change(function() {
			var location = $('#province option:selected').text();
			document.getElementById('sheng').value = location;
		})

		$("#city").change(function() {
			var location = $('#city option:selected').text();
			document.getElementById('shi').value = location;
		})

		$("#county").change(function() {
			var location = $('#county option:selected').text();
			document.getElementById('qu').value = location;
		})

	})
	</script>
	<center id="topay">
		<br>
		<br>
		<br>
		<h3 id="msg">${msg }</h3>
		<br>
		<br>
		<br>
	</center>


	<script>
		var loc = beva.locationutil.attach('province', 'city', 'county',
				'address');

		// loc.setSelectedCodes([697,698]);
	</script>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<div class="footer">
		<div class="container">
			<div class="footer_top">
				<div class="col-md-4 box_3">
					<h3>Our Stores</h3>
					<address class="address">
						<p>
							9870 St Vincent Place,
							<br>
							Glasgow, DC 45 Fr 45.
						</p>
						<dl>
							<dt></dt>
							<dd>
								Freephone:
								<span> +1 800 254 2478</span>
							</dd>
							<dd>
								Telephone:
								<span> +1 800 547 5478</span>
							</dd>
							<dd>
								FAX:
								<span>+1 800 658 5784</span>
							</dd>
							<dd>
								E-mail:&nbsp;
								<a href="mailto@example.com">info(at)buyshop.com</a>
							</dd>
						</dl>
					</address>
					<ul class="footer_social">
						<li>
							<a href="">
								<i class="fb"> </i>
							</a>
						</li>
						<li>
							<a href="">
								<i class="tw"> </i>
							</a>
						</li>
						<li>
							<a href="">
								<i class="google"> </i>
							</a>
						</li>
						<li>
							<a href="">
								<i class="instagram"> </i>
							</a>
						</li>
					</ul>
				</div>
				<div class="col-md-4 box_3">
					<h3>Blog Posts</h3>
					<h4>
						<a href="#">Sed ut perspiciatis unde omnis</a>
					</h4>
					<p>The standard chunk of Lorem Ipsum used since the 1500s is reproduced</p>
					<h4>
						<a href="#">Sed ut perspiciatis unde omnis</a>
					</h4>
					<p>The standard chunk of Lorem Ipsum used since the 1500s is reproduced</p>
					<h4>
						<a href="#">Sed ut perspiciatis unde omnis</a>
					</h4>
					<p>The standard chunk of Lorem Ipsum used since the 1500s is reproduced</p>
				</div>
				<div class="col-md-4 box_3">
					<h3>Support</h3>
					<ul class="list_1">
						<li>
							<a href="#">Terms & Conditions</a>
						</li>
						<li>
							<a href="#">FAQ</a>
						</li>
						<li>
							<a href="#">Payment</a>
						</li>
						<li>
							<a href="#">Refunds</a>
						</li>
						<li>
							<a href="#">Track Order</a>
						</li>
						<li>
							<a href="#">Services</a>
						</li>
					</ul>
					<ul class="list_1">
						<li>
							<a href="#">Services</a>
						</li>
						<li>
							<a href="#">Press</a>
						</li>
						<li>
							<a href="#">Blog</a>
						</li>
						<li>
							<a href="#">About Us</a>
						</li>
						<li>
							<a href="#">Contact Us</a>
						</li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="footer_bottom">
				<div class="copy">
					<p>
						Copyright &copy; 2015.Company name All rights reserved.
						<a target="_blank" href="http://guantaow.taobao.com/">厚朴网络淘宝店</a>
						<a target="_blank" href="http://www.moobnn.com">网页模板</a>
					</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>