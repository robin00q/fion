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
		dataType : 'json',
		error : onError,
		success : onSuccess
	});
}

function onSuccess(data, status){
	console.log(data);
	console.log(data.matchDate);
	
	var elem = document.getElementById('test');
	elem.style.color = "red";
	
}

function onError(){
	
}