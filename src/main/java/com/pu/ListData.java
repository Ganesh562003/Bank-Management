package com.pu;

import jakarta.servlet.ServletException;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Servlet implementation class ListData
 */
public class ListData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		try{  		
		          
		
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?characterEncoding=latin1","root","#Ganesh@123");  
		              
		PreparedStatement ps=con.prepareStatement("select * from transaction");  
		
		out.print("<html><head><link rel='stylesheet' href=\"display.css\"></head>");            
		out.print("<body><div class=\"table-container\"><table >");  
		 
		  
		ResultSet rs=ps.executeQuery();  
		              
		/* Printing column names */  
		ResultSetMetaData rsmd=rs.getMetaData();  
		int total=rsmd.getColumnCount();  
		out.print("<tr><thead>");  
		for(int i=1;i<=total;i++)  
		{  
		out.print("<th>"+rsmd.getColumnName(i)+"</th>");  
		}  
		  
		out.print("</tr></thead>");  
		              
		/* Printing result */  
		  
		while(rs.next())  
		{  
		       out.print("<tbody><tr><td>"+rs.getString(1)+"</td><td>"+rs.getInt(2)+ "</td><td>"+rs.getString(3)+"</td><td>"+ rs.getInt(4)+"</td></tr></tbody>");  
		       
		}  
		  
		out.print("</table></div></body></html>");  
		              
		}catch (Exception e2) {e2.printStackTrace();}  
		          
		finally{out.close();}  
		  
	

	}

}
