package com.works.restjpa.restcontrollers;

import com.works.restjpa.entities.Product;
import com.works.restjpa.services.DummyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dummy")
public class DummyRestController {
    final DummyService dummyService;

    @GetMapping("/allProduct")
    public Object allProduct() {
        return dummyService.getAllProduct();
    }

    @PostMapping("/addProduct")
    public Product addProduct(){
        return dummyService.addProduct();
    }

}
