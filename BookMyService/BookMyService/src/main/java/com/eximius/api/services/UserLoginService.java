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
import com.eximius.api.models.Login_Model;


public class UserLoginService {
	Connection con;
	public UserLoginService() {

	}

	//add User	
	public Login_Model addLogin(Login_Model login){
		Database_Connection database_Connection=new Database_Connection();
		con=database_Connection.getConection();
		PreparedStatement pst=null;
		try {
			pst=con.prepareStatement(QueryConstants.addUserLogin);

			pst.setLong(1, login.getLoginNumber());
			String encrpt=EncryptPassword.encryptPass(login.getLoginPassword());
			pst.setString(2, encrpt);


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
		return login;
	}

	//get All Users
	public List<Login_Model> getAllUserLoginServices(){
		Database_Connection database_Connection=new Database_Connection();
		con=database_Connection.getConection();

		List<Login_Model> logins=new ArrayList<Login_Model>();

		Statement st=null;
		ResultSet rs=null;
		try {
			st = con.createStatement();
			rs=st.executeQuery(QueryConstants.getAllUserLogin);
			while(rs.next()){
				Login_Model login=new Login_Model();
				login.setLoginNumber(rs.getLong(1));
				login.setLoginPassword(rs.getString(2));



				logins.add(login);
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

		return logins;
	}

	public Login_Model getUseLoginByContact(long contact_no){
		Database_Connection database_Connection=new Database_Connection();
		con=database_Connection.getConection();
		Login_Model login=new Login_Model();
		Statement pst=null;
		ResultSet rs=null;
		String sql=QueryConstants.getUserLoginByContact+contact_no+"";
		try {
			pst=con.createStatement();

			rs=pst.executeQuery(sql);
			while(rs.next()){

				login.setLoginNumber(rs.getLong(1));
				login.setLoginPassword(rs.getString(2));
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
			}finally{
				rs=null;
				pst=null;
				con=null;
			}


		}
		return login;
	}


	public void deleteUseLoginByContact(long contact_no){
		Database_Connection database_Connection=new Database_Connection();
		con=database_Connection.getConection();
		PreparedStatement st=null;
		try {
			st = con.prepareStatement(QueryConstants.deleteUserLoginByContact);
			st.setLong(1,contact_no);
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

	public Login_Model updateUseLoginByContact(Login_Model login) {
		Database_Connection database_Connection=new Database_Connection();
		con=database_Connection.getConection();
		PreparedStatement pt=null;
		if(login.getLoginNumber()<=0){
			System.out.println("error with userId");
		}
		else{
			String sql=QueryConstants.updateUserLoginByContact+login.getLoginNumber()+"";
			try {
				pt=con.prepareStatement(sql);
				pt.setString(1, login.getLoginPassword());
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
		return login;
	}
	public boolean getValidateStaus(Login_Model login){
		long cont_no=login.getLoginNumber();
		String encrpt=EncryptPassword.encryptPass(login.getLoginPassword());
		Login_Model login2=getUseLoginByContact(cont_no);
		System.out.println("password encpt :"+encrpt);
		System.out.println("service  username :"+login2.getLoginNumber()+"password :"+login2.getLoginPassword());
		if(login2.getLoginNumber()==cont_no&&login2.getLoginPassword().equals(encrpt)){
			return true;
		}
		return false;
	}
}
