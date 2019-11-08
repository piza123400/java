<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import = "java.util.Date" %>
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
			
			<% 
				Date day = new java.util.Date();
			String am_pm;
			int hour = day.getHours();
			int second = day.getSeconds();
			int minute = day.getMinutes();
			if(hour/12==0){
				am_pm = "am";
			}else {
				am_pm="PM";
				hour = hour - 12;
			}
			String CT = hour+":"+minute+":"+second+" "+am_pm;
			out.print("현재접속시간:" + CT +"\n");
			
				
			
			%>
		
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