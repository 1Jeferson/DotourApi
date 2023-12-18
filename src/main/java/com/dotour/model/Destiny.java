package com.dotour.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Destiny {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "name_destiny", length = 100, nullable = false)
    private String destiny;

    private String location;

    private String description;

    @Column(name = "price_desitny")
    private Double price;

    @OneToMany(mappedBy = "destiny", fetch = FetchType.LAZY)
    private Set<Purshace> purshaces;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestiny() {
        return this.destiny;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
