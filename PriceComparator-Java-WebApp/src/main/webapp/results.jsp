<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>Search Results</title>
</head>
<body>

<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Iterator" %>

<%
    // Retrieve the HashMap from the request
    HashMap<String, List<String>> dataMap = (HashMap<String, List<String>>) request.getAttribute("dataMap");

    // Check if the HashMap is not null before proceeding
    if (dataMap != null) {
        // Iterate over the HashMap
        Iterator<Map.Entry<String, List<String>>> iterator = dataMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, List<String>> entry = iterator.next();
            String key = entry.getKey();
            List<String> values = entry.getValue();
%>

<table border="1">
    <caption><strong><%= key %></strong></caption>
    <tr>
        <th>Values</th>
    </tr>

    <% for (String value : values) { %>
    <tr>
        <td><%= value %></td>
    </tr>
    <% } %>

</table>

<%
    }
}
else {
%>
<p>No results found.</p>
<%
    }
%>

</body>
</html>
