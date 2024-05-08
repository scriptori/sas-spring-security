<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome to SAS Interview Process</title>
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
		.content {
		    flex-grow: 1;
		    display: flex;
		    justify-content: center;
		    align-items: center;
		    padding: 20px;
		    text-align: center;
		}
		.message {
		    max-width: 800px;
		}
		.footer {
		    background-color: #f8f9fa;
		    color: #333;
		    text-align: center;
		    padding: 10px 20px;
		    border-top: 1px solid #e7e7e7;
		}
		a {
		    color: #007bff;
		    text-decoration: none;
		}
		a:hover {
		    text-decoration: underline;
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
        <div class="content">
            <div class="message">
                <p>Welcome to the demonstration of using Spring Security version 6.0 and above.</p>
                <p>This is part of the SAS Interview process for the position of Senior Software Developer - Midtier Platform Team.</p>
                <p><a href="${pageContext.request.contextPath}/login">Log In</a> or <a href="sasCreateAccount">Create an Account</a></p>
            </div>
        </div>
        <div class="footer">
            <p>© 2024 SAS Midtier Platform Team. All rights reserved.</p>
        </div>
    </div>
</body>
</html>
