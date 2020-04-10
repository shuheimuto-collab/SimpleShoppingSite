<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../include/header.html"%>
<%@include file="menu.jsp"%>

<div class="cart">
	<%-- カート内個数 --%>
	<div class="cart_title">
		<c:choose>
			<c:when test="${cart.size()>0}">
				<p>${cart.size()}種類の商品があります。</p>
				<hr>
			</c:when>
			<c:otherwise>
				<p>カートに商品がありません。</p>
				<hr>
			</c:otherwise>
		</c:choose>
	</div>

	<%-- JSPのコメント --%>
	<div class="cart_contents">
		<table style="border-collapse: separate; border-spacing: 15px;">
			<c:forEach var="item" items="${cart}">
				<tr style="border-collapse: separate;">
					<td><img src="../img/${item.product.id}.jpg" height="96"></td>
					<td>${item.product.name}</td>
					<td>${item.product.price}円</td>
					<td>${item.count}個</td>
					<td>${item.product.price*item.count}円</td>
					<td>${Math.round(item.product.price*item.count*1.1)}円(税)</td>
					<td><form
							action="/SimpleShoppingSite/servlet/CartRemove.action"
							method="post">
							<div>
								<input type="number" name="number" value="1" min="1"
									max=${item.count } style="width: 60px; height: 35px;">
							</div>
							<div>
								<input class="button" type="submit" value="カートから削除"> <input
									type="hidden" name="id" value="${item.product.id}">
							</div>

						</form></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>

<%@include file="../include/footer.html"%>
