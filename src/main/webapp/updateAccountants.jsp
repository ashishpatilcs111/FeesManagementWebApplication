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
	
	.form{
		height: 450px;
		width: 450px;
		display: flex;
		align-items: center;
		justify-content: center;
		flex-direction: column;
		background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR_4Ml7CC7X27iGYMJSTxUx9pc_nCnV-_jeSw&usqp=CAU');
		background-repeat: no-repeat;
		background-size: cover;
		border-radius: .6rem;
		box-shadow: 5px 5px 5px red;
	}
	
	input{
		height: 40px;
		width: 300px;
		margin-bottom: .5rem;
		border-radius: .5rem;
		padding: .2rem;
	}
	
	.heading{
		font-size: 100px;
	}
	
	.add-data{
		height: 40px;
		width: 130px;
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
			<h1>UPDATE ACCOUNTANT</h1>
			<h2>Enter name whose data we want to update</h2>
			<form class="form" action="<%=request.getContextPath() %>/CRUDAccountant?action=updateAccountant" method="post">
				<input type="text" name="name" placeholder="Enter Name" />
				<input type="email" name="email" placeholder="Enter E-Mail" />	
				<input type="text" name="contact" placeholder="Enter Contact Number" />
				<input type="text" name="username" placeholder="Enter Username" />
				<input type="password" name="password" placeholder="Enter Password" />
				<button class="add-data">UPDATE ACCOUNTANT</button>
			</form>
		</div>
	</div>

</body>
</html>