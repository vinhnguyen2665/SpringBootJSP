<%@ page import="com.vinhnq.common.CommonConst" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><%=CommonConst.SYSTEM.NAME %>
    </title>
    <link rel="icon" type="image/svg+xml" href="<c:url value = "/resources/imgs/sensors.svg" />">
    <link rel="stylesheet" href="<c:url value = "/resources/css/login.css" />"></link>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/fontawesome.min.css"
          integrity="sha512-OdEXQYCOldjqUEsuMKsZRj93Ht23QRlhIb8E/X0sbwZhme8eUw6g8q7AdxGJKakcBbv7+/PX0Gc2btf7Ru8cZA=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
          integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/fontawesome.min.js"
            integrity="sha512-KCwrxBJebca0PPOaHELfqGtqkUlFUCuqCnmtydvBSTnJrBirJ55hRG5xcP4R9Rdx9Fz9IF3Yw6Rx40uhuAHR8Q=="
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css"></link>
    <script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
    <script type="text/javascript" src="<c:url value = "/resources/js/common/Toast.js" />"></script>
</head>
<body>

<div class="hero-top" id="mainVisual" style="width: 100vw; height: 100vh;background-image: url(<c:url value = "/resources/imgs/hero_video_01.png"/>);" >
    <!-- /hero-search-area -->
    <div class="hero-video" >
        <video id="video" playsinline="" autoplay="" muted="" loop="">
            <%--			<source src="<c:url value = "/resources/videos/background.mp4"/>" type="video/mp4">--%>
            <source src="<c:url value = "/resources/videos/hero_video_01.mp4"/>" type="video/mp4">
            <source src="<c:url value = "/resources/videos/hero_video_01.ogv" />" type="video/ogg">
            <source src="<c:url value = "/resources/videos/hero_video_01.webm" />" type="video/webm">
            Your browser does not support the video tag.
        </video>
    </div>
    <!-- /hero-video -->
    <div id="particles-js"> <canvas class="particles-js-canvas-el" style="width: 100%; height: 100%;"></canvas></div>
    <div class="container ">
        <div class="d-flex justify-content-center h-100">
            <div class="card">
                <div class="card-header">
                    <h3><spring:message code="LAYOUT.signIn"/></h3>
                    <%--<div class="d-flex justify-content-end social_icon">
                        <span><i class="fab fa-facebook-square"></i></span>
                        <span><i class="fab fa-google-plus-square"></i></span>
                        <span><i class="fab fa-twitter-square"></i></span>
                    </div>--%>
                </div>
                <div class="card-body">
                    <form action="<c:url value = "/login"/>" method="POST">
                        <c:if test="${not empty param['error']}">
                            <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
                                <script>
                                    Toast.topCenterError('<spring:message code="MESSAGE.idOrPasswordIsIncorrect" />', '<spring:message code="MESSAGE.failedToLogin" />');
                                </script>
                            </c:if>
                        </c:if>
                        <div class="input-group form-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><i class="fas fa-user"></i></span>
                            </div>
                            <input type="text" class="form-control"
                                   placeholder="<spring:message code="LAYOUT.username" />" name="username">

                        </div>
                        <div class="input-group form-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text"><i class="fas fa-key"></i></span>
                            </div>
                            <input type="password" class="form-control"
                                   placeholder="<spring:message code="LAYOUT.password" />" name="password">
                        </div>
                        <div class="row align-items-center remember">
                            <input type="checkbox"><spring:message code="LAYOUT.rememberMe"/>
                        </div>
                        <div class="form-group">
                            <input type="submit" value="<spring:message code="LAYOUT.login" />"
                                   class="btn float-right login_btn">
                        </div>
                        <%--						<div class="d-flex justify-content-end lang-icon">--%>
                        <%--							<span><img src="<c:url value = "/resources/imgs/ja.png" />" alt="日本語"></span>--%>
                        <%--							<span><img src="<c:url value = "/resources/imgs/en.png" />" alt="English"></span>--%>
                        <%--							<span><img src="<c:url value = "/resources/imgs/vi.png" />" alt="Tiếng Việt"></span>--%>
                        <%--						</div>--%>
                    </form>

                </div>
                <div class="card-footer">
                    <div class="d-flex justify-content-center links">
                        <spring:message code="LAYOUT.dontHaveAnAccount"/><a href="#"><spring:message
                            code="LAYOUT.signUp"/></a>
                    </div>
                    <div class="d-flex justify-content-center">
                        <a href="#"><spring:message code="LAYOUT.forgotYourPassword"/></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%--<script type="text/javascript" src="<c:url value = "/resources/js/login/login.js" />"></script>--%>
</body>
</html>
