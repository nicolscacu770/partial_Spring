package com.example.springapp.services;

import com.example.springapp.entities.Customer;
import com.example.springapp.entities.Product;
import com.example.springapp.entities.Sale;
import com.example.springapp.repositories.ProductRepository;
import com.example.springapp.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;

    public List<Sale> findAll(){
        return saleRepository.findAll();
    }

    public Sale save( Sale sale, Customer customer ){
        sale.setCustomer( customer );
        return saleRepository.save( sale );
    }

    public Sale findById(Integer id ){
        Optional<Sale> optional = saleRepository.findById( id );

        return optional.isPresent() ? optional.get() : null;
    }
}
