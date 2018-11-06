package us.zachandes.shop.controller;
import us.zachandes.shop.model.Product;
import us.zachandes.shop.model.ProductDetail;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class BillController extends HttpServlet {
    String RESULT_PAGE = "genericShopBill.jsp";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie cookie;
        Cookie[] cookies;
        cookies = request.getCookies();
        List<Product> products = new ArrayList<>();

        if(cookies.length > 0){
            for(int i = 0; i < cookies.length; i++){
                cookie = cookies[i];
                if(cookie.getName().equals("cart")){
                    products = orderList(cookie.getValue());
                }
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }

        request.setAttribute("billView", products);
        RequestDispatcher view = request.getRequestDispatcher(RESULT_PAGE);
        view.forward(request, response);
    }
    protected List<Product> orderList(String upcs){
        List<Product> products = new ArrayList<>();
        ProductDetail productDetail = new ProductDetail();
        String[] nums = upcs.split(",");
        for(int i = 0; i < nums.length; i++){
            products.add(productDetail.getProductFromUPC(nums[i]));
        }
        return products;
    }

}
