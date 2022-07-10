<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
                <title>Register form</title>

        </head>
        <body>
            <form action="register" method="post">
                <table>
                    <tr><td><input type="text" name="firstName" placeholder="First Name"></td></tr>
                    <tr><td><input type="text" name="lastName" placeholder="Last Name"></td></tr>
                    <tr><td><input type="text" name="email" placeholder="email"></td></tr>
                    <tr><td><input type="text" name="title" placeholder="title"></td></tr>
                    <tr><td><input type="submit" value="register"></td></tr>
                </table>
            </form>
        </body>
</html>