package com.example.diary;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {

 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
         throws IOException {

  String name = req.getParameter("name");

  resp.getWriter().println(
          "<form method='post'>" +
                  "<input type='hidden' name='name' value='" + name + "'/>" +
                  "Title:<input name='title'/><br>" +
                  "Content:<textarea name='content'></textarea><br>" +
                  "<button>Update</button></form>"
  );
 }

 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
         throws IOException {

  try {
   DiaryUtil.update(
           getServletContext(),
           req.getParameter("name"),
           req.getParameter("title"),
           req.getParameter("content")
   );
  } catch (Exception e) {
   e.printStackTrace();
  }

  resp.sendRedirect("list");
 }
}