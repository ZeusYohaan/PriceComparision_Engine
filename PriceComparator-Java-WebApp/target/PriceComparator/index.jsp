<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Beautiful Page</title>
    <style>
        body {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
            margin: 0;
            background-color: #f2f2f2;
        }

        header, footer {
            background-color: #333;
            font-family: sans-serif;
            color: white;
            text-align: center;
            padding: 10px;
            width: 100%;
        }

        .container {
            text-align: center;
            flex: 1;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }

        h1 {
            color: #333;
            font-family: sans-serif;
            font-size: 2em;
            margin-bottom: 20px;
        }

        .beautiful-button {
            display: inline-block;
            font-family: sans-serif;
            padding: 10px 20px;
            font-size: 1.2em;
            font-weight: bold;
            text-align: center;
            text-decoration: none;
            background-color: #4CAF50;
            color: white;
            border: 2px solid #4CAF50;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .beautiful-button:hover {
            background-color: #45a049;
        }
    </style>

</head>
<body>
<header>
    <h1>Product of Yo-Alliance</h1>
</header>
<div class="container">
    <h1>Zeus Price Comparator</h1>
    <a href="login.jsp" class="beautiful-button">Explore the Site</a>
</div>
<footer>
    <p>&copy; 2023 Yo-Alliance. All rights reserved.</p>
</footer>
</body>
</html>
