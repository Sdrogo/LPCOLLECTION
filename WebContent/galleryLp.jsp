<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="author" content="Andrea Partenope">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>Lp Collection - Lp's Gallery</title>

    <!-- Main css -->

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link href="https://fonts.googleapis.com/css?family=Lora|Merriweather:300,400" rel="stylesheet">

</head>

<body>

    <!-- PRE LOADER -->

    <div class="preloader">
        <div class="sk-spinner sk-spinner-wordpress">
            <span class="sk-inner-circle"></span>
        </div>
    </div>

    <!-- Navigation section  -->

    <div class="navbar navbar-default navbar-static-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <div class="g-signin2" data-onsuccess="onSignIn" id="myP"></div>
                <p id="name"></p>
                <div id="status">
                </div>
                <script type="text/javascript">
                    function onSignIn(googleUser) {
                        var profile = googleUser.getBasicProfile();
                        var name = profile.getName();
                        var email = profile.getEmail();
                        document.getElementById("name").innerHTML = name;
                        document.getElementById("myP").style.visibility = "hidden";
                    }
                </script>
                <button onclick="SignOut()">Sign Out</button>
                <script>
                    function SignOut() {
                        gapi.auth2.getAuthInstance().disconnect();
                        location.reload();
                    }
                </script>
            </div>
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="inserisciLp">Insert LP</a></li>
                    <li><a href="inserisciGruppo">Insert Band</a></li>
                    <li class="active"><a href="galleryLp">Lp's Gallery</a></li>
                    <li><a href="contact.jsp">Contact</a></li>
                </ul>
            </div>
        </div>
    </div>

    <!-- Home Section -->
    <section id="home" class="main-blog parallax-section">
        <div class="overlay"></div>
        <div id="particles-js" style="-moz-user-select: none; -webkit-user-select: none; -ms-user-select:none; user-select:none;-o-user-select:none;"
            unselectable="on" onselectstart="return false;" onmousedown="return false;"></div>
        <div class="col-md-12 col-sm-6" style="-moz-user-select: none; -webkit-user-select: none; -ms-user-select:none; user-select:none;-o-user-select:none;"
            unselectable="on" onselectstart="return false;" onmousedown="return false;">
            <h1>Lp's Gallery</h1>
            <h3>"There's no romance in singing about an iPod"</h3>
            <p></p>
            <h3>Jack White</h3>
        </div>
    </section>

    <!-- Gallery Section -->

    <section id="contact">
        <div class="container">
            <form action="ottieniLpBand">
                <div class="col-md-12 col-sm-12">
                    <div class="row">
                        <img src="${band.getUrl_photo()}" width="500">
                    </div>
                    <div class="row">
                        <div class="col-md-2 col-sm-2"></div>
                        <div class="col-md-8 col-sm-2">
                            <h4>Seleziona un Gruppo :</h4>
                            <select id="id_gruppo" name="id_gruppo" class="form-control">
                                <c:forEach items="${lista_gruppi}" var="band">
                                    <option value="${band.getId()}">${band.getNome()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-md-2 col-sm-2"></div>
                    </div>
                    <div class="row">
                        <div class="col-md-4 col-sm-2"></div>
                        <div class="col-md-4 col-sm-2">
                            <input type="submit" value="Dettagli LP" class="form-control" id="submit">
                        </div>
                        <div class="col-md-4 col-sm-2"></div>
                    </div>
                </div>
            </form>
        </div>

    </section>
    <!-- Footer Section -->

    <footer>
        <div class="container">
            <div class="row">
                <div class="col-md-5 col-md-offset-1 col-sm-6">
                    <h3>Lp Collection</h3>
                    <h5>Progetto per il corso di Web Computing</h5>
                    <h5>Anno Accademico 2018/19</h5>
                </div>
                <div class="col-md-4 col-md-offset-1 col-sm-6">
                    <h3>Developer</h3>
                    <h5>Andrea Partenope</h5>
                    <h5>Matricola : 151807</h5>
                    <h5>
                        <a href="mailto:andreapartenope@gmail.com">andreapartenope@gmail.com</a>
                    </h5>
                </div>
                <div class="clearfix col-md-12 col-sm-12">
                    <hr>
                </div>
            </div>
        </div>
    </footer>

    <!-- Back top -->

    <a href="#back-top" class="go-top"><i class="fa fa-angle-up"></i></a>

    <!-- SCRIPTS -->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/particles.min.js"></script>
    <script src="js/app.js"></script>
    <script src="js/jquery.parallax.js"></script>
    <script src="js/smoothscroll.js"></script>
    <script src="js/custom.js"></script>
    <script src="https://apis.google.com/js/platform.js" async defer></script>
</body>

</html>