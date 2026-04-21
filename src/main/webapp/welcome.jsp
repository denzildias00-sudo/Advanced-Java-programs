<%@ page language="java" %>
<%
    // Set session timeout to 1 minute (60 seconds)
    session.setMaxInactiveInterval(60);

    String name = request.getParameter("username");

    if (name != null && !name.equals("")) {
        // Store name in session
        session.setAttribute("user", name);
    }

    String user = (String) session.getAttribute("user");
%>

<html>
<head>
    <title>Welcome Page</title>
</head>
<body>

<%
    if (user != null) {
%>
        <h2>Hello, <%= user %>!</h2>
        <p>Your session is active.</p>
        <p><i>Session will expire after 1 minute of inactivity.</i></p>

        <a href="welcome.jsp">Refresh</a>

<%
    } else {
%>
        <h2>Session Expired!</h2>
        <p>Your session has expired after 1 minute.</p>
        <a href="index.jsp">Go Back</a>
<%
    }
%>

</body>
</html>