<%@include file="/WEB-INF/views/Header.jsp" %>




<div class="container">
<div id="myCarousel"class="carousel slide" data-ride="carousel">

<lo class="corousel-indicators">
	<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
	<li data-target="#myCarousel"data-slide-to="1"></li>
	<li data-target="#myCarousel" data-slide-to="2"></li>

</lo>
	<div class="carousel-inner">
	<div class="item active">
	 <img  src="<c:url value="/resources/images/linovo.jpg"/>" alt="lenovo" style="width:100"hight="100%">
	
	</div>
	<div>
		<img  src="<c:url value="/resources/images/sasumang.jpg"/> "alt="samsung" style="width:100%;hight=50%">	
	</div>
	<div>
		<img  src="<c:url value="/resources/images/sasumangj2.jpg"/> "alt="samsungj7" style="width:100%;hight=50%">	
	</div>
	<a class="left carousel-control" href="#myCarousel"data-slide="prev">
	<span class="glyphicon glyphicon-chevron-left"></span>
	<span class="sr-only">Previous</span>
	
	</a>
	<a class="right carousel-control" href="#myCarousel" data-slide="next">
		<span class="glyphicon glyphicon-chevron-right"></span>
		<span class="sr-only">Next</span>
	</a>
	</div>
	
</div>

</div>




</body>
</html>
