<%@ page import="javax.servlet.http.Cookie" %>
<%
    String name = request.getParameter("name");
    String domain = request.getParameter("domain");
    int maxAge = Integer.parseInt(request.getParameter("maxAge"));

    Cookie cookie = new Cookie(name, domain);

    cookie.setMaxAge(maxAge);
    cookie.setDomain(domain);

    response.addCookie(cookie);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Cookie Set</title>
</head>
<body>

<h2>Cookie Added Successfully!</h2>

<p><b>Name:</b> <%= name %></p>
<p><b>Domain:</b> <%= domain %></p>
<p><b>Max Age:</b> <%= maxAge %> seconds</p>

<br>
<a href="showCookies.jsp">Go to Active Cookie List</a>

</body>
</html>