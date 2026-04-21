package com.scs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Create or get existing session
        HttpSession session = request.getSession(true);

        // Set session timeout to 1 minute (60 seconds)
        session.setMaxInactiveInterval(60);

        // Visit count handling
        Integer count = (Integer) session.getAttribute("visitCount");

        if (count == null) {
            count = 1;
        } else {
            count++;
        }

        session.setAttribute("visitCount", count);

        // Get session details
        String sessionId = session.getId();
        Date creationTime = new Date(session.getCreationTime());
        Date lastAccessTime = new Date(session.getLastAccessedTime());

        // Display output
        out.println("<html><body>");
        out.println("<h2>Session Tracking Information</h2>");

        out.println("<p><b>Session ID:</b> " + sessionId + "</p>");
        out.println("<p><b>Creation Time:</b> " + creationTime + "</p>");
        out.println("<p><b>Last Access Time:</b> " + lastAccessTime + "</p>");
        out.println("<p><b>Visit Count:</b> " + count + "</p>");

        out.println("<p><b>Session Timeout:</b> 1 Minute</p>");

        out.println("<br><a href='SessionServlet'>Refresh</a>");

        out.println("</body></html>");
    }
}