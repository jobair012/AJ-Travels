<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>

<html>
<head>
 <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>AJ-Tours &amp; Travels</title>

    <!-- Bootstrap -->	
   	<link href="${pageContext.request.contextPath}/resources/lib/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/aj_travels/css/landing.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/lib/font-awesome-4.6.3/css/font-awesome.min.css" rel="stylesheet">
	<%-- <link href="${pageContext.request.contextPath}/resources/common/css/landing-loading-bar.css" rel="stylesheet" /> --%>
  </head>
  <body>
	<div class="container" id="container">
		<header>
			<!-- Main comapny header -->
			<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
			  <div class="container">
				<div class="navbar-header">
				  <a class="navbar-brand top-navbar-brand" href="#">AJ-Tours &amp; Travels</a>
				</div>
				<ul class="nav navbar-nav navbar-right bigger-130 hidden-xs">
					<li><a href="#"><i class="fa fa-google"></i></a></li>
					<li><a href="#"><i class="fa fa-facebook"></i></a></li>
					<li><a href="#"><i class="fa fa-twitter"></i></a></li>
				</ul>
			  </div>
			</nav>
		</header>
		<section id="form" class="animated fadeInDown">
			<div class="container">    
				<div id="loginbox" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">                    
					<div class="panel white-alpha-90" >
						<div class="panel-heading">
							<div class="panel-title text-center"><h2>Sign In to <span class="text-primary">AJ-Travels</span></h2></div>
						</div>     
						<div class="panel-body" >
							<div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
								<form id="loginform" class="form-horizontal" action="${pageContext.request.contextPath}/login" method="post" role="form" >
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user"></i></span>
									<input id="login-username" type="text" class="form-control" name="username" value="" placeholder="Username">                                        
								</div>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock"></i></span>
									<input id="login-password" type="password" class="form-control" name="password" placeholder="Password">
								</div>
								<div class="alert-danger" style="text-align: center;">
									<c:if test="${param.error != null}">
										<c:out value="Incorrect Username or Password Provided" />										
									</c:if>									
								</div>
								<br />
								<div class="input-group col-xs-12 text-center login-action">
								  <div class="checkbox">
									<label>
									  <input id="login-remember" type="checkbox" name="remember" style="margin-top: 10px;"> Remember me &nbsp;
									  <!-- <span id="btn-login"><a href="#" class="btn btn-success">Login  </a></span> -->
									  <input type="submit" id="btn-login" class="btn btn-success" value="Login"/>
									</label>
								  </div>
								</div>
								<div style="margin-top:10px" class="form-group">
									<div class="col-sm-12 controls">
									  
									</div>
								</div>
							</form>     
						</div>                     
					</div>  
				</div>
			</div>
		</section>
		<footer>
			<nav class="navbar navbar-default navbar-fixed-bottom" role="navigation">
			  <div class="container text-center">
				<div class="footer-content">
				  &copy; All rights reserved by teamFibonacci
				</div>
			  </div><!-- /.container-fluid -->
			</nav>
		</footer>
	</div>

	<script src="${pageContext.request.contextPath}/resources/common/js/pace.js"></script>
	<script src="${pageContext.request.contextPath}/resources/common/js/jquery-3.1.0.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/lib/bootstrap-3.3.7/js/bootstrap.min.js"></script>

	<script src="${pageContext.request.contextPath}/resources/aj_travels/js/ajSecurity.js"></script>
	<!-- <script>
		Pace.on('hide', function(){
		   $("#container").fadeIn('1000');
		});
		
	</script> -->
  </body>
</html>