<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="Header.jsp" %>

<div class="cantainer">
<form action="<c:url value="/updateCategory"/>" method="post">
<table cellspacing="3" align="center">
<tr bgcolor="cronge"><td colspan="2"><center>Update Category Detail</center></td>
</tr>
<tr>
<td>Category Id</td>
<td><input type="text" name="catId" id="catId" value="${myCategory.categoryId }"></td>
</tr>
<tr>
<td>Category Name</td>
<td><input type="text" name="catName" value="${myCategory.category }"> </td>
</tr>
<tr>
<td>Category Desc</td>
<td><input type="text" name="catDesc" id="catDesc" value="${myCategory.category }"></td>
</tr>
<tr>
<td colspan="2">
<center><input type="submit" value="Updat Category"/></center>
</td>
</tr>

</table>



</form>
</div>
</body>
</html>