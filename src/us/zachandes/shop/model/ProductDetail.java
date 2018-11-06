package us.zachandes.shop.model;

import us.zachandes.shop.database.ServoDAOImp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class ProductDetail {

    private List<Product> productList;
    ServoDAOImp servoDAOImp = new ServoDAOImp();

    public ProductDetail() {
        productList = servoDAOImp.retrieveContent();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Product getProductFromUPC(String upc){
        Product currentProduct = null;
        for(Product product : productList){
            if(product.getUpc().equals(upc)){
                currentProduct = product;
            }
        }

        return currentProduct;
    }
}
