<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Account Created - SAS Home Login</title>
    <style>
        html {
            margin: 0;
            padding: 0;
            height: 100%;
            font-family: Arial, sans-serif;
        }
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .banner {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            text-align: center;
        }
        .container {
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            text-align: center;
        }
        .footer {
            background-color: #f8f9fa;
            color: #333;
            text-align: center;
            padding: 10px 20px;
            border-top: 1px solid #e7e7e7;
        }
        h1 {
            color: #333;
        }
        a {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            color: white;
            background-color: #007bff;
            text-decoration: none;
            border-radius: 5px;
        }
        a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="banner">
            <h1>Welcome to SAS Interview Process</h1>
        </div>
            <div class="container">
        		<p>${message}</>
        		<p><a href="welcome">Let's come in</a> or <a href="${pageContext.request.contextPath}">Back Home</a></p>
    		</div>
        <div class="footer">
            <p>© 2024 SAS Midtier Platform Team. All rights reserved.</p>
        </div>
    </div>
</body>
</html>
