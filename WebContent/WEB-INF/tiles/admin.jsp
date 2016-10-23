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

	<form class="form-horizontal" id="userSearchForm">
		<fieldset>

			<!-- Form Name -->
			<legend>Search Form</legend>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-2 control-label" for="name">Name Or Username</label>
				<div class="col-md-6">
					<input id="username" name="username" placeholder="Name Or Username" value=""
						class="form-control input-md" type="text" onkeyup="javascript:getAllNameWithUsername();">

				</div>
			</div>

			<!-- Text input-->
			<!-- <div class="form-group">
				<label class="col-md-2 control-label" for="partyId">Username</label>
				<div class="col-md-6">
					<input id="username" name="username" placeholder="Username" onkeyup="javascript:getAllUsername();"
						class="form-control input-md" type="text">

				</div>
			</div> -->

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-2 control-label" for="fromDate">From
					Date</label>
				<div class="col-md-6">
					<input id="fromDate" class="datepicker" name="fromDate" placeholder="YYYY-MM-DD"
						class="form-control input-md" type="text">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-2 control-label" for="toDate">To Date</label>
				<div class="col-md-6">
					<input id="toDate" class="datepicker" name="toDate" placeholder="YYYY-MM-DD"
						class="form-control input-md" type="text">

				</div>
			</div>

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-2 control-label" for="search"></label>
				<div class="col-md-6">
					<input type="button" id="search" name="search" class="btn btn-primary" value="Search" onclick="javascript:submitUserSearchForm();"/>					
				</div>
			</div>

		</fieldset>
	</form>
	
	<hr/>

	<div id="userSearchResult">This is Search Page</div>
</div>