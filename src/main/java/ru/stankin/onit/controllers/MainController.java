package ru.stankin.onit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.stankin.onit.model.Product;
import ru.stankin.onit.repository.ProductRepo;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    private final ProductRepo productRepo;

    public MainController(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @GetMapping("/")
    public String index(Map<String, Object> model) {
        List<Product> products = Collections.emptyList();
        model.put("products", products);
        return "index";
    }

    @GetMapping("/product")
    public String product(@RequestParam(defaultValue = "lol") String name, Map<String, Object> model) {
        List<Product> products = productRepo.findByName(name);
        model.put("products", products);
        return "index";
    }

//    @GetMapping("/init")
//    public String init() {
//        Product product = new Product();
//
//        product.setCode("awd");
//        product.setName("Dwafwaf");
//        product.setPrice(12414412);
//        product.setStorage("5");
//        productRepo.save(product);
//
//        return "ok";
//    }
}
