package com.scs;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.net.URLDecoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4421811677060719159L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");

        // ✅ Encode username (FIX)
        String encodedName = URLEncoder.encode(username, "UTF-8");

        int visitCount = 1;

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {

                if (c.getName().equals("visitCount")) {
                    visitCount = Integer.parseInt(c.getValue());
                    visitCount++;
                }

                if (c.getName().equals("username")) {
                    // ✅ Decode username when reading
                    username = URLDecoder.decode(c.getValue(), "UTF-8");
                }
            }
        }

        // Create cookies
        Cookie nameCookie = new Cookie("username", encodedName);
        Cookie countCookie = new Cookie("visitCount", String.valueOf(visitCount));

        // Expiry (30 seconds demo)
        nameCookie.setMaxAge(30);
        countCookie.setMaxAge(30);

        response.addCookie(nameCookie);
        response.addCookie(countCookie);

        // Output
        out.println("<html><body>");
        out.println("<h2>Welcome back " + username + "!</h2>");
        out.println("<p>You have visited this page " + visitCount + " times.</p>");
        out.println("<p><b>Cookie expires in 30 seconds</b></p>");
        out.println("<a href='index.html'>Visit Again</a>");
        out.println("</body></html>");
    }
}