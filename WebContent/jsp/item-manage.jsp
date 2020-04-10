<%--pageディレクトリ--%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../include/header.html"%>
<%@include file="manage_menu.jsp"%>
<div class="product">
	<div class="product_search">
		<h2>管理画面</h2>
		<p>検索キーワード入力</p>
		<%--Searchへ--%>
		<form action="/SimpleShoppingSite/servlet/Product.action"
			method="post">
			<input type="text" name="keyword" placeholder="検索" autocomplete="off"> <input
				type="submit" value="検索" class="button">
		</form>
	</div>
	<hr>
	<div class="product_search">
		<p>商品新規作成</p>
		<%--insertへ--%>
		<form action="/SimpleShoppingSite/servlet/ProductAdd.action"
			method="post">
			<div style="margin-bottom: 10px;">
				<input type="text" name="name" autocomplete="off"
					placeholder="商品名入力" required /> <br>
			</div>
			<div style="margin-bottom: 10px;">
				<input type="number" name="price" autocomplete="off"
					placeholder="値段入力" required />
			</div>
			<div style="margin-bottom: 10px;">
				<input type="submit" value="作成" class="button">
			</div>
		</form>
	</div>
	<hr>
	<div class="product_search">
		<p>既存商品更新</p>
		<%--insertへ--%>
		<form action="/SimpleShoppingSite/servlet/ProductUpdate.action"
			method="post">
			<div style="margin-bottom: 10px;">
				<input type="number" name="name" autocomplete="off"
					placeholder="更新する商品ID入力" required /> <br>
			</div>
			<div style="margin-bottom: 10px;">
				<input type="text" name="name" autocomplete="off"
					placeholder="商品名入力" required /> <br>
			</div>
			<div style="margin-bottom: 10px;">
				<input type="number" name="price" autocomplete="off"
					placeholder="値段入力" required />
			</div>
			<div style="margin-bottom: 10px;">
				<input type="submit" value="更新" class="button">
			</div>
		</form>
	</div>
	<hr>
	<div class="product_search">
		<p>既存商品削除</p>
		<%--insertへ--%>
		<form action="/SimpleShoppingSite/servlet/ProductRemove.action"
			method="post">
			<div style="margin-bottom: 10px;">
				<input type="number" name="id" autocomplete="off"
					placeholder="削除する商品ID入力" required /> <br>
			</div>
			<div style="margin-bottom: 10px;">
				<input type="submit" value="削除" class="button">
			</div>
		</form>
	</div>
	<hr>
	<div class="product_list">
		<div class="grid">
			<c:forEach var="product" items="${list}">
				<div class="item">
					<div>ID : ${product.id}</div>
					<div>
						<a href="../img/${product.id}.jpg" class="modal"><img
							src="../img/${product.id}.jpg" class="image"></a>
					</div>
					<div>${product.name}</div>
					<div class="item_button">
						<div>
							<%--updateへ--%>
							<a class="detail_button"
								href="/SimpleShoppingSite/servlet/ProductUpdate.action"> 更新
							</a>
						</div>
						<div>
							<a class="detail_button"
								href="/SimpleShoppingSite/servlet/ProductRemove.action"> 削除
							</a>
						</div>
					</div>
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