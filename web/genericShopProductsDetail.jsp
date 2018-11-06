<%@ page import="us.zachandes.shop.model.Product" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>genericShopProductsDetail</title>
<link href="genericShop.css" rel="stylesheet" type="text/css">
</head>

<body>
	<div id="navbar">
		<ul>
			<li><a href="genericShopHome.jsp">Home</a></li>
			<li><a href="genericShopProducts.jsp">Products</a></li>
			<li><a href="Cart">View Cart</a></li>
		</ul>
	</div>
	<div id="productDetail">

		<%
			Product product = (Product) request.getAttribute("id");
		%>

		<h1>
			<%= product.getProductName()%>
		</h1>

		<hr>

		<img src="images/<%= product.getUpc()%>.jpg">

		<hr>

		<h3>$<%= product.getProductPrice()%></h3>

		<hr>

		<p><%= product.getProductDescription()%></p>

		<form action="AddedToCart">
		<button type="submit" name="addToCart" value="<%=product.getUpc()%>">Add to cart</button>
		</form>
	</div>
</body>
</html>
