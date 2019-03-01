<!DOCTYPE html>

<html>

<head>

	<title> Player Details </title>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>



	<script>

			$(document).ready(

								function()

								{

									$("#details").click(function()

										{



											var tableText = "<table id = 'mostSixes'>" + 

																"<tr>" +

																	"<th colspan='6'>Player Id</th>" +

																	"<th>Player Name</th>" +

																	"<th>Player Role</th>" +

																	"<th>Batting Style</th>" +

																	"<th>Bowling Style</th>" +

																	"<th>Score</th>" +

																"</tr>"	;		





												$.ajax({

															type:"GET",

															url: " Player.xml",

															success: function(xml)

																	{

																		$(xml).find("player").each(

																									function()

																									{

																										var pid = $(this).find("pid").text();

																										var name = $(this).find("name").text();

																										var role= $(this).find("rame").text();

																										var batting = $(this).find("battingstyle").text();

																										var bowling = $(this).find("bowlingstyle").text();

																										var score = $(this).find("score").text();





																										tableText+=	"<tr>" +

																															"<td>" + pid + "</td>" + 

																															"<td>" + name + "</td>" + 

																															"<td>" + role + "</td>" + 

																															"<td>" + batting + "</td>" + 

																															"<td>" + bowling + "</td>" + 

																															"<td>" + score + "</td>" + 

																													"</tr>";



																									}

																									);

																		tableText+="</table>";

																		$('div').html(tableText);

																	}





															error: function()

																	{

																		alert("Error");

																	}







														});







										});







								});





	</script>



</head>

<body>



	<button type="button" id="details" > Press </button>

<div>





</div>



	

<table>





</table>





</body>

</html>