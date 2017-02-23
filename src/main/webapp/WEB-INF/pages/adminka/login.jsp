<%--
  Created by IntelliJ IDEA.
  User: Zeit
  Date: 08.02.2017
  Time: 13:09
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
    <h1>Login please</h1>
    <form action="/loginCheck" class="admin_login">
        <label for="adminlogin">
            login:
            <input type="text" name="adminlogin" id="adminlogin">
        </label>
        <label for="adminpass">
            password:
            <input type="password" name="adminpass" id="adminpass">
        </label>
        <button type="submit" name="adminsubmit" id="adminsubmit">Войти</button>

    </form>
    <p class="bg-danger">${result}</p>
</div>
</body>

<script src="../../../css/bootstrap/js/bootstrap.min.js"></script>
</html>