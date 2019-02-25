<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="author" content="Andrea Partenope">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>${lp.getTitolo()} by ${gruppo.getNome()}</title>

<!-- Main css -->

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/magnific-popup.css">
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<link
	href="https://fonts.googleapis.com/css?family=Lora|Merriweather:300,400"
	rel="stylesheet">

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
			<div class="navbar-header"></div>
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
		<div id="particles-js"
			style="-moz-user-select: none; -webkit-user-select: none; -ms-user-select: none; user-select: none; -o-user-select: none;"
			unselectable="on" onselectstart="return false;"
			onmousedown="return false;"></div>
		<div class="col-md-12 col-sm-6"
			style="-moz-user-select: none; -webkit-user-select: none; -ms-user-select: none; user-select: none; -o-user-select: none;"
			unselectable="on" onselectstart="return false;"
			onmousedown="return false;">
			<h1>${lp.getTitolo()}</h1>
			<p></p>
			<h2>by ${gruppo.getNome()}</h2>
		</div>
	</section>

	<!-- Gallery Section -->

	<section id="contact">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12">
					<div class="col-md-6 col-sm-12">
						<img src="${cop.getCopertina()}" width="500">
					</div>
					<div class="col-md-6 col-sm-12">
						<h3>Anno : ${lp.getAnno()}</h3>
						<p><hr>
						<h3>Genere : ${lp.getGenere()}</h3>
						<p><hr>
						<form action="#">
							<p>
								<input type="hidden" id="search"
									value="${gruppo.getNome()} ${lp.getTitolo()} full album"
									autocomplete="off" class="form-control" />
							</p>
							<input type="submit" value="Cerca su Youtube"
								class="form-control" id="submit">
						</form>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 col-sm-12">
					<div class="col-md-2 col-sm-12"></div>
					<div class="col-md-8 col-sm-12">
						<div id="results"></div>
					</div>
					<div class="col-md-2 col-sm-12"></div>
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
	<script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
	<script src="js/video.js"></script>
	<script src="https://apis.google.com/js/client.js?onload=init"></script>


</body>
</html>