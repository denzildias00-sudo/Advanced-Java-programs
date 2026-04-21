<%@ page import="java.util.*" %>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>

<%
    String name = request.getParameter("username");

    if (name != null && !name.trim().equals("")) {
        // Create session
        session.setAttribute("username", name);

        // Set session expiry time = 1 minute (60 seconds)
        session.setMaxInactiveInterval(60);
%>

        <h2>Hello <%= name %>!</h2>

        <p>Session is set for <b>1 minute</b>.</p>

        <a href="check.jsp">Click here to check session</a>

<%
    } else {
%>
        <h3>Invalid Name!</h3>
        <a href="index.jsp">Go Back</a>
<%
    }
%>

</body>
</html>