package com.example.springapp.controllers;

import com.example.springapp.entities.Customer;
import com.example.springapp.entities.Product;
import com.example.springapp.responses.ResponseHandler;
import com.example.springapp.services.ProductService;
import com.example.springapp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<Object> findAll(){
        try{
            List<Product> result = productService.findAll();

            return ResponseHandler.generateResponse("Success",HttpStatus.OK, result );

        }catch( Exception e ){

            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<Object> save(@RequestBody Product product, @PathVariable Integer id ){
        try{
            Product result = productService.save(product);

            return ResponseHandler.generateResponse("Succes",HttpStatus.CREATED, product);

        }catch( Exception e ){

            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }


    /*@PutMapping("/{id}")
    public ResponseEntity<Product> updateProducto(@PathVariable Integer id, @RequestBody Product product) {
        try{
            product.setId(id);
            Product productoActualizado = productService.updateProducto(product);
            return ResponseHandler.generateResponse("Success",HttpStatus.OK, productoActualizado );
        }catch( Exception e ){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }


    }*/
}
