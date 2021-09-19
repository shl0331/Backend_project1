<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<title>JBeans Recipe</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/recipe/index.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/member/mypage.css" />
		<link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/member/mypage.css" />
		
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
							<header id="header">
									<a href="${pageContext.request.contextPath}/index.jsp" class="logo"><strong>Editorial</strong> by Pixelarity</a>
								</header>

							<!-- nav -->
							<div id="nav" style="text-align:center">
								<a href="${pageContext.request.contextPath}/updateMyInfo.jsp">회원정보 수정하기</a>
								<a href="${pageContext.request.contextPath}/app/member/myRecipeList.mb">내가 등록한 레시피 보러가기</a>
								<a href="${pageContext.request.contextPath}/myLikeRecipe.jsp">좋아요한 레시피 보러가기</a>
								<a href="${pageContext.request.contextPath}/myLikeUser.jsp">구독한 유저 보러가기</a>
							</div>
				
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