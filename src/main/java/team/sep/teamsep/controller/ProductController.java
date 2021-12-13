package team.sep.teamsep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
