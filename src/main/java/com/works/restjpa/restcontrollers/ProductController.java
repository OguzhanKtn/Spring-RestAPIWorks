package com.works.restjpa.restcontrollers;

import com.works.restjpa.entities.Product;
import com.works.restjpa.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    final ProductService productService;

    @PostMapping("/add")
    public ResponseEntity read(@RequestBody Product product){
      return productService.save(product);
    }

    @GetMapping("/list")
    public ResponseEntity read(){
        return productService.list();
    }

    @GetMapping("/list/{cid}")
    public ResponseEntity read(@PathVariable Long cid){
        return productService.listCat(cid);
    }

    @GetMapping("/listPage/{cid}")
    public ResponseEntity read(@PathVariable Long cid, @RequestParam(defaultValue = "0") int page){
        return productService.listCatPage(cid,page);
    }

}
