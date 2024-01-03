package com.zeusyohaan.Servlet;

import com.zeusyohaan.Manager.productManager;
import com.zeusyohaan.Utility.JsonUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

@WebServlet("/getMore")
public class getMoreResultServlet extends HttpServlet {
    private final productManager productManager = new productManager();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vegID = request.getParameter("id");
        String title = request.getParameter("name");
        String tableName = request.getParameter("title");
        HashMap<String, Integer> plotData = productManager.getPlotData(tableName, vegID);
        request.setAttribute("plotData", plotData);
        request.getRequestDispatcher("results.jsp").forward(request, response);
    }
}
