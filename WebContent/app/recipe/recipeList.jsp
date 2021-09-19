<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Untitled</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/recipe/index.css" />
		<link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
	</head>
	<body class="is-preload">
		<c:set var="recipeList" value="${requestScope.recipeList}"/>
		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<div id="main">
						<div class="inner">

							<!-- Header -->
								<%@include file="../Header.jsp"  %>
									
									<c:set var="j" value="4" />
									<fmt:parseNumber var= "len" integerOnly= "true" value= "${fn:length(recipeList)/4}" />
										<table border="1">
											<c:forEach var="i" begin="0" end="${(len+1)*4-1}">
											<c:set var="recipe" value="${recipeList[i]}"/>
											<!-- 전체길이/4+1  *  4 => 반복횟수 -->
												<c:if test="${i%j == 0 }">
												<tr>
												</c:if>
													<c:choose>
														<c:when test="${i<fn:length(recipeList)}">
														<td>
															<div style="border: 1px solid #ddd; width: 300px; height: 300px;">
																<a href="${pageContext.request.contextPath}/app/recipe/recipeView.rc?recipeNum=${recipe.recipeNum}">
																<img alt="레시피 사진" src="${pageContext.request.contextPath}/app/file/${recipe.recipeMainImg}" class="recipeList_img" style="width: 100%; height: 70%;">
																</a>
																<div>
																	레시피명:${recipe.recipeName}<br>
																	유저명:${recipe.memberId }<br>
																</div>
															</div>
														</td>
														</c:when>
														<c:otherwise>
															<td>
																<div>
																</div>
															</td>
														</c:otherwise>
													</c:choose>
												<c:if test="${i%j == j-1 }">
												</tr>
												</c:if>
											</c:forEach>
										</table>
								<!--  </table> -->
								<a  href="${pageContext.request.contextPath}/app/recipe/RecipeRegister.rc" class="button small">등록하기</a>

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