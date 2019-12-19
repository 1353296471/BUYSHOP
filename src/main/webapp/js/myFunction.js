// 全局js函数
function isLogin() {
	var flag = false;
	$.ajax({
		async : false,
		// async. 默认是 true，即为异步方式，$.ajax执行后，会继续执行ajax后面的脚本，
		// 直到服务器端返回数据后，触发$.ajax里的success方法，这时候执行的是两个线程。
		// async 设置为 false，则所有的请求均为同步请求，在没有返回值之前，
		// 同步请求将锁住浏览器，用户其它操作必须等待请求完成才可以执行。
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

function isAdmin() {
	var flag = false;
	$.ajax({
		async : false,
		type : 'post',
		url : 'isAdmin',
		success : function(msg) {
			if (msg == "isAdmin") {
				flag = true;
			} else {
				flag = false;
			}
		}
	});
	return flag;
}

function search() {
	if($("#Sea").val()==""){
		alert("搜索内容不能为空");
	}else{
		document.location.href="search.html?searchdata="+$("#Sea").val();
	}

}

// 初始化
function init() {
	if (isLogin()) {
		$.ajax({
			type : 'post',
			url : 'getUser',
			success : function(user) {
				$("#account").html(user.userName);
				$('#account').attr('href', 'personal.html');
			}
		});
	}
}

function toAddShopCar(warehouseId) {
	if(warehouseId == 0){
		alert("请先选择好商品的属性！");
		return;
	}
	
	if (isLogin()) {
		$.ajax({
			type : 'post',
			url : 'addShopCarItem/' + warehouseId,
			success : function(countMsg) {
				alert(countMsg);
			}
		});
	} else {
		alert("请先登录！");
		window.location.href = "login.html";
	}
}

function toAddShopCar(warehouseId,num) {
	if(warehouseId == 0 || num < 1){
		alert("请先选择好商品的属性！");
		return;
	}
	
	if (isLogin()) {
		$.ajax({
			type : 'post',
			url : 'addShopCarItem/' + warehouseId + '/'+num,
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
	if (isLogin()) {
		$.ajax({
			type : 'post',
			url : 'showShopCar',
			success : function(msg) {
				$("#shopCarItemListDiv").html(msg);
			}
		});
	} else {
		
	}

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
				} else {
					alert("删除失败！");
				}
			}
		});
	}
}

// 检查页码格式是否正确 id = pageNo $("#pageNo").val()
function checkPage(val) {
	val = $.trim(val);
	// 1. 校验 val 是否为数字 1, 2, 而不是 a12, b
	var flag = false;
	var reg = /^\d+$/g;
	var pageNo = 0;

	if (reg.test(val)) {
		// 2. 校验 val 在一个合法的范围内： 1-maxPage
		pageNo = parseInt(val);
		if (pageNo >= 1 && pageNo <= parseInt("${requestScope.page.maxPage }")) {
			flag = true;
		}
	}

	if (!flag) {
		alert("输入的不是合法的页码.");
		$(this).val("");
	}
	return flag;
}

// 检查邮箱格式是否正确 class = email
function checkEmail(email) {
	var falg = false;
	var reg = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
	var result = reg.test(email);
	if (!result) {
		alert("邮箱格式错误！请重新输入！");
	} else {
		falg = true;
	}
	return falg;
}

function choseLocation() {
	var location = $('#province option:selected').text();
	document.getElementById('sheng').value = location;
	location = $('#city option:selected').text();
	document.getElementById('shi').value = location;
	location = $('#county option:selected').text();
	document.getElementById('qu').value = location;
	
}

function payFormClick() {
	var sheng = $('#province option:selected').text();
	var shi = $('#city option:selected').text();
	var qu = $('#county option:selected').text();
	var userAddress = $('#userAddress').val();
	var userPhone = $('#userPhone').val();
	
	if(sheng == "" || shi == ""){
		alert("省份和市区不能为空！");
		return;
	}
	
	if(userAddress == ""){
		alert("详细地址不能为空！");
		return;
	}
	
	//编译正则表达式
	 var reg =/^1[3456789]\d{9}$/; 
	 var result = reg.test(userPhone);
	 if(!result){
		 alert("请输入正确的电话格式！");
		 return;
	 }
	 
	 $("form[name='payForm']").submit();
}

//得到登录状态，是用户还是管理
function getStatus() {
	var status ;
	$.ajax({
		async : false,
		type : 'post',
		url : 'getStatus',
		success : function(msg) {
			status = msg;
		}
	});
	return status;
}

var activeMeun;
$(document).on("click","#meun",function(){
	$(activeMeun).parents("li").attr("class","grid");
	$(this).parents("li").attr("class","active");
	activeMeun = this;
});
	
