	function validateDetails()
	{
		var errT = 0;
		
		var teamA = document.getElementById('teamA').value;
		var input1 = validateTeamName(teamA,errT);

		errT+=1;
		var teamB = document.getElementById('teamB').value;
		var input2 = validateTeamName(teamB,errT);

		

		var date = document.getElementById('matchDate').value;
		validateMatchDate(date);

		var time =  document.getElementById('playTime').value;
		validateTimeFormat(time);

		var scoreTally = [];
		var errNo = 0;
	
		var scoreA = document.getElementById('scoreA').value;
		scoreTally.push(validateScoreCard(scoreA,errNo));
	
		errNo +=1;
		var scoreB = document.getElementById('scoreB').value;
		scoreTally.push(validateScoreCard(scoreB,errNo));
		evaluateScoreCard(scoreTally);


		if(input1 == null || input2 == null)
		{
			document.getElementById("winningTeam").innerText = "";
		}
	
	}



	function validateTeamName(inputText,errT)
	{
		var pattern = /[A-Za-z]/g;
		var errTeam = document.getElementsByClassName("errMessageforTeam");
		if(!(inputText.match(pattern)))
		{	
				errTeam[errT].innerText = "Invalid Team Name";
				resetWinner();
				return null;
		}
		else
		{
				errTeam[errT].innerText = "";
				return inputText;
		}

	}




	function validateMatchDate()
	{
		var splitDate = document.getElementById('matchDate').value.split("/");
		if(splitDate.length!=3)
			document.getElementById('errMessageforDate').innerText = "Invalid Date";

		try
		{
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
							if (((year % 4 == 0) && (year % 100!= 0)) || (year%400 == 0))
								days[1] = 29;
							


							if(month.length==2 && month>0 && month<13)
								if(day<=days[month.length-1])
										status = true;		
						
						}

				
					if(status==false)
						{
							document.getElementById('errMessageforDate').innerText = "Invalid Date";
							resetWinner();
						}
					else
						document.getElementById('errMessageforDate').innerText = "";

				
				}
		}
		catch(e)
		{
			document.getElementById('errMessageforDate').innerText = "Invalid Date";
		}
		

	}




	function validateTimeFormat(inputTime)
	{
		
		var splitTime = inputTime.split(":");
		if(splitTime.length==3)
		{	
			var timeStatus = false;

			var hours = splitTime[0];
			var minutes = splitTime[1];
			var seconds = splitTime[2];

			

			if(hours>=0 && hours<24)
				if(minutes>=0 && minutes<60)
					if(seconds>=0 && seconds<60)
							timeStatus = true;

	
			if(timeStatus==false)
				{
					document.getElementById('errMessageforTime').innerText = "Invalid Time Format";
					resetWinner();
				}
			else
				document.getElementById('errMessageforTime').innerText = "";
		}
		else
			{
				document.getElementById('errMessageforTime').innerText = "Invalid Time Format";
				resetWinner();
			}
	}






function validateScoreCard(inputScore,errNo)
{
	splitScore = inputScore.split("/");
	var runs = splitScore[0];
	var wkts = splitScore[1];
	var gameStatus = false;
	var scoreCard = [];
	if(runs.length<4 && runs>=0 && wkts>=0 && wkts<=10)
		{
			gameStatus = true;
			scoreCard = { Wkts:wkts , Runs:runs };
		}
	
	if(gameStatus==false)
	{
		var err = document.getElementsByClassName("errMessage");
		err[errNo].innerText = "Invalid Score Format";
		resetWinner();
	}
	else
	{
		var err = document.getElementsByClassName("errMessage");
		err[errNo].innerText = "";
	}



	return scoreCard;
}





function evaluateScoreCard(scoreTally)
{
	var runsA = parseInt(scoreTally[0]["Runs"]);
	var runsB = parseInt(scoreTally[1]["Runs"]);
	var wktsA = parseInt(scoreTally[0]["Wkts"]);
	var wktsB = parseInt(scoreTally[1]["Wkts"]);
	var statusA = false;
	var statusB = false;

	if(runsA<runsB)
	{
		statusB = true;
	}
	else if(runsB<runsA)
	{
		statusA = true;
	}
	else
	{
		if(wktsA<wktsB)
		{
			statusA = true;
		}
		if(wktsB<wktsA)
		{	
			statusB = true;
		}
	}
	

	displayWinner(statusA,statusB);
}


function displayWinner(statusA,statusB)
{
	if(statusA)
		document.getElementById('winningTeam').innerText = "Team - " + document.getElementById('teamA').value;
	if(statusB)
		document.getElementById('winningTeam').innerText = "Team - " + document.getElementById('teamB').value;
	if(statusA!=false && statusA == statusB)
		document.getElementById('winningTeam').innerText = "Match Draw";
	
}


function resetWinner()
{
	document.getElementById("winningTeam").innerText = "";
}