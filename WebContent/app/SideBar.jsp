<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="sidebar">
						<div class="inner">

							<!-- Search -->
								<section id="search" class="alt">
									<form method="post" action="#">
										<input type="text" name="query" id="query" placeholder="Search" />
									</form>
								</section>

							<!-- Menu -->
								<nav id="menu">
									<header class="major">
										<h2>Menu</h2>
									</header>
									<ul>
										
										<li><a href="${pageContext.request.contextPath}/app/recipe/recipeList.rc">RECIPE</a></li>
										<li><a href="${pageContext.request.contextPath}/app/board/BoardList.bo">SHARE</a></li>
										<c:if test="${session != null }">
											<li><a href="${pageContext.request.contextPath}/app/user/userMyPage.mb">My Page</a></li>
										</c:if>
												
										
						
									</ul>
								</nav>
							
							
							
							<!--  카테고리 -->
							<section id="category_wrap">
								<div class="category">
									<div class="category_list">
										<a href="${pageContext.request.contextPath}/app/recipe/recipeList.rc" >
											<img alt="전체" src="${pageContext.request.contextPath}/images/cate1_01.png" class="category_img" >
										</a>
										<p>전체</p>
									</div>
									<div class="category_list">
										<a href="${pageContext.request.contextPath}/app/recipe/recipeList.rc?recipeCategory=국/탕">
											<img alt="국/탕" src="${pageContext.request.contextPath}/images/cate4_09.png" class="category_img">
										</a>
										<p>국/탕</p>
									</div>
									<div class="category_list">
										<a href="${pageContext.request.contextPath}/app/recipe/recipeList.rc?recipeCategory=면/만두">
											<img alt="면/만두" src="${pageContext.request.contextPath}/images/cate1_08.png" class="category_img">
										</a>
										<p>면/만두</p>
									</div>
									<div class="category_list">
										<a href="${pageContext.request.contextPath}/app/recipe/recipeList.rc?recipeCategory=밥">
											<img alt="밥" src="${pageContext.request.contextPath}/images/cate1_10.png" class="category_img">
										</a>
										<p>밥</p>
									</div>
									<div class="category_list" style="margin-bottom: 0em;">
										<a href="${pageContext.request.contextPath}/app/recipe/recipeList.rc?recipeCategory=빵">
											<img alt="빵" src="${pageContext.request.contextPath}/images/cate1_11.png" class="category_img">
										</a>
										<p>빵</p>
									</div>
									<div class="category_list" style="margin-bottom: 0em;">
										<a href="${pageContext.request.contextPath}/app/recipe/recipeList.rc?recipeCategory=찌개">
											<img alt="찌개" src="${pageContext.request.contextPath}/images/cate1_16.png" class="category_img">
										</a>
										<p>찌개</p>
									</div>
									<div class="category_list" style="margin-bottom: 0em;">
										<a href="${pageContext.request.contextPath}/app/recipe/recipeList.rc?recipeCategory=굽기">
											<img alt="굽기" src="${pageContext.request.contextPath}/images/cate4_01.png" class="category_img" >
										</a>
										<p>굽기</p>
									</div>
									<div class="category_list" style="margin-bottom: 0em;">
										<a href="${pageContext.request.contextPath}/app/recipe/recipeList.rc?recipeCategory=튀김">
											<img alt="튀김" src="${pageContext.request.contextPath}/images/cate4_13.png" class="category_img" >
										</a>
										<p>튀김</p>
									</div>
								</div>
							</section>
							

							<!-- Section -->
								<section>
									<header class="major">
										<h2>Get in touch</h2>
									</header>
									<p>Sed varius enim lorem ullamcorper dolore aliquam aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin sed aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
									<ul class="contact">
										<li class="icon solid fa-envelope"><a href="#">information@untitled.tld</a></li>
										<li class="icon solid fa-phone">(000) 000-0000</li>
										<li class="icon solid fa-home">1234 Somewhere Road #8254<br />
										Nashville, TN 00000-0000</li>
									</ul>
								</section>

							<!-- Footer -->
								<footer id="footer">
									<p class="copyright">&copy; Untitled. All rights reserved.</p>
								</footer>

						</div>
					</div>
</body>
</html>