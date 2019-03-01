function validate()
{
	
	var teamA = document.getElementById('teamA').value;
	validateTeamName(teamA);

	var teamB = document.getElementById('teamB').value;
	validateTeamName(teamB);

	var date = document.getElementById('matchDate').value;
	validateMatchDate(date);

	var time =  document.getElementById('playTime').value;
	validateTimeFormat(time);


	var scoreA =  document.getElementById('teamAScore').value;
	validateScoreFormat(scoreA);
	var scoreB =  document.getElementById('teamBScore').value;
	validateScoreFormat(scoreB);
}



function validateTeamName(inputText)
{
	var pattern = /[A-Za-z]/g;

	alert(inputText);
	if(!(inputText.match(pattern)))
		{
			document.getElementById('errMessageforTeam').innerText = "Invalid Team";
				alert(inputText - );
		}
	
}




function validateMatchDate(inputDate)
{
	
	var splitDate = inputDate.split("/");
	var dateFormat = splitDate[1] + "/" + splitDate[0] + "/" + splitDate[2];
	var status = false;
	var date = new Date(dateFormat);
	
	if(!(isNaN(date)))
		{	
				var day = splitDate[0];
				var month = splitDate[1];
				var year = splitDate[2];

				var days = [ 31,28,31,30,31,30,31,31,30,31,30,31 ];
			

				if(year.length==4) 
				{
					if((year%100==0 && year%4==0 )||year%400==0)
						days[1] = 29;
						


					if(month.length==2 && month>0 && month<13)
						if(day<=days[month.length-1])
								status = true;		
					
				}

			
			if(status==false)
				document.getElementById('errMessageforDate').innerText = "Invalid Date";
			
		}

}




	function validateTimeFormat(inputTime)
	{
		
		var splitTime = inputTime.split(":");

		var hours = splitTime[0];
		var minutes = splitTime[1];
		var seconds = splitTime[2];

		var timeStatus = false;

		if(hours>0 && hours<24)
			if(minutes>0 && minutes<60)
				if(seconds>0 && seconds<60)
						timeStatus = true;

	
		if(timeStatus==false)
			document.getElementById('errMessageforTime').innerText = "Invalid Time Format";

	}






	function validateScoreFormat(inputScore)
	{
		var splitScore = inputScore.split("/");

		var runs = splitScore[0];
		var wkts = splitScore[1];
	
		var gameStatus = false;

		if(runs.length<4 && runs>=0 && wkts>0 && wkts<=10)
			gameStatus = true;


	
		if(gameStatus==false)
			document.getElementById('errMessageforScore').innerText = "Invalid Score Format";


}