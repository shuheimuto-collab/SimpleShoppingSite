<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../include/header.html"%>
<%@include file="menu.jsp"%>
<div style="">
	<div style="text-align: center;">${cart.size()}種類の商品があります。</div>
	<hr>

	<table
		style="border-collapse: separate; border-spacing: 10px; border: solid 1px black; margin-left: auto; margin-right: auto;">
		<tr style="">
			<th></th>
			<th>名前</th>
			<th>値段</th>
			<th>個数</th>
			<th>合計</th>
			<th>合計(税)</th>
		</tr>
		<c:forEach var="item" items="${cart}">
			<tr>
				<td><img src="../img/${item.product.id}.jpg" height="150"></td>
				<td>${item.product.name}</td>
				<td>${item.product.price}円</td>
				<td>${item.count}個</td>
				<td>${item.product.price*item.count}円</td>
				<td>${Math.round(item.product.price*item.count*1.1)}円</td>
			</tr>
		</c:forEach>
	</table>
	<hr>
	<div style="text-align: center;">
		<form action="/SimpleShoppingSite/servlet/Purchase.action"
			method="post">
			<div style="margin-bottom: 10px;">
				<input type="text" name="name" placeholder="名前を入力してください" required />
			</div>
			<div style="margin-bottom: 10px;">
				<input type="text" name="address" placeholder="住所を入力してください" autocomplete="off"  required />
			</div>
			<div style="margin-bottom: 10px;">
				<input type="tel" name="tel" placeholder="電話番号を入力してください" autocomplete="off"  required />
			</div>
			<div style="margin-bottom: 10px;">
				<input type="submit" value="購入を確定" class="button">
			</div>
		</form>
	</div>
</div>

<%@include file="../include/footer.html"%>