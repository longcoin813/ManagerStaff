<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <link rel='stylesheet' type='text/css' media='screen'
          href='/static/css/login.css'>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"
          href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
          crossorigin="anonymous">
</head>
<body>
<section>
    <div class="container">
        <div class="card left">
            <div class="face card-front">
                <div class="signin-form">

                    <form action="/signin" method="POST">
                        <em class="pull-right"> <span
                                class="glyphicon glyphicon-warning-sign"></span>
                            ${message}${param.message}
                        </em>
                        <h2>Sign in</h2>

                        <div class="social-container">
                            <a href="javascript:void(0);" class="social" id="fb"><i
                                    class="fab fa-facebook-f"></i></a> <a href="javascript:void(0);"
                                                                          class="social" id="gp"><i
                                class="fab fa-google-plus-g"></i></a>
                            <a href="javascript:void(0);" class="social" id="lin"><i
                                    class="fab fa-linkedin-in"></i></a>
                        </div>

                        <span class="formspan">or use your registered account</span> <input
                            value="${map.username}" name="username" placeholder="Username"/><br>
                        <input value="${map.password}" name="password" type="password"
                               placeholder="Password"/> <label class="checkbox-inline">
                        <input type="checkbox" name="remember" value="true">Remember
                        me?
                    </label> <span class="olspan forgot"><a href="javascript:void(0);">Forgot
									your password?</a></span>
                        <button class="formbtn">Sign in</button>
                    </form>

                </div>
            </div>

            <div class="face card-back">
                <div class="panel">
                    <h2>Welcome back!</h2>
                    <span class="panelspan">To keep connected with us please
							login with your personal info</span>
                    <button class="panelbtn signInBtn">Sign In</button>
                </div>
            </div>

        </div>

        <div class="card right">

            <div class="face card-front">
                <div class="panel">
                    <h2>Hello, Friend!</h2>
                    <span class="panelspan">Enter your personal details and
							start journey with us</span>
                    <button class="panelbtn signUpBtn">Sign Up</button>
                </div>
            </div>

            <div class="face card-back">
                <div class="signup-form">
                    <form:form action="/register" method="post" modelAttribute="userSignUp">
                        <em class="pull-right">
                            <span class="glyphicon glyphicon-warning-sign"></span> ${message}
                        </em>
                        <h2>Create Account</h2>
                        <div class="social-container">
                            <a href="javascript:void(0);" class="social" id="fb"><i
                                    class="fab fa-facebook-f"></i></a> <a href="javascript:void(0);"
                                                                          class="social" id="gp"><i
                                class="fab fa-google-plus-g"></i></a>
                            <a href="javascript:void(0);" class="social" id="lin"><i
                                    class="fab fa-linkedin-in"></i></a>
                        </div>

                        <span class="frmspan">or use your email for registration</span>
                        <form:input type="text" path="fullName" placeholder="Full Name"/> <br>
                        <form:input type="text" path="username" placeholder="Username"/>
                        <br>
                        <form:input type="password" path="password" id="password" placeholder="Password"/>

                        <button class="formbtn" type="submit">Sign up</button>
                    </form:form>
                </div>
            </div>

        </div>

    </div>
</section>

<script src='/static/js/js.js'></script>
</body>
</html>