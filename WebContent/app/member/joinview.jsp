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
									<section id="banner">
										<form name="joinform" action="${pageContext.request.contextPath}/app/member/MemberJoinOk.mb" method="post">
																	<p>
																		<span id="text" style="color:red; font-weight:bold;"></span><br>
																		<label>아이디 <input type="text" name="memberid"></label>
																		<input type="button" value="중복체크" onclick="checkId();">
																	</p>
																	<p>
																		<label>비밀번호 <input type="password" name="memberpw"></label>
																	</p>
																	<p>
																		<label>비밀번호 확인 <input type="password" name="memberpw_re"></label>
																	</p>
																	<p> 
																		<label>이름 <input type="text" name="membername"></label>
																	</p>
																	<p>
																		<label>나이 <input type="text" name="memberage"></label>
																	</p>
																	<p>
																		<label>핸드폰 번호 <input type="text" name="memberphone"></label>
																	</p>		
																	<p>
																		<label>닉네임 <input type="text" name="membernickname"></label>
																	</p>
																	<p>
																		<label>이메일 <input type="email" name="memberemail"></label>
																	</p>
																	
																	<p>
																		우편번호<br>
																		<input type="text" name="zipcode" id="sample6_postcode"
																		placeholder="우편번호" onclick="sample6_execDaumPostcode()" readonly>
																		<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
																	</p>
																	<p>
																		<input type="text" name="useraddr" id="sample6_address" placeholder="주소"  readonly>
																	</p>
																	<p>
																		<input type="text" name="useraddrdetail" id="sample6_detailAddress"placeholder="상세주소">
																		<input type="text" name="useraddretc" id="sample6_extraAddress"  placeholder="참고항목" readonly>
																	</p>
																		<input type="button" value="회원가입" onclick="sendit()">
																</form>
								</section>

						</div>
					</div>

				<!-- Sidebar -->
					<%@include file="../SideBar.jsp"  %>

			</div>

		<!-- Scripts -->
			<script>let contextPath = "${pageContext.request.contextPath}";</script>
			<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
			<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/browser.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/breakpoints.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/util.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
			<script src="member.js"></script>
			

	</body>
</html>