import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBConnection.DbUtil;

public class Deletechnl extends HttpServlet {
	Connection con;
	DbUtil db=new  DbUtil();
	public Deletechnl() {
		con=db.getConnection();
	}
public void doGet(HttpServletRequest request,HttpServletResponse response){
	String action=request.getParameter("action");
	if(action.equalsIgnoreCase("delete")){
		long chid=Long.parseLong(request.getParameter("ch_id"));
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("delete from video_table where CH_ID="+chid);
			
			Statement st2=con.createStatement();
			ResultSet rs2=st2.executeQuery("delete from channel where CH_ID="+chid);
		request.getRequestDispatcher("channel.jsp").forward(request, response);
		} catch (SQLException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//end
		}
		
	}
}
}
