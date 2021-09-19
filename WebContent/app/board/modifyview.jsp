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

									
							<!-- Banner -->
									<section>
					<header class="main">
	
						<table style="border: 0px;">
							<tr align="center" valign="middle">
								<td><h2 style="color: #6cc5af">글 수정하기</h2></td>
							</tr>
						</table>
						<c:set var="board" value="${requestScope.board}"/>
						<c:set var="files" value="${requestScope.files}"/>
						<form method="post" name="boardForm" action="${pageContext.request.contextPath}/app/board/BoardModifyOk.bo?shareboardnum=${board.shareboardnum}" enctype="multipart/form-data">
							<!-- 게시글 작성하는 인풋들 배치 테이블 -->
							<table border="1" style="border-collapse:collapse; border-collapse: collapse; width:80%; margin: 0 auto;">
								<tr height="30px">
									<th align="center">
										제 목
									</th>
									<td>
										<input type="text" name="shareboardtitle" size="50" maxlength="100" value="${board.shareboardtitle}" style="width: 300px;">
									</td>
								</tr>
								<tr height="30px">
									<th align="center">
										글쓴이
									</th>
									<td>
										<input type="text" name="memberid" size="10" maxlength="20" value="${board.memberid}" style="width: 150px;" readonly>
									</td>
								</tr>
								<tr height="30px">
									<th align="center">
										주소
									</th>
									<td>
										<input type="text" style="width: 300px;" name="useraddr" size="10" maxlength="20" value="${board.useraddr}" readonly>
									</td>
								</tr>
								<tr height="300px">
									<th align="center">
										내 용
									</th>
									<td>
										<textarea name="shareboardcontents" style="width:1000px;height:250px;resize:none;">${board.shareboardcontents}</textarea>					
									</td>
								</tr>
								<c:choose>
									<c:when test="${files != null and fn:length(files)>0}">
										<c:forEach var="i" begin="0" end="1">
											<tr>
												<th>첨부파일${i+1}</th>
												<td>
													<c:choose>
														<c:when test="${i<fn:length(files)}">
															<p class="filename" name="shareboardrealname${i+1}" id="file${i+1}">${files[i].shareboardrealname}</p>
															<input type="hidden" name="shareboardrealname" value="${files[i].shareboardrealname}">								
														</c:when>
														<c:otherwise>
															<p class="filename" name="shareboardrealname${i+1}" id="file${i+1}"></p>
															<input type="hidden" name="shareboardrealname">								
														</c:otherwise>									
													</c:choose>		
													<label class="flabel" for="fileInput${i+1}">첨부하기</label>
													<input class="finput" name="file${i+1}" id="fileInput${i+1}" type="file"
													style="position: absolute; width: 1px; height: 1px; padding: 0; margin: -1px;">
												</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<c:forEach var="i" begin="0" end="1">
											<tr>
												<th>첨부파일${i+1}</th>
												<td>
													<p class="filename" name="shareboardrealname${i+1}" id="file${i+1}"></p>
													<input type="hidden" name="shareboardrealname">
													
													<label class="flabel" for="fileInput${i+1}">첨부하기</label>
													<input class="finput" name="file${i+1}" id="fileInput${i+1}" type="file"
													style="position: absolute; width: 1px; height: 1px; padding: 0; margin: -1px;">
												</td>
											</tr>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</table>
							<br/>
							<table style="border:0px;">
								<tr align="right" valign="middle">
									<td>
										<a href="javascript:sendit()">[수정완료]</a>&nbsp;&nbsp;
										<a href="${pageContext.request.contextPath}/app/board/BoardList.bo">[목록]</a>
									</td>
								</tr>
							</table>
						</form>

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
	<script>
	let frm = document.boardForm;
	let titleTag = frm.shareboardtitle;
	let contentsTag = frm.shareboardcontents;
	
	function sendit() {
		if (titleTag.value == "" || titleTag.value == null) {
			alert("제목을 입력하세요!");
			titleTag.focus();
			return false;
		}
		if (contentsTag.value == "" || contentsTag.value == null) {
			alert("내용을 입력하세요!");
			contentsTag.focus();
			return false;
		}
		frm.submit();
	}
	
	//HTML이 다 로딩된 이후에 넘겨주는 함수 호출
	$(document).ready(function(){
		//클래스명이 finput인것이 변화가 생겼다면 넘겨주는 함수 호출
		$('.finput').change(function(e){
			//$(this) : 변화가 생긴 그 객체(input type="file") - 방금 파일을 첨부한 input 요소
			//새로운 파일을 올렸다면 그 위에 있는 요소중 <p>의 내부에 방금 올린 파일명을 써주어야 한다.
			//3번 이전으로 가서 있는 요소가 p태그이므로 prev을 3번 써주고 그 안에있는 text를 올린 파일명으로 바꾸어준다.
			//e.target.files[0].name : 방금 선택한 파일의 파일명 추출
			$(this).prev().prev().prev().text(e.target.files[0].name);
			$(this).prev().prev().val(e.target.files[0].name);
			
		});
	});
	
	
</script>
</html>