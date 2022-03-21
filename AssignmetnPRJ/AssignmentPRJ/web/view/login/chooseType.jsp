<%-- 
    Document   : chooseType
    Created on : Mar 1, 2022, 11:03:47 PM
    Author     : chitung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Tỵ Hà Motel</title>
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body id="page-top">
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
            <div class="container px-4">
                <a class="navbar-brand" href="#page-top">Tỵ Hà Motel</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item"><a class="nav-link" href="#about">About</a></li>
                        <li class="nav-item"><a class="nav-link" href="#services">Admin</a></li>
                        <li class="nav-item"><a class="nav-link" href="#contact">Customer</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- Header-->
        <header class="bg-primary bg-gradient text-white">
            <div class="container px-4 text-center">
                <h1 class="fw-bolder">Welcome to Tỵ Hà Motel</h1>
                <p class="lead">Safety, quality assurance, full facilities</p>
                <a class="btn btn-lg btn-light" href="#about">Enjoy!</a>
            </div>
        </header>
        <!-- About section-->
        <section id="about">
            <div class="container px-4">
                <div class="row gx-4 justify-content-center">
                    <div class="col-lg-8">
                        <h2>About this motel</h2>
                        <p class="lead">A hostel that many parents and students trust and send their children and themselves to. We confidently guarantee that:</p>
                        <ul>
                            <li>Manage the inn to ensure the time.</li>
                            <li>Ensure safety for people and attached properties.</li>
                            <li>Provide adequate supplies without having to travel too far.</li>
                            <li>Each room is fully equipped with affordable prices.</li>
                        </ul>
                    </div>
                </div>
            </div>
        </section>
        <!-- Services section-->
        <section class="bg-light" id="services">
            <div class="container px-4">
                <div class="row gx-4 justify-content-center">
                    <div class="col-lg-8">
                        <h2>Managing the payment of the accommodation</h2>
                        <h3>Login for admin</h3>
                        <a href="login" style=" background-color: whitesmoke; /* màu của Quản trị mạng ^^ */
                                           border: solid;
                                           color: black;
                                           padding: 10px 15px;
                                           text-align: center;
                                           text-decoration: none;
                                           display: inline-block;
                                           font-size: 16px;">Sign in - Admin</a>
                    </div>
                </div>
            </div>
        </section>
        <!-- Contact section-->
        <section id="contact">
            <div class="container px-4">
                <div class="row gx-4 justify-content-center">
                    <div class="col-lg-8">
                        <h2>Managing the payment of the accommodation</h2>
                        <h3>Login for customer</h3>
                        <a href="loginCustomer" style=" background-color: whitesmoke; /* màu của Quản trị mạng ^^ */
                                           border: solid;
                                           color: black;
                                           padding: 10px 15px;
                                           text-align: center;
                                           text-decoration: none;
                                           display: inline-block;
                                           font-size: 16px;">Sign in - Customer</a>
                    </div>
                </div>
            </div>
        </section>
        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container px-4"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2021</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>
