package com.example.diary;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet("/view")
public class ViewServlet extends HttpServlet {

 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
         throws IOException {

  resp.setContentType("text/html;charset=UTF-8");

  try {
   String data = DiaryUtil.read(
           getServletContext(),
           req.getParameter("name")
   );

   resp.getWriter().println("<pre>" + data + "</pre>");

  } catch (Exception e) {
   e.printStackTrace();
   resp.getWriter().println("Error: " + e);
  }
 }
}