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

        Cookie[] cookies = request.getCookies();

        // Read existing cookies
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("visitCount")) {
                    visitCount = Integer.parseInt(c.getValue());
                    visitCount++;
                }
                if (c.getName().equals("username")) {
                    username = c.getValue(); // retain old name
                }
            }
        }

        // Create/update cookies
        Cookie nameCookie = new Cookie("username", username);
        Cookie countCookie = new Cookie("visitCount", String.valueOf(visitCount));

        // Set expiry (20 seconds for demo)
        nameCookie.setMaxAge(20);
        countCookie.setMaxAge(20);

        response.addCookie(nameCookie);
        response.addCookie(countCookie);

        // Output
        out.println("<html><body>");
        out.println("<h2>Welcome back " + username + "!</h2>");
        out.println("<p>You have visited this page <b>" + visitCount + "</b> times.</p>");

        // Display all cookies with set values
        out.println("<h3>Cookie Details (Name & Value):</h3>");

        if (cookies != null) {
            for (Cookie c : cookies) {
                out.println("<p>Cookie Name: <b>" + c.getName() + "</b><br>");
                out.println("Value: <b>" + c.getValue() + "</b></p>");
            }
        } else {
            out.println("<p>No cookies found</p>");
        }

        out.println("<br><p><b>Note:</b> Cookies expire in 20 seconds. "
                + "Wait and refresh to see visit count reset.</p>");

        out.println("</body></html>");
    }
}