import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBConnection.DbUtil;

public class DeleteVideoById extends HttpServlet {
	Connection con;
	DbUtil db=new  DbUtil();
	public DeleteVideoById() {
		con=db.getConnection();
	}
public void doGet(HttpServletRequest request,HttpServletResponse response){
	String action=request.getParameter("action");
	if(action.equalsIgnoreCase("delete")){
		long vid=Long.parseLong(request.getParameter("vid"));
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("delete from video_table where vid="+vid);
		request.getRequestDispatcher("channel.jsp").forward(request, response);
		} catch (SQLException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
}
