<%@ page import="us.zachandes.shop.model.Product" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>GenericShopHome</title>
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
<div id="home">
    <h3>Final Bill</h3>
    <%
        List recs = (List) request.getAttribute("billView");
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
            Price: <%= product.getProductPrice()%>
        </li>
    </ul>
    <%}%>

    Total Price: <%=total%>
</div>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="genericShop.js"></script>
</body>
</html>
