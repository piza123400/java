<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>welcometo web shopping mall</title>
</head>
<body>
	<%@include file="menu.jsp" %>
<!-- 
	<nav class = "navbar navbar-expand navbar-dark bg-dark">
		<div class="container">
			<div class = "narbar-header">
				<a class="navbar-brand" href="./welcome.jsp">home</a>				
			</div>
		</div>	
	</nav>
	 -->
	<%! String greeting = "welcoime to web shopping mall"; String tagline="welcome to web market!"; %>
	<div class = "jumbotron">
		<div class="container">
			<h1 class = "display-3"><%=greeting %></h1>
		</div>
	</div>
	<main role = "main">
	<div class = "container">
		<div class="text-center">
			<h3>
				<%= tagline %>
			</h3>
			
		response.setIntHeader("Refresh",5);
		Date day = new java.util.Date();
		String am_pm;
		
		
		
		</div>
	</div>
	</main>
	<%@include file="footer.jsp" %>
	<!-- 
	<footer class = "container">
		<p>&copy;WebMarket</p>
		
		
		
		seongjsid@hanmail.net
		
	</footer>
	 -->
</body>
</html>