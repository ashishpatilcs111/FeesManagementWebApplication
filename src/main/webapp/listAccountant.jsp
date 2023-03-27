<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="Beans.myConn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
*{
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	}
	
	.container{
	height: 100vh;
	width: 100vw;
	background-image: url('https://img.freepik.com/premium-photo/colorful-grunge-abstract-minimal-background_250469-4315.jpg');
	background-repeat: no-repeat;
	background-position: center;
	background-size: cover;
	}
	
	.navbar{
	height: 10vh;
	width: 100vw;
	display: flex;
	align-items: center;
	justify-content: space-between;
	}
	li{
	list-style: none;
	display: inline-block;
	margin-left: .6rem;
	font-size: 1.2rem;
	font-weight: bold;
	}
	
	.btn{
		color: black;
		background-color: red;
		height: 25px;
		width: 90px;
		border-radius: .5rem;
	}
	
	.main{
		height: 90vh;
		width: 100vw;
		display: flex;
		align-items: center;
		justify-content: center;
		flex-direction: column;
	}
	
	.heading{
		font-size: 100px;
	}
	table,tr,td{
		font-size: 20px;
		color: black;
		background-color: white;
		border: 1px solid black;
		padding: .5rem;
	}
	</style>
</head>
<body>
	<div class="container">
		<div class="navbar">
			<img height="80px" alt="logo" src="https://cutewallpaper.org/24/admin-png/admin-png-images-transparent-free-download-pngmartcom.png" />
			<ul>
				<li><a href="<%=request.getContextPath() %>/HomePage.jsp">Home</a></li>
				<li><a href="<%=request.getContextPath() %>/addAccountant.jsp">Add Accountant</a></li>
				<li><a href="<%=request.getContextPath() %>/listAccountant.jsp">List Accountant</a></li>
				<li><a href="<%=request.getContextPath() %>/updateAccountants.jsp">Update</a></li>
				<li><a href="<%=request.getContextPath() %>/deleteAccountant.jsp">Delete</a></li>
				<li><form action="<%=request.getContextPath() %>/loginAuthentication?action=logout" method="post">
						<input type="hidden" name="logout" />
						<button class="btn">logout</button>
					</form></li>
			</ul>
		</div>
		<div class="main">
			<br/>
		<% myConn mycon = new myConn();
		try{
			
			Connection con = mycon.getConn();
			Statement st = con.createStatement();				
			ResultSet rs = st.executeQuery("select * from accountants;");	
			out.println("<h1>" + "List Of Accountants"+ "</h1>");
			out.println("<table>");	
			out.println("<tr><td> ID </td><td> NAME </td><td> EMAIL </td><td> CONTACT </td><td> USERNAME </td><td> PASSWORD </td></tr>");
			while(rs.next()) {
				String id = rs.getString("id");
				 out.println("<tr><td>" + rs.getInt("id") + "</td>");
				 out.println("<td>" + rs.getString("name")+ "</td>");
				 out.println("<td>" + rs.getString("email")+ "</td>");
				 out.println("<td>" + rs.getString("contact")+ "</td>");
				 out.println("<td>" + rs.getString("username")+ "</td>");
				 out.println("<td>" + rs.getString("password")+ "</td>");	
				 out.println("<td><a href=CRUDAccountant?id="+id+"&action=deleteAccountant>Delete</a></td></tr>");
			}
			out.println("</table>");
			st.close();
			con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
		 	}
		%>
			
		</div>
	</div>
</body>
</html>