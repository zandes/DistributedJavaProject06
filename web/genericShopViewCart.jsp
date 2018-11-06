<%@ page import="us.zachandes.shop.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>genericShopViewCart</title>
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
	<div id="viewCart">

		<form action="Bill">


			<%
			List recs = (List) request.getAttribute("cartView");
			Iterator it = recs.iterator();
			double total = 0;
			while (it.hasNext()) {
				Product product = (Product) it.next();
				total += product.getProductPrice();
			%>


			<ul>
				<li>
					Name: <%= product.getProductName()%>
				</li>
				<li>
					Description: <%= product.getProductDescription()%>
				</li>
				<li>
					<img src="images/<%=product.getUpc()%>.jpg">
				</li>
				<li>
					Price: <%= product.getProductPrice()%>
				</li>
			</ul>
			<%}%>

			Total Price: <%=total%>
			<br>
			<button type="submit" name="completePurchase">Complete Purchase</button>
		</form>

	</div>
</body>
</html>
