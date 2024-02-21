package com.example.springapp.services;

import com.example.springapp.entities.Product;
import com.example.springapp.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product save( Product product ){

        return productRepository.save(product);
    }

    public Product findById(Integer id ){
        Optional<Product> optional = productRepository.findById( id );

        return optional.isPresent() ? optional.get() : null;
    }
}
