package com.ehmr.webapp;

import com.ehmr.webapp.auth.UserAuthenticationService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

    private final String NAME_PARAMETER = "name";
    private final String PASSWORD_PARAMETER = "password";
    private final String ERROR_MESSAGE_PARAMETER = "errorMessage";

    // This should be being injected
    private UserAuthenticationService authService = new UserAuthenticationService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter(NAME_PARAMETER);
        String password = request.getParameter(PASSWORD_PARAMETER);

        if(authService.isUserValid(username, password)) {
            request.setAttribute(NAME_PARAMETER, username);
            request.getRequestDispatcher("WEB-INF/views/welcome.jsp").forward(request, response);
        } else {
            request.setAttribute(ERROR_MESSAGE_PARAMETER, "Invalid user!");
            request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
        }
    }
}
