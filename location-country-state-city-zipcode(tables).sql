drop database projectBTS;
create database projectBTS;
use projectBTS;




drop table if exists login_data;

create table login_data(user_id varchar(10) primary key,
						user_name varchar(25) unique not null,
						pass_word varchar(25) not null,
                        role varchar(10) not null
                        );
                        
                        
                        insert into login_data value('750930','Yang','123','Admin');
                        insert into login_data value('750921','ashu','123','Customer');
                        
                        
                        
                        select * from login_data;
                        Select user_name,pass_word,role from login_data where user_id = '750930';






/* --------------------------------------------------------------------------------------  Country State City ZipCode ------------------------------------------------------------------------------------------------------------------*/





/*

  Country Table ------------>>>>>>>     */


/* droping table 'country' if its already present*/
	drop table if exists country;
		
		/*Create Country table */
        create table country(	country_id varchar(3) primary key, 
								country_name varchar(20) unique not null
							);

					/* insert values country_id(PK) , country_name in 'country' table*/
									insert into country value('NPL','NEPAL');
									insert into country value('IND','INDIA');
									insert into country value('AF','AFGANISTAN');
									insert into country value('BAN','BANGLADESH');
									insert into country value('MLD','MALDIVES');
									insert into country value('BT','BHUTAN');
									insert into country value('PAK','PAKISTAN');
									insert into country value('CHN','CHINA');
									insert into country value('US','UNITED STATES');
									insert into country value('UK','UNITED KINGDOM');
									insert into country value('BRA','BRAZIL');
									insert into country value('CAN','CANADA');
									insert into country value('SWZ','SWITZERLAND');
									insert into country value('NZ','NEW ZEALAND');                     
                     
                     
																						/*execute the query*/
																								/* List records in 'country' table -->*/			select count(*) from country;







/*
	States Table -------------->>>>>>>*/
    
    
/* droping table 'states' if its already present*/
	drop table if exists states;

		/*Create States table */
			create table states(	state_id varchar(3) primary key, 
									state_name varchar(30)  not null,
									country_id varchar(3)  not null,
                    
									foreign key (country_id) references country(country_id) 
                                );
                    
                    /* insert values state_id(PK) , state_name in 'states' table*/
								insert into states value('AP','Andra-Pradesh','IND');  /* N:1 states:country */
                                insert into states value('MP','Madhya-Pradesh','IND');
                                insert into states value('UP','Uttar-Pradesh','IND');
                                insert into states value('HP','Himachal-Pradesh','IND');
								insert into states value('TN','Tamil Nadu','IND');
								insert into states value('DL','DELHI','IND');
                                
                                /* -------------------------------------------------------------------------------------------------------------------------------------- */
                                
									/*twin state condition  not resolved*/
									/* insert into states value('DDD','DELHI','IND'); */
                                    
                                 /* -------------------------------------------------------------------------------------------------------------------------------------- */
                                
                                insert into states value('P1','Province-1','NPL');
                                insert into states value('P2','Province-2','NPL');
                                insert into states value('P3','Province-3','NPL');
                                insert into states value('P4','Province-4','NPL');
                                insert into states value('P5','Province-5','NPL');
                                insert into states value('P6','Province-6','NPL');
                                insert into states value('P7','Province-7','NPL');
                               
                               
                    
                    
                    
																								/*execute the query*/
																									/* List records in 'states' table -->*/ 			select * from states;   
																																						select * from states where country_id = 'Ind';					 
                    
               
               
               
               
 

               
/* 
    City's Table--------->>>>>>>>>*/
    
    
/* droping table 'cities' if its already present*/                 
	drop table if exists cities;   
    
    /*Create Cities table */
		create  table cities(	city_id varchar(5) primary key, 
								city_name varchar(30) not null,
								state_id varchar(3) not null,
								country_id varchar(3) not null,
			
								foreign key (state_id) references states(state_id),
								foreign key (country_id) references country(country_id)
							);
                    
                    
		/* insert values city_id(PK) , city_name, state_id, & country_id in 'states' table*/
									insert into cities value('NPGN','KATHMANDU','P1','NPL');	/*1:1 city:state*/
																								/* <-- passing a state with no city*/
									insert into cities value('KTM','KATHMANDU','P3','NPL');		/*1:n state:cities*/
                                    insert into cities value('DHRN','DHARAN','P3','NPL');
									insert into cities value('PKR','POKHARA','P4','NPL');
									insert into cities value('BTL','BUTWAL','P5','NPL');
									insert into cities value('TNS','TANSEN','P5','NPL');		
									
									 /* -------------------------------------------------------------------------------------------------------------------------------------- */
										
                                        /*Twin cities problem in twin states but in different countries*/
											/* insert into cities value('CHNTWN','CHINATOWN','P3','NPL'); */
											/* insert into cities value('CHNTN','CHINATOWN','DL','IND'); */
                                     
                                      /* -------------------------------------------------------------------------------------------------------------------------------------- */
                                    
                                    insert into cities value('CHN','CHENNAI','TN','IND');
                                    insert into cities value('DL','DELHI','DL','IND');
                                    insert into cities value('HBD','HYDERABAD','AP','IND');
                                    insert into cities value('LKNW','LUCKNOW','UP','IND');
                                    insert into cities value('JHNS','JHANSI','UP','IND');
                                    insert into cities value('KNPR','KANPUR','UP','IND');
                                    insert into cities value('BHPL','BHOPAL','MP','IND');
                                    
								
																		/*execute the query*/
																		/* List records in 'cities' table -->*/ 
																															select * from cities;
                                                                                                                            
                                                                                                                            
                                                                                                                            
                                                                                                                            
                                                                                                                            
/*City's Table*/
	/* droping table 'cities' if its already present*/                                                                                                                          
	drop table if exists city_pincode;
    
    
    
    
    
    /*Create Cities table */
			create table city_pincode(location_id int primary key auto_increment, 
										zip_code varchar(10) unique not null,
										city_id varchar(5) not null,
								  
										foreign key (city_id) references cities(city_id)
									);
                          
                          
	
    
			/* insert values city_id(PK) , city_name, state_id, & country_id in 'states' table*/   
							    insert into city_pincode(zip_code,city_id) value('110091','DL');   /* N:1 code:city */
							    insert into city_pincode(zip_code,city_id) value('110092','DL');
							    insert into city_pincode(zip_code,city_id) value('110093','DL');
							    insert into city_pincode(zip_code,city_id) value('110094','DL');
							    insert into city_pincode(zip_code,city_id) value('110095','DL');
							    insert into city_pincode(zip_code,city_id) value('110096','DL');
							    insert into city_pincode(zip_code,city_id) value('110097','DL');
							  
                          
								insert into city_pincode(zip_code,city_id) value('603103','CHN');
								insert into city_pincode(zip_code,city_id) value('603104','CHN'); 
								insert into city_pincode(zip_code,city_id) value('603105','CHN');
								insert into city_pincode(zip_code,city_id) value('603106','CHN');
								insert into city_pincode(zip_code,city_id) value('603107','CHN');
								insert into city_pincode(zip_code,city_id) value('603108','CHN');
								insert into city_pincode(zip_code,city_id) value('603109','CHN');
                                
                                
								insert into city_pincode(zip_code,city_id) value('44600','KTM');
                                insert into city_pincode(zip_code,city_id) value('44601','KTM');
                                insert into city_pincode(zip_code,city_id) value('44602','KTM');
                                insert into city_pincode(zip_code,city_id) value('44603','KTM');
                                insert into city_pincode(zip_code,city_id) value('44604','KTM');
                                insert into city_pincode(zip_code,city_id) value('44605','KTM');
                                insert into city_pincode(zip_code,city_id) value('44606','KTM');
                                
                                
					
																		/*execute the query*/
																		/* List records in 'cities' table -->*/          
																															select * from city_pincode;
                                
                                
    
    
    
    
    
  /*Location Table*/
	/* droping table 'location' if its already present*/                               
		drop table if exists location;
             
		/*Create location table */
		create table location(loc_id int primary key auto_increment, 
								city_id varchar(5)  not null,
                                state_id varchar(3)  not null,
                                zip_code varchar(10)  not null,
                                country_id varchar(3)  not null,
                               
                                foreign key (city_id) references cities(city_id),
                                foreign key (state_id) references states(state_id),
                                foreign key (country_id) references country(country_id),
                                foreign key (zip_code) references city_pincode(zip_code)
                              
                                
                                );
                                
					/* insert values location_id(PK) , country_id, state_id, & city_id in 'location' table*/           
																	
											insert into location(city_id,state_id,zip_code,country_id) values('DL','DL','110091','IND'); 
											insert into location(city_id,state_id,zip_code,country_id) values('DL','DL','110092','IND'); 
                                            insert into location(city_id,state_id,zip_code,country_id) values('DL','DL','110093','IND'); 
                                            insert into location(city_id,state_id,zip_code,country_id) values('DL','DL','110094','IND'); 
                                            insert into location(city_id,state_id,zip_code,country_id) values('DL','DL','110095','IND'); 
                                            insert into location(city_id,state_id,zip_code,country_id) values('DL','DL','110096','IND'); 
											insert into location(city_id,state_id,zip_code,country_id) values('DL','DL','110097','IND'); 
                                                  
											insert into location(city_id,state_id,zip_code,country_id) values('KTM','P3','44600','NPL');
                                            insert into location(city_id,state_id,zip_code,country_id) values('KTM','P3','44601','NPL'); 
                                            insert into location(city_id,state_id,zip_code,country_id) values('KTM','P3','44602','NPL'); 
                                            insert into location(city_id,state_id,zip_code,country_id) values('KTM','P3','44603','NPL'); 
                                            insert into location(city_id,state_id,zip_code,country_id) values('KTM','P3','44604','NPL'); 
                                            insert into location(city_id,state_id,zip_code,country_id) values('KTM','P3','44606','NPL'); 
                                                              
                                                                    
                                                                    
                                                                    
                                                                    /*execute the query*/
																		/* List records in 'location' table -->*/   
																															select * from location;
                          
			







Select * from cities where country_id = 'IND' and  state_id = 'DL';







