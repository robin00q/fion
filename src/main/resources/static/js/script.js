function toggleTable(matchId) {
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
	
	var matchDetailDiv = document.getElementById('matchDetail');
	
	console.log(matchDetailDiv);
	var playerArray = data.matchInfo[0].player;
	
	var table = document.createElement('table');
	var thead = document.createElement('thead');
	var tbody = document.createElement('tbody');
	
	console.log(playerArray);

	playerArray.forEach(element => {
		var tr = document.createElement('tr');
		for(let [key, value] of Object.entries(element)) {
			if(key === "spId") {
				$(tr).append('<td><img src="https://fo4.dn.nexoncdn.co.kr/live/externalAssets/common/players/p' + value%1000000 + '.png " /></td>');
			} else if(key === "status"){
				for(let [key, value] of Object.entries(element.status)) {
					$(tr).append('<td>'+element.status[key]+'</td>');
				}
			} else {
				$(tr).append('<td></td>');
			}
		}
		
		
		tbody.appendChild(tr);
	});

	
	table.appendChild(tbody);
	matchDetailDiv.appendChild(table);
	

	console.log(matchDetailDiv);
}

function onError(){
	
}
/* ]]> */