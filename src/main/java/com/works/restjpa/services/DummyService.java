package com.works.restjpa.services;

import com.works.restjpa.entities.Product;
import com.works.restjpa.models.Products;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class DummyService {

    final RestTemplate restTemplate;

    public Object getAllProduct(){
        String url = "https://dummyjson.com/products";
        Products obj = restTemplate.getForObject(url, Products.class);
        String title = obj.getProducts().get(0).getTitle();
        System.out.println(title);
        return obj;
    }

    public Product addProduct(){
        String url = "https://dummyjson.com/products/add";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        Product product = new Product();
        product.setTitle("TV");

        HttpEntity httpEntity = new HttpEntity(product,httpHeaders);

       ResponseEntity<Product> responseEntity = restTemplate.postForEntity(url,httpEntity,Product.class);
       return responseEntity.getBody();
    }
}
