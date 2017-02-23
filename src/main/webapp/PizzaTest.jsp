<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Pizza pizz!</title>

    <link href="./css/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="./css/pizz.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lobster&amp;subset=cyrillic" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <script src="./js/modal.js"></script>
</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">
                <img alt="Brand" src="./img/logo.png">
            </a>
        </div>
        <a type="button" class="btn btn-success pull-right basket" id="korzina"
           href="${pageContext.request.contextPath}/cart">Корзина пуста</a>

        <p><a href="#" id="go" class="btn btn-success pull-right basket">Обратная связь</a></p>

        <a href="?lang=ru">
            <img class="flag" alt="RUS" src="./img/lang/ru.png">
        </a>
        <a href="?lang=en">
            <img class="flag" alt="ENG" src="./img/lang/uk.png">
        </a>

    </div>
</nav>


<br>
<a href="<c:url value="/login"/>" target="_blank">Adminka</a>
<br/>

<div class="row">
    <c:if test="${!empty listPizza}">
    <% int i = 0; %>
    <c:forEach items="${listPizza}" var="pizza">
    <% if ((i > 0) && (i % 3 == 0)) {%>
</div>
<div class="row">
    <%
        }
        ;
        i++;
    %>

    <div class="col-sm-6 col-md-4 pizza">
        <div class="thumbnail">
            <img src="${pizza.urlPizza}" alt="...">
            <div class="caption">
                <h3>${pizza.namePizza}</h3>
                <div class="alert alert-warning" role="alert">
                    <p>${pizza.titlPizza}</p>
                </div>
                <div class="alert alert-danger" role="alert">
                    <p class="lead">Только за</p>
                    <h2 class="price">${pizza.pricePizza}
                    </h2>

                </div>
                <p><a href="${pageContext.request.contextPath}/ordernow/${pizza.id }" class="btn btn-warning take_pizza"
                      role="button">В корзину</a>
            </div>
        </div>
    </div>

    </c:forEach>
    </c:if>

    <%--набранный товар--%>
    <script>
        var $value = parseInt(${sessionScope.get("cart")});
        if ($value > 0) {
            $('#korzina').text('В корзине на ' + $value + ' денег');
        }
    </script>


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

<script src="./js/modal.js"></script>
<script src="./css/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>