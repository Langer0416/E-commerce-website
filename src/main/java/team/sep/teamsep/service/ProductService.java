package team.sep.teamsep.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;
import team.sep.teamsep.database.Sql2oDbHandler;
import team.sep.teamsep.model.Order;
import team.sep.teamsep.model.Product;
import team.sep.teamsep.model.ShopCar;

@Service
public class ProductService {
  @Autowired
  private Sql2oDbHandler sql2oDbHandler;

  public ProductService() {

  }

  public List<Product> getCountProducts() {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "SELECT PRODUCT_ID id,PRODUCT_NAME name,INSTOCK"
          +
                " stock,PICTURE picture,PRICE price,QUANTITY quantity FROM project.product ";


      return connection.createQuery(query)
                .executeAndFetch(Product.class);
    }
  }

  public List<Product> getProducts(long id) {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "SELECT PRODUCT_ID id,PRODUCT_NAME name,INSTOCK stock,PICTURE picture,"
                +
                "PRICE price,QUANTITY quantity FROM project.product "
                +
                "where PRODUCT_ID <= :id and PRODUCT_ID >= :id-5";

      //System.out.println(id);
      return connection.createQuery(query)
                .addParameter("id", id)
                .executeAndFetch(Product.class);
    }
  }

  public List<ShopCar> getProducts1(String account) {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "SELECT PRODUCT_NAME name,PRODUCT_ID id,INSTOCK stock,"
          +
          "PICTURE picture,PRICE price,QUANTITY quantity FROM project.productcar"
          +
          " where ACCOUNT =:account";

      return connection.createQuery(query)
          .addParameter("account", account)
          .executeAndFetch(ShopCar.class);
    }
  }

  public List<ShopCar> CheckShopCar(String account, String name) {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "SELECT ACCOUNT account,PRODUCT_NAME name,PRODUCT_ID id,"
                +
                "INSTOCK stock,PICTURE picture,PRICE price,QUANTITY "
                +
                "quantity FROM project.productcar "
                +
                "where PRODUCT_NAME = :name and ACCOUNT =:account";
      //System.out.println(query);
      //System.out.println(account);
      //System.out.println(name);
      return connection.createQuery(query)
                    .addParameter("name", name)
                    .addParameter("account", account)
                    .executeAndFetch(ShopCar.class);
    }
  }

  public List<Order> getProductOrder() {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "select pay.account,pay.id ,pay.name,pay.pay,"
          +
          "pay.deliver,pay.money from pay order by pay.id";

      return connection.createQuery(query)
                    .executeAndFetch(Order.class);
    }
  }

  public List<Product> getProducts(String keyword) {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "select PRODUCT_NAME name,PRODUCT_ID id,INSTOCK stock,"
                +
                "PICTURE picture,PRICE price,QUANTITY quantity"
                +
                " FROM project.product where PRODUCT_NAME like :keyword";

      return connection.createQuery(query)
                .addParameter("keyword", "%" + keyword + "%")
                .executeAndFetch(Product.class);
    }
  }

  //List<Product> first = 0;
  public List<Product> InsertIntoCar1(String id) {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      //String query = "Insert into project.productcar(PRODUCT_NAME,INSTOCK,PRICE,PICTURE)
      // select PRODUCT_NAME,INSTOCK,PRICE,PICTURE FROM project.product where PRODUCT_NAME = :id";
      // String query1 ="Insert into project.productcar(QUANTITY) VALUES(:amount)
      // where PRODUCT_NAME =':id'";
      String query2 = "select PRODUCT_NAME name,PRODUCT_ID id,INSTOCK stock,"
                +
                "PICTURE picture,PRICE price,QUANTITY quantity"
                +
                " FROM project.product where PRODUCT_NAME =:id";


      return connection.createQuery(query2)
                    .addParameter("id", id)
                    .executeAndFetch(Product.class);
            //System.out.println(query2);
            /*connection.createQuery(query1)
                            .addParameter("amount",amount)
                            .addParameter("id",id)
                            .executeUpdate();*/
            //System.out.println(query);
            //System.out.println(id);
          /*connection.createQuery(query)
                    .addParameter("id",id)
                    //.addParameter("amount",amount)
                    .executeUpdate();*/

    }
  }

  public String StuffIntoCar(long price, String picture, long instock, long
        quantity, String name, String account) {
        try (Connection connection = sql2oDbHandler.getConnector().open()) {
          String query = "Insert INTO project.productcar(PRICE,PICTURE,INSTOCK,QUANTITy,PRODUCT_NAME,ACCOUNT) "
                +
                "VALUES(:price,:picture,:instock,:quantity,:name,:account)";

          System.out.println(query);
          connection.createQuery(query)
                    .addParameter("price", price)
                    .addParameter("picture", picture)
                    .addParameter("instock", instock)
                    .addParameter("quantity", quantity)
                    .addParameter("name", name)
                    .addParameter("account", account)
                    .executeUpdate();
        }
        return "success";
    }

    public String pay(String account,String pay,String deliver,String name,Integer money) {
        try (Connection connection = sql2oDbHandler.getConnector().open()) {
            String query = "Insert INTO project.pay(account,pay,deliver,name,money) VALUES(:account,:pay,:deliver,:name,:money+10)";

            System.out.println(query);
            connection.createQuery(query)
                .addParameter("account",account)
                .addParameter("pay",pay)
                    .addParameter("deliver",deliver)
                .addParameter("name",name)
                .addParameter("money",money)
                .executeUpdate();

            String query1 = "DELETE FROM project.productcar where PRODUCT_NAME = :name";
          System.out.println(query1);
          connection.createQuery(query1)
              .addParameter("name",name)
              .executeUpdate();
        }
        return "success";
    }

    public String shownProduct(String id) {
      try (Connection connection = sql2oDbHandler.getConnector().open()) {
        String query = "DELETE FROM project.productcar where PRODUCT_NAME = :id";

        System.out.println(query);
        connection.createQuery(query)
            .addParameter("id",id)
            .executeUpdate();
      }
      return "success";
    }

    public String InsertIntoCar2(String id) {
        try (Connection connection = sql2oDbHandler.getConnector().open()) {
            String query = "DELETE FROM project.productcar where PRODUCT_NAME = :id";

            System.out.println(query);
            connection.createQuery(query)
                .addParameter("id",id)
                .executeUpdate();

        }
        return "success";
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
    public String updateShopcarProduct(Integer id, Integer price,String quantity,String name,String account) {
        try (Connection connection = sql2oDbHandler.getConnector().open()) {
            String query = "UPDATE project.productcar SET PRODUCT_ID =:id, PRICE =:price,QUANTITY = :quantity  WHERE PRODUCT_NAME = :name and ACCOUNT=:account";


            connection.createQuery(query)
                    .addParameter("id",id)
                    .addParameter("price",price)
                    .addParameter("quantity",quantity)
                    .addParameter("name", name)
                    .addParameter("account",account)
                    .executeUpdate();
            return "Success";
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
            return "Success";
        }
    }
    Boolean correct;
    public String changepassword(String account,String password) {
        try (Connection connection = sql2oDbHandler.getConnector().open()) {
            String query = "UPDATE project.customer SET PASSWORD =:password  WHERE ACCOUNT = :account";



                     connection.createQuery(query)
                    .addParameter("password",password )
                    .addParameter("account" ,account)
                    .executeUpdate();
            System.out.println(password);
            System.out.println(account);
            //System.out.println(correct);
            return "success" ;
        }
    }

    public String sellerchangepassword(String account,String password) {
        try (Connection connection = sql2oDbHandler.getConnector().open()) {
            String query = "UPDATE project.seller SET PASSWORD =:password  WHERE ACCOUNT = :account";



            connection.createQuery(query)
                    .addParameter("password",password )
                    .addParameter("account" ,account)
                    .executeUpdate();
            System.out.println(password);
            System.out.println(account);
            //System.out.println(correct);
            return "success" ;
        }
    }
    int count;
    public String loginProduct(String account,String password) {
        try (Connection connection = sql2oDbHandler.getConnector().open()) {
            String query = "SELECT count(*) as total FROM project.customer WHERE ACCOUNT=:account and PASSWORD =:password";

            count=connection.createQuery(query)
                .addParameter("account", account)
                .addParameter("password", password)
                .executeScalar(Integer.class);
        }
        if(count>0) {
            return "Success";
        }
        else{
            return "fail";
        }
    }

    int count1;
    public String loginProduct1(String account,String password) {
        try (Connection connection = sql2oDbHandler.getConnector().open()) {
            String query = "SELECT count(*) as total FROM project.seller WHERE ACCOUNT=:account and PASSWORD =:password";

            count1=connection.createQuery(query)
                .addParameter("account", account)
                .addParameter("password", password)
                .executeScalar(Integer.class);
        }
        if(count1>0) {
            return "Success";
        }
        else{
            return "fail";
        }
    }

int b;
    public String registerProduct(String account,String name,Integer phone,String password) {
        try (Connection connection = sql2oDbHandler.getConnector().open()) {
            String query = "Insert INTO project.customer(ACCOUNT,NAME,PHONE_NUMBER,PASSWORD) VALUES(:account,:name,:phone,:password)";

                b=connection.createQuery(query)
                .addParameter("account", account)
                .addParameter("name", name)
                .addParameter("phone", phone)
                .addParameter("password", password)
                .executeUpdate()
                    .getKey(int.class);
            if(b==0) {
                return "success";
            }
            else{
                return "Fail";
            }
        }
    }

}
