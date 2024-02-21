package com.example.springapp.services;

import com.example.springapp.entities.Customer;
import com.example.springapp.entities.Sale;
import com.example.springapp.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> findAll(){

        return customerRepository.findAll();
    }

    public Customer findById(Integer id ){
        Optional<Customer> optional = customerRepository.findById(id);

        return optional.isPresent() ? optional.get() : null;
    }

    public Customer save(Customer customer){

        return customerRepository.save(customer);
    }

    public List<Customer> findByName(String name ){

        return customerRepository.findByName( name );
    }

    public List<Sale> getSales(Customer customer){
        return customer.getSales();
    }

    public void delete( Customer customer){
        customerRepository.delete(customer);
    }
}
