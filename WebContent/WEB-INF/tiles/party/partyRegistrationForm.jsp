<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div id="page-wrapper">

	<br />
	<div class="row">
		<div class="pull-left">
			<a href="${pageContext.request.contextPath}/party/search" class="btn btn-info"><span class="glyphicon glyphicon-search"></span> Search</a> 
			<a href="${pageContext.request.contextPath}/party/create" class="btn btn-info"><span class="glyphicon glyphicon-plus"></span> Add New</a>
		</div>
	</div>
	
	<br />

	<form:form class="form-horizontal" action="${pageContext.request.contextPath}/party/doCreateOrUpdate" method="POST" commandName="party">
		<fieldset>
		
		<!-- Form Name -->
		<legend>User Information</legend>
		
		<!-- Select Basic -->
		<div class="form-group">
		  <label class="col-md-2 control-label" for="selectbasic">Party Type *</label>
		  <div class="col-md-6">
		  	<form:select id="partyType" name="partyType" class="form-control"  path="partyType.partyTypeId">
		  		<form:option value="">Select Role</form:option>
		  		<c:forEach items="${partyType}" var="type">		  		
		      		<form:option value="${type.value}">${type.label}</form:option>    		    
		  		</c:forEach>
		  	</form:select>	
		  	<form:errors path="partyType.partyTypeId" cssClass="alert-danger"></form:errors>	   
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-2 control-label" for="partyName">Name *</label>  
		  <div class="col-md-6">
		  	<form:input id="partyName" name="partyName" placeholder="Name" class="form-control input-md" type="text"  path="partyName" />
		    <form:errors path="partyName" cssClass="alert-danger"></form:errors>
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-2 control-label" for="phoneNo">Phone No.</label>  
		  <div class="col-md-6">
		  	<form:input id="phoneNo" name="phoneNo" placeholder="Phone Number" class="form-control input-md" type="text"  path="contact.phoneNo" />
		    <form:errors path="contact.phoneNo" cssClass="alert-danger"></form:errors>
		  </div>
		</div>		
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-2 control-label" for="country">Country</label>  
		  <div class="col-md-6">
		  	<form:input id="countryId" name="countryId" type="hidden"  path="contact.country.countryId" />
		  	<form:input id="country" name="country" placeholder="Country" class="form-control input-md" type="text"  path="contact.country.countryName" onkeypress="javascript:getAllCountry();" />
		    <form:errors path="contact.country.countryName" cssClass="alert-danger"></form:errors>
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-2 control-label" for="state">State Or Division</label>  
		  <div class="col-md-6">
		  	<form:input id="stateId" name="stateId" type="hidden"  path="contact.state.stateId" />
		  	<form:input id="state" name="state" placeholder="State Or Division" class="form-control input-md" type="text"  path="contact.state.stateName" onkeypress="javascript:getAllStateByCountryId();" />
		    <form:errors path="contact.state.stateName" cssClass="alert-danger"></form:errors>
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-2 control-label" for="city">City</label>  
		  <div class="col-md-6">
		  	<form:input id="cityId" name="cityId" type="hidden"  path="contact.city.cityId" />
		  	<form:input id="city" name="city" placeholder="City" class="form-control input-md" type="text"  path="contact.city.cityName" onkeypress="javascript:getAllCityByStateId();" />
		    <form:errors path="contact.city.cityName" cssClass="alert-danger"></form:errors>
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-2 control-label" for="area">Area</label>  
		  <div class="col-md-6">
		  	<form:input id="areaId" name="areaId" type="hidden"  path="contact.area.areaId" />
		  	<form:input id="area" name="area" placeholder="Area" class="form-control input-md" type="text"  path="contact.area.areaName" onkeypress="javascript:getAllAreaByCityId();" />
		    <form:errors path="contact.area.areaName" cssClass="alert-danger"></form:errors>
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-2 control-label" for="postralCode">Postral Code</label>  
		  <div class="col-md-6">
		  	<form:input id="postralCode" name="postralCode" placeholder="Postral Code" class="form-control input-md" type="text"  path="contact.postralCode" />
		    <form:errors path="contact.postralCode" cssClass="alert-danger"></form:errors>
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-2 control-label" for="address">Full Address</label>  
		  <div class="col-md-6">
		  	<form:textarea id="address" name="address" placeholder="Full Address" class="form-control input-md" path="contact.address"></form:textarea>
		    <form:errors path="contact.address" cssClass="alert-danger"></form:errors>
		  </div>
		</div>
		
		<!-- Button -->
		<div class="form-group">
		  <label class="col-md-2 control-label" for="create"></label>
		  <div class="col-md-4">		  
			<c:choose>
				<c:when test="${param.partyId ne null}" >
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