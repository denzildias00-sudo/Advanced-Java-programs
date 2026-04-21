package com.scs;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/prime")
public class PrimeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int num = Integer.parseInt(request.getParameter("num"));
        boolean isPrime = true;
        StringBuilder steps = new StringBuilder();

        if (num <= 1) {
            isPrime = false;
            steps.append(num + " is not prime (<=1)<br>");
        } else {
            for (int i = 2; i <= num / 2; i++) {
                steps.append(num + " ÷ " + i + " = " + (double)num / i + "<br>");
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        // HTML Output (Styled like your image)
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Prime Result</title>");
        out.println("<style>");
        out.println("body { font-family: Arial; background:#f5f5f5; }");
        out.println(".box { width:500px; margin:50px auto; padding:20px; border:2px solid gold; border-radius:10px; background:#eee; }");
        out.println("h1 { font-size:28px; }");
        out.println("a { color:purple; font-size:18px; }");
        out.println("</style>");
        out.println("</head>");

        out.println("<body>");
        out.println("<div class='box'>");

        out.println("<h1>Prime Number Result</h1>");

        out.println("<p><b>Number:</b> " + num + "</p>");

        if (isPrime) {
            out.println("<p><b>Result:</b> Prime Number</p>");
        } else {
            out.println("<p><b>Result:</b> Not a Prime Number</p>");
        }

        out.println("<p><b>Checking divisibility:</b><br>");
        out.println(steps.toString());
        out.println("</p>");

        out.println("<a href='index.html'>Check Another Number</a>");

        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}