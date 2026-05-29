
package com.example.cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cart")
public class ShoppingCartServlet extends HttpServlet {

    // Product class
    static class Product {

        String name;
        int price;
        int number;

        public Product(String name, int price, int number) {
            this.name = name;
            this.price = price;
            this.number = number;
        }

        public int subtotal() {
            return price * number;
        }
    }

    // Shopping cart list
    private static final List<Product> cart = new ArrayList<>();

    // Add products once
    @Override
    public void init() {

        if (cart.isEmpty()) {

            cart.add(new Product("cola", 3, 10));
            cart.add(new Product("chips", 6, 8));

        }
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        // Delete product
        String deleteIndex = request.getParameter("delete");

        if (deleteIndex != null) {

            int index = Integer.parseInt(deleteIndex);

            if (index >= 0 && index < cart.size()) {
                cart.remove(index);
            }
        }

        response.setContentType("text/html;charset=UTF-8");

        int total = compute(cart);

        PrintWriter out = response.getWriter();

        // HTML Start
        out.println("<!DOCTYPE html>");
        out.println("<html>");

        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Shopping Cart</title>");
        out.println("<link rel='stylesheet' href='css/style.css'>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h1>Shopping Cart</h1>");

        out.println("<table>");

        out.println("<tr>");
        out.println("<th>Product</th>");
        out.println("<th>Price</th>");
        out.println("<th>Quantity</th>");
        out.println("<th>Subtotal</th>");
        out.println("<th>Operation</th>");
        out.println("</tr>");

        // Display products
        for (int i = 0; i < cart.size(); i++) {

            Product p = cart.get(i);

            out.println("<tr>");

            out.println("<td>" + p.name + "</td>");
            out.println("<td>" + p.price + "</td>");
            out.println("<td>" + p.number + "</td>");
            out.println("<td>" + p.subtotal() + "</td>");

            out.println("<td>");
            out.println("<a href='cart?delete=" + i + "'>");
            out.println("<button>Delete</button>");
            out.println("</a>");
            out.println("</td>");

            out.println("</tr>");
        }

        out.println("</table>");

        out.println("<h2>Total amount: " + total + " yuan</h2>");

        out.println("</body>");
        out.println("</html>");
    }

    // Compute total
    private int compute(List<Product> cart) {

        int total = 0;

        for (Product item : cart) {

            total += item.price * item.number;

        }

        return total;
    }
}

