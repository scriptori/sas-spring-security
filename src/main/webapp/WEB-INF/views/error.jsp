<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Error - SAS</title>
    <style>
        body, html {
            margin: 0;
            padding: 0;
            height: 100%;
            font-family: Arial, sans-serif;
        }
        .container {
            min-height: 100%;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
        }
        .banner {
            background-color: #ff0000; /* Red color for error indication */
            color: white;
            padding: 10px 20px;
            text-align: center;
        }
        .content {
            flex-grow: 1;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 20px;
        }
        .message {
            text-align: center;
            max-width: 600px;
            border: 1px solid #ccc;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 15px 5px rgba(0,0,0,0.1);
        }
        .footer {
            background-color: #f8f9fa;
            color: #333;
            text-align: center;
            padding: 10px 20px;
            border-top: 1px solid #e7e7e7;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="banner">
            <h1>Error Occurred</h1>
        </div>
        <div class="content">
            <div class="message">
                <h2>Sorry, something went wrong.</h2>
                <p><%= request.getAttribute("errorMessage") %></p> <!-- Display the error message from request -->
                <p><a href="${pageContext.request.contextPath}">Home</a> or <a href="sasCreateAccount">Try again...</a></p>
            </div>
        </div>
        <div class="footer">
            <p>© 2024 SAS. All rights reserved.</p>
        </div>
    </div>
</body>
</html>
