import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBConnection.DbUtil;

public class ListChannel extends HttpServlet {
Connection con;
DbUtil db=new DbUtil();
public ListChannel(){
	con=db.getConnection();
}
public void doGet(HttpServletRequest request,HttpServletResponse response){
	try {
		PrintWriter out=response.getWriter();
		Statement st=con.createStatement();
		HttpSession session=request.getSession();
		String uid=session.getAttribute("user_id").toString();
		ResultSet rs=st.executeQuery("select ch_id, ch_name from channel where user_id="+uid);
		
		out.println("<html><head>");
		out.println(" <link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\">");
		out.println(" <link rel=\"stylesheet\" href=\"http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css\">");
		out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js\"></script>");
		out.println("<script src=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\"></script>");
		out.println(" <link rel=\"stylesheet\" href=\"danger.css\">");
		out.println("<script language=\"javascript\" >");
	       RequestDispatcher rd=request.getRequestDispatcher("jquery.js");   //include javascript file
	       
	       rd.include(request, response);
	       
	       out.println("</script>");
		while(rs.next()){
			
			out.println("<div class=\"row\"><div  class=\"col-sm-12 chn\" style=\"background-color:#FEF9E7;padding:1.2%;border:1px solid #eee;\"><a style=\"color:#EC7063;font-size:22px;font-weight:bold;\" href=\"videoupload?action=edit&chid="+rs.getLong(1)+"\"><span class=\"glyphicon glyphicon-triangle-right\"></span>"+rs.getString(2)+"</a><a href=\"dltchnl?action=delete&ch_id="+rs.getLong(1)+"\"><span id=\"rem\" class=\"glyphicon glyphicon-remove-sign \" onclick=\"myFunction() \"></span></a></div></div><br><br>");
		out.println("<div class=\"panel panel-default\">");
		out.println("<div class=\"panel-body\">");
		Statement st2=con.createStatement();
		ResultSet rs2=st2.executeQuery("select vname,video_url,vid from video_table where ch_id="+rs.getLong(1));
		out.print("<ul class=\"list-unstyled list-inline\">");
		while(rs2.next()){
			String str=rs2.getString(2);
			String strs[]=str.split("/");
			System.out.println(strs[6]+"/"+strs[7]);
			
			out.print("<li><a href=\""+strs[6]+"/"+strs[7]+"\"><button style=\"width:100px;height:90px;padding:0.88%;\"><img src=\"videoimg2.png\" height=\"50px\" width=\"80px\"><br>"+rs2.getString(1)+"</button></a><br><br><center><a href=\"delete?action=delete&vid="+rs2.getLong(3)+"\"><button class=\"btn btn-danger btns\" style=\"color:#000;\"><span class=\"glyphicon glyphicon-remove\"></span>&nbsp;&nbsp;delete</button></a></center></li>");
		}
		out.print("<ul>");
		out.print("</div>");
		out.print("</div>");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
