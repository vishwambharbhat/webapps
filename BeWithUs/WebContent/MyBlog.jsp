<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="theme.js"></script>
<script
	src="//raw.github.com/botmonster/jquery-bootpag/master/lib/jquery.bootpag.min.js"></script>
<link rel="stylesheet" type="text/css" href="gmain.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
		String user = session.getAttribute("userid").toString();
	%>
<script>
	$(document).ready(function() {
		$(window).load(function() {
			$("#log").fadeIn(3000);
		});
		$("#comment").click(function() {
			$("#mycmt").focus();
		});

		
	});
</script>
<style>
.btn2:hover {
	background-color: #fff;
	color: #0f0;
	border: 1px solid #0f0;
}

.active {
	border-bottom: 3px solid #f00;
}

hr {
	display: block;
	height: 1px;
	border: 0;
	border-top: 1px solid #aaa;
	margin: 1em 0;
	padding: 0;
}
</style>
</head>
<body
	style="background-image: url('beautiful.jpg'); width: 100%; height: 100%; background-repeat: no-repeat; background-attachment: fixed;">
	
	<nav class="navbar navbar-default">

	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">MyBlogs</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">


			<ul class="nav navbar-nav navbar-right">
				<form class="navbar-form navbar-left" role="search"
					action="srch.jsp">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search......"
							name="searchv">
					</div>
					<button type="submit" id="sub" class="btn btn-default">
						<span class="glyphicon glyphicon-search"></span>&nbsp;Search
					</button>
				</form>

				<li class="active"><a href="LoginForm.jsp">Login&nbsp;<span
						class="glyphicon glyphicon-user"></span></a></li>


				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Settings&nbsp;<span
						class="glyphicon glyphicon-cog"></span><span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#" data-toggle="modal" data-target="#myModal">change profile&nbsp;<span
								class="glyphicon glyphicon-edit"></span></a></li>

						<li><a href="logout.jsp">logOut&nbsp;<span
								class="fa fa-power-off"></a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">Help&nbsp;<span class="fa fa-question"></span></a></li>

					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>
	
	<!-- pop up form for updating user information -->
	
 <c:set var="object" value="${user}" />

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Update User</h4>
        </div>
        <div class="modal-body">
          <div class="col-sm-6" >
						<form action="adduser" method="get">
							<div class="row">
								<div class="form-group col-sm-12 col-md-offset-2 ">
										<label for="usr">First Name:</label> <input type="text"
										class="form-control " name="firstname"
										placeholder="enter the frst name..."  value="${object.firstName }" required>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-sm-12 col-md-offset-2 ">
									<label for="eml">Last Name:</label> <input type="text"
										class="form-control" name="lastname"
										placeholder="enter the last name..." value="${object.lastName }" required>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-sm-12 col-md-offset-2 ">
									<label for="eml">Age:</label> <input type="number"
										class="form-control" name="age" placeholder="enter the age..." value="${object.age }"
										required>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-sm-12 col-md-offset-2 ">
									<label for="eml">Date Of Birth:</label> <input type="date"
										class="form-control" name="dob"
										value="${object.date_of_birth }"  required>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-sm-12 col-md-offset-2 ">
									<label for="eml">Email</label> <input type="email"
										class="form-control" name="email"
										placeholder="enter the user Email..." value="${object.emial_id }"required>
								</div>
							</div>



							<div class="row">
								<div class="form-group col-sm-12 col-md-offset-2 ">
									<label for="pwd">Password:</label> <input type="text"
										class="form-control" name="password"
										placeholder="enter the password..." value="${object.password }" required>
								</div>
							</div>


								<div class="row">
								<div class="col-sm-12 col-md-offset-2">
									<input type="submit" class="form-control btn btn-success btn2"
										value="Register">
								</div>
							</div>
						</form>
					</div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" data-dismiss="modal"><span class="glyphicon glyphicon-remove "></span>Close</button>
        </div>
      </div>
      
    </div>
  </div>
  

<!-- end of pop up form -->


	<div class="container" style="background-color: #ffffff;">
		<h1>${message}</h1>
	</div>
	<br>
	<div class="container" style="background-color: #ffffff; padding: 1%;">
		<form action="MyPost" method="post">

			<div class="row">
				<div class="form-group col-sm-12">
					<label for="eml">Title Of Post:</label> <input type="text"
						class="form-control" name="title" placeholder="enter the title..."
						required>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-sm-12">
					<label for="eml">Contents Of Post:</label>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-sm-12">
					<textarea rows="3" name="postcontent" class="col-sm-12"></textarea>
				</div>
			</div>
			<input type="submit" class="btn btn-success" value="Post">
		</form>
	</div>
	<br>
	<c:forEach items="${posts}" var="post">
		<div class="container" id="vishwa"
			style="background-color: #fff2e6; padding: 1%; border: 1px solid #42417f;">

			<h3> <a href="MyPost?action=getpost&postid=<c:out value="${post.post_title}"/>"> 
				<c:out value="${post.post_title}" />
				<span class="glyphicon glyphicon-edit"></span>&nbsp;  </a>
				<span class="nav navbar-right" style="padding-right:0.9%;" id="delete">  <a href="MyPost?action=delete&pid=<c:out value="${post.post_title}" />&uid=<%=user%>&authid=<c:out
					value="${post.user_name}" />"><span class="glyphicon glyphicon-remove btn btn-default" style="border:none;"></span></a></span>
			</h3>
			<span style="direction: rtl;"><span
				class="glyphicon glyphicon-calendar"></span>&nbsp;<c:out
					value="${post.date_of_post}" /></span><span class="nav navbar-right"
				style="padding-right: 1%; font-weight: bold; color: #7a5348;" id="usr"><span
				class="glyphicon glyphicon-user"></span>&nbsp;<c:out
					value="${post.user_name}" /></span>
			<hr>
			<p>
				<c:out value="${post.post_content}" />
			</p>
			<hr>
			<a
				href="LikesGiven?action=like&pid=<c:out value="${post.post_title}"/>&uid=<%=user%>"><button
					id="like" class="btn btn-primary">
					<span class="glyphicon glyphicon-thumbs-up"></span>&nbsp;Like
				</button></a>&nbsp;&nbsp;
			<button id="comment" class="btn btn-primary">
				<span class="glyphicon glyphicon-comment"></span>&nbsp;comment
			</button>
			&nbsp;&nbsp;
			<button id="share" class="btn btn-primary">
				<span class="glyphicon glyphicon-share-alt"></span>&nbsp;share
			</button>
			<br>
			<b>likes:<c:out value="${post.likes}" /></b>
			<hr>
			<form action="myComments" method="get">
				<input type="text" id="mycmt" name="mycommnents"><input
					type="hidden" name="cmtr" value="<%=user%>"> <input
					type="hidden" name="post_id"
					value="<c:out value="${post.post_title}"/>"><input
					type="submit" value="post" class="btn btn-info">
			</form>
			<div style="background-color: #c5cbd6; color: #0f1c38; padding: 1%">
				<h4><u>Comments:</u></h4><br>
				<c:forEach items="${post.comments}" var="comment">
				<span><c:out value="${comment.userName}" /></span><span class="nav navbar-right" style="padding-right:1%;"><c:out value="${comment.date_of_comment}" /></span><hr>
					<span ><b><i>"<c:out value="${comment.comment_content}" />"</i></b></span><br><br>
					
					<button>like</button>&nbsp;<button>share</button><hr>
				</c:forEach>
				</<br>
			</div>
		</div>
		<br>
	</c:forEach>
</body>
</html>