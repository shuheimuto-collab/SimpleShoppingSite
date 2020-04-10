//JQueryの実行時
//アニメーション
$(document).ready(function() {
	$(".login-in").show(3000);
	$(".product").show(3000);
});

// Lightbox風モーダル1
$(function() {
	$("body").append("<div id='glayLayer'></div><div id='overLayer'></div>");

	$("#glayLayer").click(function() {
		$(this).hide()
		$("#overLayer").hide();
	});

	$("a.modal").click(
			function() {
				$("#glayLayer").show();
				$("#overLayer").show().html(
						"<img src='" + $(this).attr("href") + "'>");
				return false;
			});
});

// Lightbox風モーダル2
$(function() {
	// 隠す
	$("#hide_detail").hide()
	// body要素の後ろにくっつける
	$("body").append("<div id='glayLayer1'></div><div id='overLayer1'></div>");
	// glayLayer1をクリックしたとき
	$("#glayLayer1").click(function() {
		// 隠す
		$(this).hide();
		// 隠す
		$("#overLayer1").hide();
		// 隠す
		$("#hide_detail").hide();
	});
	$("a.detail_button").click(function() {
		// 表に出す
		$("#glayLayer1").show();
		// 表に出す
		$("#overLayer1").show();
		// CSS変更
		$("#overLayer1").css({
			"margin-top" : "-" + $("#overLayer1").height() / 2 + "px",
			"margin-left" : "-" + $("#overLayer1").width() / 2 + "px"
		});
		// 挿入する
		$("#hide_detail").show().appendTo("#overLayer1");
		return false;
	});

});

// 増減ボタン処理
$(function() {
	var arySpinnerCtrl = [];
	var spin_speed = 20; // 変動スピード
	// 長押し押下時
	$('.btnspinner').on(
			'touchstart mousedown click',
			function(e) {
				if (arySpinnerCtrl['interval'])
					return false;
				var target = $(this).data('target');
				arySpinnerCtrl['target'] = target;
				arySpinnerCtrl['timestamp'] = e.timeStamp;
				arySpinnerCtrl['cal'] = Number($(this).data('cal'));
				// クリックは単一の処理に留める
				if (e.type == 'click') {
					spinnerCal();
					arySpinnerCtrl = [];
					return false;
				}
				// 長押し時の処理
				setTimeout(function() {
					// インターバル未実行中 + 長押しのイベントタイプスタンプ一致時に計算処理
					if (!arySpinnerCtrl['interval']
							&& arySpinnerCtrl['timestamp'] == e.timeStamp) {
						arySpinnerCtrl['interval'] = setInterval(spinnerCal,
								spin_speed);
					}
				}, 500);
			});

	// 長押し解除時 画面スクロールも解除に含む
	$(document).on('touchend mouseup scroll', function(e) {
		if (arySpinnerCtrl['interval']) {
			clearInterval(arySpinnerCtrl['interval']);
			arySpinnerCtrl = [];
		}
	});

	// 変動計算関数
	function spinnerCal() {
		var target = $(arySpinnerCtrl['target']);
		var num = Number(target.val());
		num = num + arySpinnerCtrl['cal'];
		if (num > Number(target.data('max'))) {
			target.val(Number(target.data('max')));
		} else if (Number(target.data('min')) > num) {
			target.val(Number(target.data('min')));
		} else {
			target.val(num);
		}
	}
});
$(function() {
});