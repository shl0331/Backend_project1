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
								<header id="header">
									<a href="${pageContext.request.contextPath}/index.jsp" class="logo"><strong>Editorial</strong> by Pixelarity</a>
										<ul class="icons">
											<c:choose>
											<c:when test="${session.memberid == null}">
												<li><a href="${pageContext.request.contextPath}/app/member/MemberLogin.mb" class="button"><span class="label">로그인</span></a></li>
												<li><a href="${pageContext.request.contextPath}/app/member/MemberJoin.mb" class="button"><span class="label">회원가입</span></a></li>
											</c:when>
											<c:when test="${session.memberid != null}">
												<p1>안녕하세요. ${session.memberid}님 환영합니다.</p1>
												<li><a href="${pageContext.request.contextPath}/app/member/MemberLogOut.mb" class="button"><span class="label">로그아웃</span></a></li>
											</c:when>	
										</c:choose>
										</ul>
								</header>
</body>
</html>