<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Zeit
  Date: 13.01.2017
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="./css/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="./css/pizz.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <script src="./js/modal.js"></script>

    <title><spring:message code="PassOrder"/></title>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">
                <img alt="Brand" src="./img/logo.png">
            </a>
        </div>
        <a type="button" class="btn btn-success pull-right basket" id="korzina" href="/cart">Корзина</a>
        <p><a href="#" id="go" class="btn btn-success pull-right basket">Обратная связь</a></p>
        <a href="?lang=ru">
            <img class="flag" alt="RUS" src="./img/lang/ru.png">
        </a>
        <a href="?lang=en">
            <img class="flag" alt="ENG" src="./img/lang/uk.png">
        </a>

    </div>
</nav>

<form method="post" action="${pageContext.request.contextPath}/saveOrder">
    <table>
        <tr>
            <td><p><spring:message code="PassName"/></p></td>
            <td><input minlength="2" maxlength="45" type="text" name="nameP" id="namePP" class="namePP" required></td>
        </tr>
        <tr>
            <td><p><spring:message code="PassAdress"/></p></td>

            <td><input minlength="5" maxlength="70" type="text" name="addressP" id="addressPP" required></td>
        </tr>
        <tr>
            <td><p><spring:message code="PassNum"/></p></td>
            <td><input minlength="10" maxlength="15" type="text" name="numberP" id="phonePP" required></td>
        </tr>
        <tr>
            <td><p><spring:message code="PassCheck"/></p></td>
            <td><input type="submit" value="<spring:message code="PassCheck"/>" id="submit_order"></td>
        </tr>


    </table>
    <p id="err"></p>

    <a class="warning">${warning}</a>
    <a href="${pageContext.request.contextPath}/PizzaTest"><spring:message code="PageIndex"/></a>

</form>


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

<%--набранный товар--%>
<script>
    var $value = parseInt(${sessionScope.get("cart")});
    if ($value > 0) {
        $('#korzina').text('В корзине на ' + $value + ' денег');
    }
</script>

<script src="js/cart_order.js"></script>
</body>
</html>
