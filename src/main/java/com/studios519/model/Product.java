package com.studios519.model;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "products")

public class Product
{
    public Product(){}
    @Id
    @GeneratedValue()
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotEmpty(message = "*Please provide an product name")
    private String name;

    @Column(name = "description")
    @NotEmpty(message = "*Please provide an product description")
    private String description;

    @Column(name = "live")
    private int live;

    public String getName() {
        return name;
    }
    public Long getId(){return id;}
    public Long setId(Long id){ return this.id = id;}
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLive() { return live; }
    public int setLive(int live) { return this.live = live; }
}
