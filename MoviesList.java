import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBConnection.DbUtil;

public class MoviesList extends HttpServlet {
	Connection con;
	DbUtil db=new DbUtil();
	public MoviesList(){
		con=db.getConnection();
	}
public void doGet(HttpServletRequest request,HttpServletResponse response){
	
	try {
		PrintWriter out=response.getWriter();
		out.println("<html><head>");
		out.println(" <link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\">");
		out.println(" <link rel=\"stylesheet\" href=\"http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css\">");
		out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js\"></script>");
		out.println("<script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\"></script>");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select vname,video_url from video_table where cat_id=2");
		out.print("<ul class=\"list-unstyled list-inline\">");
		while(rs.next()){
			String str=rs.getString(2);
			String strs[]=str.split("/");
			System.out.println(strs[6]+"/"+strs[7]);
			
			out.print("<li><a href=\""+strs[6]+"/"+strs[7]+"\"><button style=\"width:100px;height:90px;padding:0.88%;\"><img src=\"videoimg2.png\" height=\"50px\" width=\"80px\"><br>"+rs.getString(1)+"</button></a></li>");
		}
		out.print("<ul>");
		
	} catch (SQLException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
