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
							<header id="header">
									<a href="${pageContext.request.contextPath}/index.jsp" class="logo"><strong>Editorial</strong> by Pixelarity</a>
								</header>

							<!-- Banner -->
								<section id="login">
					<c:if test="${not empty param.flag}">
					<script>
						alert("아이디 또는 비밀번호 오류입니다.");
					</script>
				</c:if>
				<form name="loginform" action="${pageContext.request.contextPath}/app/member/MemberLoginOk.mb" method="post">
					<div style="text-align:center">
						<table border="1" style="text-align:center;width:400px;border-collapse:collapse;margin-left:auto;margin-right:auto;">
							<tr>
								<td>아이디</td>
								<td>
									<input type="text" name="memberid">
								</td>
							</tr>
							<tr>
								<td>비밀번호</td>
								<td>
									<input type="password" name="memberpw">
								</td>					
							</tr>
							<tr>
								<td colspan="2">
									<input type="button" value="로그인" onclick="sendit();">
									&nbsp;&nbsp;&nbsp;
									<input type="button" value="회원가입"
									onclick="location.href='${pageContext.request.contextPath}/app/member/joinview.jsp'">
								</td>
							</tr>
						</table>
					</div>
				</form>
				</section>

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
	<script >
	let frm = document.loginform;
	let idTag = frm.memberid;
	let pwTag = frm.memberpw;
	
	function sendit(){
		if(idTag.value == "" || idTag.value == null){
			alert("아이디를 입력하세요!");
			idTag.focus();
			return false;
		}
		if(pwTag.value == "" || pwTag.value == null){
			alert("비밀번호를 입력하세요!");
			pwTag.focus();
			return false;
		}
		frm.submit();
	}
	</script>
</html>