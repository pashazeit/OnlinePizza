<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Zeit
  Date: 07.01.2017
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <title>Pizza pizz!</title>

        <link href="./css/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="./css/pizz.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <script src="./js/modal.js"></script>
    </head>

</head>

<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="PizzaTest">
                <img alt="Brand" src="./img/logo.png">
            </a>
        </div>
        <p><a href="#" id="go" class="btn btn-success pull-right basket">Обратная связь</a></p>
        <a href="?lang=ru">
            <img class="flag" alt="RUS" src="./img/lang/ru.png">
        </a>
        <a href="?lang=en">
            <img class="flag" alt="ENG" src="./img/lang/uk.png">
        </a>
    </div>
</nav>
<div align="center" class="table-responsive">
    <h1>Pizza Cart</h1>

    <c:set var="check" value="${result}"></c:set>
    <c:if test="${not empty check}">

        <table class="table table-bordered">
            <tr>
                <th><spring:message code="CartName"/></th>
                <th><spring:message code="CartPhoto"/></th>
                <th><spring:message code="CartQuantity"/></th>
                <th><spring:message code="CartCost"/></th>
            </tr>
            <c:forEach var="pr" items="${result}">
                <tr>
                    <td>${pr[5]}</td>
                    <td><img src="${pr[6]}" alt="${pr[5]}"></td>
                    <td>${pr[2]}</td>
                    <td>${pr[3]}</td>
                    <td><a href="${pageContext.request.contextPath}/delete/${pr[1]}"><spring:message
                            code="CartRemove"/></a></td>
                </tr>
                <c:set var="total" value="${total+ pr[3]}"></c:set>
            </c:forEach>
        </table>
        <h4><spring:message code="CartTotal"/> = ${total}</h4>
        <a class="btn btn-primary btn-cart pull-left"
           href="${pageContext.request.contextPath}/PizzaTest"><spring:message code="PageIndex"/></a>
        <a class="btn btn-primary btn-cart pull-right"
           href="${pageContext.request.contextPath}/CheckOut"><spring:message code="PageOrder"/></a>
    </c:if>

    <c:if test="${empty check}">
        <h2><spring:message code="CartEmpty"/></h2>
        <a class="btn btn-primary btn-cart" href="${pageContext.request.contextPath}/PizzaTest"><spring:message
                code="PageIndex"/></a>
    </c:if>

</div>

<div id="modal_form">
    <span id="modal_close">X</span>
    <form action="mailpost" method="post">
        <h3>Обратная связь</h3>
        <p>Данные сюда.</p>
        <p>Ваше имя<br/>
            <input type="text" name="your-name" value="" size="40"/>
        </p>
        <p>Ваш телефон<br/>
            <input type="text" name="your-number" value="" size="40"/>
        </p>
        <p>Ваше сообщение<br/>
            <input type="text" name="your-message" value="" size="40"/>
        </p>
        <p style="text-align: center; padding-bottom: 10px;">
            <button type="submit" class="btn btn-primary btn-sm">Отправить</button>
        </p>
    </form>
</div>
<div id="overlay"></div>

<script src="./css/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>