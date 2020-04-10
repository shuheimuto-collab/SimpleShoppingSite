<%@page pageEncoding="UTF-8"%>
<div class="menu_header">
	<div class="menu">
		<div class="menu_div">こんにちは！ ${customer.login}さん。</div>
	</div>
	<div class="menu">
		<div class="menu_div">
			<a href="/SimpleShoppingSite/servlet/Product.action">Item</a>
		</div>
		<div class="menu_div">
			<a href="/SimpleShoppingSite/jsp/cart.jsp">Cart</a>
		</div>
		<div class="menu_div">
			<a href="/SimpleShoppingSite/servlet/Preview.action">Purchase</a>
		</div>
		<div class="menu_div">
			<a href="/SimpleShoppingSite/jsp_login_out/login-in.jsp">Login</a>
		</div>
		<div class="menu_div">
			<a href="/SimpleShoppingSite/jsp_login_out/logout-in.jsp">Logout</a>
		</div>
		<div class="menu_div">
			<a href="/SimpleShoppingSite/jsp/history.jsp">History</a>
		</div>
	</div>
</div>
<div></div>
<hr>
