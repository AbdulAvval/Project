<%@include file="Header.jsp" %>
<form action="<c:url value="/addToCart/${product.productId }"/>" method="get"></form>

<div class="container">

	<div class="row">
	<div class="col-md-4 item-photo">
		<img src="<c:url value="/resources/images/${product.productId }.jpg"/> "/>
	</div>
	
	
	<div class="col-md-5" style="border:0px solid gray">
	<h3>${product.productName }</h3>
	<h5 class="title-price">
	<small>Stock:${product.stock }</small>
	</h5>
	<h4 style="margin-top:0px;">Price:INR${product.price}/-</h4>
	<div class="section">
		<h6 class="title-attr"style="margin-top:15px">
		 <small>Description:${product.productDesc}</small>
			
		</h6>
	</div>
		<div>
			<div class="btn-minus"><span class="glyphicon glyphicon-minus"></span></div>
			<input value="1"name="quantiy"/>
			<div class="btn-plus"><span class="glyphicon glyphicon-plus"></span></div>
		</div>
		
		<div class="section">
		<input type="submit" class="btn btn-success" value="AddToCart"/>
		</div>
		
	</div>
	
	</div>
	
	
</div>
</body>
</html>