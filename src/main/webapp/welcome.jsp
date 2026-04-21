<%@ page language="java" session="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
</head>
<body>

<%
    String name = request.getParameter("username");

    if (name != null) {
        session.setAttribute("user", name);
        session.setMaxInactiveInterval(60); // 1 minute
    }

    String user = (String) session.getAttribute("user");
%>

<% if (user != null) { %>

    <h1>Hello <%= user %>!</h1>
    <p>Session valid for 1 minute.</p>

    <a href="check.jsp">Check Session</a>

<% } else { %>

    <h2 style="color:red;">Session Expired!</h2>
    <a href="index.jsp">Go Back</a>

<% } %>

</body>
</html>