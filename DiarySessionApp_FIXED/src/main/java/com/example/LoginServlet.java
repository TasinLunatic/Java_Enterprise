
package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username) && "123456".equals(password)) {

            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            response.sendRedirect("diary");

        } else {

            response.setContentType("text/html;charset=UTF-8");

            response.getWriter().println(
                    "<h2>Login Failed!</h2>" +
                    "<a href='login.html'>Back</a>"
            );
        }
    }
}
