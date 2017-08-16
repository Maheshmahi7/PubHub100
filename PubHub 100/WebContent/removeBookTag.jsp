<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        	<!-- JSTL includes -->
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Remove|BookTag</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<h1 align="center"> Welcome to Book Management System </h1><br />
<nav class="navbar navbar-inverse">
  <div class="container-fluid">

    <ul class="nav navbar-nav">
      <li><a href="index.jsp">Home</a></li>
      <li><a href="search.jsp">Search</a></li>
      <li><a href="addBookTag.jsp">Add Book Tag</a></li>
      <li class="active"><a href="removeBookTag.jsp">Remove Book Tag</a></li>
   </ul>
  </div>
</nav>
<br>
<div>
<form action="removeBookTag" method=get>
<div class="form-group">
		    <label for="isbn13" class="col-sm-4 control-label">Enter ISBN:</label>
		    <div class="col-sm-3">
		      <input type="text" class="form-control" id="isbn13" name="isbn13" placeholder="ISBN 13" value="${param.isbn13 }" />
		    </div>
		    </div><br/><br/>
		    <div class="form-group">
		    <label for="tag" class="col-sm-4 control-label">Enter Tag:</label>
		    <div class="col-sm-3">
		      <input type="text" class="form-control" id="tag" name="tag" placeholder="Book Tag" value="${param.tag }" />
		    </div>
		    </div><br/><br/>
		  <div class="form-group">
		    <div class="col-sm-offset-4 col-sm-1">
		      <button type="submit" class="btn btn-info">Remove</button>
		    </div>
		  </div>
<!-- <p style="text-align:center;">Isbn Number:  <input type="text" value="Isbn number"></p><br>
<p style="text-align:center;">Book Tag:     <input type="text" value="Book Tag"></p><br>
<p style="text-align:center;">  <input type="button" value="Remove Tag"></p><br>-->
</form></div><br/><br/>
<div>
	  <p class="alert ${messageClass}" style="text-align:center">${message }</p>
	  	<%
	  session.setAttribute("message", null);
	  session.setAttribute("messageClass", null);
	%>
	  </div>

</body>
</html>