<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        div {
            background-color: #ffffff;
            border-radius: 5px;
            padding: 40px 50px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            min-width: 400px;
            
        }

        h1 {
            text-align: center;
            color: #333;
        }

        form {
            text-align: left;
        }

        label {
            display: block;
            margin-bottom: 5px;
            color: #555;
        }

        input[type="text"],
        input[type="email"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        input[type="text"]:focus,
        input[type="email"]:focus {
            border-color: #007bff;
            outline: none;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>

<title>Login Form</title>
</head>
<body>
	<div>
    <h1>Login Form</h1>
    <form method="post" action="/home">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>
        
        <label for="mobile">Mobile Number:</label>
        <input type="text" id="mobile" name="mobile" pattern="[0-9]{10}" title="Enter a 10-digit Indian mobile number" required><br><br>
        
        <input type="submit" value="Submit">
    </form>
    </div>
</body>
</html>
