package com.eximius.api.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.eximius.api.DbConnection.Database_Connection;
import com.eximius.api.constants.QueryConstants;

import com.eximius.api.models.OrderModel;

public class Order_Service {
Connection con;
	
	@Autowired
	Engineer_Login_Service loginService;
	
	public Order_Service() {
		
	}
	
	//add User	
	public OrderModel addOrder(OrderModel order){
		Database_Connection database_Connection=new Database_Connection();
		con=database_Connection.getConection();
		PreparedStatement pst=null;
		try {
			pst=con.prepareStatement(QueryConstants.addOrder);
			
			 java.sql.Date dateOrdered = new java.sql.Date(order.getDateOfOrder().getTime());
			 java.sql.Date dateApplied = new java.sql.Date(new java.util.Date().getTime());
			
			pst.setDate(1, dateApplied);
			pst.setDate(2,dateOrdered );
			pst.setString(3, order.getTimeOfOrder());
			pst.setString(4, order.getServiceName());
			pst.setString(5, order.getOrderAddress());
			pst.setLong(6, order.getOrderPinCode());
			pst.setBigDecimal(7, order.getLattitude());
			pst.setBigDecimal(8, order.getLongitude());
			pst.setLong(9, order.getUserContact());
			pst.setLong(10, order.getEnggContact());
			pst.setString(11, order.getOrderDescription());
			pst.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				if(pst!=null){
					pst.close();
				}
				if(con!=null){
				con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				
				pst=null;
				con=null;
			}
			
		}
		
		return order;
	}

	//get All Users
	public List<OrderModel> getAllOrders(){
		Database_Connection database_Connection=new Database_Connection();
		con=database_Connection.getConection();
		List<OrderModel> orders=new ArrayList<OrderModel>();

		Statement st=null;
		ResultSet rs=null;
		try {
			st = con.createStatement();
			rs=st.executeQuery(QueryConstants.getAllOrders);
			while(rs.next()){
				OrderModel order=new OrderModel();
				order.setOrderId(rs.getLong(1));
				order.setDateOfApplied(rs.getDate(2));
				order.setDateOfOrder(rs.getDate(3));
				order.setTimeOfOrder(rs.getString(4));
				order.setServiceName(rs.getString(5));
				order.setOrderAddress(rs.getString(6));
				order.setOrderPinCode(rs.getInt(7));
				order.setLattitude(rs.getBigDecimal(8));
				order.setLongitude(rs.getBigDecimal(9));
				order.setUserContact(rs.getLong(10));
				order.setEnggContact(rs.getLong(11));
				order.setOrderDescription(rs.getString(12));
				order.setAcceptDate(rs.getDate(13));
				orders.add(order);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
			try {
				if(rs!=null){
					rs.close();
				}
				if(st!=null){
					st.close();
				}
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				rs=null;
				st=null;
				con=null;
			}
			
		}

		return orders;
	}

public List<OrderModel> getAllOrders(long pincode){
	Database_Connection database_Connection=new Database_Connection();
	con=database_Connection.getConection();
		List<OrderModel> orders=new ArrayList<OrderModel>();

		Statement st=null;
		ResultSet rs=null;
		try {
			st = con.createStatement();
			rs=st.executeQuery(QueryConstants.getAllOrdersPincode+pincode+" "+QueryConstants.orderByDateOfOrder);
			while(rs.next()){
				OrderModel order=new OrderModel();
				order.setOrderId(rs.getLong(1));
				order.setDateOfApplied(rs.getDate(2));
				order.setDateOfOrder(rs.getDate(3));
				order.setTimeOfOrder(rs.getString(4));
				order.setServiceName(rs.getString(5));
				order.setOrderAddress(rs.getString(6));
				order.setOrderPinCode(rs.getInt(7));
				order.setLattitude(rs.getBigDecimal(8));
				order.setLongitude(rs.getBigDecimal(9));
				order.setUserContact(rs.getLong(10));
				order.setEnggContact(rs.getLong(11));
				order.setOrderDescription(rs.getString(12));
				order.setAcceptDate(rs.getDate(13));
				orders.add(order);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
finally{
			
			try {
				if(rs!=null){
					rs.close();
				}
				if(st!=null){
					st.close();
				}
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				rs=null;
				st=null;
				con=null;
			}
			
		}
		return orders;
	}
	
public List<OrderModel> getAllOrdersByContact(long contact){
	Database_Connection database_Connection=new Database_Connection();
	con=database_Connection.getConection();
	List<OrderModel> orders=new ArrayList<OrderModel>();

	Statement st=null;
	ResultSet rs=null;
	try {
		st = con.createStatement();
		rs=st.executeQuery(QueryConstants.getAllOrdersContact+contact+" "+QueryConstants.orderByDateOfAccept);
		while(rs.next()){
			OrderModel order=new OrderModel();
			order.setOrderId(rs.getLong(1));
			order.setDateOfApplied(rs.getDate(2));
			order.setDateOfOrder(rs.getDate(3));
			order.setTimeOfOrder(rs.getString(4));
			order.setServiceName(rs.getString(5));
			order.setOrderAddress(rs.getString(6));
			order.setOrderPinCode(rs.getInt(7));
			order.setLattitude(rs.getBigDecimal(8));
			order.setLongitude(rs.getBigDecimal(9));
			order.setUserContact(rs.getLong(10));
			order.setEnggContact(rs.getLong(11));
			order.setOrderDescription(rs.getString(12));
			order.setAcceptDate(rs.getDate(13));
			orders.add(order);
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally{
		
		try {
			if(rs!=null){
				rs.close();
			}
			if(st!=null){
				st.close();
			}
			if(con!=null){
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			rs=null;
			st=null;
			con=null;
		}
		
	}
	return orders;
}

	public OrderModel getOrderById(long orderId){
		Database_Connection database_Connection=new Database_Connection();
		con=database_Connection.getConection();
		OrderModel order=new OrderModel();
		String sql=QueryConstants.getOrderById+orderId+"";
		Statement pst=null;
		ResultSet rs=null;
		try {
			pst=con.createStatement();
			
			 rs=pst.executeQuery(sql);
			while(rs.next()){
				order.setOrderId(rs.getLong(1));
				order.setDateOfApplied(rs.getDate(2));
				order.setDateOfOrder(rs.getDate(3));
				order.setTimeOfOrder(rs.getString(4));
				order.setServiceName(rs.getString(5));
				order.setOrderAddress(rs.getString(6));
				order.setOrderPinCode(rs.getInt(7));
				order.setLattitude(rs.getBigDecimal(8));
				order.setLongitude(rs.getBigDecimal(9));
				order.setUserContact(rs.getLong(10));
				order.setEnggContact(rs.getLong(11));
				order.setOrderDescription(rs.getString(12));
				order.setAcceptDate(rs.getDate(13));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
finally{
			
			try {
				if(rs!=null){
					rs.close();
				}
				if(pst!=null){
					pst.close();
				}
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				rs=null;
				pst=null;
				con=null;
			}
			
		}
		return order;
	}


	public void deleteOrderById(long orderId){
		Database_Connection database_Connection=new Database_Connection();
		con=database_Connection.getConection();
		PreparedStatement st =null;	
		try {
			st= con.prepareStatement(QueryConstants.deleteOrderById);
			st.setLong(1,orderId);
			st.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
finally{
			
			try {
				
				if(st!=null){
					st.close();
					}
					if(con!=null){
						con.close();
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				
				st=null;
				con=null;
			}
			
		}
		return;
		
	}

	public OrderModel updateOrderById(OrderModel order) {
		Database_Connection database_Connection=new Database_Connection();
		con=database_Connection.getConection();
		PreparedStatement pt=null;
		if(order.getOrderId()<=0){
			System.out.println("error with userId");
		}
		else{
			String sql=QueryConstants.updateOrderById+order.getOrderId()+" "+QueryConstants.orderByDateOfOrder;
			try {
				java.sql.Date acceptDate = null;
				 pt=con.prepareStatement(sql);
				pt.setLong(1, order.getEnggContact());
				if(order.getEnggContact()!=0){
					acceptDate = new java.sql.Date(new java.util.Date().getTime());
				}
				pt.setDate(2, acceptDate);
				pt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
finally{
			
			try {
				
				if(pt!=null){
					pt.close();
					}
					if(con!=null){
					con.close();
					}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				
				pt=null;
				con=null;
			}
			
		}
		}
		return order;
	}
}
