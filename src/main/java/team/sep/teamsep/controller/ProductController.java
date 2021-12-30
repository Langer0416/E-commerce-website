package team.sep.teamsep.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.sep.teamsep.model.Order;
import team.sep.teamsep.model.Product;
import team.sep.teamsep.model.ShopCar;
import team.sep.teamsep.service.ProductService;

/**
 * ProductController.
 */
@RestController
public class ProductController {

  @Autowired
    ProductService productManager;

  @GetMapping("/Countproducts")
    public List<Product> getCountProducts() {
    return productManager.getCountProducts();
  }


  @GetMapping("/products")
    public List<Product> getProduct(@RequestParam("id") long id) {
    return productManager.getProducts(id);
  }

  @GetMapping("/shopcar")
    public List<ShopCar> getProducts1(@RequestParam("account") String account) {
    return productManager.getProducts1(account);
  }

  /**
   * checkshopcar.
   */

  @GetMapping(value = "/checkshopcar")
    public List<ShopCar> checkshopcar(
            @RequestParam ("account") String account,
            @RequestParam ("name") String name
  ) {
    //System.out.println(account);
    //System.out.println(name);
    return  productManager.checkshopcar(account, name);
  }

  @GetMapping("/Order")
    public List<Order> getProductOrder() {
    return productManager.getProductOrder();
  }

  @GetMapping("/products/{keyword}")
    public List<Product> getProducts(@PathVariable("keyword") String keyword) {

    return productManager.getProducts(keyword);
  }

  @GetMapping(value = "/ChooseProductIntoShopCar/{id}")
    public List<Product> insertintocar1(
            @PathVariable("id") String id
  ) {
    //System.out.println(id);
    return productManager.insertintocar1(id);
  }

  @GetMapping(value = "/shopcar/{id}")
    public String insertintocar2(
            @PathVariable("id")  String id
  ) {
    System.out.println(id);
    return productManager.insertintocar2(id);
  }

  @GetMapping(value = "/stuffintocar")
    public String stuffin(
            @RequestParam("price") long price,
            @RequestParam("picture") String picture,
            @RequestParam("instock") long instock,
            @RequestParam("quantity") long quantity,
            @RequestParam("name") String name,
            @RequestParam("account") String account
  ) {
    System.out.println(price);
    return productManager.stuffintocar(price, picture, instock, quantity, name, account);
  }

  /**
   * payment.
   */

  @GetMapping(value = "/pay")
    public String send(
            @RequestParam("account")  String account,
            @RequestParam("pay") String pay,
            @RequestParam("deliver")  String deliver,
            @RequestParam("name")  String name,
            @RequestParam("money")  Integer money
  ) {

    System.out.println(account);
    return productManager.pay(account, pay, deliver, name, money);
  }

  @RequestMapping(value = "/add", method = RequestMethod.GET)
  @ResponseBody
    public String add(
            @RequestParam("name")  String name,
            @RequestParam("stock")  Integer stock,
            @RequestParam("price")  Integer price,
            @RequestParam("quantity")  Integer quantity,
            @RequestParam("picture")  String picture
  ) {
    return productManager.addProduct(name, stock, price, quantity, picture);
  }

  @RequestMapping(value = "/shown", method = RequestMethod.GET)
  @ResponseBody
    public String shown(
            @RequestParam("id")  String name
  ) {
    return productManager.shownProduct(name);
  }

  @RequestMapping(value = "/update", method = RequestMethod.GET)
  @ResponseBody
    public String update(
            @RequestParam("name")  String name,
            @RequestParam("stock")  Integer stock,
            @RequestParam("price")  Integer price,
            @RequestParam("quantity")  Integer quantity,
            @RequestParam("picture")  String picture
  ) {
    return productManager.updateProduct(name, stock, price, quantity, picture);
  }

  @RequestMapping(value = "/UpdateShopCarProduct", method = RequestMethod.GET)
  @ResponseBody
    public String update(
            @RequestParam("id")  Integer id,
            @RequestParam("price")  Integer price,
            @RequestParam("quantity")  String quantity,
            @RequestParam("name") String name,
            @RequestParam("account") String account
  ) {
    return productManager.updateShopcarProduct(id, price, quantity, name, account);
  }

  @RequestMapping(value = "/change", method = RequestMethod.GET)
  @ResponseBody
    public String change(
            @RequestParam("account")  String account,
            @RequestParam("password")  String password
  ) {
    return productManager.changepassword(account, password);
  }

  @RequestMapping(value = "/changesellerpassword", method = RequestMethod.GET)
  @ResponseBody
    public String changesellerpassword(
            @RequestParam("account")  String account,
            @RequestParam("password")  String password
  ) {
    return productManager.sellerchangepassword(account, password);
  }

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  @ResponseBody
    public String login(
            @RequestParam("account")  String account,
            @RequestParam("password")  String password
  ) {
    return productManager.loginProduct(account, password);
  }

  @RequestMapping(value = "/login1", method = RequestMethod.GET)
  @ResponseBody
    public String login1(
            @RequestParam("account")  String account,
            @RequestParam("password")  String password
  ) {
    return productManager.loginProduct1(account, password);
  }

  @RequestMapping(value = "/register", method = RequestMethod.GET)
  @ResponseBody
    public String register(
            @RequestParam("account")  String account,
            @RequestParam("name")  String name,
            @RequestParam("phone")  Integer phone,
            @RequestParam("password")  String password
  ) {
    return productManager.registerProduct(account, name, phone, password);
  }
}