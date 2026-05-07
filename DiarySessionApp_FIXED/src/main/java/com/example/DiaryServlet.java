
package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/diary")
public class DiaryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);

        String username = null;

        if (session != null) {
            username = (String) session.getAttribute("username");
        }

        out.println("<html>");
        out.println("<body>");

        out.println("<h2>Diary List</h2>");

        if (username != null) {

            out.println("<p>Welcome: " + username + "</p>");
            out.println("<a href='logout'>Logout</a><br><br>");

        } else {

            out.println("<p>User not logged in.</p>");
            out.println("<a href='login.html'>Login</a><br><br>");
        }

        out.println("<ul>");

        out.println("<li>Diary Record 1");

        if (username != null) {
            out.println(" <button>Delete</button>");
        }

        out.println("</li>");

        out.println("<li>Diary Record 2");

        if (username != null) {
            out.println(" <button>Delete</button>");
        }

        out.println("</li>");

        out.println("</ul>");

        out.println("</body>");
        out.println("</html>");
    }
}
