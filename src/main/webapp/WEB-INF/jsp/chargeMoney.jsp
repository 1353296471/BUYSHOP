<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>充值</h1>
<center>
	我的余额：$ ${cash }
	<br>
		<br>
		充值金额：<input type="number" name="money" class="money">
		<br>
		<br>
		
		<input type="button" value="确认充值" onclick="chargeMoney()">
</center>
