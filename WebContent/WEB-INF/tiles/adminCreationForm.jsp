<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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

	<form class="form-horizontal" action="${pageContext.request.contextPath}/admin/doCreateOrUpdate" method="post">
		<fieldset>
		
		<!-- Form Name -->
		<legend>Create Admin</legend>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-2 control-label" for="name">Name</label>  
		  <div class="col-md-6">
		  <input id="name" name="name" placeholder="Name" class="form-control input-md" type="text">
		    
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-2 control-label" for="email">Email</label>
		  <div class="col-md-6">
		  <input id="email" name="email" placeholder="Email" class="form-control input-md" type="email">
		    
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-2 control-label" for="phoneNo">Contact No.</label>
		  <div class="col-md-6">
		  <input id="phoneNo" name="phoneNo" placeholder="Contact No." class="form-control input-md" type="text">
		    
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-2 control-label" for="username">Username</label>
		  <div class="col-md-6">
		  <input id="username" name="username" placeholder="Username" class="form-control input-md" type="text">
		    
		  </div>
		</div>
		
		<!-- Password Field-->
		<div class="form-group">
		  <label class="col-md-2 control-label" for="password">Password</label>  
		  <div class="col-md-6">
		  <input id="password" name="password" placeholder="Password" class="form-control input-md" type="password">
		    
		  </div>
		</div>
		
		<!-- Confirm Password Field-->
		<div class="form-group">
		  <label class="col-md-2 control-label" for="confirmPassword">Confirm Password</label>  
		  <div class="col-md-6">
		  <input id="confirmPassword" name="confirmPassword" placeholder="Confirm Pasword" class="form-control input-md" type="password">
		    
		  </div>
		</div>
		
		<!-- Select Basic -->
		<div class="form-group">
		  <label class="col-md-2 control-label" for="selectbasic">Role</label>
		  <div class="col-md-4">
		    <select id="role" name="role" class="form-control">
		      <option value="ROLE_USER">User</option>
		      <option value="ROLE_ADMIN">Admin</option>      
		    </select>
		  </div>
		</div>
		
		<!-- Multiple Radios (inline) -->
		<div class="form-group">
		  <label class="col-md-2 control-label" for="status">Status</label>
		  <div class="col-md-4"> 
		    <label class="radio-inline" for="status-0">
		      <input name="status" id="status-0" value="active" checked="checked" type="radio">
		      activate
		    </label> 
		    <label class="radio-inline" for="status-1">
		      <input name="status" id="status-1" value="deactivate" type="radio">
		      deactivate
		    </label>
		  </div>
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
	</form>

</div>