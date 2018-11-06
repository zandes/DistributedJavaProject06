package us.zachandes.shop.database;

import us.zachandes.shop.model.Product;

import java.util.List;

public interface ServoDAO {
    List<Product> retrieveContent();
}
