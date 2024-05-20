package com.pu;

import jakarta.servlet.ServletException;
import java.io.PrintWriter;
import java.sql.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Insertdata
 */
public class Insertdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insertdata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{ 
		    Class.forName("com.mysql.jdbc.Driver"); 
		    Connection  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank?characterEncoding=latin1","root","#Ganesh@123"); 
		    PreparedStatement st = con.prepareStatement("insert into transaction values(?, ?, ?, ?)");
		    
		     st.setString(1, request.getParameter("name"));
		     st.setInt(2, Integer.valueOf(request.getParameter("number")));
		     st.setString(3, request.getParameter("ifsc"));
		     st.setInt(4, Integer.valueOf(request.getParameter("amount")));
		     
		     st.executeUpdate();
		     st.close();
		     con.close(); 
		     PrintWriter out = response.getWriter();
		     out.println("<html><body style='margin-top: 5%;background-color: #f4f4f9;'><b ><center style='font-size: 70px;font-weight: 800;margin-bottom: 20px;color: hsl(233, 26%, 24%);line-height: 1.1;'>Transaction Successful"+"<p>Thank you for using easybank</p><br><button style='width:auto;padding: 10px;background-color: #009879;color: #ffffff;border: none;border-radius: 10px;cursor: pointer;'><a href='./Main.html' style='text-decoration: none;font-size: 1.2rem;font-weight: 600;color: hsl(233, 16%, 10%);'>Go back to main page</a></button>"
		     + "</center></b></body></html>");
		}catch(Exception e){
		      System.out.println(e);} 
		
	}

}
