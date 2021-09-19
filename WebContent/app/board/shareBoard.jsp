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
							<%@include file="../Header.jsp"  %>
							<c:if test="${session.memberid == null}">
				<script>
					alert("로그인 후 이용하세요!");
					location.replace("${pageContext.request.contextPath}/app/member/MemberLogin.mb");
				</script>
			</c:if>
			<c:if test="${not empty param.flag}">
				<script>
					alert("글쓰기 실패! 다시 시도하세요!");
				</script>
			</c:if>
			<c:set var="boardList" value="${requestScope.boardList}" />
			<c:set var="page" value="${requestScope.page}" />
			<c:set var="startPage" value="${requestScope.startPage}" />
			<c:set var="endPage" value="${requestScope.endPage}" />
			<c:set var="totalCnt" value="${requestScope.totalCnt}" />
			<c:set var="totalPage" value="${requestScope.totalPage}" />

							<!-- Banner -->
									<section>
					<header class="main">

						<div style="text-align: center;">
							<!-- 제목과 글 개수 띄워주는 테이블 -->
							<table style="border: 0px;">
								<tr>
									<td><h2 style="color: #6cc5af;">공유 게시판</h2></td>
								</tr>
								<tr align="right" valign="middle">
									<td>글 개수 : ${totalCnt}개</td>
								</tr>
							</table>
							<!-- 게시글 리스트 띄우는 테이블 -->
							<table border="1" style="border-collapse: collapse; border-spacing: 0; width:80%; margin: 0 auto;">
								<tr align="center" valign="middle">
									<th width="8%" style="text-align:center">번호</th>
									<th width="10%" style="text-align:center">제목</th>
									<th width="15%" style="text-align:center">작성자</th>
									<th width="20%" style="text-align:center">위치</th>
									<th width="10%" style="text-align:center">날짜</th>
									<th width="10%" style="text-align:center">조회수</th>
								</tr>
								<c:choose>
									<c:when test="${boardList != null and fn:length(boardList)>0 }">
										<!-- 보여줄 게시글 목록이 있음 -->
										<!-- for(BoardDTO board : boardList) -->
										<c:forEach items="${boardList}" var="board">
											<tr onmouseover="this.style.background='#f9fbe7'"
												onmouseout="this.style.background=''">
												<td height="25">${board.shareboardnum}</td>
												<td>
													<a href="${pageContext.request.contextPath}/app/board/BoardView.bo?shareboardnum=${board.shareboardnum}">${board.shareboardtitle} </a>
												</td>
												<td>${board.memberid}</td>
												<td>${board.useraddr}</td>
												<td>${board.shareboarddate}</td>
												<td>${board.shareboardreadcnt}</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<!-- 보여줄 게시글 목록이 없음 -->
										<tr>
											<td colspan="5" align="center">등록된 게시글이 없습니다.</td>
										</tr>
									</c:otherwise>
								</c:choose>
							</table>
							<br>

							<!-- 페이징 처리하는 테이블 -->
							<table style="border: 0px; border-collapse: collapse; width:80%; margin: 0 auto;">
								<tr align="center" valign="middle">
									<td><c:if test="${page>1}">
											<a href="${pageContext.request.contextPath}/app/board/BoardList.bo?page=${page-1}">[&lt;]</a>
										</c:if> <c:forEach begin="${startPage}" end="${endPage}" step="1"
											var="i">
											<c:choose>
												<c:when test="${page == i}">[${i}]</c:when>
												<c:otherwise>
													<a href="${pageContext.request.contextPath}/app/board/BoardList.bo?page=${i}">[${i}]</a>
												</c:otherwise>
											</c:choose>
										</c:forEach> <c:if test="${page<totalPage}">
											<a
												href="${pageContext.request.contextPath}/app/board/BoardList.bo?page=${page+1}">[&gt;]</a>
										</c:if></td>
								</tr>
							</table>
							<br/>
							<!-- 글쓰기 버튼 배치하는 테이블 -->
							<table style="border: 0px;">
								<tr align="right" valign="middle">
									<td>
									<a href="${pageContext.request.contextPath}/app/board/BoardWrite.bo?page=${page}">[글쓰기]</a></td>
								</tr>
							</table>
						</div>

					</header>
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
</html>