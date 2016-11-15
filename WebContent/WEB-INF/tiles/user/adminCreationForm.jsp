<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div id="page-wrapper">
	<!-- <div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Administration</h1>
		</div>
	</div> -->
	<br />
	<div class="row">
		<div class="pull-left">
			<!-- <div class="btn-group"> -->
				<!-- <a href="#" class="btn btn-info"><span class="glyphicon glyphicon-search"></span> Search</a>  -->
				<a href="${pageContext.request.contextPath}/admin/search" class="btn btn-info"><span class="glyphicon glyphicon-search"></span> Search</a> 
				<a href="${pageContext.request.contextPath}/admin/create" class="btn btn-info"><span class="glyphicon glyphicon-plus"></span> Add New</a>
			<!-- </div> -->
		</div>
	</div>
	
	<br />

	<form:form class="form-horizontal" action="${pageContext.request.contextPath}/admin/doCreateOrUpdate" method="POST" commandName="user">
		<fieldset>
		
		<!-- Form Name -->
		<legend>User Information</legend>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-2 control-label" for="name">Name *</label>  
		  <div class="col-md-6">
		  	<form:input id="name" name="name" placeholder="Name" class="form-control input-md" type="text"  path="userDetail.name" />
		    <form:errors path="userDetail.name" cssClass="alert-danger"></form:errors>
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-2 control-label" for="email">Email *</label>
		  <div class="col-md-6">
		  	<form:input id="email" name="email" placeholder="Email" class="form-control input-md" type="email"  path="userDetail.email"/>
		    <form:errors path="userDetail.email" cssClass="alert-danger"></form:errors>
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-2 control-label" for="phoneNo">Contact No. *</label>
		  <div class="col-md-6">
		  	<form:input id="phoneNo" name="phoneNo" placeholder="Contact No." class="form-control input-md" type="tel"  path="userDetail.phoneNo"/>
		    <form:errors path="userDetail.phoneNo" cssClass="alert-danger"></form:errors>
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-2 control-label" for="username">Username *</label>
		  <div class="col-md-6">
		  	<form:input id="username" name="username" placeholder="Username" class="form-control input-md" type="text"  path="username" onchange="javascript:checkDuplicateUsername();"/>
		   	<form:errors path="username" cssClass="alert-danger"></form:errors>
		   	<div id="userExists"></div>		   
		  </div>
		  
		</div>
		
		<!-- Password Field-->
		<div class="form-group">
		  <label class="col-md-2 control-label" for="password">Password *</label>  
		  <div class="col-md-6">
		  	<form:input id="password" name="password" placeholder="Password" class="form-control input-md" type="password"  path="password" />
		    <form:errors path="password" cssClass="alert-danger"></form:errors>
		  </div>
		</div>
		
		<!-- Confirm Password Field-->
		<div class="form-group">
		  <label class="col-md-2 control-label" for="confirmPassword">Confirm Password *</label>  
		  <div class="col-md-6">
		  	<form:input id="confirmPassword" name="confirmPassword" placeholder="Confirm Pasword" class="form-control input-md" type="password"  path="" onkeyup="javascript:checkPasswordMatch();" onchange="javascript:checkPasswordMatch2();"/>
		  	<div id="passwordMismatch">																										
		  </div>
		  </div>
		</div>				
		
		<!-- Select Basic -->
		<div class="form-group">
		  <label class="col-md-2 control-label" for="selectbasic">Role *</label>
		  <div class="col-md-6">
		  	<form:select id="role" name="role" class="form-control"  path="userRole.role">
		  		<form:option value="">Select Role</form:option>
		  		<c:forEach items="${userRole}" var="role">		  		
		      		<form:option value="${role.value}">${role.label}</form:option>    		    
		  		</c:forEach>
		  	</form:select>	
		  	<form:errors path="userRole.role" cssClass="alert-danger"></form:errors>	   
		  </div>
		</div>
		
		<!-- Multiple Radios (inline) -->
		<div class="form-group">
		  <label class="col-md-2 control-label" for="status">Status *</label>
		  <div class="col-md-4"> 
		    <label class="radio-inline" for="status-0">
		      <form:radiobutton name="enabled" path="enabled" value="true" />Activate
		    </label> 
		    <label class="radio-inline" for="status-1">
		      <form:radiobutton name="enabled" path="enabled" value="false" />Dectivate
		    </label>
		  </div>
		  <form:errors path="enabled" cssClass="alert-danger"></form:errors>
		</div>	
		
		<!-- Button -->
		<div class="form-group">
		  <label class="col-md-2 control-label" for="create"></label>
		  <div class="col-md-4">		  
			<c:choose>
				<c:when test="${param.username ne null}" >
			  		<button id="update" name="action" value="update" class="btn btn-primary">Update</button>
				</c:when>
				<c:otherwise>
					<button id="create" name="action" value="create" class="btn btn-primary">Create</button>
				</c:otherwise>
		  	</c:choose>		  	
		  </div>
		</div>		
		</fieldset>
	</form:form>

</div>