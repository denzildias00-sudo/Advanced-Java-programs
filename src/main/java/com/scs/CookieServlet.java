package com.scs;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");

        int visitCount = 1;

        // Get existing cookies
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("visitCount")) {
                    visitCount = Integer.parseInt(c.getValue());
                    visitCount++;
                }
            }
        }

        // Create cookies
        Cookie nameCookie = new Cookie("username", username);
        Cookie countCookie = new Cookie("visitCount", String.valueOf(visitCount));

        // Set expiry time (30 seconds for demo)
        nameCookie.setMaxAge(30);
        countCookie.setMaxAge(30);

        response.addCookie(nameCookie);
        response.addCookie(countCookie);

        // Display output
        out.println("<html><body>");
        out.println("<h2>Welcome back " + username + "!</h2>");
        out.println("<p>You have visited this page <b>" + visitCount + "</b> times.</p>");

        // Display all cookies
        out.println("<h3>List of Cookies:</h3>");
        if (cookies != null) {
            for (Cookie c : cookies) {
                out.println("Name: " + c.getName() + " | Value: " + c.getValue() + "<br>");
            }
        }

        out.println("<br><p><b>Note:</b> Cookies expire in 30 seconds. Refresh after 30s to see reset.</p>");
        out.println("</body></html>");
    }
}