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

						<c:set var="board" value="${requestScope.board}" />
						<c:set var="files" value="${requestScope.files}"/>
						<!-- 게시글 보여주는 인풋들 배치 테이블 -->
						<table style="border: 0px;" >
							<tr>
								<td><h2 style="color: #6cc5af; text-align:center;">글 상세보기</h2></td>
							</tr>
						</table>
						<table border="1" style="border-collapse: collapse; width:80%; margin: 0 auto;">
							<tr height="30px">
								<th align="center" width="150px">제 목</th>
								<td><input type="text" name="shareboardtitle" value="${board.shareboardtitle}"
									size="50" maxlength="100" style="width:300px;" readonly></td>
							</tr>
							<tr height="30px">
								<th align="center" width="150px">글쓴이</th>
								<td><input type="text" name="memberid" size="10" maxlength="20"
									value="${board.memberid}" style="width:200px;" readonly></td>
							</tr>
							<tr height="30px">
								<th align="center" width="150px">주소</th>
								<td><input type="text" name="useraddr" size="10" maxlength="20"
									value="${board.useraddr}" style="width:300px;" readonly></td>
							</tr>
							<tr height="300px">
								<th align="center" width="150px">내 용</th>
								<td><textarea name="shareboardcontents"
										style="width: 1000px; height: 250px; resize: none;" readonly>${board.shareboardcontents}</textarea>
								</td>
							</tr>
							<c:choose>
								<c:when test="${files != null and fn:length(files)!=0}">
									<!-- for(int i=0;i<=0;i++) -->
									<c:forEach var="i" begin="0" end="${fn:length(files)-1}">
										<tr>
											<th>첨부파일${i+1}</th>
											<td>
												&nbsp;&nbsp;
												<a href="${pageContext.request.contextPath}/app/board/FileDownload.bo?shareboardfilename=${files[i].shareboardfilename}&orgname=${files[i].shareboardrealname}">${files[i].shareboardrealname}
												</a>
											</td>
										</tr>					
									</c:forEach>
								</c:when>			
								<c:otherwise>
									<tr>
										<td colspan="2" style="text-align:center;">첨부 파일이 없습니다.</td>
									</tr>
								</c:otherwise>
							</c:choose>
						</table>
						<!-- 지도 -->
						<div id="map" style="width: 900px;height:400px; right:50px; margin: 30px auto 30px;">
							<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1eecfac0e449bd5561f994da08f823a3&libraries=services,clusterer,drawing"></script>
							<script>
								//주소 받아오기
								var useraddr = '<c:out value="${board.useraddr}"/>'						
							
								var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
							    mapOption = {
							        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
							        level: 3 // 지도의 확대 레벨
							    };
		
								// 지도를 생성합니다    
								var map = new kakao.maps.Map(mapContainer, mapOption); 
			
								// 주소-좌표 변환 객체를 생성합니다
								var geocoder = new kakao.maps.services.Geocoder();
			
								// 주소로 좌표를 검색합니다
								geocoder.addressSearch(useraddr, function(result, status) {
			
								    // 정상적으로 검색이 완료됐으면 
								     if (status === kakao.maps.services.Status.OK) {
			
								        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
			
								        // 결과값으로 받은 위치를 마커로 표시합니다
								        var marker = new kakao.maps.Marker({
								            map: map,
								            position: coords
								        });
			
								        // 인포윈도우로 장소에 대한 설명을 표시합니다
								        var infowindow = new kakao.maps.InfoWindow({
								            content: '<div style="width:150px;text-align:center;padding:6px 0;">' + useraddr + '</div>'
								        });
								        infowindow.open(map, marker);
			
								        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
								        map.setCenter(coords);
								    } 
								});    
								
							</script>	
						</div>
						<form name="deleteForm" action="${pageContext.request.contextPath}/app/board/BoardDeleteOk.bo">
							<input type="hidden" value="${board.shareboardnum}" name="shareboardnum">
						</form>
						<table style="border: 0px;">
							<tr align="right" valign="middle">
								<td>
									<c:if test="${board.memberid == session.memberid}">
										<a href="${pageContext.request.contextPath}/app/board/BoardModify.bo?shareboardnum=${board.shareboardnum}">[수정]</a>
										<a href="javascript:document.deleteForm.submit()">[삭제]</a>
									</c:if>
									<a href="${pageContext.request.contextPath}/app/board/BoardList.bo">[목록]</a>
								</td>
							</tr>
						</table>

						<form name="replyForm" method="post" action="${pageContext.request.contextPath}/app/board/ReplyWriteOk.bo">
							<input type="hidden" value="${board.shareboardnum}" name="shareboardnum">
							<table style="border-collapse: collapse; width:80%; margin: 0 auto;">
								<tr height="200px">
									<td>
										댓 글
									</td>
									<td>
										<textarea name="sharereplycontents" style="width:1000px;height:140px;resize:none; margin-left:70px"></textarea>
										<a href="javascript:document.replyForm.submit();" style="float:right;">[등록]</a>
									</td>
								</tr>
							</table>
						</form>
						<form name="updateForm" action="${pageContext.request.contextPath }/app/board/ReplyModifyOk.bo" method="post">
							<input type="hidden" name="shareboardnum" value="${board.shareboardnum}">
							<table style="border-collapse: collapse; width:80%; margin: 0 auto;">
								<c:choose>
									<c:when test="${replys != null and fn:length(replys)>0}">
										<c:set var="i" value="0"/>
										<c:forEach items="${replys}" var="reply">
											<c:set var="i" value="${i+1}"/>
											<tr style="width:1000px;">
												<td align="center" width="80px">${reply.memberid}</td>
												<td valign="top" align="center" >
													<textarea name="reply${i}" id="reply${i}" rows="3" style="resize:none; width:900px;" readonly>${reply.sharereplycontents}</textarea>
												</td>
												<td>
													<c:if test="${reply.memberid == session.memberid}">
														<a id="ready${i}" href="javascript:updateReply(${i});">[수정]</a>
														<a id="ok${i}" style="display:none;" href="javascript:updateOk(${reply.sharereplynum},${i})">[수정완료]</a>&nbsp;&nbsp;
														<a href="${pageContext.request.contextPath}/app/board/ReplyDeleteOk.bo?sharereplynum=${reply.sharereplynum}&shareboardnum=${board.shareboardnum}">[삭제]</a>
													</c:if>
												</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>

									</c:otherwise>
								</c:choose>
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
	function sendreply() {
		let replyTag = document.replyForm.sharereplycontents;
		
		if(replyTag.value == "" || replyTag.value == null) {
			alert("댓들을 입력하세요!");
			replyTag.focus();
			return false;
		}
		document.replyForm.submit();
	}

	function updateReply(num){
		let udBtn = document.getElementById("ready"+num);
		let okBtn = document.getElementById("ok"+num);
		let replyTag = document.getElementById("reply"+num);
		
		udBtn.style.display="none";
		okBtn.style.display="";
		replyTag.removeAttribute("readonly");
	}
	function updateOk(sharereplynum, num){
		let udBtn = document.getElementById("ready"+num);
		let okBtn = document.getElementById("ok"+num);
		let replyTag = document.getElementById("reply"+num);
		
		udBtn.style.display="";
		okBtn.style.display="none";
		replyTag.setAttribute("readonly","readonly");
		
		//localhost:9090/board/ReplyModifyOk.bo?sharereplynum=101&num=3&boardnum=100012
		document.updateForm.setAttribute("action","${pageContext.request.contextPath}"
						+"/app/board/ReplyModifyOk.bo?sharereplynum="+sharereplynum+"&num="+num);
		document.updateForm.submit();
	}
</script>
	
	
	
	
</html>