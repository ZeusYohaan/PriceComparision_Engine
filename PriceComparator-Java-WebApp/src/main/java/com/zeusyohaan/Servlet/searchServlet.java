package com.zeusyohaan.Servlet;

import com.zeusyohaan.SearchEngine.searchEngine;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/searchResults")
public class searchServlet extends HttpServlet {
    private static final Log log = LogFactory.getLog(searchServlet.class);

    private final searchEngine searchEngine = new searchEngine();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchResult = (String) request.getParameter("searchInput");

        log.info("Search result: " + searchResult);

        // Use HashMap specifically
        HashMap<String, List<String>> results = searchEngine.getItemsFromDB(searchResult);

        log.info("Size of the HashMap: " + results.size());

        for (Map.Entry<String, List<String>> entry : results.entrySet()) {
            log.info("Key: " + entry.getKey());
            log.info("Values: " + entry.getValue());
        }

        request.setAttribute("dataMap", results);
        request.getRequestDispatcher("results.jsp").forward(request, response);
    }
}
