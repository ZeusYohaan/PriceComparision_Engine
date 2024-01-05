<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.zeusyohaan.Utility.JsonUtil" %>
<%@ page import="com.fasterxml.jackson.core.type.TypeReference" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Search Results</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <!-- Your custom CSS -->
    <style>
        body {
            font-family: sans-serif;
        }

        h1 {
            color: #4CAF50;
            text-align: center;
            margin-top: 20px;
        }

        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ddd;
            font-family: sans-serif;
        }

        th {
            background-color: #f2f2f2;
            font-family: sans-serif;
        }

        button {
            background-color: #4CAF50;
            font-family: sans-serif;
            color: white;
            padding: 8px 12px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>

    <script>
        function sendParameters(title, id, name) {
            $.ajax({
                type: "GET",
                url: "getMore",
                data: {id: id, name: name, title: title},
                dataType: 'json',
                success: function (response) {
                    console.log(response);
                    $('#modal_' + id).modal('show');
                }
            });
        }
    </script>
</head>
<body>

<%
    HashMap<String, HashMap<String, String>> outerMap = (HashMap<String, HashMap<String, String>>) request.getAttribute("dataMap");
    if (outerMap != null) {
        Iterator<Map.Entry<String, HashMap<String, String>>> outerIterator = outerMap.entrySet().iterator();

        while (outerIterator.hasNext()) {
            Map.Entry<String, HashMap<String, String>> outerEntry = outerIterator.next();
            String outerKey = outerEntry.getKey();
            HashMap<String, String> innerMap = outerEntry.getValue();

%>


<div class="container">
    <h1 class="mt-4 mb-4"><%= outerKey %></h1>
    <table class="table table-bordered">
        <caption><strong>Products</strong></caption>
        <thead>
        <tr>
            <th>Product-ID</th>
            <th>Product-Name</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <% for (Map.Entry<String, String> innerEntry : innerMap.entrySet()) { %>
        <tr>
            <td><%= innerEntry.getKey() %></td>
            <td><%= innerEntry.getValue() %></td>
            <td>
                <button type="button" data-toggle="modal" id="<%=innerEntry.getKey()%>"
                        data-target="#modal_<%= innerEntry.getKey() %>" class="btn btn-primary"
                        onclick="sendParameters('<%=outerKey.toLowerCase()%>', '<%= innerEntry.getKey() %>', '<%= innerEntry.getValue() %>')">
                    Show More
                </button>
            </td>
        </tr>

        <!-- Modal for each entry -->
        <div class="modal fade" id="modal_<%= innerEntry.getKey() %>" tabindex="-1" role="dialog"
             aria-labelledby="exampleModalLabel_<%= innerEntry.getKey() %>" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel_<%= innerEntry.getKey() %>">Details for
                            <%= innerEntry.getValue() %></h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <!-- Include your modal content here -->
                        <%
                            JsonUtil<HashMap<String, Integer>> jsonUtil = new JsonUtil<>();
                            String plotDataJson = (String) request.getAttribute("plotData");

                            if(plotDataJson!=null){
                                TypeReference<HashMap<String, Integer>> typeReference = new TypeReference<>() {};
                                HashMap<String, Integer> plotData = jsonUtil.fromJsonMap(plotDataJson, typeReference);
                                Iterator<Map.Entry<String, Integer>> iterator = plotData.entrySet().iterator();
                                while (iterator.hasNext()){
                                    Map.Entry<String, Integer> element = iterator.next();
                                    String date = element.getKey();
                                    String price = ""+element.getValue();
                        %>
                        <div class="container">
                            <h1 class=""><%= innerEntry.getKey() %></h1>
                            <table class="table-bordered">
                                <caption><strong>Products</strong></caption>
                                <thead>
                                <tr>
                                    <th>Date</th>
                                    <th>Price</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td><%=date%></td>
                                    <td><%=price%></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <%}
                        }else {
                        %>

                        <div class="container mt-4">
                            <p>No results found.</p>
                        </div>
                        <%
                            }
                        %>

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
        <% } %>
        </tbody>
    </table>
</div>

<%
    }
} else {
%>
<div class="container mt-4">
    <p>No results found.</p>
</div>
<%
    }
%>


</body>
</html>