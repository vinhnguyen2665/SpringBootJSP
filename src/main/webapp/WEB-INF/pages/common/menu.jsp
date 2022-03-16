<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="vn.com.nsmv.common.CommonConst" %>
<%@ page import="vn.com.nsmv.common.URLConst" %>
<%@ page import="vn.com.nsmv.common.CommonCode" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title><%=CommonConst.SYSTEM.NAME %></title>
    <link rel="icon" type="image/svg+xml" href="<c:url value = "/resources/imgs/sensors.svg" />">
</head>
<script>
    let contextPath = "${pageContext.request.contextPath}";
    let currentPath = "${currentPath}"
    let lang = "<spring:message    code="LAYOUT.LANG" />";
    let userInfo = {
        'userId' : ${userLogin.id},
        'userName' : "${userLogin.userName}",
        'firstName' : "${userLogin.firstName}",
        'midName' : "${userLogin.midName}",
        'lastName' :  "${userLogin.lastName}"
    }
</script>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="currentPath" value="${currentPath}"/>
<spring:message var="lang"  code='LAYOUT.LANG' />


<jsp:include page="css_common.jsp"/>
<jsp:include page="js_common.jsp"/>
<style>
    *,
    *:before,
    *:after {
        box-sizing: border-box;
        margin: 0;
        padding: 0;
    }


/*Menu*/

    .heading-section {
        font-size: 28px;
        color: #000; }
    .heading-section small {
        font-size: 18px; }

    .img {
        background-size: cover;
        background-repeat: no-repeat;
        background-position: center center; }

    .navbar {
        padding: 15px 10px;
        background: #fff;
        border: none;
        border-radius: 0;
        margin-bottom: 40px;
        -webkit-box-shadow: 1px 1px 3px rgba(0, 0, 0, 0.1);
        box-shadow: 1px 1px 3px rgba(0, 0, 0, 0.1); }

    .navbar-btn {
        -webkit-box-shadow: none;
        box-shadow: none;
        outline: none !important;
        border: none; }

    .line {
        width: 100%;
        height: 1px;
        border-bottom: 1px dashed #ddd;
        margin: 40px 0; }

    .wrapper {
        width: 100%; }

    #sidebar {
        min-width: 270px;
        max-width: 270px;
        background: #34568B;
        color: #fff;
        -webkit-transition: all 0.3s;
        -o-transition: all 0.3s;
        transition: all 0.3s; }
    #sidebar.active {
        min-width: 80px;
        max-width: 80px;
        text-align: center; }
    #sidebar.active ul.components li {
        font-size: 14px; }
    #sidebar.active ul.components li a {
        padding: 10px 0; }
    #sidebar.active ul.components li a span {
        margin-right: 0;
        display: block;
        font-size: 24px; }
    #sidebar.active .logo {
        padding: 10px 0; }
    #sidebar.active .footer, #sidebar.active .show-text {
        display: none !important; }
    #sidebar .logo {
        display: block;
        color: #fff;
        font-weight: 900;
        padding: 10px 30px;
        -webkit-transition: 0.3s;
        -o-transition: 0.3s;
        transition: 0.3s; }
    @media (prefers-reduced-motion: reduce) {
        #sidebar .logo {
            -webkit-transition: none;
            -o-transition: none;
            transition: none; } }
    #sidebar ul.components {
        padding: 0;
        -webkit-transition: 0.3s;
        -o-transition: 0.3s;
        transition: 0.3s; }
/*    @media (prefers-reduced-motion: reduce) {
        #sidebar ul.components {
            -webkit-transition: none;
            -o-transition: none;
            transition: none; } }*/
    #sidebar ul li {
        font-size: 16px; }
    #sidebar ul li > ul {
        /*margin-left: 10px; }*/
        margin-left: 0px; }
    #sidebar ul li > ul li {
        font-size: 14px; }
    #sidebar ul li a {
        padding: 10px 30px;
        display: block;
        color: white;
        border-bottom: 1px solid rgba(255, 255, 255, 0.1); }
    #sidebar ul li a span {
        margin-right: 15px; }
/*    @media (max-width: 991.98px) {
        #sidebar ul li a span {
            display: block; } }*/
    #sidebar ul li a:hover {
        color: #fff; }
    #sidebar ul li.active > a {
        background: transparent;
        color: #fff; }
/*    @media (max-width: 991.98px) {
        #sidebar {
            min-width: 80px;
            max-width: 80px;
            text-align: center;
            margin-left: -80px !important; }
        #sidebar.active {
            margin-left: 0 !important; } }*/

    a[data-toggle="collapse"] {
        position: relative; }

    .dropdown-toggle::after {
        display: block;
        position: absolute;
        top: 50%;
        right: 0;
        -webkit-transform: translateY(-50%);
        -ms-transform: translateY(-50%);
        transform: translateY(-50%); }

/*    @media (max-width: 991.98px) {
        #sidebarCollapse span {
            display: none; } }*/

    .footer {
        padding: 0 30px; }
/*    @media (max-width: 991.98px) {
        .footer {
            display: none; } }
    #sidebar > .show-text {
        padding: 0; }
    @media (max-width: 991.98px) {
        #sidebar > .show-text {
            display: none !important; } }*/
    #content {
        width: 100%;
        padding: 0;
        min-height: 100vh;
        -webkit-transition: all 0.3s;
        -o-transition: all 0.3s;
        transition: all 0.3s; }

    .btn.btn-primary {
        background: #3e64ff;
        border-color: #3e64ff; }
    .btn.btn-primary:hover, .btn.btn-primary:focus {
        background: #3e64ff !important;
        border-color: #3e64ff !important; }
#sidebar * {
    text-decoration: none;
}
.selected-menu > * {
    background: #92A8D1 !important;
    color: black !important;
}
    #sidebar *:hover,  .selected-menu > a:hover, .selected-menu > span:hover {
        cursor: pointer;
        background-color: #333 !important;
        color: white !important;
    }
    .icon-flag {
        width: 100%;
        min-height: 15px;
        min-width: 20px;
        max-height: 30px;
        max-width: 40px;
    }
</style>

<body class="container-fluid" style="padding-right: 0; padding-left: 0;">
<c:set var = "selectedMenu" value =  "${selectedMenuCode}" />

<div class="modal fade" id="loadingModal" tabindex="-1" data-bs-backdrop="static" data-bs-keyboard="false"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <div class="d-flex justify-content-center">
                    <div class="spinner-border text-success" role="status">
                        <span class="visually-hidden">Loading...</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="wrapper d-flex align-items-stretch">
    <nav id="sidebar" class="active">
        <div>
            <a href="${contextPath}/${lang}<%= URLConst.DASHBOARD.HOME %>" class="logo show " style="background: #ffffff00 !important;">
            <div class="d-flex justify-content-center" style="display: block">
                <span class="material-icons" style="font-size: 80px;">home</span>
                <span class="show-text" style="font-size: 32px;position: absolute; top: 76px;"> Spring System</span>
            </div>
            </a>
            <hr>
        </div>
        <ul class="list-unstyled components mb-5">
            <li>
                <a href="#" id="sidebarCollapse" class="btn btn-primary" style="border-bottom:0; background: #ffffff00 !important; border-color: #ffffff00 !important;box-shadow: 0 0 0 0.25rem rgb(255 255 255 / 0%) !important;">
                    <i id="sidebarIcon" class="fa fa-bars" style="font-size: 35px;"></i>
                    <span class="sr-only">Toggle Menu</span>
                </a>
            </li>
            <li class="active <%= CommonCode.selectedMenu( pageContext.getAttribute("selectedMenu"), CommonConst.PAGE_CODE.dashboard) %>">
                <a href="${contextPath}/${lang}<%= URLConst.DASHBOARD.HOME %>">
                    <span class="fas fa-tachometer-alt"></span>
                    <span class="show-text"><spring:message code="LAYOUT.dashboard" /></span>
                </a>
            </li>
            <li class="active <%= CommonCode.selectedMenu( pageContext.getAttribute("selectedMenu"), CommonConst.PAGE_CODE.report) %>">
                <a href="${contextPath}/${lang}/#">
                    <span class="fas fa-chart-line"></span>
                    <span class="show-text"><spring:message code="LAYOUT.report" /></span>
                </a>
            </li>
<%--            <li class="active <%= CommonCode.selectedMenu( pageContext.getAttribute("selectedMenu"), CommonConst.PAGE_CODE.send_message) %>">
                <a href="${contextPath}/${lang}<%= URLConst.SEND_MESSAGE.HOME %>">
                    <span class="material-icons">sms</span>
                    <span class="show-text"><spring:message code="LAYOUT.message" /></span>
                </a>
            </li>--%>
            <li class="active <%= CommonCode.selectedMenu( pageContext.getAttribute("selectedMenu"), CommonConst.PAGE_CODE.gateway) %>">
                <a href="${contextPath}/${lang}<%= URLConst.LOGIN.LOGOUT %>">
                    <span class="fas fa-sign-out-alt"></span>
                    <span class="show-text"><spring:message code="LAYOUT.signOut" /></span>
                </a>
            </li>

<%--            <li class="active <%= CommonCode.selectedMenu( pageContext.getAttribute("selectedMenu"), CommonConst.PAGE_CODE.gateway) %>">
                <a href="${contextPath}/${lang}<%= URLConst.GATEWAY.HOME %>">
                    <span class="material-icons">schedule</span>
                    <span class="show-text">DEMO</span>
                </a>
            </li>--%>
           <%-- <li>
                <a href="#"><span class="fa fa-cogs"></span> </a>
            </li>
            <li class="">
                <a href="#"><span class="fa fa-paper-plane"></span> </a>
            </li>
            <li>
                <ul>
                    <li class="">
                        <a href="#"><span class="fa fa-paper-plane"></span> </a>
                    </li>
                    <li>
                        <a href="#"><span class="fa fa-paper-plane"></span> </a>
                    </li>
                </ul>
            </li>--%>

            <li><div class="d-flex justify-content-center w-100">
                <span class="col-4 p-1" >
                    <a href="${pageContext.request.contextPath}/ja/${currentPath}" style="border:none;">
                        <img class="icon-flag" src="<c:url value = "/resources/imgs/ja.png" />" alt="日本語">
                    </a>
                </span>
                <span class="col-4 p-1">
                    <a href="${pageContext.request.contextPath}/en/${currentPath}" style="border:none;">
                        <img class="icon-flag" src="<c:url value = "/resources/imgs/en.png" />" alt="English">
                    </a>
                </span>
                <span class="col-4 p-1">
                    <a href="${pageContext.request.contextPath}/vi/${currentPath}" style="border:none;">
                        <img class="icon-flag" src="<c:url value = "/resources/imgs/vi.png" />" alt="Tiếng Việt">
                    </a>
                </span>
            </div></li>
        </ul>

        <div class="footer">
            <p>
                Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved
            </p>
        </div>
    </nav>

    <script>
        (function($) {

            "use strict";

/*            var fullHeight = function() {

                $('.js-fullheight').css('height', $(window).height());
                $(window).resize(function(){
                    $('.js-fullheight').css('height', $(window).height());
                });

            };
            fullHeight();*/

            $('#sidebarCollapse ').on('click', function () {
                $('#sidebar').toggleClass('active');
                let sidebarIcon = $('#sidebarIcon');
                if(sidebarIcon.hasClass('fa-bars')){
                    sidebarIcon.removeClass('fa fa-bars');
                    sidebarIcon.addClass('fas fa-times');
                } else {
                    sidebarIcon.removeClass('fas fa-times');
                    sidebarIcon.addClass('fa fa-bars');
                }
            });})(jQuery);
        //$("#sidebar").niceScroll();
        let specifiedElement = document.getElementById('sidebar');
        document.addEventListener('click', function(event) {
            let isClickInside = specifiedElement.contains(event.target);
            let sidebarIcon = $('#sidebarIcon');
            if (isClickInside) {
                console.log('You clicked inside')
            }
            else {
                if(!sidebarIcon.hasClass('fa-bars')) {
                    $('#sidebarCollapse ').trigger('click');
                }
            }
        });
    </script>
    <div id="content" class="p-1 p-lg-1"
         style="/*min-width: 1340px; box-shadow: 0 0 10px 3px #d1d1d1; */ border-radius: 0px 0px 20px 20px; background-color: #ffffff">
