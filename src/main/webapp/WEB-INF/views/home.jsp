<!DOCTYPE html>
<html>
<head>
<title>Welcome to Mint-Office</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type='text/javascript' src="resources/js/bootstrap.js"></script>
<link rel="stylesheet" href="resources/css/bootstrap.css">
<link rel="stylesheet" href="resources/css/home/home.css">
<script defer
src="https://use.fontawesome.com/releases/v5.0.12/js/all.js"
integrity="sha384-Voup2lBiiyZYkRto2XWqbzxHXwzcm4A5RfdfG6466bu5LqjwwrjXCMBQBLMWh7qR"
crossorigin="anonymous"></script>

<script>
$(function(){
	var $idObj = $('input[type=text]'); //type속성이 text인 input객체를 dom트리에서 찾기
	var itemValue = localStorage.getItem('id');
	var $chkObj = $('input[type=checkbox]');
	$idObj.val(itemValue);
	$('form').submit(function(){
		var idValue = $idObj.val();
		//chkObj가 체크된 경우에는
		if($chkObj.prop('checked')){
		  localStorage.setItem('id', idValue);		
		}else{//chkObj가 체크안된 경우에는
		  localStorage.removeItem('id');
		}
		$.ajax({
			data:$('form').serialize(),
			method:'POST',
			url: 'login.do',
			success: function(data){
				//$('section').html(data);				
				data = data.trim();
				if(data == '1'){
					//$('section').html('로그인 성공');
					//location.href="index.jsp";
					<%--location.href="<%=request.getContextPath()%>";--%>
					$('#loginWarining').css('display','none');
					location.href="home.jsp";
				}else{
					$('#loginWarining').css('display','initial');
				}
			}
		});
		return false; //기본이벤트처리 막기
	});
	
	$('.warningx').on('click',function(){
		$('#loginWarining').css('display','none');
	});
	
});
</script>	
	
	
<style>
html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}

.carousel, .item, .active {
	height: 100%;
}

.carousel-inner {
	height: 100%;
}

.carousel-caption {
	z-index: 0;
	top: 40%;
}

.carousel .item {
	background-color: #777;
}

.carousel .carousel-inner .bg {
	background-repeat: no-repeat;
	background-size: cover;
}

.carousel .carousel-inner .bg1 {
	background-image: url('resources/img/login0');
	background-position: center top;
}

.carousel .carousel-inner .bg2 {
	background-image: url('resources/img/login1');
	background-position: center center;
}

.carousel .carousel-inner .bg3 {
	background-image: url('resources/img/login2');
	background-position: center bottom;
}

.carousel .carousel-inner .bg4 {
	background-image: url('resources/img/login3');
	background-position: center bottom;
}

.carousel .carousel-inner .bg5 {
	background-image: url('resources/img/login4');
	background-position: center bottom;
}


/* modal start */
/* Full-width input fields */
input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

/* Set a style for all buttons */
button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

button:hover {
	opacity: 0.8;
}

/* Extra styles for the cancel button */
.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}
/* Center the image and position the close button */
.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
	position: relative;
}

img.avatar {
	width: 60%;
}

#id01>.modal-content>div.container {
	padding: 16px;
	width: 100%;
}

span.psw {
	float: right;
	padding-top: 16px;
}

/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
	padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 5% auto 15% auto;
	/* 5% from the top, 15% from the bottom and centered */
	border: 1px solid #888;
	width: 40%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
	position: absolute;
	right: 25px;
	top: 0;
	color: #000;
	font-size: 35px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: red;
	cursor: pointer;
}

/* Add Zoom Animation */
.animate {
	-webkit-animation: animatezoom 0.6s;
	animation: animatezoom 0.6s
}

@
-webkit-keyframes animatezoom {
	from {-webkit-transform: scale(0)
}

to {
	-webkit-transform: scale(1)
}

}
@
keyframes animatezoom {
	from {transform: scale(0)
}

to {
	transform: scale(1)
}

}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
	span.psw {
		display: block;
		float: none;
	}
	.cancelbtn {
		width: 100%;
	}
}
</style>
</head>
<body>
	<%-- <c:if test="${!empty sessionScope.loginInfo}">
		<script>
			location.href="home.jsp";
		</script>
	</c:if> --%>
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
			<li data-target="#myCarousel" data-slide-to="3"></li>
			<li data-target="#myCarousel" data-slide-to="4"></li>
		</ol>
		<div class="carousel-inner">
			<div class="item bg bg1 active"></div>
			<div class="item bg bg2"></div>
			<div class="item bg bg3"></div>
			<div class="item bg bg4"></div>
			<div class="item bg bg5"></div>
		</div>
		<a class="left carousel-control" href="#myCarousel" data-slide="prev"><span
			class="glyphicon glyphicon-chevron-left"></span></a> <a
			class="right carousel-control" href="#myCarousel" data-slide="next"><span
			class="glyphicon glyphicon-chevron-right"></span></a>
	</div>
	<div class="container" id="back-text">
		<div class="carousel-caption">
			<h1>DevLink for all developers!</h1>
			<p>
				DevLink is a social network Service which gives you Simple, Fast, Effective
				way of improving your career.<br> Reducing wasted time for finding job and let's make connections with great mates.
			</p>
			<p>
				<a class="btn btn-lg btn-primary" href="#" role="button"
					onclick="document.getElementById('id01').style.display='block'">Login</a>
			</p>
		</div>
	</div>
</body>

<div id="id01" class="modal">
	<form class="modal-content animate" action="/action_page.php">
		<div class="imgcontainer">
			<span onclick="document.getElementById('id01').style.display='none'"
				class="close warningx" title="Close Modal">&times;</span> <img
				src="image/login/mintOffice.png" alt="Avatar" class="avatar">
		</div>
		<div class="container">
			<div style="text-align:center;display:none;" id="loginWarining">
				<label><b style="color:red;">LOGIN FAILED</b></label><br>
			</div>
			<label for="uname"><b>Username</b></label>
			<input type="text" placeholder="Enter Username" name="id" required>
			<label for="psw"><b>Password</b></label>
			<input type="password" placeholder="Enter Password" name="pwd" required>
			<button type="submit">Login</button>
			<label> <input type="checkbox" checked="checked" name="remember"> Remember me</label>
		</div>
		
		<div class="container" style="background-color: #f1f1f1">
			<button type="button"
				onclick="document.getElementById('id01').style.display='none'"
				class="cancelbtn warningx">Cancel</button>
			<span class="psw">Forgot <a href="#">password?</a></span>
		</div>
	</form>
</div>
<script>
	// Get the modal
	var modal = document.getElementById('id01');

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
	}
</script>
</html>