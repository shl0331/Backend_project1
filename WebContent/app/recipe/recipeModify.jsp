<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>JBeans RecipeModify</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/recipe/index.css" />
		<link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
		
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/recipe/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/js/recipe/library/slick-1.8.1/slick/slick.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/js/recipe/library/slick-1.8.1/slick/slick-theme.css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/recipe/library/slick-1.8.1/slick/slick.min.js"></script>
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

							<!-- Banner -->
								<section id="banner">
										<table>
										<tr  style="width: 100%;">
											<td>레시피 제목</td><td colspan="2"><input class="recipeName" type="text" placeholder="소고기 미역국 끓이기" ></td>
										</tr>
										<tr style="width: 100%; height: 150px;">
											<td>요리소개</td><td colspan="2"><input class="recipeEx"  type="text" placeholder="레시피의 탄생배경을 얘기해 주세요" style="height:150px; "></td>
										</tr>
										<tr>
											<td>	카테고리</td>
											<td>	 
												<select style="width: 200px;">
													<option>종류별</option>
													<option>국/탕</option>
													<option>면/만두</option>
													<option>밥</option>
													<option>빵</option>
													<option>찌개</option>
													<option>굽기</option>
													<option>튀김</option>
												</select>
											</td>
											<td>
												<select style="width: 200px;">
													<option>상황별</option>
													<option>아침</option>
													<option>점심</option>
													<option>저녁</option>
											</select>
											</td>
										</tr>
									</table>
								</section>
								<section>
								<!--  이부분 반복문 -->
									<div>
										<img id="img'+count+' src=""><br>
										<input type="file" ><br>
										<textarea style="width:70%;height:50%;resize: none;"></textarea><br>
									</div>
								</section>
								<a href="recipeView" class="button primary large">수정완료</a>
								<a href="recipeList" class="button primary large">삭제</a>
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

	</body>
</html>