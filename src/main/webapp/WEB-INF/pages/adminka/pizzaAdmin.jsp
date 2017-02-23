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
                <li class="active"><a href="pizzaAdmin">Пицца <span class="sr-only">(current)</span></a></li>
                <li><a href="orderDate">Заказы</a></li>
            </ul>
        </div>

        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">Пицца</h1>
            <div class="panel">
                <div class="admin_main">

                    <ul class="nav nav-tabs" role="tablist">
                        <li role="presentation" class="active"><a href="#PizzaList" aria-controls="pizza" role="tab"
                                                                  data-toggle="tab">Список всех</a></li>

                        <li role="presentation"><a href="#PizzaAdd" aria-controls="pizza-add" role="tab"
                                                   data-toggle="tab">Добавить / Редактировать</a></li>
                    </ul>

                    <div class="tab-content">

                        <div role="tabpanel" class="tab-pane active" id="PizzaList">Список всех

                            <c:if test="${!empty listPizza}">
                                <table class="tg table table-striped table-hover">
                                    <tr>
                                        <th width="80">ID</th>
                                        <th width="120">Фото</th>
                                        <th width="120">Название</th>
                                        <th width="120">Описание</th>
                                        <th width="120">Цена</th>
                                        <th width="60">Редактировать</th>
                                        <th width="60">Удалить</th>
                                    </tr>
                                    <c:forEach items="${listPizza}" var="pizza">
                                        <tr>
                                            <td>${pizza.id}</td>
                                            <td><img class="admin_pizza_image" src="${pizza.urlPizza}" alt="..."></td>
                                            <td><a href="/PizInfo/${pizza.id}" target="_blank">${pizza.namePizza}</a>
                                            </td>
                                            <td>${pizza.titlPizza}</td>
                                            <td>${pizza.pricePizza}</td>
                                            <td><a href="<c:url value='/edit/${pizza.id}'/>">Edit</a></td>
                                            <td><a href="<c:url value='/remove/${pizza.id}'/>">Delete</a></td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </c:if>

                        </div>

                        <div role="tabpanel" class="tab-pane" id="PizzaAdd">
                            <h1>Add Pizza</h1>

                            <c:url var="addAction" value="/pizzaAdmin/add"/>

                            <form:form action="${addAction}" commandName="pizza">
                                <div class="add_redo">
                                    <c:if test="${!empty pizza.namePizza}">

                                        <form:label path="id">
                                            <spring:message text="ID"/>
                                        </form:label>

                                        <form:input path="id" readonly="true" size="8" disabled="true"/>
                                        <form:hidden path="id"/>

                                    </c:if>

                                    <form:label path="urlPizza">
                                        <spring:message text="URL"/>
                                    </form:label>

                                    <form:input path="urlPizza"/>

                                    <form:label path="namePizza">
                                        <spring:message text="Название"/>
                                    </form:label>

                                    <form:input path="namePizza"/>

                                    <form:label path="titlPizza">
                                        <spring:message text="Описание"/>
                                    </form:label>

                                    <form:textarea path="titlPizza"/>


                                    <form:label path="pricePizza">
                                        <spring:message text="Цена"/>
                                    </form:label>

                                    <form:input pattern="[0-9]{1,}" path="pricePizza"/>

                                    <div class="add_redo buttons">

                                        <c:if test="${!empty pizza.namePizza}">
                                            <input type="submit" id="add_redo_redoSubmit"
                                                   value="<spring:message text="Редактировать Пиццу"/>"/>
                                        </c:if>
                                        <c:if test="${empty pizza.namePizza}">
                                            <input type="submit" id="add_redo_addSubmit"
                                                   value="<spring:message text="Добавить Пиццу"/>"/>
                                        </c:if>

                                    </div>

                                    <p id="add_redo_answer" class="alert-danger">

                                    </p>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="../../../css/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>