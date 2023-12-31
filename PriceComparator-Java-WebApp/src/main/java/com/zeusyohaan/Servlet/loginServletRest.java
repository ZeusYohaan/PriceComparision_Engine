package com.zeusyohaan.Servlet;

import com.google.protobuf.ServiceException;
import com.zeusyohaan.DependencyInjector.Injector;
import com.zeusyohaan.Data.*;
//import com.zeusyohaan.Manager.UserManager;
import com.zeusyohaan.Manager.userManager;
import com.zeusyohaan.Utility.JwtUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class loginServletRest extends HttpServlet{
    private loginData getLoginDetails(HttpServletRequest request){
        loginData user = new loginData();
        user.setUserName(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        return user;
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        loginData user = getLoginDetails(request);
        userManager userManager = Injector.buildUserManager();
        boolean isAuthentic;
        try {
            isAuthentic = userManager.checkLoginDetails(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (isAuthentic) {
            String jwtToken = JwtUtil.createJwtToken(user.getUserName());
            HttpSession session = request.getSession();
            session.setAttribute("token", jwtToken);
            session.setAttribute("username", user.getUserName());
            response.sendRedirect(request.getContextPath() + "/home.jsp");
        } else {
            request.setAttribute("message", "Invalid username/password");
            request.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
