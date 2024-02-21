package com.example.springapp.controllers;

import com.example.springapp.entities.Customer;
import com.example.springapp.entities.Product;
import com.example.springapp.entities.Sale;
import com.example.springapp.responses.ResponseHandler;
import com.example.springapp.services.SaleService;
import com.example.springapp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sales")
public class SaleController {
    @Autowired
    private SaleService SaleService;
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<Object> findAll(){
        try{
            List<Sale> result = SaleService.findAll();

            return ResponseHandler.generateResponse("Success",HttpStatus.OK, result );

        }catch( Exception e ){

            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<Object> save(@RequestBody Sale sale, @PathVariable Integer id ){
        try{
            Customer customer = customerService.findById( id );
            if( customer != null ){

                Sale result = SaleService.save(sale, customer);

                return ResponseHandler.generateResponse("Succes",HttpStatus.CREATED, sale);
            }
            return ResponseHandler.generateResponse("Success Author",HttpStatus.NOT_FOUND, null );

        }catch( Exception e ){

            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }

}
