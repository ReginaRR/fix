<%--
  Created by IntelliJ IDEA.
  User: Регина
  Date: 09.04.2018
  Time: 0:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <link href = "/css/styles.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class ="form-style-1">
            <form method="post" action="/signUp">
                <label for="first_name">Name
                    <input type="text" id="first_name" name="first_name">
                </label>
                <label for="last_name"> Login
                    <input type="text" id ="last_name" name="last_name">
                </label>
                <label for="password">  Password
                    <input type="password" id="password" name="password">
                </label>
                <input type="submit" value="Sign Up!">
            </form>
        </div>

    </body>
</html>
