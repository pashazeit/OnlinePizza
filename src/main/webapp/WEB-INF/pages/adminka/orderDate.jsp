<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
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
    <link href="../../../css/datepicker/bootstrap-datepicker.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <script src="../../../js/pzz_admin.js"></script>
</head>
<body>


<nav class="navbar navbar-default header">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/PizzaTest">
                <img alt="Brand" src="../../../img/logo.png">
            </a>
        </div>
        <a href="?lang=ru">
            <img class="flag" alt="RUS" src="./img/lang/ru.png">
        </a>
        <a href="?lang=en">
            <img class="flag" alt="ENG" src="./img/lang/uk.png">
        </a>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li><a href="pizzaAdmin">Пицца <span class="sr-only">(current)</span></a></li>
                <li class="active"><a href="orderDate">Заказы</a></li>
            </ul>
        </div>

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

            <div class="col-sm-3">
                <h1 class="page-header">Поиск по датам</h1>
                <div class="panel">
                    <div class="input-daterange input-group" id="datepicker">

                        <form method="post" id="values" action="searchD">
                            <input type="text" class="input-sm form-control" name="startD" autocomplete="off"/>
                            <span class="input-group-addon">to</span>
                            <input type="text" class="input-sm form-control" name="endD" autocomplete="off"/>
                            <input type="submit" class="btn btn-primary" value="Поиск"/>
                        </form>
                    </div>
                </div>
            </div>


            <div class="col-sm-3">
                <h1 class="page-header">Поиск по тексту</h1>
                <div class="panel">
                    <form method="post" id="searchString" action="searchAll">
                        <input type="text" class="input-sm form-control" name="searchString" autocomplete="off"/>
                        <input type="submit" class="btn btn-primary" value="Поиск"/>
                    </form>
                </div>
            </div>
        </div>

    </div>
</div>

<div align="center" class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 table-responsive">
    <h1>Pizza Cart</h1>
    <table class="table table-bordered">
        <tr>
            <th><spring:message code="OrderId"/></th>
            <th><spring:message code="PassDate"/></th>
            <th><spring:message code="PassName"/></th>
            <th><spring:message code="PassNum"/></th>
            <th><spring:message code="PassAdress"/></th>
            <th><spring:message code="OrderTotal"/></th>
        </tr>


        <c:forEach var="pr" items="${result}">
            <tr>
                <td><a target="_blank" href="<c:url value='/orderInfo/${pr[0]}'/>">${pr[0]}</a></td>
                <td>${pr[1]}</td>
                <td>${pr[2]}</td>
                <td>${pr[3]}</td>
                <td>${pr[4]}</td>
                <td>${pr[5]}</td>
            </tr>
        </c:forEach>

    </table>
</div>

<script src="../../../css/bootstrap/js/bootstrap.min.js"></script>
<script src="../../../js/bootstrap-datepicker.js"></script>
<script>
    $('.input-daterange input[type=text]').datepicker({
        format: "yyyy-mm-dd",
        todayBtn: "linked",
        clearBtn: true,
        autoclose: true,
        todayHighlight: true
    });
</script>
</body>
</html>