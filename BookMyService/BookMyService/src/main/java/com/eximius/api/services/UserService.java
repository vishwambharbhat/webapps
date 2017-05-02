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
import com.eximius.api.models.Login_Model;
import com.eximius.api.models.User_Model;

public class UserService {
	Connection con=null;

	@Autowired
	UserLoginService loginService;

	//initialize connection
	public UserService() {

	}

	//add User	
	public User_Model addUser(User_Model user){
		PreparedStatement pst=null;
		try {
			Database_Connection database_Connection=new Database_Connection();
			con=database_Connection.getConection();
			pst=con.prepareStatement(QueryConstants.addUserSql);

			pst.setLong(1, user.getUserContactNumber());
			pst.setString(2, user.getUserName());
			String encrpt=EncryptPassword.encryptPass(user.getUserPassword());
			pst.setString(3, encrpt);


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
			finally {
				pst=null;
				con=null;
			}

		}
		Login_Model login=new Login_Model();
		login.setLoginNumber(user.getUserContactNumber());
		login.setLoginPassword(user.getUserPassword());

		loginService.addLogin(login);

		return user;
	}

	//get All Users
	public List<User_Model> getAllUsers(){

		List<User_Model> users=new ArrayList<User_Model>();
		Database_Connection database_Connection=new Database_Connection();
		con=database_Connection.getConection();
		Statement st=null;
		ResultSet rs=null;
		try {
			st = con.createStatement();
			rs=st.executeQuery(QueryConstants.getAllUsers);
			while(rs.next()){
				User_Model user=new User_Model();
				user.setUserContactNumber(rs.getLong(1));
				user.setUserName(rs.getString(2));
				user.setUserPassword(rs.getString(3));



				users.add(user);
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
			finally {
				rs=null;
				st=null;
				con=null;
			}

		}

		return users;
	}

	public User_Model getUserByContact(long contact_no){
		Database_Connection database_Connection=new Database_Connection();
		con=database_Connection.getConection();
		Statement pst=null;
		ResultSet rs=null;
		User_Model user=new User_Model();
		String sql=QueryConstants.getUserByContact+contact_no+"";
		try {
			pst=con.createStatement();

			rs=pst.executeQuery(sql);
			while(rs.next()){

				user.setUserContactNumber(rs.getLong(1));
				user.setUserName(rs.getString(2));
				user.setUserPassword(rs.getString(3));
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
			}finally {
				rs=null;
				pst=null;
				con=null;
			}

		}
		return user;
	}


	public void deleteUserByContact(long contact_no){

		Database_Connection database_Connection=new Database_Connection();
		con=database_Connection.getConection();
		PreparedStatement st=null;

		try {
			st = con.prepareStatement(QueryConstants.deleteUserByContact);
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
			finally {
				
				st=null;
				con=null;
			}
		}
		return;

	}

	public User_Model updateUserByContact(User_Model user) {
		PreparedStatement pt=null;
		Database_Connection database_Connection=new Database_Connection();
		con=database_Connection.getConection();
		if(user.getUserContactNumber()<=0){
			System.out.println("error with userId");
		}
		else{
			String sql=QueryConstants.updateUserByContact+user.getUserContactNumber()+"";
			try {
				pt=con.prepareStatement(sql);
				pt.setLong(1, user.getUserContactNumber());
				pt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				try{
					if(pt!=null){
					pt.close();
					}
					if(con!=null){
					con.close();
					}
				}catch (SQLException e) {
					e.printStackTrace();
				}
				finally {
					
					pt=null;
					con=null;
				}

			}

		}
		return user;
	}

}
