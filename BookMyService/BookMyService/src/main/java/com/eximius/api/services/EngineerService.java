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
import com.eximius.api.models.EnginnerModel;
import com.eximius.api.models.Login_Model;


public class EngineerService {
	Connection con;
	
	@Autowired
	Engineer_Login_Service loginService;
	
	public EngineerService() {
		
	}
	
	//add User	
	public EnginnerModel addEngineer(EnginnerModel engg){
		Database_Connection database_Connection=new Database_Connection();
		con=database_Connection.getConection();
		PreparedStatement pst=null;
		try {
			pst=con.prepareStatement(QueryConstants.addEngineer);
			
			pst.setLong(1, engg.getEnggContactNumber());
			pst.setString(2, engg.getEnggName());
			pst.setString(3, engg.getEnggDesignation());
			String encrpt=EncryptPassword.encryptPass(engg.getEnggPassword());
			pst.setString(4, encrpt);
			pst.setString(5, engg.getEnggAddress());
			pst.setLong(6, engg.getEnggPinCode());
			pst.setBigDecimal(7, engg.getLattitude());
			pst.setBigDecimal(8, engg.getLongitude());
			
			pst.setString(9, engg.getImageUrl());
			
			pst.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
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
		
		Login_Model login=new Login_Model();
		login.setLoginNumber(engg.getEnggContactNumber());
		login.setLoginPassword(engg.getEnggPassword());
		
		loginService.addLogin(login);
		return engg;
	}

	//get All Users
	public List<EnginnerModel> getAllEngineers(){
		Database_Connection database_Connection=new Database_Connection();
		con=database_Connection.getConection();
		List<EnginnerModel> enggs=new ArrayList<EnginnerModel>();

		Statement st=null;
		ResultSet rs=null;
		try {
			st = con.createStatement();
			rs=st.executeQuery(QueryConstants.getAllEngineers);
			while(rs.next()){
				EnginnerModel engg=new EnginnerModel();
				engg.setEnggContactNumber(rs.getLong(1));
				engg.setEnggName(rs.getString(2));
				engg.setEnggDesignation(rs.getString(3));
				engg.setEnggPassword(rs.getString(4));
				engg.setEnggAddress(rs.getString(5));
				engg.setEnggPinCode(rs.getInt(6));
				engg.setLattitude(rs.getBigDecimal(7));
				engg.setLongitude(rs.getBigDecimal(8));
				engg.setImageUrl(rs.getString(9));
				enggs.add(engg);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
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
		return enggs;
	}

	public EnginnerModel getEngineerByContact(long contact_no){
		Database_Connection database_Connection=new Database_Connection();
		con=database_Connection.getConection();
		EnginnerModel engg=new EnginnerModel();
		String sql=QueryConstants.getEngineerByContact+contact_no+"";
		Statement pst=null;
		ResultSet rs=null;
		try {
		pst=con.createStatement();
			
			 rs=pst.executeQuery(sql);
			while(rs.next()){
				engg.setEnggContactNumber(rs.getLong(1));
				engg.setEnggName(rs.getString(2));
				engg.setEnggDesignation(rs.getString(3));
				engg.setEnggPassword(rs.getString(4));
				engg.setEnggAddress(rs.getString(5));
				engg.setEnggPinCode(rs.getInt(6));
				engg.setLattitude(rs.getBigDecimal(7));
				engg.setLongitude(rs.getBigDecimal(8));
				engg.setImageUrl(rs.getString(9));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
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
		return engg;
	}


	public void deleteEngineerByContact(long contact_no){
		Database_Connection database_Connection=new Database_Connection();
		con=database_Connection.getConection();
		PreparedStatement st=null;	
		try {
			 st= con.prepareStatement(QueryConstants.deleteEngineerByContact);
			st.setLong(1,contact_no);
			st.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
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

	public EnginnerModel updateEngineerByContact(EnginnerModel engg) {
		Database_Connection database_Connection=new Database_Connection();
		con=database_Connection.getConection();
		PreparedStatement pt=null;
		if(engg.getEnggContactNumber()<=0){
			System.out.println("error with userId");
		}
		else{
			String sql=QueryConstants.updateUserLoginByContact+engg.getEnggContactNumber()+"";
			try {
				pt=con.prepareStatement(sql);
				pt.setString(1, engg.getEnggName());
				pt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
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
		return engg;
	}
}
