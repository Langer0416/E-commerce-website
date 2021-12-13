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
            String query = "SELECT PRODUCT_NAME name,PRODUCT_ID id,INSTOCK stock,PICTURE picture,PRICE price,QUANTITY quantity FROM project.product" ;

            return connection.createQuery(query).executeAndFetch(Product.class);
        }
    }

    public List<Product> getProducts(String keyword) {
        try (Connection connection = sql2oDbHandler.getConnector().open()) {
            String query = "select PRODUCT_NAME name,PRODUCT_ID id,INSTOCK stock,PICTURE picture,PRICE price,QUANTITY quantity"
                + " FROM project.product where PRODUCT_NAME like :keyword";

            return connection.createQuery(query)
                .addParameter("keyword", "%" + keyword + "%")
                .executeAndFetch(Product.class);
        }
    }


    public String addProduct(String name, Integer stock,Integer price,Integer quantity,String picture) {
        try (Connection connection = sql2oDbHandler.getConnector().open()) {
            String query = "Insert INTO project.product(PRODUCT_NAME,INSTOCK,PRICE,QUANTITY,PICTURE) VALUES(:name,:stock,:price,:quantity,:picture)";

            System.out.println(query);
            connection.createQuery(query)
                .addParameter("name",name)
                .addParameter("stock",stock)
                .addParameter("price",price)
                .addParameter("quantity",quantity)
                .addParameter("picture",picture)
                .executeUpdate();

            return "success";
        }
    }

    public String updateProduct(String name, Integer stock,Integer price,Integer quantity,String picture) {
        try (Connection connection = sql2oDbHandler.getConnector().open()) {
            String query = "UPDATE project.product SET INSTOCK =:stock, PRICE = :price,QUANTITY = :quantity ,PICTURE = :picture WHERE PRODUCT_NAME = :name";


            connection.createQuery(query)
                .addParameter("name",name)
                .addParameter("stock",stock)
                .addParameter("price",price)
                .addParameter("quantity",quantity)
                .addParameter("picture",picture)
                .executeUpdate();

            return "success";
        }
    }

}
