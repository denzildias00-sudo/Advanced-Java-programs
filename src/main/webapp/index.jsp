<%@ page language="java" %>
<html>
<head>
    <title>Session Example</title>
</head>
<body>
    <h2>Enter Your Name</h2>

    <form action="welcome.jsp" method="post">
        Name: <input type="text" name="username" required />
        <br><br>
        <input type="submit" value="Submit" />
    </form>
</body>
</html>