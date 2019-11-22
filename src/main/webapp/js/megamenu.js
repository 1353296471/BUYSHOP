$.fn.megamenu = function(e) {
	function r() {
		$(".megamenu").find("li, a").unbind();
		if (window.innerWidth <= 768) {
			o();
			s();
			if (n == 0) {
				$(".megamenu > li:not(.showhide)").hide(0)
			}
		} else {
			u();
			i()
		}
	}
	function i() {
		$(".megamenu li").bind("mouseover", function() {
			$(this).children(".dropdown, .megapanel").stop().fadeIn(t.interval)
		}).bind(
				"mouseleave",
				function() {
					$(this).children(".dropdown, .megapanel").stop().fadeOut(
							t.interval)
				})
	}
	function s() {
		$(".megamenu > li > a").bind(
				"click",
				function(e) {
					if ($(this).siblings(".dropdown, .megapanel")
							.css("display") == "none") {
						$(this).siblings(".dropdown, .megapanel").slideDown(
								t.interval);
						$(this).siblings(".dropdown").find("ul").slideDown(
								t.interval);
						n = 1
					} else {
						$(this).siblings(".dropdown, .megapanel").slideUp(
								t.interval)
					}
				})
	}
	function o() {
		$(".megamenu > li.showhide").show(0);
		$(".megamenu > li.showhide").bind("click", function() {
			if ($(".megamenu > li").is(":hidden")) {
				$(".megamenu > li").slideDown(300)
			} else {
				$(".megamenu > li:not(.showhide)").slideUp(300);
				$(".megamenu > li.showhide").show(0)
			}
		})
	}
	function u() {
		$(".megamenu > li").show(0);
		$(".megamenu > li.showhide").hide(0)
	}
	var t = {
		interval : 250
	};
	var n = 0;
	$(".megamenu")
			.prepend(
					"<li class='showhide'><span class='title'>MENU</span><span class='icon1'></span><span class='icon2'></span></li>");
	r();
	$(window).resize(function() {
		r()
	})
	
	
	// 全局js函数
	function isLogin() {
		var flag = false;
		$.ajax({
			async:false,
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
	
	$(document).ready(function() {
		if (isLogin()) {
			$.ajax({
				type : 'post',
				url : 'getUser',
				success : function(user) {
					$("#account").html(user.userName);
					$('#account').attr('href','personal.html'); 
				}
			});
		}
	})
	
	function toAddShopCar(proId) {

		if (isLogin()) {
			$.ajax({
				type : 'post',
				url : 'addShopCarItem/' + proId,
				success : function(countMsg) {
					alert(countMsg);
				}
			});
		} else {
			alert("请先登录！");
			window.location.href = "login.html";
		}

	} 

	function toShowShopCarItem() {
		if(isLogin()){
			$.ajax({
				type : 'post',
				url : 'showShopCar',
				success : function(msg) { 
					$("#shopCarItemListDiv").html(msg);
				}
			});
		}else{
			var txt = "";
		}
		
	}
	
	function deletePro(proId) {
		var r = confirm("确定要删除购物项吗？");
		if(r == true){
			$.ajax({
				type : 'post',
				url : 'deleteShopCarItem/' + proId,
				success : function(countMsg) {
					if (countMsg == "操作成功！") {
						alert("删除成功！");
					}else{
						alert("删除失败！");
					}
				}
			});
		}
	}
}