package com.btrs.service.constants;

public class QueryConstants {

	public static final String VERIFY_LOGIN = "Select user_name,pass_word,role from login_data where user_id = ?";
	
	
	//Module 1 Queries
	public static final String GET_CUSTOMER_ID = "Select max(customer_id) from customer";
	public static final String REGISTER_NEW_CUSTOMER = "insert into customer(customer_id,customer_name,customer_address,customer_country_id,customer_state_id, customer_city_id,customer_loc_zip_code,customer_email,customer_gender,customer_contact_no,customer_dob,customer_type,customer_reg_password) value(?,?,?,?,?,?,?,?,?,?,?,?,?)";


	//Module - 4 Queries
	
	//View/Get Specific Customer
	public static final String UPDATE_CUSTOMER_ID = "Select * from customer where customer_id = ?";
	
	
	//Update Specific Customer
	public static final String UPDATE_CUSTOMER = "Update Customer set customer_name=? , customer_address=? , customer_country_id=? , customer_state_id = ? , customer_city_id = ? , customer_loc_zip_code=? , customer_email = ? where customer_id=?";

	
	//View All Customers
	public static final String VIEW_CUSTOMER_RECORDS = "Select * from customer";

	//Delete Specific Customer
	public static final String DELETE_EXISTING_CUSTOMER = "Delete from customer where customer_id = ?";

	
	
	


	public static final String CUSTOMER_RESERVED_TICKETS = "select * from ticket_details where customer_id = ?";


	public static final String CANCEL_RESERVED_TICKETS = "delete from ticket_details where ticket_id = ?";

	
	
	
	
	
//Booking Queries
	public static final String GET_BOOKING_ID = "Select * from customer where customer_id = ?";
	
	
	
	
	
	public static final String TICKETS_BOOKED_BY = "Select * from customer where customer_id = ?";


	public static final String GET_LOCATION_DETAILS = "Select route_id from route_details where route_from = ? and route_to = ?";


	public static final String GET_SCHEDULE = "Select s_id from bus_schedule_details where route_id = ?";


	public static final String GET_AVALIABLE_JOURNEY_DATES = "select date_of_journey from bus_schedule_information where s_id = ?";


	public static final String GET_SCHEDULE_INFORMATION = "select s_id from bus_schedule_information where date_of_journey = ?";


	public static final String GET_BUS_INFORMATION = " select (select bus_id from bus_schedule_details where s_id = ?),bus_name from bus_details";


	public static final String GET_SEAT_INFORMATION = "select seats_avaliable from bus_schedule_information where s_id = ?";


	public static final String GET_TIME_INFORMATION = "select schedule_time from bus_schedule_details where s_id = ?";


	public static final String GET_COST_INFORMATION = "select travel_cost from route_details where route_from = ? and route_to = ?";


	public static final String GET_TICKET_ID = "select lpad(cast(ifnull(max(cast(substr(ticket_id,13) as decimal )),0)+1 as character),4,'0') as ticket_id from ticket_details";


	public static final String BOOKTICKETS = "insert into ticket_details(ticket_id,customer_id,location_from,location_to,journey_date,number_of_tickets,bus_id,bus_time,ticket_charge) value(?,?,?,?,?,?,?,?,?)";


	public static final String VIEWTICKET = "select * from ticket_details where ticket_id = ?";


	
	
	
	
	//Route Info
	//Route ID
	public static final String GENERATE_ROUTE_ID = "select lpad(cast(ifnull(max(cast(substr(route_id,2) as decimal )),0)+1 as character),1,'0') as route_id from route_details";

	//ADD NEW ROUTE
	public static final String ADD_NEW_ROUTE = "insert into route_details(route_id, route_from, route_to, travel_cost) value(?,?,?,?)";


	
	
	
	
	
	
	
	
	
	
	
	
	
	//------------------------------------------------------------------ Pre-fill --------------------------------------------------------------------------
	
	
	//GPS
	//Countries
	public static final String GET_COUNTRIES = "Select * from country";

	//States
	public static final String GET_STATES = "Select * from states";

	//Cities
	public static final String GET_CITIES = "Select * from cities";

	//Customer Type
	public static final String GET_CUSTOMER_TYPE = "select * from customer_type_identifier";


	
	
	
	
	//BUS TYPES
	public static final String GET_BUS_TYPES = "Select * from max_seat_capacity";

	//GET ROUTES
	public static final String GET_ROUTE_IDS = "Select route_id from  Route_Details where from = ? and to = ?";






	
	//GENERATE BUS ID
	public static final String GET_BUS_ID = "select lpad(cast(ifnull(max(cast(substr(bus_id,2) as decimal )),100)+1 as character),3,'0') as bus_id from bus_details";

	//ADD NEW BUS
	public static final String ADD_NEW_BUS = "insert into bus_details(bus_id, bus_name, bus_type, bus_capacity) value(?,?,?,?)";

	//GET BUSSES
	public static final String GET_BUSSES = "select bus_id,bus_name from bus_details";


	public static final String GET_ZIPCODES = "Select * from city_pincode";
	
	
	
	

}