package com.works.restjpa.services;

import com.works.restjpa.configs.Rest;
import com.works.restjpa.entities.Product;
import com.works.restjpa.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    final ProductRepository repository;

    public ResponseEntity save(Product product){
        try{
            repository.save(product);
            Rest rest = new Rest(true, product);
            return new ResponseEntity(rest,HttpStatus.OK);

        }catch (Exception ex){
            Rest rest = new Rest(false, ex.getMessage());
            return new ResponseEntity(rest,HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity list(){
        try{
            Rest rest = new Rest(true,repository.proCatJoin());
            return new ResponseEntity<>(rest,HttpStatus.OK);
        }catch (Exception ex){
            Rest rest = new Rest(false,ex.getMessage());
            return new ResponseEntity<>(rest,HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity listCat(Long cid){
        try{
            Rest rest = new Rest(true,repository.proCatJoin(cid));
            return new ResponseEntity<>(rest,HttpStatus.OK);
        }catch (Exception ex){
            Rest rest = new Rest(false,ex.getMessage());
            return new ResponseEntity<>(rest,HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity listCatPage(Long cid,int page){
        try{
            Sort sort = Sort.by("pid").descending();
            Pageable pageable = PageRequest.of(page,3,sort);
            Rest rest = new Rest(true,repository.proCatJoin(cid,pageable));
            return new ResponseEntity<>(rest,HttpStatus.OK);
        }catch (Exception ex){
            Rest rest = new Rest(false,ex.getMessage());
            return new ResponseEntity<>(rest,HttpStatus.BAD_REQUEST);
        }
    }
}
