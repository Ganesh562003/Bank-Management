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
 * Servlet implementation class AccountData
 */
public class AccountData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountData() {
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
		              
		PreparedStatement ps=con.prepareStatement("select * from account where name=?"); 
		ps.setString(1, request.getParameter("name")); 
 
		
		out.print("<html><head><script src=\"https://cdn.tailwindcss.com\"></script></head>");            
		out.print("<body style=\"background-color: #f4f4f9;\"><div class=\"max-w-md mx-auto bg-white shadow-lg rounded-lg overflow-hidden\" style=\"margin-top: 200px;\">\r\n"+ "<div class=\"sm:flex sm:items-center px-6 py-4\">\r\n"+ "<div class=\"mt-4 sm:mt-0 sm:ml-4 text-center sm:text-left\">");  
		 
		  
		ResultSet rs=ps.executeQuery();  
		              
		/* Printing column names */  
		ResultSetMetaData rsmd=rs.getMetaData();  
		int total=rsmd.getColumnCount();  
		  
		              
		/* Printing result */  
		 while(rs.next()) {
			 
		 
		 
	out.print("<p class=\"text-xl leading-tight\">"+rs.getString(1)+"</p><p class=\"text-sm leading-tight text-zinc-600\">Your Details</p></div><div class=\"px-6 py-4 border-t border-zinc-200\">\r\n"+ "<div class=\"border-b py-2 flex items-center\">\r\n"+ "\r\n"+ "<span class=\"text-zinc-700\">"+"Accno: "+rs.getInt(2)+ "</span></div><div class=\"border-b py-2 flex items-center\"><span class=\"text-zinc-700\">"+"Age: "+rs.getInt(3)+"</span></div><div class=\"border-b py-2 flex items-center\"><span class=\"text-zinc-700\">"+"Date-of-birth: "+rs.getString(4)+"</span></div><div class=\"border-b py-2 flex items-center\"><span class=\"text-zinc-700\">"+"Email: "+rs.getString(5)+"</span></div><div class=\"border-b py-2 flex items-center\"><span class=\"text-zinc-700\">"+"Phno: "+rs.getInt(6)+"</span></div>"+"<div class=\\\"border-b py-2 flex items-center\\\"><span class=\\\"text-zinc-700\\\">"+"<center><button style='width:auto;padding: 10px;margin:10px;background-color: #009879;color: #ffffff;border: none;border-radius: 10px;cursor: pointer;'><a href='./Main.html' style='text-decoration: none;font-size: 1.2rem;font-weight: 600;color: hsl(233, 16%, 10%);'>Main Page</a></button></center>"+"</span></div></div>");  
		       
	 
		 }  
		out.print("</div></body><br></html>");  
		              
		}catch (Exception e2) {e2.printStackTrace();}  
		          
		finally{out.close();}
	}

}
