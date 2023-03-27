package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.myConn;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/CRUDStudentServlet")
public class CRUDStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CRUDStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//JDBC connection object
		myConn mycon = new myConn();
		Connection con;
		response.setContentType("text/html");	
		String action = request.getParameter("action");
		HttpSession newsession=request.getSession(false);
		if(newsession==null) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		switch(action) {
		case "addStudent":

			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String contact = request.getParameter("contact");
			String roll = request.getParameter("rollNumber");
			String feesDues = request.getParameter("fees");
			
			try {
				
				con = mycon.getConn();
				String qr = "insert into students(name,email,contact,roll, fees_dues) values(?,?,?,?,?);";				
				PreparedStatement pt = con.prepareStatement(qr);				
				pt.setString(1, name);
				pt.setString(2, email);
				pt.setString(3, contact);
				pt.setString(4, roll);
				pt.setString(5, feesDues);				
				pt.executeUpdate();				
				request.getRequestDispatcher("accountantDashborad.jsp").forward(request, response);				
				pt.close();
				con.close();				
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			break;
			
		case "updateStudent":
			String name1	 = request.getParameter("name");
			String email1 = request.getParameter("email");
			String contact1 = request.getParameter("contact");
			String roll1 = request.getParameter("roll");
			String fees1 = request.getParameter("fees");
			
			try {			
				con = mycon.getConn();
				String qr = "update students set email=?, contact=?, roll=?, fees_dues=? where name=?;";				
				PreparedStatement pt = con.prepareStatement(qr);			
				pt.setString(1, email1);
				pt.setString(2, contact1);
				pt.setString(3, roll1);
				pt.setString(4, fees1);
				pt.setString(5, name1);			
				pt.executeUpdate();				
				request.getRequestDispatcher("accountantDashborad.jsp").forward(request, response);
				pt.close();
				con.close();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			break;
			
		case "deleteStudent":
			String name3 = request.getParameter("name");
			
			try {			
				con = mycon.getConn();
				String qr = "delete from students where name=?;";				
				PreparedStatement pt = con.prepareStatement(qr);				
				pt.setString(1, name3);				
				pt.executeUpdate();				
				request.getRequestDispatcher("accountantDashborad.jsp").forward(request, response);				
				pt.close();
				con.close();	
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			break;
		}

	}

}
