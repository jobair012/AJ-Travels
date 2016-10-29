/**
 * 
 */

$(document).ready(function(){
	$( ".datepicker" ).datepicker({ dateFormat: 'yy-mm-dd' });
});

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
		url : "/aj_travels/admin/checkDuplicateUsername",
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
		url : "/aj_travels/admin/getAllUsername",
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
		url : "/aj_travels/admin/getNameAndUsernameList",
		type : "GET",
		success : function(data) {
			$("#username").autocomplete({
				source : data
			});
		},
		error : function(data) {
			alert("Something went wrong !");
		}
	});
}

function submitUserSearchForm(){
	
	userSearchPagination();
}

function userSearchPagination(){
	
	var username = $("#username").val();
	var fromDate = $("#fromDate").val();
	var toDate = $("#toDate").val();
	
	$("#usersPagination").dataTable( {
		"destroy" : true,
		"ordering": false,
        "bProcessing" : true,
        "bServerSide" : true,
        "sort" : "position",
        "bStateSave" : true,
        "responsive" : true,
        "iDisplayStart" : 0,
        "fnDrawCallback" : function () {
        },         
        ajax:  {
	    	url : "/aj_travels/admin/doSearchUser",
	        type : "POST",
	        data : { "username" : username, "fromDate" : fromDate, "toDate" : toDate }, 		
        },
        "aoColumns": [
	      { "mData": "username" },
	      { "mData": "userDetail.name" },                     
	      { "mData": "enabled" },
	      { "mData": "role" },                      
	    ]       
    });
}