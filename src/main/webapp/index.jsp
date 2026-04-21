<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Student Result Form</title>

    <script>
        function validateForm() {
            let roll = document.forms["form"]["rollno"].value;
            let name = document.forms["form"]["name"].value;
            let marks = ["sub1","sub2","sub3","sub4","sub5"];

            if (roll == "" || isNaN(roll)) {
                alert("Enter valid Roll Number");
                return false;
            }

            if (name == "") {
                alert("Student name required");
                return false;
            }

            for (let i = 0; i < marks.length; i++) {
                let m = document.forms["form"][marks[i]].value;

                if (m == "" || isNaN(m) || m < 0 || m > 100) {
                    alert("Enter valid marks (0-100) for " + marks[i]);
                    return false;
                }
            }
            return true;
        }
    </script>
</head>

<body>
    <h2>Student Result Form</h2>

    <form name="form" action="ResultServlet" method="post" onsubmit="return validateForm()">
        Roll No: <input type="text" name="rollno"><br><br>
        Name: <input type="text" name="name"><br><br>

        Sub1: <input type="text" name="sub1"><br><br>
        Sub2: <input type="text" name="sub2"><br><br>
        Sub3: <input type="text" name="sub3"><br><br>
        Sub4: <input type="text" name="sub4"><br><br>
        Sub5: <input type="text" name="sub5"><br><br>

        <input type="submit" value="Calculate Result">
    </form>
</body>
</html>