package com.luv2code.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDatabaseServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//setup connection variable
		String user="hbstudent";
		String password ="hbstudent";
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		String driver ="com.mysql.cj.jdbc.Driver";
		//get connection
		
		try {
			PrintWriter out = response.getWriter();
			
			out.println("connecting to database "+jdbcUrl);
			Class.forName(driver);
			
			Connection myconn= DriverManager.getConnection(jdbcUrl,user,password);
			out.print("Success!!");
			
			myconn.close();
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServletException();
		}finally {
			
		}
	}

}
