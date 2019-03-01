	function ValidateEntry()
		{
			var playerName = validateName();
			var matchDetails = validateMatches();
			var inningDetails = validateInnings();
			var runsScored = validateRunsDetails();

			AddPlayerDetails(playerName,matchDetails,inningDetails,runsScored);
		}



		function validateName()
			{
			
				var inputName = document.getElementById("playerName").value;
				var pattern = /[A-Za-z]/g;
				/*var pattern = /^[a-zA-Z ]+$/g ;*/

				for(i=0;i<inputName.length;i++)
				{
					if(!(inputName.charAt(i).match(pattern)) )
					{
							inputName = prompt("Please Enter Valid Player Name: ", inputName);
							i=0;
					}					
				}
				
				document.getElementById("playerName").value = inputName;	
			
				return inputName;



			}

		function validateMatches()
		{

				var inputMatchDetails = document.getElementById("matchesPlayed").value;
				while(isNaN(inputMatchDetails) || inputMatchDetails > 99999 || inputMatchDetails=="" || inputMatchDetails==null)
				{	
						inputMatchDetails = prompt("Please Enter Valid Match Entries: ", inputMatchDetails);
						document.getElementById("matchesPlayed").innerText = inputMatchDetails;
						
				}
				
			
				return inputMatchDetails;
		}


		function validateInnings()
		{
		
			var inputInningsDetails = document.getElementById("inningsPlayed").value;
			while(isNaN(inputInningsDetails) || inputInningsDetails > 99999 || inputInningsDetails=="" || inputInningsDetails==null)
					{
						inputInningsDetails = prompt("Please Enter Valid Innings Played: ", inputInningsDetails);
						document.getElementById("inningsPlayed").innerText = inputInningsDetails;
					}

				
				return inputInningsDetails;
		}


		function validateRunsDetails()
		{
			var inputRunsDetails = document.getElementById("runsScored").value;
			while(isNaN(inputRunsDetails) || inputRunsDetails > 99999 || inputRunsDetails=="" || inputRunsDetails==null)
					{
						inputRunsDetails = prompt("Please Enter Valid Run Scored: ", inputRunsDetails);
						document.getElementById("runsScored").innerText = inputRunsDetails;
					}

			
			return inputRunsDetails;
		}







		function AddPlayerDetails(playerName,matchDetails,inningDetails,runsScored)
			{

				var tbody = document.getElementById('playerAdded');
				var nRowCount = tbody.rows.length;
				var tRow = tbody.insertRow(nRowCount);
				var cell1 = tRow.insertCell(0);
				var element1 = document.createElement("input");
				element1.type = "checkbox";
				element1.name = "chkbox[]";
				/*element1.setAttribute('type','checkbox');*/
				cell1.appendChild(element1);



				/*var cell2 = row.insertCell(1);
				cell2.innerHTML = rowCount + 1;*/
				var cell2 = tRow.insertCell(1);
				var element2 = document.createElement("td");
				element2.name = "nPlayerName[]";
				element2.id = "pName";
				//var pName = document.createTextNode(document.getElementById('playerName').value);
				var pName = document.createTextNode(playerName);
				element2.appendChild(pName);
				/*element2.innerHTML = playerName;*/
				cell2.appendChild(element2);
				


				var cell3 = tRow.insertCell(2);
				var element3 = document.createElement("td");
				element3.name = "nMatchesPlayed[]";
				//var pMatches = document.createTextNode(document.getElementById('matchesPlayed').value);
				var pMatches = document.createTextNode(matchDetails);
				element3.appendChild(pMatches);
				cell3.appendChild(element3);
				


				var cell4 = tRow.insertCell(3);
				var element4 = document.createElement("td");
				element4.name = "nInningsPlayed[]";
				//var pInnings = document.createTextNode(document.getElementById('inningsPlayed').value);
				var pInnings = document.createTextNode(inningDetails);
				element4.appendChild(pInnings);
				cell4.appendChild(element4);



				var cell5 = tRow.insertCell(4);
				var element5 = document.createElement("td");
				element5.name = "nRunsScored[]";
				//var pRuns = document.createTextNode(document.getElementById('runsScored').value);
				var pRuns = document.createTextNode(runsScored);
				element5.appendChild(pRuns);
				cell5.appendChild(element5);
			}

		


		function removePlayerDetails()
		{
			try 
			{
				var tbody = document.getElementById('playerAdded');
				var tRowCount = tbody.rows.length;
				for(var i=0; i<tRowCount; i++) 
				{
					var row = tbody.rows[i];
					var chkbox = row.cells[0].childNodes[0];
					if(chkbox!=null && chkbox.checked==true) 
					{
						tbody.deleteRow(i);
						tRowCount-=1;
						i-=1;
					}
				}
			}
			catch(e) 
			{
				alert("Player Removed - " + e);
			}
		}