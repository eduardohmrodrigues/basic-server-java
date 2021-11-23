package com.ehmr.webapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

        private final String NAME_PARAMETER = "name";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter(NAME_PARAMETER);

        request.setAttribute(NAME_PARAMETER, name);
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);

    }

}
