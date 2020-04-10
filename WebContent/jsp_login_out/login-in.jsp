<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../include/header.html"%>
<div class="login-in">
	<div>
		<p class="login-in_title">ログイン画面</p>
	</div>
	<div>
		<form class="login-in_form"
			action="/SimpleShoppingSite/login_out/Login.action" method="post">
			<div>
				<input type="text" name="login" placeholder="LoginName" value="" autocomplete="off" required/>
			</div>
			<br>
			<div>
				<input type="password" name="password" placeholder="password"
					value="" autocomplete="off" required/>
			</div>
			<br>
			<div class="login-in_submit">
				<input type="submit" value="  ログイン  " class="button"> <input
					type="reset" value="  クリア  " class="button">
			</div>
		</form>
		<div>
			<a href="#" style="font-size: 0.8rem;">ID・パスワードをお忘れですか</a>
		</div>
		<div >
			<a href="#" style="font-size: 0.8rem;">はじめてご利用の方（新規会員登録）</a>
		</div>
	</div>
</div>
<%@include file="../include/footer.html"%>