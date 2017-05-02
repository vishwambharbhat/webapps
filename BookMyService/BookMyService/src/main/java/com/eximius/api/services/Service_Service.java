package com.eximius.api.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.eximius.api.DbConnection.Database_Connection;
import com.eximius.api.constants.QueryConstants;

import com.eximius.api.models.Service_Model;
public class Service_Service {
Connection con;
	
	
	
	//initialize connection
	public Service_Service() {
		
	}
	
//add User	
public Service_Model addService(Service_Model service){
	Database_Connection database_Connection=new Database_Connection();
	con=database_Connection.getConection();
	PreparedStatement pst=null;
	try {
		pst=con.prepareStatement(QueryConstants.addService);
		
		
		pst.setString(1, service.getServiceName());
		pst.setString(2, service.getServiceDescription());
		pst.setLong(3, service.getServicePrice());		
		
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
	
	
	return service;
}

//get All Users
public List<Service_Model> getAllServices(){
	Database_Connection database_Connection=new Database_Connection();
	con=database_Connection.getConection();
	List<Service_Model> services=new ArrayList<Service_Model>();

	Statement st=null;
	ResultSet rs=null;
	try {
		st = con.createStatement();
		rs=st.executeQuery(QueryConstants.getAllService);
		while(rs.next()){
			Service_Model service=new Service_Model();
			service.setServiceId(rs.getLong(1));
			service.setServiceName(rs.getString(2));
			service.setServiceDescription(rs.getString(3));
			service.setServicePrice(rs.getLong(4));
			
			
			services.add(service);
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

	return services;
}

public Service_Model getServiceByName(String serv_name){
	Database_Connection database_Connection=new Database_Connection();
	con=database_Connection.getConection();
	Service_Model service=new Service_Model();
	ResultSet rs=null;
	Statement pst=null;
	String sql=QueryConstants.getServiceByName+serv_name+"'";
	try {
		pst=con.createStatement();
		
		rs=pst.executeQuery(sql);
		while(rs.next()){
			
			service.setServiceId(rs.getLong(1));
			service.setServiceName(rs.getString(2));
			service.setServiceDescription(rs.getString(3));
			service.setServicePrice(rs.getLong(4));
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
	return service;
}


public void deleteServiceByName(String serv_name){
	Database_Connection database_Connection=new Database_Connection();
	con=database_Connection.getConection();
	PreparedStatement st=null;	
	try {
		st = con.prepareStatement(QueryConstants.deleteServiceByName);
		st.setString(1,serv_name);
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

public Service_Model updateServiceByName(Service_Model service) {
	Database_Connection database_Connection=new Database_Connection();
	con=database_Connection.getConection();
	PreparedStatement pt=null;
	if(service.getServiceName()!=null){
		System.out.println("error with userId");
	}
	else{
		String sql=QueryConstants.updateEnggLoginByContact+service.getServiceName()+"'";
		try {
			pt=con.prepareStatement(sql);
			pt.setString(1, service.getServiceName());
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
	
	return service;
}

}
