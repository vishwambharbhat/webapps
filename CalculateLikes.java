import java.sql.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBConnection.DbUtil;

public class CalculateLikes extends HttpServlet {
	Connection con;
	DbUtil db=new DbUtil();
	public CalculateLikes(){
		con=db.getConnection();
	}
public  void doGet(HttpServletRequest request,HttpServletResponse response){
	long vid=0;
	String action=request.getParameter("action");
	if(action.equalsIgnoreCase("edit")){
	 vid=Long.parseLong(request.getParameter("vid"));
	 System.out.println(vid);
	}
	Statement st1,st2,st3;
	long likes=0;
	try {
		st1 = con.createStatement();
		ResultSet rs1=st1.executeQuery("select likes from video_table where vid="+vid);
		while(rs1.next()){
			likes=rs1.getLong(1);
			 System.out.println("before liking video: "+likes);
		}
		likes++;
		 System.out.println("after liking video: "+likes);
		st2=con.createStatement();
		ResultSet rs2=st2.executeQuery("update video_table set likes="+likes+" where vid="+vid);
		
		/*st3=con.createStatement();
		ResultSet rs=st3.executeQuery("insert into likeflag values("+Long.parseLong(request.getAttribute("user_id").toString())+","+vid+",1");
		*/
		request.getRequestDispatcher("home.jsp").forward(request, response);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
