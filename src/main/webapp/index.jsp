<%--
  Created by IntelliJ IDEA.
  User: Zeit
  Date: 28.01.2017
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Redirect</title>
    <style>
        h1 {
            text-align: center;
            margin-top: 5rem;
        }
        .load {
            width: 300px;
            position: absolute;
            top: calc(50% - 200px);
            left: calc(50% - 150px);
        }
    </style>
</head>
<body>
<h1>LOADING DATA!</h1>
<img class="load" src="img/111.gif" alt="loading">

<script language="javascript">
    setTimeout(function () {
        location.replace("PizzaTest");
    }, 3000);

</script>
</body>
</html>
