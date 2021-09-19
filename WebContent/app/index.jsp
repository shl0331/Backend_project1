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
      
    
        <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/recipe/findstore.js"></script>
    <script>
    
    </script>
      
   </head>
   <body class="is-preload">

      <!-- Wrapper -->
         <div id="wrapper">

            <!-- Main -->
               <div id="main">
                  <div class="inner">

                     <!-- Header -->
                     <%@include file="Header.jsp"  %>

                     <!-- Banner -->
                        <section id="banner">
                           

                           <div class="your-class image object">
                             <div><img src="${pageContext.request.contextPath}/images/mainImg.jpg" alt="mainImg"></div>
                             <!-- 
                             <div>your content</div>
                             <div>your content</div>
                             -->
                           </div>

                        <div class="drop">
                                          <div class="drop__container" id="drop-items">
                                              <div class="drop__card">
                                                  <div class="drop__data">
                                                      <img src="${pageContext.request.contextPath}/images/rank1User.jpg" alt="" class="drop__img">
                                                      <div>
                                                          <h1 class="drop__name">Clay</h1>
                                                          <span class="drop__profession" style="font-size: 0.7em;">비린내 없이 바삭한 멸치볶음 레시피</span>
                                                      </div>
                                                  </div>
                              
                                                  <div>
                                                      <a href="#" class="drop__social"><i class='bx bxl-youtube'></i></a>
                                                  </div>
                                              </div>
                              
                                              <div class="drop__card">
                                                  <div class="drop__data">
                                                      <img src="${pageContext.request.contextPath}/images/rank2User.jpg" alt="" class="drop__img">
                                                      <div>
                                                          <h1 class="drop__name">Sara Mill</h1>
                                                          <span class="drop__profession" style="font-size: 0.7em;">[병아리콩 요리] 병아리콩 밥볼</span>
                                                      </div>
                                                  </div>
                              
                                                  <div>
                                                      <a href="#" class="drop__social"><i class='bx bxl-youtube'></i></a>
                                                  </div>
                                              </div>
                              
                                              <div class="drop__card">
                                                  <div class="drop__data">
                                                      <img src="${pageContext.request.contextPath}/images/rank3User.jpg" alt="" class="drop__img">
                                                      <div>
                                                          <h1 class="drop__name">Robbie Ford</h1>
                                                          <span class="drop__profession" style="font-size: 0.7em;">황금레시피 조림양념으로 갈치조림</span>
                                                      </div>
                                                  </div>
                              
                                                  <div>
                                                      <a href="#" class="drop__social"><i class='bx bxl-youtube'></i></a>
                                                  </div>
                                              </div>
                              
                                              <div class="drop__card">
                                                  <div class="drop__data">
                                                      <img src="${pageContext.request.contextPath}/images/rank4User.jpg" alt="" class="drop__img">
                                                      <div>
                                                          <h1 class="drop__name">Jenny Lit</h1>
                                                          <span class="drop__profession" style="font-size: 0.7em;">부드럽고 고소한 영양가득 여름 한 그릇</span>
                                                      </div>
                                                  </div>
                              
                                                  <div>
                                                      <a href="#" class="drop__social"><i class='bx bxl-youtube'></i></a>
                                                  </div>
                                              </div>
                                          </div>
                                      </div>
                           
                        </section>

                     

                     <!-- Section -->
                        <section>
                           <header class="major">
                              <h2>오늘의 레시피</h2>
                           </header>
                           <div class="posts">
                              <article>
                                 <a href="#" class="image"><img src="${pageContext.request.contextPath}/images/moring.jpg" alt="" /></a>
                                 <h3>아침 레시피</h3>
                                 <p>10분만 투자해 든든한 아침 즐기기! 빵, 시리얼부터 다양한 밥레시피까지! 출근기운 업시켜줄 아침 간단 레시피❤</p>
                                 <ul class="actions">
                                    <li><a href="#" class="button">보러가기</a></li>
                                 </ul>
                              </article>
                              <article>
                                 <a href="#" class="image"><img src="${pageContext.request.contextPath}/images/lunch.jpg" alt="" /></a>
                                 <h3>점심레시피</h3>
                                 <p>집에서 간단하게 요리하기 좋은 색다른 홈브런치 만들기! 브런치 카페 부럽지 않은 나만의 하루를 보내보세요~</p>
                                 <ul class="actions">
                                    <li><a href="#" class="button">보러가기</a></li>
                                 </ul>
                              </article>
                              <article>
                                 <a href="#" class="image"><img src="${pageContext.request.contextPath}/images/dinner.jpg" alt="" /></a>
                                 <h3>저녁레시피</h3>
                                 <p>저녁시간에 꼭 땡기는 칼칼한 요리! 매콤칼칼 국물요리부터 쫀득한 떡볶이 레시피까지! 칼칼하고 얼큰한 요리로 느글한 속 회복해요~</p>
                                 <ul class="actions">
                                    <li><a href="#" class="button">보러가기</a></li>
                                 </ul>
                              </article>
                              <article>
                                 
                           </div>
                        </section>

                  </div>
               </div>

            <!-- Sidebar -->
               <%@include file="SideBar.jsp"  %>

         </div>

      <!-- Scripts -->
         <script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
         <script src="${pageContext.request.contextPath}/assets/js/browser.min.js"></script>
         <script src="${pageContext.request.contextPath}/assets/js/breakpoints.min.js"></script>
         <script src="${pageContext.request.contextPath}/assets/js/util.js"></script>
         <script src="${pageContext.request.contextPath}/assets/js/main.js"></script>

   </body>
</html>