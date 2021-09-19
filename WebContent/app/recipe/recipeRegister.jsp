<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>JBeans Recipe</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/recipe/index.css" />
		<link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
		
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/recipe/jquery-3.6.0.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/recipe/findstore.js"></script>
    
		
	</head>
	<body class="is-preload">

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<div id="main">
						<div class="inner">

							<!-- Header -->
								<%@include file="../Header.jsp"  %>
								<!-- register -->
								
								<form name="recipeRegisterform" action="${pageContext.request.contextPath}/recipe/RecipeRegisterOk.rc" method="post" enctype="multipart/form-data">
									<table>
										<tr  style="width: 100%;">
											<td>레시피 제목</td><td colspan="2"><input name="recipeName" class="recipeName" type="text" placeholder="소고기 미역국 끓이기" ></td>
										</tr>
										<tr style="width: 100%; height: 150px;">
											<td>요리소개</td>
											<td colspan="2">
											<textarea cols="50" rows="10" style="resize:none;" placeholder="레시피의 탄생배경을 얘기해 주세요" name="recipeInfo"></textarea>
											</td>
										</tr>
										<tr>
											<td>	카테고리</td>
											<td>	 
												<select style="width: 200px;" name="recipeCategory">
													<option>종류별</option>
													<option value="국/탕">국/탕</option>
													<option value="면/만두">면/만두</option>
													<option value="밥">밥</option>
													<option value="빵">빵</option>
													<option value="찌개">찌개</option>
													<option value="굽기">굽기</option>
													<option value="튀김">튀김</option>
												</select>
											</td>
											<td>
												<select style="width: 200px;" name="recipeTime">
													<option >상황별</option>
													<option value="아침">아침</option>
													<option value="점심">점심</option>
													<option value="저녁">저녁</option>
											</select>
											</td>
										</tr>
									</table>
									<h3>대표이미지</h3>
									<input type="file" name="recipeMainImg">
									
										<!-- 레시피 등록 순서 -->
										<section>
											<div class="recipeRegister"></div>
											<!-- requset.getvaluse -->
										</section> 
										<a href="javascript:addStep()" class="button primary large">추가</a>
										<a href="javascript:recipeSubmit()" class="button primary large">등록하기</a>
								</form>
						</div>
					</div>
		
				<!-- Sidebar -->
					<%@include file="../SideBar.jsp"  %>

			</div>

		<!-- Scripts -->
			<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/browser.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/breakpoints.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/util.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/recipe/index.js"></script>
			<script src="http://code.jquery.com/jquery-latest.min.js"></script>
			
			<script type="text/javascript">
					
					
					let count = 1;
					let recipeStep='<div><h3>step'+count+'</h3><br>';
					let recipeRegisterInputFile='<input id="recipeFile'+count+'" name="recipeFile" type="file"><br>';
					let recipeRegisterText='<textarea id="recipeText'+count+'" name="recipeText" style="width:70%;height:50%;resize: none;"></textarea><br></div>';
					function addStep() {
						console.log("asd")
						
						$('.recipeRegister').append(
								
								'<div><h3>step'+count+'</h3><br>'+'<input id="recipeFile'+count+'" name="recipeFile" type="file"><br>'+'<textarea id="recipeText'+count+'" name="recipeText" style="width:70%;height:50%;resize: none;"></textarea><br></div>'
						);
						count++;
					}
					function setThumbnail(event) {
						var reader = new FileReader(); 
						reader.onload = function(event) { 
						var img = document.getElementsByName("recipeRegisterImg"); 
						img.setAttribute("src", event.target.result); }; 
						reader.readAsDataURL(event.target.files[0]); }

					
					
				function recipeSubmit() {
					let frm = document.recipeRegisterform;
					frm.action = "${pageContext.request.contextPath}/recipe/RecipeRegisterOk.rc?count="+count;
					frm.submit()
				}
			</script>

	</body>
</html>