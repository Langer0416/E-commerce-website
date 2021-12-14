package team.sep.teamsep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import team.sep.teamsep.model.Product;
import team.sep.teamsep.service.ProductService;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productManager;

    @GetMapping("/products")
    public List<Product> getProduct(){
        return productManager.getProducts();
    }

    @GetMapping("/products/{keyword}")
    public List<Product>getProducts(@PathVariable("keyword") String keyword) {
        return productManager.getProducts(keyword);
    }


    @RequestMapping(value= "/add", method= RequestMethod.GET)
    @ResponseBody
    public String add(
        @RequestParam("name")  String name,
        @RequestParam("stock")  Integer stock,
        @RequestParam("price")  Integer price,
        @RequestParam("quantity")  Integer quantity,
        @RequestParam("picture")  String picture
    ){
        return productManager.addProduct(name,stock, price,quantity, picture);}

    @RequestMapping(value="/update", method=RequestMethod.GET)
    @ResponseBody
    public String update(
        @RequestParam("name")  String name,
        @RequestParam("stock")  Integer stock,
        @RequestParam("price")  Integer price,
        @RequestParam("quantity")  Integer quantity,
        @RequestParam("picture")  String picture
    ){
        return productManager.updateProduct(name,stock, price,quantity, picture);
    }

    @RequestMapping(value="/login", method=RequestMethod.GET)
    @ResponseBody
    public String login(
        @RequestParam("account")  String account,
        @RequestParam("password")  String password
    ){
        return productManager.loginProduct(account,password);
    }

    @RequestMapping(value="/register", method=RequestMethod.GET)
    @ResponseBody
    public String register(
        @RequestParam("account")  String account,
        @RequestParam("name")  String name,
        @RequestParam("phone")  Integer phone,
        @RequestParam("password")  String password
    ){
        return productManager.registerProduct(account,name,phone,password);
    }
}
