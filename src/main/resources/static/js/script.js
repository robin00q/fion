function toggleTable(matchId) {
//  var x = document.getElementById("matchDetail");
//  if (x.style.display === "none") {
//    x.style.display = "block";
//  } else {
//    x.style.display = "none";
//  }
	console.log("click!!");

	$.ajax({
		url : "showMatchDetail",
		type : 'get',
		data : "matchId=" + matchId,
		dataType : 'text',
		error : onError,
		success : onSuccess
	});
}

function onSuccess(data, status){
	console.log(data);
}

function onError(){
	
}