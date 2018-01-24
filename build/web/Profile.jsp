<%@page import="com.test.beans.UserWeb"%>
<%@page import="com.test.beans.Country"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.test.daoimplemenatation.DaoImplementation"%>
<!DOCTYPE html>
<html 
    <head>
        <meta charset="UTF-8">
        <title>May Login Form </title>

        <link rel="stylesheet" href="css/reset.css">
        <link rel='stylesheet prefetch' href='css/css.css'>
        <link rel='stylesheet prefetch' href='css/font-awesome.min.css'>
        <link rel="stylesheet" href="css/style.css">

    </head>
    <body>


        <!-- Form Mixin-->
        <!-- Input Mixin-->
        <!-- Button Mixin-->
        <!-- Pen Title-->
        <div class="pen-title">
            <h1>May Login Form</h1>
        </div>
        <!-- Form Module-->
        <div class="module form-module">
            <div class="toggle"><i class="fa fa-times fa-pencil"></i>

            </div>
            <div class="form">
                <h2>Your Profile</h2>
                <form>
                    <% UserWeb uw = (UserWeb) request.getSession().getAttribute("userlog"); %>
                    <h5>First Name:</h5>
                    <input type="text"  placeholder="<%=uw.getFirstName()%> "  readonly/>
                    <h5>Last Name:</h5>
                    <input type="text"  placeholder="<%=uw.getLastName()%>" readonly/>
                    <h5>User Name:</h5>
                    <input type="text" placeholder="<%=uw.getUserName()%>" readonly/>
                    <h5>Email:</h5>
                    <input type="text"  placeholder="<%=uw.getEmail()%>" readonly/>
                    <h5>Country:</h5>
                    <input type="text"  placeholder="<%=uw.getCountry()%>" readonly/>
                    <h5>Phone Number:</h5>
                    <input type="text"  placeholder="<%=uw.getPhoneNumber()%>" readonly/>
                     <button><a href="UserLogOut">Log Out</a></button>
                </form>
            </div>

        </div>
        <script src='js/jquery.min.js'></script>
        <script src="js/index.js"></script>

    </body>
</html>
