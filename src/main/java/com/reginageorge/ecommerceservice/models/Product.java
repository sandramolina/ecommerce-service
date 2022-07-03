package com.reginageorge.ecommerceservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import org.hibernate.annotations.Cascade;
import org.joda.money.Money;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@AllArgsConstructor
@Builder
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "price")
    private Money price;

    @NotNull
    @Column(name = "product_category")
    private String productCategory;

    @Column(name = "image")
    private String image;

    @NotNull
    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "long_description")
    private String longDescription;

    //TODO Transform Raiting and RateCount into an object
    @Column(name = "rating")
    private double rating;

    @Column(name = "rate_count")
    private int rate_count;

    //TODO transform this so it used the enum Ingredients instead of the class
    @Column(name = "ingredient_list")
    @ElementCollection(targetClass=Ingredients.class)
    private List<Ingredients> ingredients;

    public Product() {
    }

    //TODO Make this use the enum colors
//    @Column(name = "colors")
//    private List<String> colors;

    public void addIngredient(Ingredients ingredient){
        this.ingredients.add(ingredient);
    }

//    public void addColor(String color){
//        this.colors.add(color);
//    }
}
