<%--pageディレクトリ--%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../include/header.html"%>
<%@include file="menu.jsp"%>
<div class="product">
	<div class="product_search">
		<h2>Organic Shop</h2>
		<p>
			<br> 体に優しい自然食を提供する。<br>無添加の食材を利用したメニューが特徴です。<br>
			おいしいブレンドコーヒーとヘルシーなオーガニックフードで<br>体の内側から癒やされてください。 <br>
		</p>
		<p>検索キーワード入力</p>
		<form action="/SimpleShoppingSite/servlet/Product.action"
			method="post">
			<input type="text" name="keyword" autocomplete="off" placeholder="検索">
			<input type="submit" value="検索" class="button">
		</form>
	</div>
	<div class="product_list">
		<div class="grid">
			<c:forEach var="product" items="${list}">
				<div class="item">
					<div>
						<a href="../img/${product.id}.jpg" class="modal"><img
							src="../img/${product.id}.jpg" class="image"></a>
					</div>
					<div>${product.name}</div>
					<div class="item_button">
						<div>
							<a class="detail_button" href="../img/${product.id}.jpg">
								商品詳細 </a>
						</div>
						<div>${product.price}円</div>
					</div>
					<form action="/SimpleShoppingSite/servlet/CartAdd.action"
						method="get">
						<div>
							<div class="number_select spinner_area">
								数量 <input type="number" name="number" value="1" min="1" max="50"
									style="width: 60px; height: 35px;"> 個
							</div>
						</div>
						<div>
							<input type="hidden" name="id" value="${product.id}">
						</div>
						<div>
							<input class="button" type="submit" value="カートに入れる">
						</div>
					</form>
					<br> <br>
				</div>
			</c:forEach>
			<div id="hide_detail">
				<c:forEach var="product" items="${list}">
					<div id="${product.id}">
						<img src="../img/${product.id}.jpg">
						<div>${product.name}</div>
						<div>${product.price}</div>
						<div>${product.detail}</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>
<%@include file="../include/footer.html"%>
