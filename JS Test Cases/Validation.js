
function validation()
{
	var teamnameA=document.getElementById('teamA').value;
	var teamnameB=document.getElementById('teamB').value;
	var datename=document.getElementById('date').value;
	var timename=document.getElementById('time').value;
	var teamnameAscore=document.getElementById('teamAscore').value;
	var teamnameBscore=document.getElementById('teamBscore').value;


	validationMandatory(teamnameA,teamnameB,datename,timename,teamnameAscore,teamnameBscore);

}



function validationMandatory(teamnameA,teamnameB,datename,timename,teamnameAscore,teamnameBscore)
{
	var namePattern=/[A-Za-z]/g;
	var status=true;

	

	 if(!(teamnameA.match(namePattern)))
		 document.getElementById("errTeamA").innerHTML="Invalid Team A Name";


	 if(!(teamnameB.match(namePattern)))
			document.getElementById("errTeamB").innerHTML="Invalid Team B Name";




	var validformat=/^\d{2}\/\d{2}\/\d{4}$/; 

		 if (!validformat.test(datename))
		 	document.getElementById("errDate").innerHTML= "1" ;//"Invalid Date Name";
		 else
			{ 
				var splitdate=datename.split("/");
		 		var monthfield=splitdate[1];
				var dayfield=splitdate[0];
		  		var yearfield=splitdate[2];

		  		var dayobj = new Date(yearfield, monthfield-1, dayfield);

		 		 if ((dayobj.getMonth()+1!=monthfield)||(dayobj.getDate()!=dayfield)||(dayobj.getFullYear()!=yearfield))
					document.getElementById("errDate").innerHTML="2"; //"Invalid Date Name";
				
				}	




		var isValid = /^([0-1]?[0-9]|2[0-4]):([0-5][0-9])(:[0-5][0-9])?$/.test(timename);
		if(isValid==false)
		document.getElementById('errTime').innerHTML = "Invalid Time Format";



	var count=0;
	var scorePattern = /[0-9][/]/g;
	var scorePattern1=/[0-9]/g;
	var splitScoreA = teamnameAscore.split("/");
	if((teamnameAscore.match(scorePattern)))
	{	
		count++;
		
				if((splitScoreA.length==2)) 
				{  
					count++;
					var s=parseInt(splitScoreA[0]);
					var s1=parseInt(splitScoreA[1]);
					if(splitScoreA[0].match(scorePattern1) && splitScoreA[1].match(scorePattern1))
						{  
						count++;
						if(s>=0 && s<=999 && s1<=10)
						 count++;
						}
				}
	}

	if(!(count==4))
			document.getElementById("errTeamAscore").innerHTML = "Invalid Team A Score ";





	var count=0;
	var scorePattern = /[0-9][/]/g;
	var scorePattern1=/[0-9]/g;
	var splitScoreB = teamnameBscore.split("/");
	if((teamnameAscore.match(scorePattern)))
	{	
		count++;
		
				if((splitScoreB.length==2)) 
				{  
					count++;
					var s=parseInt(splitScoreB[0]);
					var s1=parseInt(splitScoreB[1]);

					if(splitScoreB[0].match(scorePattern1) && splitScoreB[1].match(scorePattern1))
						{  
						count++;
						if(s>=0 && s<=999 && s1<=10)
						 count++;
						}
				}
	}

	if(!(count==4))
			document.getElementById("errTeamBscore").innerHTML = "Invalid Team B Score ";




	if(splitScoreA[0]>splitScoreB[0])
		winningTeam = teamnameA;	
	
	else if(splitScoreA[0]==splitScoreB[0])
		{alert("hello");	
			if(splitScoreA[1]<splitScoreB[1])
				winningTeam = teamnameA;
			else
				winningTeam = teamnameB;
			}
	else
		winningTeam = teamnameB;



document.getElementById('winningTeam').innerHTML = winningTeam;
}