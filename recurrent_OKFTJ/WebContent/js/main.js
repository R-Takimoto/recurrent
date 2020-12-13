//メニュータブのカレント処理
$(function(){
	let pageUrlParameters = location.search;
	let pageUrlParametersArr = pageUrlParameters.split('?');
	let parameters = pageUrlParametersArr[1];

  $('.global-nav li a').each(function(){
	let target = $(this).attr('href');
	let targetArr = target.split('?');
	let targetAllCategory = targetArr[1];
	let parameter = '&orderTypeId=1';
	let targetAllCatParam = targetAllCategory + parameter;

    if(targetAllCategory === parameters || targetAllCatParam === parameters) {
      $(this).parent().addClass('current');
    } else {
      $(this).parent().removeClass('current');
    }
  });
});

//数量入力カウンター
$(function() {
	let num;
	let totalNum;
	let max = 20;
	let $input = $('#count');
	let $up = $('#upButton');
	let $down = $('#downButton');

	function total() {
		totalNum = 0;
		$input.each(function(val) {
			val = Number($(this).val());
			totalNum += val;
		});
		return totalNum;
	}
	//アップボタンクリック時
	$up.on('click', function() {
		num = Number($(this).prev($input).val());
		console.log('---');
		if (num < max) {
			$(this).prev($input).val(num + 1);
			if ((num + 1) == max) {
			$(this).prop("disabled", true);
			}
			$(this).prev().prev($down).prop("disabled", false);
		} else {
			$(this).prop("disabled", true);
		}
		total();
		if (totalNum == max) {
			$up.prop("disabled", true);
		} else {
			$up.prop("disabled", false);
		}
	});
	//ダウンボタンクリック時
	$down.on('click', function() {
		total();
		num = Number($(this).next($input).val());
		if (num > 0) {
			$(this).next($input).val(num - 1);
			if ((num - 1) == 0) {
			$(this).prop("disabled", true);
			}
			$(this).next().next($up).prop("disabled", false);
		} else {
			$(this).prop("disabled", true);
		}
		total();
		if (totalNum < max) {
			$up.prop("disabled", false);
		}
	});
})


