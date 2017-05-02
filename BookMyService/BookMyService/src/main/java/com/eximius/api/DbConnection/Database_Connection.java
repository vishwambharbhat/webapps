package com.eximius.api.DbConnection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database_Connection {
	public Database_Connection() {
		// TODO Auto-generated constructor stub
	}
	private   Connection con=null;
	public   Connection getConection(){
		if(con!=null){
			return con;
		}
		else{
			try {
				Properties prop=new Properties();
				InputStream is=Database_Connection.class.getClassLoader().getResourceAsStream("/db.properties");
				prop.load(is);
				String driver=prop.getProperty("driver");
				String url=prop.getProperty("url");
				String user=prop.getProperty("user");
				String password=prop.getProperty("password");
				
				Class.forName(driver);
				con=DriverManager.getConnection(url,user,password);
				
				
				
			} catch (IOException | ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return con;
	}
}
