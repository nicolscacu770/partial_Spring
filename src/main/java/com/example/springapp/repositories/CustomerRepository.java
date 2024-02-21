package com.example.springapp.repositories;

import com.example.springapp.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("SELECT a FROM Customer a WHERE a.name LIKE CONCAT('%',:name,'%')")
    public List<Customer> findByName(String name);

}
