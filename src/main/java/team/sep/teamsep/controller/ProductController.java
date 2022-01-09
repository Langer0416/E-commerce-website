package team.sep.teamsep.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ValueConstants;
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

  @GetMapping("/Countproducts1")
  public List<Product>  getCountProducts1(
      @RequestParam("account") String account
  ) {
    return productManager.getCountProducts1(account);
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

  @GetMapping(value = "/CheckShopCar")
  public List<ShopCar> aaCheckShopCar(
      @RequestParam ("account") String account,
      @RequestParam ("name") String name
  ) {
    //System.out.println(account);
    //System.out.println(name);
    return  productManager.CheckShopCar(account, name);
  }

  @GetMapping(value = "/InstockByProductname")
  public List<Product> aaInstockByProductname(
      @RequestParam("name") String name) {
    System.out.println(name);
    return productManager.InstockByProductname(name);
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
  public List<Product> aaInsertIntoCar1(
      @PathVariable("id") String id
  ) {
    //System.out.println(id);
    return productManager.InsertIntoCar1(id);
  }

  @GetMapping(value = "/shopcar/{id}")
  public String aaInsertIntoCar2(
      @PathVariable("id")  String id
  ) {
    System.out.println(id);
    return productManager.InsertIntoCar2(id);
  }

  @GetMapping(value = "/StuffIntoCar")
  public String aaStuffIn(
      @RequestParam("price") long price,
      @RequestParam("picture") String picture,
      @RequestParam("instock") long instock,
      @RequestParam("quantity") long quantity,
      @RequestParam("name") String name,
      @RequestParam("account") String account
  ) {
    System.out.println(price);
    return productManager.StuffIntoCar(price, picture, instock, quantity, name, account);
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
      @RequestParam("money")  Integer money,
      @RequestParam("quantity") String quantity
  ) {

    // System.out.println(nowstock);
    return productManager.pay(account, pay, deliver, name, money, quantity);
  }

  @RequestMapping(value = "/add", method = RequestMethod.GET)
  @ResponseBody
  public String add(
      @RequestParam("name")  String name,
      @RequestParam("stock")  Integer stock,
      @RequestParam("price")  Integer price,
      @RequestParam("quantity")  Integer quantity,
      @RequestParam("picture")  String picture,
      @RequestParam("account") String account
  ) {
    return productManager.addProduct(name, stock, price, quantity, picture, account);
  }

  @RequestMapping(value = "/shown", method = RequestMethod.GET)
  @ResponseBody
  public String shown(
      @RequestParam("id")  String name
  ) {
    return productManager.shownProduct(name);
  }

  @RequestMapping(value = "/updatestock", method = RequestMethod.GET)
  @ResponseBody
  public String updatestock(
      @RequestParam("name")  String name,
      @RequestParam("stock")  Integer stock
  ) {
    return productManager.updatestock(name, stock);
  }

  @RequestMapping(value = "/update", method = RequestMethod.GET)
  @ResponseBody
  public String update(
      @RequestParam("name")  String name,
      @RequestParam("stock")  Integer stock,
      @RequestParam("price")  Integer price,
      @RequestParam("quantity")  Integer quantity,
      @RequestParam("picture")  String picture,
      @RequestParam("account") String account
  ) {
    return productManager.updateProduct(name, stock, price, quantity, picture, account);
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

  @RequestMapping(value = "/check_your_product", method = RequestMethod.GET)
  @ResponseBody
  public String check_your_product(
      @RequestParam("name")  String name,
      @RequestParam("account")  String account
  ) {
    return productManager.check_your_product(name, account);
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