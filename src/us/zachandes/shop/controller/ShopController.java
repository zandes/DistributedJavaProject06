package us.zachandes.shop.controller;

import us.zachandes.shop.model.ProductDetail;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShopController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");

        ProductDetail productDetail = new ProductDetail();
        RequestDispatcher dispatcher;

        String id = request.getParameter("button");

        request.setAttribute("id", productDetail.getProductFromUPC(id));
        dispatcher = request.getRequestDispatcher("/genericShopProductsDetail.jsp");


        dispatcher.forward(request, response);
    }
}
