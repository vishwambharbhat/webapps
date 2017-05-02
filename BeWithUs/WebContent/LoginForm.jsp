<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script src="theme.js"></script>
		<link rel="stylesheet" type="text/css" href="gmain.css">
		
		
		<script>
$(document).ready(function(){
    $(window).load(function(){
        $("#log").fadeIn(3000);
    });
});
</script>
	<style>

.btn2:hover{
background-color:#fff;
color:#0f0;
border:1px solid #0f0;

}
.active{
border-bottom:3px solid #f00;
}
</style>
</head>
<body style="background-color: 	#CCD1D1">
<nav class="navbar navbar-default">

  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
        <a class="navbar-brand" href="#">MyBlogs</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      
      
      <ul class="nav navbar-nav navbar-right">
	  <form class="navbar-form navbar-left" role="search" action="srch.jsp">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search......" name="searchv">
        </div>
        <button type="submit" id="sub" class="btn btn-default"><span class="glyphicon glyphicon-search"></span>&nbsp;Search</button>
      </form>
	  	
        <li class="active">
          <a href="signin.jsp">Login&nbsp;<span class="glyphicon glyphicon-user"></span></a>
         </li>
     
        
		<li class="dropdown" >
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Settings&nbsp;<span class="glyphicon glyphicon-cog"></span><span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li ><a href="updateform.jsp">change profile&nbsp;<span class="glyphicon glyphicon-edit"></span></a></li>
          
                      <li><a href="logout.jsp">logOut&nbsp;<span class="fa fa-power-off"></a></li>
			<li role="separator" class="divider"></li>
			 <li><a href="#">Help&nbsp;<span class="fa fa-question"></span></a></li>
			
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<!-- <nav class="navbar navbar-inverse">
  <div class="container-fluid">
   
    <ul class="nav navbar-nav">
       <li><a href="home.jsp">Home</a></li>
      <li><a href="listvideo.jsp">Video Listing</a></li> 
      <li><a href="channel.jsp">Video Upload</a></li> 
	   <li ><a href="Contact_we.jsp">Contact</a></li> 
    </ul>
  </div>
</nav> -->




<div class="container" id="log" style="display:none;">
<div class="panel panel-default">
<div class="panel-body">

<FIELDSET>
    <LEGEND>Sign in</LEGEND>
	${message}
<div class="row">
<div class="col-sm-6" >
<form  action="login" method="post" >
<div class="row">
    <div class="form-group col-sm-6 col-md-offset-2 ">
	<h2>already exist?</h2>
  <label for="usr">Name:</label>
  <input type="text" class="form-control " name="name" placeholder="enter the username..." required>
</div></div>
<div class="row">
<div class="form-group col-sm-6 col-md-offset-2 ">
  <label for="pwd">Password:</label>
  <input type="password" class="form-control" name="pass" placeholder="enter the user password..." required>
</div></div>

<div class="row">
<div class="form-group col-sm-6 col-md-offset-2 ">
   <input type="checkbox"  id="chk" >
   <label for="chk">keep sign in</label>
</div> </div>

<div class="row">
<div class="col-sm-6 col-md-offset-2">
    <input type="submit" class="form-control btn btn-success btn2" value="Login">
</div></div>

</form>
</div>

<!-- For Registration-->

<div class="col-sm-6" style="border-left:1px solid lightgrey;">
<form action="adduser" method="post">
<div class="row">
    <div class="form-group col-sm-6 col-md-offset-2 ">
	<h2>create new</h2>
  <label for="usr">First Name:</label>
  <input type="text" class="form-control " name="firstname" placeholder="enter the frst name..." required>
</div>
</div>

<div class="row">
<div class="form-group col-sm-6 col-md-offset-2 ">
  <label for="eml">Last Name:</label>
  <input type="text" class="form-control" name="lastname" placeholder="enter the last name..." required>
</div></div> 

<div class="row">
<div class="form-group col-sm-6 col-md-offset-2 ">
  <label for="eml">Age:</label>
  <input type="number" class="form-control" name="age" placeholder="enter the age..." required>
</div></div>  

<div class="row">
<div class="form-group col-sm-6 col-md-offset-2 ">
  <label for="eml">Date Of Birth:</label>
  <input type="date" class="form-control" name="dob" placeholder="enter the user Email..." required>
</div></div>  

<div class="row">
<div class="form-group col-sm-6 col-md-offset-2 ">
  <label for="eml">Email</label>
  <input type="email" class="form-control" name="email" placeholder="enter the user Email..." required>
</div></div>



<div class="row">
<div class="form-group col-sm-6 col-md-offset-2 ">
  <label for="pwd">Password:</label>
  <input type="password" class="form-control" name="password" placeholder="enter the password..." required>
</div></div>


<div class="row">
<div class="form-group col-sm-6 col-md-offset-2 ">
  <label for="pwd">Confirm Password:</label>
  <input type="password" class="form-control" id="pwd" placeholder="enter the Confirm password..." required>
</div></div>






<div class="row">
<div class="col-sm-6 col-md-offset-2">
    <input type="submit" class="form-control btn btn-success btn2" value="Register">
</div></div>
</form>
</div>

</div>
	
	
	
</FIELDSET>
</form>
</div>
</div>
</div>



	
</body>
</html>