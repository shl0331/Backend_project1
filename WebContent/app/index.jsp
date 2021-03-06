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
                                                          <span class="drop__profession" style="font-size: 0.7em;">????????? ?????? ????????? ???????????? ?????????</span>
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
                                                          <span class="drop__profession" style="font-size: 0.7em;">[???????????? ??????] ???????????? ??????</span>
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
                                                          <span class="drop__profession" style="font-size: 0.7em;">??????????????? ?????????????????? ????????????</span>
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
                                                          <span class="drop__profession" style="font-size: 0.7em;">???????????? ????????? ???????????? ?????? ??? ??????</span>
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
                              <h2>????????? ?????????</h2>
                           </header>
                           <div class="posts">
                              <article>
                                 <a href="#" class="image"><img src="${pageContext.request.contextPath}/images/moring.jpg" alt="" /></a>
                                 <h3>?????? ?????????</h3>
                                 <p>10?????? ????????? ????????? ?????? ?????????! ???, ??????????????? ????????? ??????????????????! ???????????? ???????????? ?????? ?????? ????????????</p>
                                 <ul class="actions">
                                    <li><a href="#" class="button">????????????</a></li>
                                 </ul>
                              </article>
                              <article>
                                 <a href="#" class="image"><img src="${pageContext.request.contextPath}/images/lunch.jpg" alt="" /></a>
                                 <h3>???????????????</h3>
                                 <p>????????? ???????????? ???????????? ?????? ????????? ???????????? ?????????! ????????? ?????? ????????? ?????? ????????? ????????? ???????????????~</p>
                                 <ul class="actions">
                                    <li><a href="#" class="button">????????????</a></li>
                                 </ul>
                              </article>
                              <article>
                                 <a href="#" class="image"><img src="${pageContext.request.contextPath}/images/dinner.jpg" alt="" /></a>
                                 <h3>???????????????</h3>
                                 <p>??????????????? ??? ????????? ????????? ??????! ???????????? ?????????????????? ????????? ????????? ???????????????! ???????????? ????????? ????????? ????????? ??? ????????????~</p>
                                 <ul class="actions">
                                    <li><a href="#" class="button">????????????</a></li>
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