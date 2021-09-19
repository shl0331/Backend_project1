/**
 * 
 */var tryCount = 1;// 함수호출횟수
var tags = '';
var lastsign = 0;
var cycleController = 0;
console.log(tryCount);

$(document).ready(function(){
	callAjax();
	$(".custom_calendar_table").on("click", "td", function () {
		tryCount = 1;
		console.log();
		tags = '';
		lastsign = 0;
		if (lastsign ===0)callAjax();
	});
	$(window).scroll(function(){
		var scrollBottom = $(document).height() - $(window).height() - $(window).scrollTop();
		console.log(scrollBottom);
		if(scrollBottom <=30 && cycleController ==0){
			cycleController++;
			console.log("0입니다 : "+scrollBottom);
			if (lastsign ===0)callAjax();
			console.log("스크롤시 : "+tryCount);
		}else if(scrollBottom >=30) cycleController = 0;
	})
});

		// 스크립트 contextPath
		var ctx = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
		
		$.ajax({
			url : ctx+"/recipeFrontController/recipeListLoad.re",
			type: "GET",
			data: {"selectName":selectName , "tryCount" : tryCount},
			dataType:"JSON"
		})
		.done(function(data){
			console.log(tryCount);
			console.log("통신성공");
			console.log(data);
			tagsStack(data,tags);
			tryCount++;
			console.log("통신성공시 "+tryCount);
			console.log("json 로그 : " + data.json.length);
			if(data.json.length == 0 && lastsign ===0){
				tags += "<div id = endlist><a href=\"#\">끝까지 다봤어요!↑(click!)</a></div>"
				lastsign ++;
				$(".contents").html(tags);
			}else{
				console.log("asd")
				tagsStack(data);
			}
		})
		.fail(function(xhr,error){
			console.log(tryCount);
			console.log("통신실패");
			$(".contents").text(".fail");
			console.log("code:"+xhr.status+"\n"+"message:"+xhr.responseText+"\n"+"error:"+error);
		});
	function tagsStack(data) {
		console.log(data.json.length)
		for(i = 0; i <data.json.length; i++){
			console.log("zxc")
			tags += '<div class = recipeList id = '+((tryCount*4-5)+i)+'>';
			tags += "<div><img alt=\"이미지\" src=\"\"></div>";
			tags += "<div>";
			tags += "contents"+((tryCount*10-9)+i)+"<br>";
			tags += "번호 : "+data.json[i].groundnum+"<br>";
			tags += "구장이름 : "+data.json[i].groundname+"<br>";
			tags += "주소 : "+data.json[i].groundaddr+"<br>";
			console.log()
			tags += "가격 : "+data.json[i].groundfee+"<br>";
			tags += "<a class = listbutton href='../app/futsal/reservation.fu?groundnum="+data.json[i].groundnum+"'>예약하기</a>";
			tags += "</div>"
			tags += "</div>";
		}
		$(".contents").html(tags);
		console.log("tagstack : "+ tryCount);
	}
