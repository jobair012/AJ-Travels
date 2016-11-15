<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="page-wrapper">
	<br />
	<div class="row">
		<div class="pull-left">
				<a href="${pageContext.request.contextPath}/party/search" class="btn btn-info"><span class="glyphicon glyphicon-search"></span> Search</a> 
				<a href="${pageContext.request.contextPath}/party/create" class="btn btn-info"><span class="glyphicon glyphicon-plus"></span> Add New</a>
		</div>
	</div>
	
	<br />

	<form class="form-horizontal" id="partySearchForm">
		<fieldset>

			<!-- Form Name -->
			<legend>Search Form</legend>
			
			<!-- Select Basic -->
			<div class="form-group">
			  <label class="col-md-2 control-label" for="selectbasic">Party Type</label>
			  <div class="col-md-6">
			  	<select id="partyTypeId" name="partyTypeId" class="form-control">
			  		<option value="">Select Role</option>
			  		<c:forEach items="${partyType}" var="type">		  		
			      		<option value="${type.value}">${type.label}</option>    		    
			  		</c:forEach>
			  	</select>   
			  </div>
			</div>
			
			<!-- Text input-->
			<div class="form-group has-feedback">
				<label class="col-md-2 control-label" for="partyId">Party ID</label>
				<div class="col-md-6">
					<input id="partyId" name="partyId" placeholder="Party ID" class="form-control input-md" type="text" />
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group has-feedback">
				<label class="col-md-2 control-label" for="partyName">Party Name</label>
				<div class="col-md-6">
					<input id="partyName" name="partyName" placeholder="Party Name"
						class="form-control input-md" type="text" onkeypress="javascript:getAllPartyName();"/>
					<span class="form-control-feedback">
				        <i class="fa fa-user"></i>
				    </span>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group has-feedback">
				<label class="col-md-2 control-label" for="fromDate">From Date</label>
				<div class="col-md-6">
					<input id="fromDate"  name="fromDate" placeholder="YYYY-MM-DD"
						class="form-control input-md datepicker" type="text">
					<span class="form-control-feedback">
				        <i class="fa fa-calendar"></i>
				    </span>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group has-feedback">
				<label class="col-md-2 control-label" for="toDate">To Date</label>
				<div class="col-md-6">
					<input id="toDate" name="toDate" placeholder="YYYY-MM-DD"
						class="form-control input-md datepicker" type="text">
					<span class="form-control-feedback">
				        <i class="fa fa-calendar"></i>
				    </span>
				</div>
			</div>
						

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-2 control-label" for="search"></label>
				<div class="col-md-6">
					<input type="button" id="search" name="search" class="btn btn-primary" value="Search" onclick="javascript:submitPartySearchForm();"/>					
				</div>
			</div>

		</fieldset>
	</form>
	
	<hr/>

	<jsp:include page="partySearchResult.jsp"></jsp:include>
</div>
