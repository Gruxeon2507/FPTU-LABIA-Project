<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>




<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>JSP Page</title>
        <style>
            h1{
                text-align: center;

            }
            body{


                background-image: url("img/fpthl.jpg");
                background-size: cover;
            }
            .bg-img {
                /* The image used */
                display: flex;
                justify-content: center;


                /* Center and scale the image nicely */
                background-position: center;
                background-repeat: no-repeat;
                background-size: cover;
                position: relative;
            }
            input[type=text], input[type=password] {
                width: 100%;
                padding: 15px;
                margin: 5px 0 22px 0;
                border: none;
                background: #f1f1f1;
            }

            input[type=text]:focus, input[type=password]:focus {
                background-color: #ddd;
                outline: none;
            }

            /* Set a style for the submit button */
            .btn {
                background-color: #04AA6D;
                color: white;
                padding: 16px 20px;
                border: none;
                cursor: pointer;
                width: 100%;
                opacity: 0.9;
            }
            .container {

                position: absolute;
                margin: auto;
                max-width: 300px;
                padding: 16px;
                background-color: white;
            }
        </style>
    </head>
    <body>
        <h1 >FPT University Academic Portal</h1>
        <div class="bg-img">
            <form method="post" action="../login" class="container">
                <label for="uname"><b>Username</b></label>
                <input type="text" placeholder="Enter Username" name="username" required><br>


                <label for="psw"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="password" required><br>
                ${errorLogin}
                <button type="submit" class="btn">Login</button>
            </form>
        </div>
    </body>
</html>