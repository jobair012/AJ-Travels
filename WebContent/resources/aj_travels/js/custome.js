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
	      { "mData": "userRole.role" },
	    ],
	    "columnDefs": [ {
	        "targets": 4,
	        "data": "username",
	        "render": function ( data, type, full, meta ) {
	          return '<a href="/aj_travels/admin/explore?username='+data+'">Explore</a>';
	        }
	      } ]
    });
}

function getAllCountry() {
	
	$.ajax({
	       url: "/aj_travels/common/getAllCountry",
	       type: "GET",
	       success: function(data) {	    	   
	           $("#country").autocomplete({
	               source: data,
	               focus: function(event, ui) {
	                   event.preventDefault();
	                   $(this).val(ui.item.label);
	               },
	               select: function(event, ui) {
	                   event.preventDefault();
	                   $(this).val(ui.item.label);
	                   $("#countryId").val(ui.item.value);
	                   $("#country").blur(function() {
	                       var country = $("#country").val();
	                       if (country == ui.item.label) {
	                           $("#countryId").val(ui.item.value);
	                           return true;
	                       } else {
	                           $("#countryId").val(null);
	                       }
	                   });
	               }
	           });
	            
	       }
	 });
}

function getAllStateByCountryId() {
	
	var countryId = $("#countryId").val();
	
	$.ajax({
	       url: "/aj_travels/common/getAllStateByCountryId",
	       type: "GET",
	       data : { "countryId" : countryId },
	       success: function(data) {	    	   
	           $("#state").autocomplete({
	               source: data,
	               focus: function(event, ui) {
	                   event.preventDefault();
	                   $(this).val(ui.item.label);
	               },
	               select: function(event, ui) {
	                   event.preventDefault();
	                   $(this).val(ui.item.label);
	                   $("#stateId").val(ui.item.value);
	                   $("#state").blur(function() {
	                       var state = $("#state").val();
	                       if (state == ui.item.label) {
	                           $("#stateId").val(ui.item.value);
	                           return true;
	                       } else {
	                           $("#stateId").val(null);
	                       }
	                   });
	               }
	           });
	            
	       }
	 });
}

function getAllCityByStateId(){

	var stateId = $("#stateId").val();
	
	$.ajax({
	       url: "/aj_travels/common/getAllCityByStateId",
	       type: "GET",
	       data : { "stateId" : stateId },
	       success: function(data) {	    	   
	           $("#city").autocomplete({
	               source: data,
	               focus: function(event, ui) {
	                   event.preventDefault();
	                   $(this).val(ui.item.label);
	               },
	               select: function(event, ui) {
	                   event.preventDefault();
	                   $(this).val(ui.item.label);
	                   $("#cityId").val(ui.item.value);
	                   $("#city").blur(function() {
	                       var city = $("#city").val();
	                       if (city == ui.item.label) {
	                           $("#cityId").val(ui.item.value);
	                           return true;
	                       } else {
	                           $("#cityId").val(null);
	                       }
	                   });
	               }
	           });
	            
	       }
	  });
}

function getAllAreaByCityId(){

	var cityId = $("#cityId").val();
	
	$.ajax({
	       url: "/aj_travels/common/getAllAreaByCityId",
	       type: "GET",
	       data : { "cityId" : cityId },
	       success: function(data) {	    	   
	           $("#area").autocomplete({
	               source: data,
	               focus: function(event, ui) {
	                   event.preventDefault();
	                   $(this).val(ui.item.label);
	               },
	               select: function(event, ui) {
	                   event.preventDefault();
	                   $(this).val(ui.item.label);
	                   $("#areaId").val(ui.item.value);
	                   $("#area").blur(function() {
	                       var area = $("#area").val();
	                       if (area == ui.item.label) {
	                           $("#areaId").val(ui.item.value);
	                           return true;
	                       } else {
	                           $("#areaId").val(null);
	                       }
	                   });
	               }
	           });	            
	       }
	  });
}