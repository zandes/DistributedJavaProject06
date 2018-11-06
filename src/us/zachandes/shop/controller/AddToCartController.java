package us.zachandes.shop.controller;

import com.sun.deploy.util.ArrayUtil;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AddToCartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String order = null;
        Cookie cookie;
        Cookie[] cookies;
        cookies = request.getCookies();

        if(cookies.length > 0){
            for(int i = 0; i < cookies.length; i++){
                cookie = cookies[i];
                if(cookie.getName().equals("cart")){
                    order = cookie.getValue();
                }
            }
        }

        if(order != null){
            order += request.getParameter("addToCart") + ",";
        } else {
            order = request.getParameter("addToCart") + ",";
        }

        Cookie cart = new Cookie("cart", order);
        cart.setMaxAge(60*60*24);
        response.addCookie(cart);

        String site = "genericShopHome.jsp";
        response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", site);
    }


}
