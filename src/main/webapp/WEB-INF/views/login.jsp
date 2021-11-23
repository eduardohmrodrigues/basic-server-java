<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Yahoo!!! From JSP</title>
</head>
<body>

    <p><span style="color: red; ">${errorMessage}</span></p>
    <form action="/login.do" method="post">
        Name: <input type="text" name="name"/>
        Password: <input type="password" name="password"/>
        <input type="submit"/>
    </form>
</body>
</html>
