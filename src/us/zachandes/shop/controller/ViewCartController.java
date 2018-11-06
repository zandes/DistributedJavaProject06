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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ViewCartController extends HttpServlet {
    private String RESULT_PAGE = "genericShopViewCart.jsp";

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method. Not currently used.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    } // </editor-fold>

    @Override
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
            }
        }

        request.setAttribute("cartView", products);
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




    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Main Controller";
    }// </editor-fold>
}
