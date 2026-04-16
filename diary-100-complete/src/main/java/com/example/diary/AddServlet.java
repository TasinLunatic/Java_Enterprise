package com.example.diary;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet("/add")
public class AddServlet extends HttpServlet {

 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
         throws IOException {

  try {
   DiaryUtil.save(
           getServletContext(),
           req.getParameter("title"),
           req.getParameter("content"),
           req.getRemoteAddr()
   );
  } catch (Exception e) {
   e.printStackTrace();
  }

  resp.sendRedirect("list");
 }
}
