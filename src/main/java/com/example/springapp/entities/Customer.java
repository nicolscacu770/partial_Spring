package com.example.springapp.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 20)
    private String cedula;

    @Column(nullable = false, length = 20)
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<Sale> sales;

    public Customer() {
        sales = new ArrayList<>();
    }

    public Customer(Integer id, String name, String cedula, String email) {
        this.id = id;
        this.name = name;
        this.cedula = cedula;
        this.email = email;
    }

    //GETTERS & SETTERS7
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales){
        this.sales = sales;
    }
}
