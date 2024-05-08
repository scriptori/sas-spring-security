<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SAS Create Account Form</title>
    
    <!-- <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css" type="text/css"> -->
    
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
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            text-align: center;
        }
        .form-container {
            flex-grow: 1;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 20px;
        }
        form {
            border: 1px solid #ccc;
            padding: 30px;
            box-shadow: 0 0 15px 5px rgba(0,0,0,0.1);
            border-radius: 10px;
            min-width: 320px;
            max-width: 450px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .footer {
            background-color: #f8f9fa;
            color: #333;
            text-align: center;
            padding: 10px 20px;
            border-top: 1px solid #e7e7e7;
        }
        label, input, button {
            display: block;
            width: 100%;
            margin-top: 10px;
        }
        input, button {
            padding: 10px;
        }
        button {
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style> 
</head>
<body>
    <div class="container">
        <div class="banner">
            <h1>Welcome to SAS Interview Process</h1>
        </div>
        <div class="form-container">
            <form:form action="sasProcessAccount" method="POST" modelAttribute="addAccount">
                <h2>Create Account</h2>
                <div>
                    <label for="username">Email:</label>
                    <form:input type="text" id="email" name="email" path="email"/>
                </div>
                <div>
                    <label for="username">Username:</label>
                    <form:input type="text" id="username" name="username" path="username"/>
                </div>
                <div>
                    <label for="password">Password:</label>
                    <form:input type="password" id="password" name="password" path="password"/>
                </div>
                <div>
                    <button type="submit">Create Account</button>
                </div>
            </form:form>
        </div>
        <div class="footer">
            <p>© 2024 SAS. All rights reserved.</p>
        </div>
    </div>
</body>
</html>
