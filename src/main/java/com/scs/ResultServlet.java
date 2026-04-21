package com.scs;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String rollno = request.getParameter("rollno");
        String name = request.getParameter("name");

        String error = "";

        int s1=0,s2=0,s3=0,s4=0,s5=0;

        try {
            s1 = Integer.parseInt(request.getParameter("sub1"));
            s2 = Integer.parseInt(request.getParameter("sub2"));
            s3 = Integer.parseInt(request.getParameter("sub3"));
            s4 = Integer.parseInt(request.getParameter("sub4"));
            s5 = Integer.parseInt(request.getParameter("sub5"));

            if (s1<0 || s1>100 || s2<0 || s2>100 || s3<0 || s3>100 ||
                s4<0 || s4>100 || s5<0 || s5>100) {
                error = "Marks must be between 0 and 100";
            }

        } catch (Exception e) {
            error = "Invalid marks input";
        }

        if (rollno == null || rollno.trim().isEmpty())
            error += "<br>Roll Number required";

        if (name == null || name.trim().isEmpty())
            error += "<br>Name required";

        if (!error.isEmpty()) {
            response.setContentType("text/html");
            response.getWriter().println("<h3>" + error + "</h3>");
            response.getWriter().println("<a href='index.jsp'>Go Back</a>");
            return;
        }

        // Calculate result
        int total = s1 + s2 + s3 + s4 + s5;
        double avg = total / 5.0;

        String result = (s1>40 && s2>40 && s3>40 && s4>40 && s5>40) ? "PASS" : "FAIL";

        // Pass data to JSP
        request.setAttribute("rollno", rollno);
        request.setAttribute("name", name);
        request.setAttribute("s1", s1);
        request.setAttribute("s2", s2);
        request.setAttribute("s3", s3);
        request.setAttribute("s4", s4);
        request.setAttribute("s5", s5);
        request.setAttribute("avg", avg);
        request.setAttribute("result", result);

        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}