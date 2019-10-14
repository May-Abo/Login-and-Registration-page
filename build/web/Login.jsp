<%@page import="com.test.beans.Country"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.test.daoimplemenatation.DaoImplementation"%>
<!DOCTYPE html>
<html >
    <script src="js/MyMessage.js"></script>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>May Login Form </title>


        <link rel="stylesheet" href="css/reset.css">
        <link rel='stylesheet prefetch' href='css/css.css'>
        <link rel='stylesheet prefetch' href='css/font-awesome.min.css'>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/jquery1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>




    </head>

    <%

        String message = request.getParameter("errorMsg");
        int myMessage = 0;
        if (message != null && message.length() > 0) {

            myMessage = Integer.parseInt(message);

        } else {
            myMessage = 0;
        }

    %>

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
                <div class="tooltip">Click Me</div>
            </div>

            <div class="form">
                <div id="mymsg"></div>
                <h2>Login to your account</h2>

                <form action="UserServlet" method="post">
                    <input type="text" name="username1" id="username1" placeholder="Username" autofocus/>
                    <input type="password" name="password1" id="password1" placeholder="Password" />
                    <button>Login</button>
                </form>
            </div>
            <div class="form">
                <h2>Create an account</h2>
                <form action="UserController" name="regforms"   method="post">
                    <input type="text" name="fname" id="fname" placeholder="First Name "/>
                    <input type="text" name="lname" id="lname" placeholder="Last Name "/>
                    <input type="text" name="username" id="username" placeholder="User Name "/>
                    <input type="text" name="email" id="email" placeholder="Email"/>
                    <h4>Choose your Country</h4>
                    <select name="country" id="country" placeholder="Country" onchange="countrySelection()">
                        <%  DaoImplementation daoI = new DaoImplementation();
                            ArrayList al = daoI.getAllCountryNames();
                            for (int i = 0; i < al.size(); i++) {%>
                        <option value="<%=((Country) al.get(i)).getCountry()%>"><%=((Country) al.get(i)).getCountry()%></option>                          
                        <%}%>
                    </select>
                    <input type="text" name="phoneNumber" id="phoneNumber" placeholder="Phone Number" disabled="disabled"/>
                    <input type="password" name="password" id="password" placeholder="Password"/>
                    <input type="password" name="repassword" id="repassword" placeholder="Re-Password"/> 
                    <button type="button" onclick="validateUserRegistration()">Register</button>
                </form>
            </div>
            <div class="cta"><a href="#">Forgot your password?</a></div>
        </div>
        <script src="js/ValidateRegistration.js"></script>
        <script src='js/jquery.min.js'></script>
        <script src="js/index.js"></script>


        <script>
            if('<%=myMessage%>' !=0)
            {
                if('<%=myMessage%>'==1)
                {
                    getMessage('Invalid username/password Try again') 
                }
                if('<%=myMessage%>'==2){
                    getMessage('Session time out ') 
                }
                if('<%=myMessage%>'==3){
                    getMessage('You are logged out ') 
                }
                if('<%=myMessage%>'==3){
                    getMessage('You are logged out ') 
                }
                if('<%=myMessage%>'==4){
                    getMessage('User Name or Email already taken ') 
                }
            }    
        </script>


    </body>
</html>
