package com.example.springapp.controllers;

import com.example.springapp.entities.Customer;
import com.example.springapp.entities.Sale;
import com.example.springapp.responses.ResponseHandler;
import com.example.springapp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService CustomerService; // inyectar dpendencia del servicio

    @GetMapping()
    public ResponseEntity<Object> findAll(){
        try {
            List<Customer> result = CustomerService.findAll();

            return ResponseHandler.generateResponse("Success",HttpStatus.OK,result);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById( @PathVariable Integer id ){
        try {
            Customer customer = CustomerService.findById( id );

            return  ResponseHandler.generateResponse("Success",HttpStatus.OK, customer);
        }catch (Exception e){
            return  ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Customer customer){
        try {
            Customer result = CustomerService.save(customer);

            return  ResponseHandler.generateResponse("Success",HttpStatus.CREATED,result);

        }catch (Exception e){
            return  ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Object> findByName(@PathVariable  String name){
        try {
            List<Customer> result = CustomerService.findByName( name );

            return  ResponseHandler.generateResponse("Success",HttpStatus.OK,result );
        }catch (Exception e){
            return  ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }

    @GetMapping("/sales/{id}")
    public ResponseEntity<Object> getBooks(@PathVariable Integer id){
        try{
            Customer customer = CustomerService.findById( id );
            if( customer != null){
                List<Sale> result = CustomerService.getSales(customer);

                return ResponseHandler.generateResponse("Succes",HttpStatus.OK,result);
            }
           return ResponseHandler.generateResponse("Succes",HttpStatus.CREATED,null);

        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id){
        try{
            Customer customer = CustomerService.findById( id );
            if( customer != null){
                CustomerService.delete(customer);

                return ResponseHandler.generateResponse("Succes", HttpStatus.ACCEPTED, customer);
            }
            return ResponseHandler.generateResponse("Succes Author",HttpStatus.NOT_FOUND, null);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
