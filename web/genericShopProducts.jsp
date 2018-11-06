<%@ page import="java.util.List" %>
<%@ page import="us.zachandes.shop.model.Product" %>
<%@ page import="us.zachandes.shop.model.ProductDetail" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>genericShopProducts</title>
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
	<div id="products">
		<ul>
			<%
				ProductDetail productDetail = new ProductDetail();
				List<Product> productList = productDetail.getProductList();
				for (Product product: productList){
			%>
			<li>
				<p><form action="ProductDetail"><button type="submit" name="button" value="<%=product.getUpc()%>"><%=product.getProductName()%></button></form><img src="images/<%=product.getUpc()%>.jpg"></p>
			</li>
			<%}%>
		</ul>
	</div>
</body>
</html>
