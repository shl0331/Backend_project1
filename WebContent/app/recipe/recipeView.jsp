<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<title>JBeans RecipeView</title>
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
<c:set var="selectRecipe" value="${requestScope.selectRecipe}"/>
<c:set var="stepRecipeList" value="${requestScope.stepRecipeList}"/>
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
											<td>레시피 제목</td><td colspan="2"><input class="recipeName" type="text" value="${selectRecipe.recipeName} " ></td>
										</tr>
										<tr style="width: 100%; height: 150px;">
											<td>요리소개</td><td colspan="2">
												<input class="recipeEx"  type="text" placeholder="레시피의 탄생배경을 얘기해 주세요" value="${selectRecipe.recipeInfo}" readonly style="height:150px; ">
											</td>
										</tr>
										<tr>
											<td>	카테고리</td>
											<td>	 
												<select style="width: 200px;">
													<option>종류별</option>
													<option ${selectRecipe.recipeCategory=="국/탕"?"selected":""}>국/탕</option>
													<option ${selectRecipe.recipeCategory=="면/만두"?"selected":""}>면/만두</option>
													<option${selectRecipe.recipeCategory=="밥"?"selected":""}>밥</option>
													<option ${selectRecipe.recipeCategory=="빵"?"selected":""}>빵</option>
													<option ${selectRecipe.recipeCategory=="찌개"?"selected":""}>찌개</option>
													<option ${selectRecipe.recipeCategory=="굽기"?"selected":""}>굽기</option>
													<option ${selectRecipe.recipeCategory=="튀김"?"selected":""}>튀김</option>
												</select>
											</td>
											<td>
												<select style="width: 200px;" disabled>
													<option >상황별</option>
													<option ${selectRecipe.recipeTime=="아침"?"selected":""}>아침</option>
													<option  ${selectRecipe.recipeTime=="점심"?"selected":""}>점심</option>
													<option  ${selectRecipe.recipeTime=="저녁"?"selected":""}>저녁</option>
											</select>
											</td>
										</tr>
									</table>
								</section>
								<!-- 레시피별 스텝 출력하는 부분 -->
								<section>
								<c:forEach var="i" begin="0" end="${fn:length(stepRecipeList)-1}" >
									<c:set var="recipeStep" value="${stepRecipeList[i]}"/>
									<div style="display: flex;">
										<h3>step${i+1}</h3>
										<img  src="${pageContext.request.contextPath}/app/file/${recipeStep.recipeStepImg}" id="recipeStepImg${i+1}" name="recipeStepImg" style="width: 200px;height: 100px;">
										<input id="recipeStepText${i+1}" name="recipeStepText" value="${recipeStep.recipeStepText}">
									</div>
								</c:forEach>
								</section>
								<a href="#<%-- ${pageContext.request.contextPath}/app/recipe/recipeModify.rc --%>" class="button primary large">수정</a>
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