package com.eximius.api.constants;

public class QueryConstants {



	//user_crud operations
	public final static String addUserSql="insert into user_details(contact_number,contact_name,user_password) values(?,?,?)";

	public final  static  String getAllUsers="select * from user_details";

	public final  static  String getUserByContact="select * from user_details where contact_number=";

	public  final static  String deleteUserByContact= "delete from user_details where contact_no=?";

	public final   static  String updateUserByContact="update user_details set contact_name=? where contact_number=";



	//user_login_crud operations
	public final   static  String addUserLogin="insert into login_details(contact_number,user_password) values(?,?)";

	public final   static  String getAllUserLogin="select * from login_details";

	public final   static  String getUserLoginByContact="select * from login_details where contact_number=";

	public final   static  String deleteUserLoginByContact="delete from login_details where contact_number=?";

	public final   static  String updateUserLoginByContact="update login_details set user_password=? where contact_number=";



	//Order_crud opeartions
	public final   static  String addOrder="insert into order_details(date_applied,date_of_order,time_of_order,service_name,address,pincode,lattitude,longitude,user_contact,engg_contact,description,status) values(?,?,?,?,?,?,?,?,?,?,?,?)";

	public final   static  String getAllOrders="select * from order_details";
	public final   static  String getAllOrdersPincode="select * from order_details where pincode=";
	public final   static  String getAllOrdersContact="select * from order_details where accept_date IS NOT NULL AND user_contact=";
	public final   static String getOrderById="select * from order_details where order_id=";
	public final   static String orderByDateOfOrder="ORDER BY date_of_order desc";
	public final   static String orderByDateOfAccept="ORDER BY accept_date desc";

	public final   static String deleteOrderById="delete from order_details where order_id=?";

	public final   static String updateOrderById="update order_details set engg_contact=?,accept_date=? where order_id=";


	//Enginner_crud operations
	public final   static String addEngineer="insert into engineer_details(engg_contact,engg_name,engg_designation,engg_password,engg_address,engg_pincode,engg_lattitude,engg_longitude,engg_image) values(?,?,?,?,?,?,?,?,?)";

	public final   static String getAllEngineers="select * from engineer_details";

	public final   static String getEngineerByContact="select * from engineer_details where engg_contact=";

	public final   static String deleteEngineerByContact="delete from engineer_details where engg_contact=?";

	public final   static String updateEngineerByContact="update engineer_details set engg_name=? where engg_contact=";


	//Engineer_login_crud operations
	public final   static  String addEnggLogin="insert into engg_login(contact_number,engg_password) values(?,?)";

	public final   static  String getAllEnggLogin="select * from engg_login";

	public final   static  String getEnggLoginByContact="select * from engg_login where contact_number=";

	public final   static  String deleteEnggLoginByContact="delete from engg_login where contact_number=?";

	public final   static  String updateEnggLoginByContact="update engg_login set engg_password=? where contact_number=";
	
	
	//Service_crud operations
	public final   static String addService="insert into services(service_name,service_description,price) values(?,?,?)";

	public final   static  String getAllService="select * from services";

	public final   static  String getServiceByName="select * from services where service_name='";

	public final   static  String deleteServiceByName= "delete from services where service_name=?";

	public final   static  String updateServiceByName="update services set service_description=? where service_name='";

}
