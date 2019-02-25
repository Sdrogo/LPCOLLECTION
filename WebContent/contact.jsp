<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">

<head>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="author" content="Andrea Partenope">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="google-signin-client_id" content="653205003158-1d4cr7foromdit776hca3kfardigrq3i.apps.googleusercontent.com">

    <title>Lp Collection - Contact</title>

    <!-- Main css -->
    <link href="https://fonts.googleapis.com/css?family=Lora|Merriweather:300,400" rel="stylesheet">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/style.css">

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
                <div id="status">
                    <p id="name"></p>
                    <button id="sign_out" onclick="SignOut()">Sign Out</button>
                </div>
            </div>
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="inserisciLp">Insert LP</a></li>
                    <li><a href="inserisciGruppo">Insert Band</a></li>
                    <li><a href="galleryLp">Lp's Gallery</a></li>
                    <li class="active"><a href="contact.jsp">Contact</a></li>
                </ul>
            </div>
        </div>
    </div>

    <!-- Home Section -->

    <section id="home" class="main-contact parallax-section">
        <div class="overlay"></div>
        <div id="particles-js" style="-moz-user-select: none; -webkit-user-select: none; -ms-user-select:none; user-select:none;-o-user-select:none;"
            unselectable="on" onselectstart="return false;" onmousedown="return false;"></div>
        <div class="col-md-12 col-sm-6" style="-moz-user-select: none; -webkit-user-select: none; -ms-user-select:none; user-select:none;-o-user-select:none;"
            unselectable="on" onselectstart="return false;" onmousedown="return false;">
            <h1>Contact Us</h1>
            <h3>"The album's not dead for me; I still buy vinyl albums."</h3>
            <p>
                <h3>Jimi Page</h3>
            </p>
        </div>
    </section>

    <!-- Contact Section -->

    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-md-offset-1 col-md-10 col-sm-12">
                    <h2>Sand us your feedback</h2>
                    <form name="tell" id="tell" method="post" action="send_mail.php" autocomplete="on">
                        <div class="col-md-4 col-sm-4">
                            <input type="text" name="nome_mittente" class="form-control" id="nome_mittente" placeholder="Nome"
                                value="">
                        </div>
                        <div class="col-md-4 col-sm-4">
                            <input type="email" name="mail_mittente" class="form-control" id="email_mittente"
                                placeholder="Email" value="">
                        </div>
                        <div class="col-md-4 col-sm-4">
                            <input type="text" name="subject" class="form-control" id="subject" placeholder="Subject">
                        </div>
                        <div class="col-md-12 col-sm-12">
                            <textarea name="messaggio" rows="10" cols="30" class="form-control" id="message"
                                placeholder="Message"></textarea>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <input type="submit" value="Submit" class="form-control" id="submit">
                        </div>
                    </form>
                </div>
            </div>
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
                    <h5> Andrea Partenope</h5>
                    <h5> Matricola : 151807</h5>
                    <h5> <a href="mailto:andreapartenope@gmail.com">andreapartenope@gmail.com</a></h5>
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

    <script type="text/javascript">
        function onSignIn(googleUser) {
            var profile = googleUser.getBasicProfile();
            var name = profile.getName();
            var email = profile.getEmail();
            document.getElementById("name").innerHTML = name;
            document.getElementById("myP").style.visibility = "hidden";
            document.getElementById("nome_mittente").setAttribute("value", name);
            document.getElementById("email_mittente").setAttribute("value", email);
            document.getElementById("nome_mittente").setAttribute("readonly", true);
            document.getElementById("email_mittente").setAttribute("readonly", true);

        }
    </script>

    <script>
        function SignOut() {
            gapi.auth2.getAuthInstance().disconnect();
            location.reload();
        }
    </script>

</body>

</html>