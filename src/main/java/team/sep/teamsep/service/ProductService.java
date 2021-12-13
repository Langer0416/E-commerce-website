package team.sep.teamsep.service;

import team.sep.teamsep.model.Product;
import team.sep.teamsep.database.Sql2oDbHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private Sql2oDbHandler sql2oDbHandler;

    public ProductService() {

    }

    public List<Product> getProducts() {
        try (Connection connection = sql2oDbHandler.getConnector().open()) {
            String query = "SELECT PRODUCT_NAME name,PRODUCT_ID id,INSTOCK instock,PICTURE picture,PRICE price,QUANTITY quantity FROM project.product" ;

            return connection.createQuery(query).executeAndFetch(Product.class);
        }
    }
}
