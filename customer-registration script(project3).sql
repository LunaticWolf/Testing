use projectBTS;




/* Customer Type table for Customer Registration Page */
/* Drop table customer_type_identifier */
	drop table if exists customer_type_identifier;




						/* create table customer type */
						create table customer_type_identifier(customer_type_id varchar(2) primary key,
																customer_type varchar(10) unique not null,
																customer_priority varchar(10) not null,
																customer_weightage int not null
															);
                            
                            
                            
					   /* Inserting values customer_type, customer_priority & customer_priority_weightage */                 
					  insert into customer_type_identifier value('N','NORMAL','NORMAL','5');               
					  insert into customer_type_identifier value('V','VIP','HIGH','10');                  
                            
								
                                
																	   
                                                                    /*execute the query*/
																	/* List records in 'location' table -->*/   
																														select * from customer_type_identifier;
                                                                                                                        
                                                                                                                        
                                                                                                                        
                                                                                                                        
                                                                                                                        
                                                                                                                        
                                                                                                                        
	/* Module 1 */												
                                                                                                                        
                                                                                                                        
	drop table if exists customer;

					create table customer(	customer_id decimal(10) primary key , 
											customer_name varchar(50) not null,
											customer_address varchar(50) not null,
										   
																								customer_country_id varchar(3) not null,
																								customer_state_id varchar(3) not null,
																								customer_city_id varchar(5) not null,
																								customer_loc_zip_code varchar(10) not null,
											
                                            customer_email varchar(30) unique not null,
											customer_gender varchar(1) not null,
											customer_contact_no decimal(10) unique not null,
											customer_dob date not null,
										   
																								customer_type varchar(2) not null,
										   
										   customer_reg_password varchar(20) not null,
											
											
											foreign key (customer_country_id) references country(country_id),
											foreign key (customer_state_id) references states(state_id),
											foreign key (customer_city_id) references cities(city_id),
											foreign key (customer_loc_zip_code) references city_pincode(zip_code),
											foreign key (customer_type) references customer_type_identifier(customer_type_id)
											);
                        
                        
                        
											insert into customer value('2019020001','Nikhil', '9-A/1 HTT apprt. Mayur Vihar' ,'IND','DL','DL','110091','Nikhil@123','M','7042645960','1995-12-15','V','Pmckinnon');
                                            
                                            insert into customer value('2019020002','Nik', '9-A/1 HTT apprt. Mayur Vihar' ,'IND','DL','DL','110091','Nikhil@gmail.com','M','7042645961','1995-12-15','V','Pmckinnon');
                                            
                                            
                                           
																																											
                                                                     
                                                                     
                                                                     Select max(customer_id) from customer;
																		
																																													select * from customer;
                                            
                                            
             
             
             	drop table if exists max_seat_capacity;
            
            
            
					create table max_seat_capacity(		bus_type varchar(20) primary key,
														max_seats  numeric(2) unique not null
                                                    );
                                            


                                            
														insert into max_seat_capacity value('A/C Semi Sleeper',35);
														insert into max_seat_capacity value('A/C Sleeper',25);
														insert into max_seat_capacity value('Non A/C seater',45);
																
                                            
                                            
                                            
																																									select * from max_seat_capacity;
             
             
             
             
             
            		/* Module 5 */
        /* Bus Registration , Route registration , Schedule Registration  */
        
        
        
			drop table if exists bus_details;
            
            
							create table bus_details( bus_id varchar(4) primary key,
													  bus_name varchar(20)  not null,
													  bus_type varchar(20)  not null,
                                                     
													  bus_capacity numeric(2) not null,
                                                      
                                                      
                                                      
														foreign key (bus_type) references max_seat_capacity(bus_type),
														foreign key (bus_capacity) references max_seat_capacity(max_seats)
                                                      
                                                    );
                                            
                                          
                                          ALTER TABLE bus_details ADD CONSTRAINT bus_name_type UNIQUE (bus_name,bus_type);

                                            
													insert into bus_details value('B101','KPN Travels','A/C Semi Sleeper',35);
													insert into bus_details value('B102','ABT Travels','A/C Semi Sleeper',35);
													insert into bus_details value('B103','PNK SRT Travels','A/C Sleeper',25);
													insert into bus_details value('B104','ABT Travels','Non A/C seater',45);
													insert into bus_details value('B105','KPN Travels','Non A/C seater',45);
													insert into bus_details value('B106','PNK SRT Travels','Non A/C seater',45);
									


                    
                    
																																					select * from bus_details;
                                             
                                            
                                     
                                            
                                            select lpad(cast(ifnull(max(cast(substr(bus_id,2) as decimal )),100)+1 as character),3,'0') as id from bus_details;
       
       
     
       /* Module 2 */                           
       
                   
                   
                   
			drop table if exists ticket_details;
                   
                   
                   create table ticket_details(		
													   ticket_id varchar(14) primary key,
													   customer_id decimal(10)  not null,
													   location_from varchar(20)  not null,
													   location_to varchar(20)  not null,
													   journey_date date not null,
													   number_of_tickets int not null,
													   
													   bus_id varchar(4) not null,
                                                       bus_time time not null,
													   ticket_charge numeric(5) not null,
													
													
														foreign key (customer_id) references customer(customer_id),
														foreign key (location_from) references cities(city_id),
														foreign key (location_to) references cities(city_id),
                                                        
														foreign key (bus_id) references bus_details(bus_id)
                                                
												);
                                                
                                                
                                                
                                                
                                            
                                              
													
                                                
                                                    select lpad(cast(ifnull(max(cast(substr(ticket_id,13) as decimal )),0)+1 as character),4,'0') as id from ticket_details;
                                                    
                                                    
                                                   
																									 delete from ticket_details where customer_id = '2019020001';															
                                                                                                     
                                                                                                     
                                                                                                     select * from ticket_details;
                                                
                                                
                                                
									
                                                       
																																
                                                                                                                                                                    
                                                                                                                                                                    
                                                                                                                                                                    
                                                                                                                                                                    
             drop table if exists route_details;
             
             
             
				create table route_details(	route_id varchar(100) primary key,
											route_from varchar(30) not null,
                                            route_to varchar(30) not null,
                                            travel_cost decimal(5),
                                            
                                            foreign key (route_from) references cities(city_id),
                                            foreign key (route_to) references cities(city_id)
                                            
                                            
                                            );
                                            
                                            
																			insert into route_details value('R1','DL','CHN',4000);
																			insert into route_details value('R2','DL','HBD',5000);
																			insert into route_details value('R3','HBD','CHN',2000);
																			insert into route_details value('R4','HBD','DL',5000);
																			insert into route_details value('R5','CHN','DL',4000); 
																			insert into route_details value('R6','CHN','HBD',2000); 
																									
                                            
																																								                                                                                                                                                                
                                                                                                                                                                
                                                                                                                                                                
                                                                                                                                                                select * from route_details;
                                                                                                                                                                
																				select lpad(cast(ifnull(max(cast(substr(route_id,2) as decimal )),0)+1 as character),1,'0') as route_id from route_details;       
                                                                                                                                                                
                                                                                                                                                                
                                                                                                                                                                
																																							
                                                                                                                                                            
              drop table if exists bus_schedule_details;
              
							create table bus_schedule_details(s_id varchar(100) primary key,
																	route_id  varchar(100)  not null,
																	bus_id varchar(4)  not null ,
																	schedule_time time not null,
                                                                    
                                                                    
																	
																	foreign key (route_id) references route_details(route_id),
																	foreign key (bus_id) references bus_details(bus_id)
                                                                    );
                                                                    
                                                                    
                                                                     ALTER TABLE bus_schedule_details ADD CONSTRAINT bus_route_id_time UNIQUE (route_id,bus_id,schedule_time);
																																		
																					insert into bus_schedule_details value('S1','R1','B101','100000');  
																					insert into bus_schedule_details value('S2','R2','B102','090000'); 
																					insert into bus_schedule_details value('S3','R3','B103','084500');
																					insert into bus_schedule_details value('S4','R4','B104','074500'); 
                                                                                    insert into bus_schedule_details value('S5','R2','B102','100000');
																					
																					
																																		
                                                                                                                                        
                                                                                                                                        
                                                                                                                                        
																																				select * from bus_schedule_details;
                                                                                                                                                
                                                                               
                
                
                
                
                
                drop table if exists bus_schedule_information;
                
						create table bus_schedule_information(s_id varchar(100) primary key,
															  date_of_journey date not null,
															  seats_avaliable decimal(10),
															  
															  foreign key (s_id) references  bus_schedule_details(s_id)
															  
															  );
                                                      
                
																							insert into  bus_schedule_information value('S1','2012-05-05',30);
																							
			
																							insert into  bus_schedule_information value('S2','2012-05-10',30);
																							insert into  bus_schedule_information value('S3','2012-05-11',30);
																							insert into  bus_schedule_information value('S4','2012-05-12',22);


																																					select *  from bus_schedule_information;
                                                                                                                                                    
                                                                                                                                                    select date_of_journey from bus_schedule_information where s_id = 'S1';
	  