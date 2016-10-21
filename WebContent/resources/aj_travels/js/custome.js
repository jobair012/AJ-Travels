/**
 * 
 */

function checkPasswordMatch() {
	var password = $("#password").val();
	var confirmPassword = $("#confirmPassword").val();

	if (confirmPassword) {
		if (password !== confirmPassword) {
			$("#passwordMismatch").text("Password doesn't match").show();
		} else {
			$("#passwordMismatch").hide();
		}
	}
}

function checkPasswordMatch2() {
	var password = $("#password").val();
	var confirmPassword = $("#confirmPassword").val();

	if (confirmPassword) {
		if (password !== confirmPassword) {
			$("#confirmPassword").val(null);
			$("#passwordMismatch").text("Please confirm your password").show();
			$("#confirmPassword").focus();
		} else {
			$("#passwordMismatch").hide();
		}
	}
}

function checkDuplicateUsername() {

	var username = $("#username").val();

	$.ajax({
		url : "checkDuplicateUsername",
		type : "GET",
		data : {
			"username" : username
		},
		success : function(data) {
			if (data) {
				$("#username").val(null);
				$("#userExists").text(data).show();
				$("#username").focus();
			} else {
				$("#userExists").hide();
			}
		}
	});
}

function getAllUsername() {
	
	$.ajax({
		url : "admin/getAllUsername",
		type : "GET",
		success : function(data) {
			$("#username").autocomplete({
				source : data,
			});
		},
		error : function(data) {
			alert("Something went wrong !");
		}
	});
}

function getAllNameWithUsername() {
	
	$.ajax({
		url : "admin/getNameAndUsernameList",
		type : "GET",
		success : function(data) {
			$("#username").autocomplete({
				source : data,
			});
		},
		error : function(data) {
			alert("Something went wrong !");
		}
	});
}