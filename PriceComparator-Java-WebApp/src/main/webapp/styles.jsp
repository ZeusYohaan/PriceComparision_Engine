<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

    #searchPopup {
        display: none;
        position: absolute;
        background-color: #ffffff;
        border: 1px solid #ccc;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        z-index: 1;
    }

    #searchPopup p {
        margin: 0;
        padding: 8px;
        border-bottom: 1px solid #eee;
    }

    #searchPopup a {
        color: #333333;
        text-decoration: none;
        cursor: pointer;
    }

    #searchPopup a:hover {
        background-color: #f2f2f2;
    }
</style>
