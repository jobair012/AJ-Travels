<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">User Search Result</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<table id="users" width="100%" class="table table-striped table-hover" >
					<thead>
						<tr>
							<th>Username</th>
							<th>Status</th>
							<th>Role</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${searchResult}" var="result">
							<tr>
								<td><c:out value="${result.username}"></c:out></td>
								<td><c:out value="${result.enabled}"></c:out></td>
								<td><c:out value="${result.role}"></c:out></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<script>
	$(document).ready(function() {
		$('#users').DataTable({
			responsive : true
		});
	});
</script>