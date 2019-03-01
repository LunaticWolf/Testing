drop database amululu;
create database amululu;

use amululu;



/* States Table */
drop table if exists states;
create table states( state_id varchar(2) primary key,
					 state_name varchar(30) unique not null
                     );
                     
                     
         insert into states value('AN','Andaman and Nicobar Islands');            
         insert into states value('AP','Andhra Pradesh');
         insert into states value('AR','Arunachal Pradesh');
         insert into states value('AS','Assam');
         insert into states value('BR','Bihar');
         insert into states value('CH','Chandigarh');
         insert into states value('CT','Chhattisgarh');
         insert into states value('DN','Dadra and Nagar Haveli');
         insert into states value('DD','Daman and Diu');
         insert into states value('DL','Delhi');
         insert into states value('GA','Goa');
         insert into states value('GJ','Gujarat');
         insert into states value('HR','Haryana');
         insert into states value('HP','Himachal Pradesh');
         insert into states value('JK','Jammu and Kashmir');
         insert into states value('JH','Jharkhand');
         insert into states value('KA','Karnataka');
         insert into states value('KL','Kerala');
         insert into states value('LD','Lakshadweep');
         insert into states value('MP','Madhya Pradesh');
         insert into states value('MH','Maharashtra');
         insert into states value('MN','Manipur');
         insert into states value('ML','Meghalaya');
         insert into states value('MZ','Mizoram');
         insert into states value('NL','Nagaland');
         insert into states value('OR','Odisha/Orissa');
         insert into states value('PY','Puducherry');
         insert into states value('PB','Punjab');
         insert into states value('RJ','Rajasthan');
         insert into states value('SK','Sikkim');
         insert into states value('TN','Tamil Nadu');
         insert into states value('TG','Telangana');
         insert into states value('TR','Tripura');
         insert into states value('UP','Uttar Pradesh');
         insert into states value('UT','Uttarakhand/Uttaranchal');
		 insert into states value('WB','West Bengal');
                     
                     
   select * from states;    
   
   
   
   
   
   
   /* Insurance Plan */
   drop table if exists insurance_plan;
   create table insurance_plan(iplan_id varchar(2) primary key,
								iplan varchar(50) unique not null
                                );
                                
                                
                                
             insert into insurance_plan value('P1','Plan 1');  
              insert into insurance_plan value('P2','Plan 2'); 
               insert into insurance_plan value('P3','Plan 3'); 
                insert into insurance_plan value('P4','Plan 4'); 
                 insert into insurance_plan value('P5','Plan 5'); 
                 
						
   
   
   select * from insurance_plan;
   
   
   
   
   
   
   
   
   
                     
                     
                     