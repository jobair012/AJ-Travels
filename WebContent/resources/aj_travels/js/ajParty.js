function getAllPartyName(){
	$.ajax({
		url : "/aj_travels/party/getAllPartyName",
		type : "GET",
		success : function(data) {
			$("#partyName").autocomplete({
				source : data,
			});
		},
		error : function(data) {
			alert("Something went wrong !");
		}
	});
}

function submitPartySearchForm(){

	partySearchPagination();
}

function partySearchPagination(){
	
	var partyTypeId = $("#partyTypeId").val();
	var partyId = $("#partyId").val();
	var partyName = $("#partyName").val();
	var fromDate = $("#fromDate").val();
	var toDate = $("#toDate").val();
		
	$("#partyPagination").dataTable( {
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
	    	url : "/aj_travels/party/doSearchParty",
	        type : "POST",
	        data : { "partyTypeId" : partyTypeId, "partyId" : partyId, "partyName" : partyName,  "fromDate" : fromDate, "toDate" : toDate }, 		
        },
        "aoColumns": [
	      { "mData": "partyId" },
	      { "mData": "partyName" },                     
	      { "mData": "partyType.partyTypeName" },
	      { "mData": "createdStamp",
	    	  	"render": function (data) {
	    	        var date = new Date(data);
	    	        var month = Number(date.getMonth() + 1);
	    	        var theMonth = (month < 10) ? ("0"+month) : month;
	    	        var theDate = (Number(date.getDate()) < 10) ? ("0"+date.getDate()) : date.getDate();
	    	        return date.getFullYear() + "-" + theMonth + "-" + theDate;
	    	    }},
	    ],
	    "columnDefs": [ {
	        "targets": 4,
	        "data": "partyId",
	        "render": function ( data, type, full, meta ) {
	          return '<a href="/aj_travels/party/explore?partyId='+data+'">Explore</a>';
	        }
	      } ]
    });
}
