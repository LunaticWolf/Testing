use amululu;


select * from states;
select * from insurance_plan;



	drop table if exists patient_details;
	/* Patient Table */
							create table patient_details(patient_id int primary key auto_increment,
														 first_name varchar(20) not null,
														 last_name varchar(20),
														 pass_word varchar(15) not null,
														 dob date not null,
														 email varchar(25),
														 contact_number decimal(12) unique not null,
														 
														 state_id varchar(2) not null,
														 iplan_id varchar(2) not null,
														 
														 foreign key (iplan_id) references insurance_plan(iplan_id),
														 foreign key (state_id) references states(state_id),
														 /*foreign key (state_id) references states(state_id)*/
														 unique(first_name,last_name)
														 );
                             
                             /*foreign key(first_name,last_name) references patient_name(first_name,last_name)*/
							
                              
                             
                       
                       
                       
                       
						insert into patient_details(first_name,last_name,pass_word,dob,email,contact_number,state_id,iplan_id) value('Akhila','Burra', 'burrraknow','1997-05-05','akhilaburra@burra.no','999999899','AN','P1');
                        insert into patient_details(first_name,last_name,pass_word,dob,email,contact_number,state_id,iplan_id) value('Akhila','Burra', 'burrraknow','1997-05-05','ahilaburra@burra.no','999989999','AN','P2');
                       
                             
                             
						select * from patient_details;
                             
                             
                             
                             
                             
                             
                             
  select * from states;  
  select * from insurance_plan;
                             
 drop table if exists department;
 
 create table department(department_id varchar(2) primary key,
						 department_name varchar(20) unique not null
                         );
                         
                         
                         
                         insert into department value('D1','Department1');
                         insert into department value('D2','Department2');
                         insert into department value('D3','Department3');
                         insert into department value('D4','Department4');
                         insert into department value('D5','Department5');
                             
                             
                             
                             select * from department;
                             
                             
                             
                             
                             
 drop table if exists physician_details;                            
                   
                   
                   create table physician_details(physician_id varchar(5) primary key,
												  first_name varchar(20) not null,
												  last_name varchar(20),
                                                  department_id varchar(3) not null,
                                                  edu_qualification varchar(30) not null,
                                                  experience int not null,
                                                  state_id varchar(2) not null,
                                                  iplan_id varchar(2) not null,
                                                  
                                                  foreign key (state_id) references states(state_id),
                                                  foreign key (iplan_id) references insurance_plan(iplan_id),
                                                  foreign key (department_id) references Department(department_id)
                                                  
                                                  );
                                                  
                                                  
                             
                             insert into physician_details value('PR002', 'Amululu','ululu','d1','B.Tech',0,'AP','P1');
                             
                             
                             select * from physician_details;
                             
                             
                             
                             
                             
                             
  drop table if exists mode_of_payment;
  
  create table MOP(mop_id varchar(2) primary key,
                   payment_method varchar(15) unique not null
                   );
                   
                   insert into MOP value('CC','Credit Card');
                      insert into MOP value('DC','Debit Card');
                         insert into MOP value('C','Cash');
                         
                         select * from MOP;
                   
                             
                             
                             
                             
  drop table if exists patient_diagnosis;
  
	create table patient_diagnosis(patient_id int not null,
								   diagnosis_id int(10) primary key auto_increment,
                                   symptoms varchar(255),
                                   diagnosis_provided varchar(255),
                                   administered_by varchar(5) not null,
                                   date_of_diagnosis date not null,
                                   follow_up_required boolean not null,
                                   date_of_follow_up date not null,
								   bill_amount double not null,
                                   card_number decimal(12) not null,
                                   mop_id varchar(2) not null,
                                   
                                   
                                   
                                   
								   foreign key (patient_id) references patient_details(patient_id),
                                   foreign key (administered_by) references physician_details(physician_id),
                                   foreign key (mop_id) references mop(mop_id)
                                   
                                   
                                   );
                                    
                             
                             
                             
                             
                             insert into patient_diagnosis value(1,121364985,'lulu fever','eat chicken' ,'PR002','2018-08-08',true,'2018-12-12','500.00','124595634862','DC');
                             
                             
                             select * from patient_diagnosis;
                             
                             
                             
                             
                             
                             
                             