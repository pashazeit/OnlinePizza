<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Zeit
  Date: 08.02.2017
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Pizza pizz!</title>


    <link href="../../../css/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../../css/pizz.css" rel="stylesheet">
    <link href="../../../css/admin.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>
<body>

<div align="center" class="table-responsive">
    <h1>Order info</h1>
    <table class="table table-bordered">
        <tr>
            <th><spring:message code="OrderId"/></th>
            <th><spring:message code="PassDate"/></th>
            <th><spring:message code="PassName"/></th>
            <th><spring:message code="PassNum"/></th>
            <th><spring:message code="PassAdress"/></th>
            <th><spring:message code="CartName"/></th>
            <th><spring:message code="CartQuantity"/></th>
            <th><spring:message code="OrderTotal"/></th>
        </tr>
        <c:forEach var="pr" items="${result}">
            <c:set var="total" value="${total+ pr[5]}"></c:set>
            <tr>
                <td>${pr[7]}</td>
                <td>${pr[6]}</td>
                <td>${pr[1]}</td>
                <td>${pr[2]}</td>
                <td>${pr[3]}</td>
                <td>${pr[4]}</td>
                <td>${pr[8]}</td>
                <td>${pr[5]}</td>
            </tr>
        </c:forEach>
    </table>
    <h4><spring:message code="CartTotal"/> = ${total}</h4>
</div>
</body>

<script src="../../../css/bootstrap/js/bootstrap.min.js"></script>
</html>
