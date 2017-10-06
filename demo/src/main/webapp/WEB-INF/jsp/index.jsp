<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache"> 
    <meta http-equiv="Cache-Control" content="no-cache"> 
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
    
    <title>Nisha's Book Store</title>
    
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
     <link href="static/css/style.css" rel="stylesheet">
    
    <!--[if lt IE 9]>
		<script src="static/js/html5shiv.min.js"></script>
		<script src="static/js/respond.min.js"></script>
	<![endif]-->
</head>
<body>

	<div role="navigation">
		<div class="navbar">
			<a href="/" class="navbar-brand">Nisha's Book Store</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="insert">Add New Book</a></li>
					<li><a href="getBooks">Order History</a></li>
					<li><a href="cart">Cart</a></li>
					<li><a href="login">Login</a></li>
				</ul>
			</div>
		</div>
	</div>
	<c:choose>
		<c:when test="${mode == 'MODE_HOME'}">				
			<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>Welcome to my Book Store</h1>
				</div>
			</div>
		</c:when>
		
		
		<c:when test="${mode == 'MODE_TASKS'}">			
			<div class="container text-center" id="taskDiv">
				
					<h3>My Books</h3>
					<hr>
					<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
					<thead>
					<tr>
						<th>ISBN</th>
						<th>Book Name</th>
						<th>Description</th>
						<th>Dated added</th>
						<th>Delivered</th>
						<th></th>
						<th></th>
					</tr>					
					</thead>
					<tbody>
						<c:forEach var="book" items="${books}">
								<tr>
									<td>${book.id}</td>
									<td>${book.name}</td>
									<td>${book.description}</td>
									<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${book.date_created}"/></td>
									<td>${book.finished}</td>
									<td><a href="update?id=${book.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
									<td><a href="delete?id=${book.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
								</tr>
							</c:forEach>
					
					</tbody>
					</table>					
					</div></div>	
		</c:when>
		<c:when test="${mode == 'MODE_NEW' || mode == 'MODE_UPDATE'}">
			<div class="container text-center" id="taskDiv" action="save">
			<h3>Manage Books</h3>
			<form class="Form-horizontal" method="POST" action="save">
			<input type="hidden" name="id" value="${book.id}" >
					<div class="form-group">
					<label class="control-label col-md-3">Name</label>
					<div class="col-md-7">
					<input type="text" class ="form-control" name="name" value="${book.name}" >
					</div>
					</div>
					<br>
					<div class="form-group">
					<label class="control-label col-md-3">Description</label>
					<div class="col-md-7">
					<input type="text" class ="form-control" name="description" value="${book.description}" >
					</div>
					</div>
					<br>
					<div class="form-group">
						<label class="control-label col-md-3">Finished</label>
						<div class="col-md-7">
							<input type="radio" class="col-sm-1" name="finished" value="true"/>
							<div class="col-sm-1">Yes</div>
							<input type="radio" class="col-sm-1" name="finished" value="false" checked/>
							<div class="col-sm-1">No</div>
						</div>				
					</div>	
					<br>	
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Save"/>
					</div>
			</form>
			</div>
	</c:when>		
	</c:choose>	
		

	<script src="static/js/jquery-1.11.1.min.js"></script>    
    <script src="static/js/bootstrap.min.js"></script>
</body>
</html>