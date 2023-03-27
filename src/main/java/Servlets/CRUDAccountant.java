package Servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.jdbc;
import Beans.myConn;

/**
 * Servlet implementation class addDataServlet
 */
@WebServlet("/CRUDAccountant")
public class CRUDAccountant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CRUDAccountant() {
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
		case "addAccountant":

			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String contact = request.getParameter("contact");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			try {
				
				con = mycon.getConn();
				String qr = "insert into Accountants(name,email,contact,username,password) values(?,?,?,?,?);";				
				PreparedStatement pt = con.prepareStatement(qr);				
				pt.setString(1, name);
				pt.setString(2, email);
				pt.setString(3, contact);
				pt.setString(4, username);
				pt.setString(5, password);				
				pt.executeUpdate();				
				request.getRequestDispatcher("addAccountant.jsp").forward(request, response);				
				pt.close();
				con.close();				
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			break;
			
		case "listAccountant":		
			try {			
				con = mycon.getConn();
				Statement st = con.createStatement();				
				ResultSet rs = st.executeQuery("select * from accountants;");				
				out.println("<h1>" + "List Of Accountants"+ "</h1>");
				out.print("<html><body>");
				out.println("<table>");				
				while(rs.next()) {	
					 out.println("<tr><td>" + rs.getInt("id") + "</td>");
					 out.println("<td>" + rs.getString("name")+ "</td>");
					 out.println("<td>" + rs.getString("email")+ "</td>");
					 out.println("<td>" + rs.getString("contact")+ "</td>");
					 out.println("<td>" + rs.getString("username")+ "</td>");
					 out.println("<td>" + rs.getString("password")+ "</td></tr>");					
				}
				out.println("</table>");
				out.println("<a href='HomePage.jsp'>Back to HomePage</a>");
				out.print("</body></html>");
				st.close();
				con.close();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			break;
			
		case "updateAccountant":
			String name1	 = request.getParameter("name");
			String email1 = request.getParameter("email");
			String contact1 = request.getParameter("contact");
			String username1 = request.getParameter("username");
			String password1 = request.getParameter("password");
			
			try {			
				con = mycon.getConn();
				String qr = "update Accountants set email=?, contact=?, username=?, password=? where name=?;";				
				PreparedStatement pt = con.prepareStatement(qr);			
				pt.setString(1, email1);
				pt.setString(2, contact1);
				pt.setString(3, username1);
				pt.setString(4, password1);
				pt.setString(5, name1);			
				pt.executeUpdate();				
				request.getRequestDispatcher("updateAccountants.jsp").forward(request, response);
				pt.close();
				con.close();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			break;
			
		case "deleteAccountant":
			String name3 = request.getParameter("name");
			
			try {			
				con = mycon.getConn();
				String qr = "delete from Accountants where name=?;";				
				PreparedStatement pt = con.prepareStatement(qr);				
				pt.setString(1, name3);				
				pt.executeUpdate();				
				request.getRequestDispatcher("updateAccountants.jsp").forward(request, response);				
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
