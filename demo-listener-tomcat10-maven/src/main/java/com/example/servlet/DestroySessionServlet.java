package com.example.servlet;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/destroySession")
public class DestroySessionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession(false);
        if(session != null){
            session.invalidate();
            resp.getWriter().println("Session destroyed");
        } else {
            resp.getWriter().println("No session");
        }
    }
}
