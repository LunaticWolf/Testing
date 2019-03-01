		
	function dateCheck()
	{	
		var dateformat = document.getElementById('dateformat').value;
		alert("Entered Value - " + dateformat);
		var date = dateformat.split("/");
		alert("After Split - " + date);

		var validateDate = date[1]+"/"+date[0]+"/"+date[2];
		var days = [ 31,28,31,30,31,30,31,31,30,31,30,31 ];
		
		var day = date[0];
		var month = date[1];
		var year = date[2];


		if(year.length==4) 
		{
			if((year%100==0 && year%4==0 )||year%400==0)
				days[2] = 29;

					if(month.length==2 && month>0 && month<13)
						if(day<=days[month-1])
							
		}
							
						


							

			

	}