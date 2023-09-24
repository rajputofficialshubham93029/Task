<%@page import="java.util.ArrayList , com.shubham.Task.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home Page</title>
</head>
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
            min-width: 80%;
            margin:auto;
            
        }

        h1 {

            color: #007bff;
            font-weight: 400;
            text-align: center;
        }

        form {
            text-align: left;
           
        }

        label {
            display: block;
            margin-bottom: 5px;
            color: #007bff;
        }

        textarea , input[type="text"],
        input[type="email"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
		textarea , 
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
        .inner{
        display:flex;
        justify-content: space-between;
        align-items: center;
        }
         table {
            border-collapse: collapse;
            width: 80%;
            margin: 0 auto; /* Center the table horizontally */
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #dddddd;
        }
        .ta{
        	margin-top:20px;
        }
        
    </style>


<body>
<div>
<div class="inner">
<h2>Welcome ${name} </h2>

<form method="get" action="/logout">
	<input type="submit" value="Logout">
</form>
</div>

    
    <h1>All Users Data :-</h1>
    <table>
    <tr>
    		<th>Name</th><th>Email</th><th>Mobile Number</th>
    </tr>
    		<% 
        		ArrayList<Users> al = (ArrayList<Users>) request.getAttribute("users");
        		for (Users l : al) {
        	%>
        		<tr>
        		<td>
        		<%= l.getName() %>
        		</td>
        		<td>
        		<%= l.getEmail()%>
        		</td>
        		<td>
        		<%= l.getMobile()%>
        		</td>
        		</tr>
        	<%
       		 }
       		 %>
    		
    		
    		
    
    </table>
    
    <h1>Previous Messages:-</h1>
    <table>
    
    		<% 
        		ArrayList<String> al1 = (ArrayList<String>) request.getAttribute("previousMessages");
        		for (String l : al1) {
        	%>
        		<tr>
        		<td>
        		<%= l %>
        		</td>
        		
        		</tr>
        	<%
       		 }
       		 %>
    		
    		
    		
    
    </table>
    
    
    </div>
</body>
</html>
