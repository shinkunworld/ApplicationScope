<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.SiteEV"%>
<%
	SiteEV siteEV = (SiteEV) application.getAttribute("siteEV");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shin kun hompage</title>
</head>
<body>
	<h1>welcome to my hompage</h1>
	<p>

		<!-- Do get방식 -->
		<a href="/applicationScope/MinatoIndex?action=like">like</a>
		<%=siteEV.getLike()%>people
		<a href="/applicationScope/MinatoIndex?action=dislike">Dislike</a>
		<%=siteEV.getDislike()%>people
	</p>

	<!--Do post방식 -->
	<!-- <form action="" method="post">
	<input type="hidden" name="action" value="like">
	<input type="submit" value="よいね">
</form>

<form action="" method="post">
	<input type="hidden" name="action" value="dislike">
	<input type="submit" value="よくないね">
</form> -->
	<h2>shinkunhwan is man</h2>
	<p>hihihihihihihihihihihi</p>
</body>
</html>