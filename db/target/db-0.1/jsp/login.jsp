<%--
  Created by IntelliJ IDEA.
  User: Регина
  Date: 09.04.2018
  Time: 2:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href = "/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class ="form-style-1">
    <form method="post" action="/login">
        <label for="last_name"> Login
            <input type="text" id ="last_name" name="last_name">
        </label>
        <label for="password">  Password
            <input type="password" id="password" name="password">
        </label>
        <input type="submit" value="Sign In!">
    </form>
</div>

</body>
</html>
