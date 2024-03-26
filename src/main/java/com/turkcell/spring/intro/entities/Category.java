package com.turkcell.spring.intro.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="categories")
public class Category
{
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;

    // DEĞİŞKEN İSMİ!

    // TODO: DTO İLE ÇÖZ
    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
