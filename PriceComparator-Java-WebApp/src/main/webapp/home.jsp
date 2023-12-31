<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }

        header {
            background-color: #333333;
            color: #ffffff;
            padding: 5px;
            text-align: center;
        }

        main {
            flex-grow: 1;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .search-container {
            text-align: center;
            border-radius: 5px;
        }

        .search-container h2 {
            color: #333333;
            border-radius: 5px;
        }

        #searchInput {
            padding: 10px;
            margin: 10px 0;
            width: 300px;
            border-radius: 5px;
        }

        button {
            padding: 10px 20px;
            background-color: #4caf50;
            color: #ffffff;
            border: none;
            cursor: pointer;
            border-radius: 5px;
        }

        button:hover {
            background-color: #45a049;
        }

        footer {
            background-color: #333333;
            color: #ffffff;
            padding: 10px;
            text-align: center;
        }
    </style>
</head>
<body>

<%@ include file="header.jsp" %>

<main>
    <div class="search-container">
        <h2>Search for items :-</h2>
        <form class="search-form" action="searchResults" method="get">
            <input type="text" name="searchInput" id="searchInput" placeholder="Enter your search">
            <button type="submit">Search</button>
        </form>
    </div>
</main>

<%@ include file="footer.jsp" %>

</body>
</html>
