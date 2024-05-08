<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SAS Login Form</title>
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
            align-items: center; /* Center align the children vertically */
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
            <h1>Welcome to SAS</h1>
        </div>
        <div class="form-container">
            <!--  <form action="${pageContext.request.contextPath}/authenticate" method="post"> -->
            <form action="sasProcessAccount">
                <div>
                    <label for="username">Username:</label>
                    <input type="text" id="username" name="username"/>
                </div>
                <div>
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password"/>
                </div>
                <div>
                    <button type="submit">Login</button>
                </div>
            </form>
        </div>
        <div class="footer">
            <p>© 2024 SAS. All rights reserved.</p>
        </div>
    </div>
</body>
</html>
