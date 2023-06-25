package com.works.restjpa.models;

import lombok.Data;

import java.util.List;

@Data
public class Products {
    private List<Product> products;
    private Long total;
    private Long skip;
    private Long limit;
}
