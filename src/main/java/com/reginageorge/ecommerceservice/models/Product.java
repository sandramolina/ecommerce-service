package com.reginageorge.ecommerceservice.models;

import com.sun.istack.NotNull;
import lombok.*;
import org.joda.money.Money;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "stock")
    private int stock;

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

    //TODO Rating class with rate and count
   @Column(name = "rating")
    private double rating;

    @Column(name = "ingredient_list")
    @ElementCollection(targetClass=Ingredients.class)
    private List<Ingredients> ingredients;

    @Column(name = "colours")
    @ElementCollection(targetClass=Colours.class)
    private List<Colours> colours;

    public void addIngredient(Ingredients ingredient){
        this.ingredients.add(ingredient);
    }

    public void addColour(Colours colour){this.colours.add(colour);}
}
