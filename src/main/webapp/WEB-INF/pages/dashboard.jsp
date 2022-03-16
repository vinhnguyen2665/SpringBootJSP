<%@ page import="com.vinhnq.common.URLConst" %>
<%@ page import="com.vinhnq.common.CommonConst" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="common/menu.jsp"/>
<link rel="stylesheet" href="//cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css"></link>
<link rel="stylesheet" href="<c:url value = "/resources/css/dashboard.css" />"></link>
<style>
    .btn-message {
        vertical-align: baseline;
    }

</style>
<script>
    let LAYOUT = {
        recent_alerts: '<spring:message code="LAYOUT.recent_alerts" />',
        normal: '<spring:message code="LAYOUT.normal" />',
        danger_of_falling: '<spring:message code="LAYOUT.danger_of_falling" />',
        sudden_movement: '<spring:message code="LAYOUT.sudden_movement" />',
    }
    let MessageTitle = {
        MESSAGE_falling_warning: '<spring:message code="LAYOUT.fall_warning" />',
    }
</script>

<%--<div class="container ">
    <div class="d-flex justify-content-center h-100">--%>
<div class="w-100">
    <div class="d-f justify-content-left h-100">
        <div class="card col-12">
            <div class="card-header">
                <h3><spring:message code="LAYOUT.real_time"/></h3>
                <div class="d-flex justify-content-end social_icon">
                    <%--						<span><i class="fab fa-facebook-square"></i></span>
                                            <span><i class="fab fa-google-plus-square"></i></span>
                                            <span><i class="fab fa-twitter-square"></i></span>--%>
                </div>
            </div>
            <div class="card-body">
                <div>
                    <div id="user-real">
                        <label id="displayUserName" style="margin-left:10px;font-size:30px"></label>
                        <span class="btn btn-message material-icons">sms</span> <%--onclick="{$('#message-modal').modal('toggle')}--%>
                        <div class="sensor">
                            <div class="real-time-container col-12 col-sm-12 col-md-6 col-lg-2">
                                <div class="real-time-item double-click-chart" data-chartdata="heart-rate"
                                     style="min-height: 120px;position: relative;">
                                    <!--  nhip tim -->
                                    <div><spring:message code="LAYOUT.heart_rate"/></div>
                                    <h1 id="h1" style="position: absolute;font-size: 3.5rem;font-weight:bold"></h1>
                                    <div style="position: absolute;top: 75%;right: 5%;"> (BPM)</div>
                                </div>

                            </div>
                            <div class="real-time-container col-12 col-sm-12 col-md-6 col-lg-2">
                                <div class="real-time-item double-click-chart" data-chartdata="step"
                                     style="min-height: 120px;position: relative;">
                                    <!--bước chân  -->
                                    <div><spring:message code="LAYOUT.step"/></div>
                                    <h1 id="h2" style=" position: absolute;font-size: 3.5rem;font-weight:bold"></h1>
                                    <%-- <div style="position: absolute;top: 75%;right: 5%;"> (°C)</div>--%>
                                </div>

                            </div>

                            <div class="real-time-container col-12 col-sm-12 col-md-6 col-lg-2">
                                <div class="real-time-item double-click-chart" data-chartdata="spo2"
                                     style="min-height: 120px;position: relative;">
                                    <!--spo2  -->
                                    <div><spring:message code="LAYOUT.spo2"/></div>
                                    <h1 id="h3" style=" position: absolute;font-size: 3.5rem;font-weight:bold"></h1>
                                    <div style="position: absolute;top: 75%;right: 5%;"> (%)</div>
                                </div>
                            </div>

                            <%--====================================--%>

                            <div class="real-time-container col-12 col-sm-12 col-md-6 col-lg-2">
                                <div class="real-time-item double-click-chart" data-chartdata="fall"
                                     style="min-height: 120px;position: relative;">
                                    <!-- cảnh báo ngã  -->
                                    <div><spring:message code="LAYOUT.fall_warning"/></div>
                                    <h1 id="h4" style="position: absolute;font-size: 1.5rem;font-weight:bold"></h1>
                                    <%-- <div style="position: absolute;top: 75%;right: 5%;"><spring:message code="LAYOUT.bma_unit"/></div>--%>
                                </div>
                            </div>
                            <div class="real-time-container col-12 col-sm-12 col-md-6 col-lg-2">
                                <div class="real-time-item double-click-chart" data-chartdata="location-gps"
                                     style="min-height: 120px;position: relative;">
                                    <!--định vị  -->
                                    <div><spring:message code="LAYOUT.location"/></div>
                                    <span id="h5" style="padding: 17 5 5 5; position: absolute;font-size: 1rem;font-weight:bold"></span>
                                    <%--  <div style="position: absolute;top: 75%;right: 5%;"> (kPa)</div>--%>
                                </div>
                            </div>
                            <div class="real-time-container col-12 col-sm-12 col-md-6 col-lg-2">
                                <div class="real-time-item  <%--double-click-chart--%>" data-chartdata="battery"
                                     style="min-height: 120px;position: relative;">
                                    <div><spring:message code="LAYOUT.battery"/></div>
                                    <h1 id="h6" style=" position: absolute;font-size: 3.5rem;font-weight:bold"></h1>
                                    <div style="position: absolute;top: 75%;right: 5%;"> (<spring:message code="LAYOUT.battery_unit"/>) </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <%--==========================================--%>

                <div class="tab-panel">

                    <div class="row " style="width: 100%; margin: 2px;">

                        <div class=" " style="width: 100%">
                            <%--                            <nav>
                                                            <div class="nav nav-tabs nav-fill" id="nav-tab" role="tablist">
                                                                <span class="nav-item nav-link active" id="nav-alert-tab" data-toggle="tab"
                                                                      role="tab" aria-controls="nav-alert" aria-selected="true"><spring:message
                                                                        code="LAYOUT.alert"/></span>
                                                                <span class="nav-item nav-link " id="nav-message-tab" data-toggle="tab" role="tab"
                                                                      aria-controls="nav-message" aria-selected="false"><spring:message
                                                                        code="LAYOUT.message"/></span>
                                                            </div>
                                                        </nav>--%>
                            <hr>
                            <div class="tab-content py-3 px-3 px-sm-0" id="nav-tabContent">
                                <div class="tab-pane fade show active" id="nav-alert" role="tabpanel"
                                     aria-labelledby="nav-alert-tab">
                                    <%--                                    <h1>nav-alert-tab</h1>--%>
                                    <h5 id="recent_alerts"></h5>
                                    <table id="nav-alert-table" style="width: 100%!important;">
                                        <thead>
                                        <tr>
                                            <th><spring:message code="LAYOUT.date"/></th>
                                            <th><spring:message code="LAYOUT.group"/></th>
                                            <th><spring:message code="LAYOUT.contents"/></th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <%--
                                                                                <tr>
                                                                                    <td>2021-07-27 16:04:23</td>
                                                                                    <td>ユーザーA</td>
                                                                                    <td>心拍数が100回以上になるという通知を表示します。</td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td>2021-07-27 16:20:22</td>
                                                                                    <td>ユーザーA</td>
                                                                                    <td>周囲温度が35°Cを超えていることを示すメッセージを表示します。</td>
                                                                                </tr>
                                                                                <tr>
                                                                                    <td>2021-07-27 16:44:22</td>
                                                                                    <td>ユーザーA</td>
                                                                                    <td>は転倒する危険があるという通知を表示します。</td>
                                                                                </tr>--%>
                                        </tbody>
                                    </table>
                                </div>
                                <%--                                <div class="tab-pane fade " id="nav-message" role="tabpanel"
                                                                     aria-labelledby="nav-message-tab">
                                                                    <h1>nav-message-tab</h1>
                                                                </div>--%>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


    </div>
    <%--            <div class="card-footer">
                    <div class="d-flex justify-content-center links">
                        Don't have an account?<a href="#">Sign Up</a>
                    </div>
                    <div class="d-flex justify-content-center">
                        <a href="#">Forgot your password?</a>
                    </div>
                </div>--%>
</div>
</div>
</div>
<script>
    $(document).ready(function () {
        getData();
    });
</script>
<script src="//cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" language="javascript"
        src="https://nightly.datatables.net/responsive/js/dataTables.responsive.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/common/Utils.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/dashboard/dashboard.js"></script>
<jsp:include page="common/footer.jsp"/>

