package us.zachandes.shop.database;

import us.zachandes.shop.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServoDAOImp implements ServoDAO {

    public List<Product> retrieveContent() {
        List<Product> productList = new ArrayList<>();
        final String DB_URL = "jdbc:derby:ServoDB";
        Statement stmt = null;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL);
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT ProdUPC, ProdName, Description, Price FROM Servo";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                //Retrieve by column name
                String id = rs.getString("ProdUPC");
                String name = rs.getString("ProdName");
                double price = rs.getDouble("Price");
                String description = rs.getString("Description");

                productList.add(new Product(id, name, description, price));

            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try

        return productList;
    }
}