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
							<tr>
								<td><h2 style="color: #6cc5af; text-align: center;">글쓰기</h2></td>
							</tr>
						</table>

							<form name="boardForm" method="post" action="${pageContext.request.contextPath}/app/board/BoardWriteOk.bo"
								enctype="multipart/form-data">
								<!-- 게시글 작성하는 인풋들 배치 테이블 -->
								<table style="border-collapse: collapse; width:80%; margin: 0 auto;">
									<tr>
										<th>제 목</th>
										<td><input type="text" name="shareboardtitle" maxlength="100"
											placeholder="제목을 입력하세요" style="width:300px"></td>
									</tr>
									<tr>
										<th align="center">글쓴이</th>
										<td><input type="text" name="memberid" maxlength="20"
											value="${session.memberid}" style="width:150px" readonly></td>
									</tr>
									<tr>
										<th align="center">주소</th>
										<td><input type="text" name="useraddr" maxlength="20"
											value="${session.useraddr}" style="width:300px" readonly></td>
									</tr>
									<tr height="300px">
										<th align="center" width="">내 용</th>
										<td><textarea name="shareboardcontents"
												style="height: 300px; resize: none;"></textarea></td>
									</tr>
									<tr>
										<th>파일 첨부1</th>
										<td>													
											<input type="file" name="file1"> 
											<input type="button" value="첨부삭제" onclick="cancelFile('file1')">
										</td>
									</tr>
									<tr>
										<th>파일 첨부2</th>
										<td>
											<input type="file" name="file2"> 
											<input type="button" value="첨부삭제" onclick="cancelFile('file2')">
										</td>
									</tr>
								</table>
								<br/>
								<table style="border: 0px;">
									<tr align="right" valign="middle">
										<td><a href="javascript:sendit()">[등록]</a>&nbsp;&nbsp; <a
											href="${pageContext.request.contextPath}/app/board/BoardList.bo?page=${requestScope.page}">[목록]</a>
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
			<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
			<script src="https://code.jquery.com/jquery-migrate-1.2.1.js"></script>
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

	function cancelFile(filename){
		if($.browser.msie){
			//input[name='		file1	']
			$("input[name='"+filename+"']").replaceWith($("input[name='"+filename+"']").clone(true));
		}else{
			$("input[name='"+filename+"']").val("");
		}
	}
	
</script>
	</body>
</html>