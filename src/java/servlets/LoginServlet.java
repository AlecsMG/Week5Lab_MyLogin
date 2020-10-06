/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;
import models.User;

/**
 *
 * @author 831690
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String logout = request.getParameter("logout");

        if (logout != null) {
            request.setAttribute("message", "You have successfully logged out");
            session.invalidate();
            session = request.getSession();
            response.sendRedirect(request.getContextPath() + "/login");
        } else if (logout == null) {
            response.sendRedirect(request.getContextPath() + "/home");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        AccountService checker = new AccountService();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (!username.equals("") && !password.equals("")) {
            User user = checker.login(username, password);

            if (user != null) {
                session.setAttribute("user", user);
                response.sendRedirect(request.getContextPath() + "/home");
            } else {

                request.setAttribute("username", username);
                request.setAttribute("password", password);
                request.setAttribute("message", "Invalid username or password");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").
                        forward(request, response);
            }

        } else {
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.setAttribute("message", "Please enter a username and password");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").
                    forward(request, response);
        }

    }

}
