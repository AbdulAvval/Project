<%@include file="Header.jsp" %>

<div class="container">

<form action="insertCategory" mathod="post">
<table cellspcing="3" align="center">
	<tr bgcolor="crange"><td colspan"2"><center>Category Details</center></td></tr>
	<tr>
		<td>Category Name</td>
		<td><input type="text" name="catName" id="catName"></td>
	
	</tr>
	<tr>
		<td>Category Desc</td>
		<td><input type="text" name="catDesc"id="catDesc"></td>	
	</tr>
	<tr>
	<td colspan "2">
	<input type="submit" value="insert Catgory">
	</td>
	
	</tr>
	
	
</table>
</form>

<table align="center" callspacing="2" border="1">
<tr bgcolor="crange">
<td colspan="4"><center>Category Details</center></td>
</tr>
<tr bgcolor="cyan">
	<td>Category ID</td>
	<td>Category Name</td>
	<td>Category Desc</td>
	<td>operations</td>
</tr>
  <c:forEach items="${categories }" var="category">
  <tr>
	<td>${category.categoryId}</td>
	<td>${category.categoryName}</td>
	<td>${category.categoryDesc}</td>
	
	<td>
		<a href="<c:url value="/editCategory/${category.categoryId }"/>">Edit</a>
		<a href="<c:url value="/deleteCategory/${category.categoryId }"/>">Delete</a>
	</td>
	
	
  </tr>
	</c:forEach>
		
</table>
</div>
 </body>


</html>