<%@include file="Header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="containor">
<form:form action="InsertProduct" enctype="multipart/form-data" modelAttribute="product" method="post">
<table class="table table bodered">
<tr bgcolor="green" >
	<td colspan="2"><h3 align="center">Product Data</h3></td>
</tr>
<tr>
	<td colspan="2"><h4 align="center"><font color="red">${Error}</font></h4></td>
</tr>

<tr>
	<td>Product Name</td>
	<td><form:input path="productName"/>
</tr>
<tr>
	<td>Price</td>
	<td><form:input path="price" /></td>
	
</tr>
<tr>
	<td>Stock</td>
	<td><form:input path="stock"/></td>
	
</tr>
<tr>
	<td>Category</td>
	<td>
	
		<form:select path="categoryId">
		 <form:option value="0" label="--select List"/>
		<form:option items="${categoryList }"/>
		
		</form:select>
	
</tr>
<tr>
	<td>Supplier</td>
	<td><form:input path="supplierId"/></td>
</tr>
<tr>
	<td>Product Desc</td>
	<td><form:input path="productDesc"/></td>
</tr>

<tr>
		<td>Product Image</td>
		<td><form:input type="file"path="pimage"/></td>

</tr>


<tr bgcolor="green">
	<td colspan="2">
	<input type="submit" value="Insert"/>

	</td>
</tr>
</table>
</form:form>


<table align="center" callspacing="2" border="1">
<tr bgcolor="crange">
<td colspan="6"><center>Product Details</center></td>
</tr>
<tr bgcolor="cyan">
	<td>Product ID</td>
	<td>Product Name</td>
	<td>Price</td>
	<td>Stock</td>
	<td>Image</td>
	<td>operations</td>
</tr>
  <c:forEach items="${listProducts }" var="product">
  <tr>
	<td>${product.productId}</td>
	<td>${product.productName}</td>
	<td>${product.price}</td>
	<td>${product.stock}</td>
	
	<td>
		<a href="<c:url value="/editProduct/${product.productId }"/>">Edit</a>
		<a href="<c:url value="/deleteProduct/${product.productId }"/>">Delete</a>
		<a href="<c:url value="/totalProductDisplay/${product.productId }"/>">Product</a>
	</td>
	
	
  </tr>
	</c:forEach>


</div>


</body>
</html>