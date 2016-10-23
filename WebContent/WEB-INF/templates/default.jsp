<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Voucher Management for AJ-Toours & Travels">
    <meta name="author" content="teamFibonacci">

    <title><tiles:getAsString name="title" /></title>

    <!-- Bootstrap Core CSS -->
   	<link href="${pageContext.request.contextPath}/resources/lib/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
   	<link href="${pageContext.request.contextPath}/resources/lib/metisMenu/metisMenu.min.css" rel="stylesheet">		

    <!-- Theme CSS -->
   	<link href="${pageContext.request.contextPath}/resources/aj_travels/css/theme.min.css" rel="stylesheet">		

    <!-- Custom Fonts -->
	<link href="${pageContext.request.contextPath}/resources/lib/font-awesome-4.6.3/css/font-awesome.min.css" rel="stylesheet">
	
	 <!-- Jquery UI CSS -->
	<link href="${pageContext.request.contextPath}/resources/lib/jquery-ui-1.12.0/jquery-ui.min.css" rel="stylesheet">
	
	 <!-- Datatables CSS -->
	<link href="${pageContext.request.contextPath}/resources/lib/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">
	
	 <!-- Datatables Responsive CSS -->
	<link href="${pageContext.request.contextPath}/resources/lib/datatables-responsive/dataTables.responsive.css" rel="stylesheet">
	
	<!-- Theme CSS -->
   	<link href="${pageContext.request.contextPath}/resources/aj_travels/css/custome.css" rel="stylesheet">		
	
</head>

<body>

	<div id="wrapper">
		<tiles:insertAttribute name="headerAndSidebar" />
		<tiles:insertAttribute name="content" />
	</div>	
	
	<!-- jQuery -->
	<script src="${pageContext.request.contextPath}/resources/common/js/jquery-3.1.0.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
	<script src="${pageContext.request.contextPath}/resources/lib/bootstrap-3.3.7/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
   	<script src="${pageContext.request.contextPath}/resources/lib/metisMenu/metisMenu.min.js"></script>
   	
   	<!-- Custom Theme JavaScript -->
   	<script src="${pageContext.request.contextPath}/resources/aj_travels/js/theme.min.js"></script>
   	
   	<!-- Jquery UI -->
	<script src="${pageContext.request.contextPath}/resources/lib/jquery-ui-1.12.0/jquery-ui.min.js"></script>
		
	<!-- Jquery Datatables -->
	<script src="${pageContext.request.contextPath}/resources/lib/datatables/js/jquery.dataTables.min.js"></script>
	
	<!-- Datatables Bootstrap-->
	<script src="${pageContext.request.contextPath}/resources/lib/datatables-plugins/dataTables.bootstrap.min.js"></script>
	
	<!-- Datatables Responsive-->
	<script src="${pageContext.request.contextPath}/resources/lib/datatables-responsive/dataTables.responsive.js"></script>
	
   	<!-- Custom JavaScript -->
   	<script src="${pageContext.request.contextPath}/resources/aj_travels/js/custome.js"></script>
	
</body>

</html>