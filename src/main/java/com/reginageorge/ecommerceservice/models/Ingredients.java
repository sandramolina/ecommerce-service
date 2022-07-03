package com.reginageorge.ecommerceservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ingredients")
public class Ingredients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ingredient_id;

    private String  ingredient;

    @ManyToMany
    @JsonIgnoreProperties({"ingredients"})
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "ingredients_products",
            joinColumns = {@JoinColumn(name = "ingredient_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "product_id", nullable = false, updatable = false)}
    )
    private List<Product> products;

    public Ingredients() {
    }

    public Ingredients(String ingredient) {
        this.ingredient_id = ingredient_id;
        this.ingredient = ingredient;
        this.products = new ArrayList<Product>();
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public void addProduct(Product product){
        this.products.add(product);
    }
}
