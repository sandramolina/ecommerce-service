package com.reginageorge.ecommerceservice.models;

import com.sun.istack.NotNull;
import org.joda.money.Money;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "prsNoLombok")
public class PrNoLombok {
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

    @Column(name = "rating")
    private double rating;

    @Column(name = "ingredients")
    @ElementCollection(targetClass=Ingredients.class)
    private List<Ingredients> ingredientsLists;

    @Column(name = "colours")
    @ElementCollection(targetClass=String.class)
    private List<String> colours;

    public PrNoLombok() {
    }

    public PrNoLombok(String title, Money price, int stock) {
        this.title = title;
        this.price = price;
        this.ingredientsLists = new ArrayList<Ingredients>();
        this.stock = stock;
        this.colours = new ArrayList<String>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    public List<Ingredients> getIngredientsLists() {
        return ingredientsLists;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<String> getColours() {
        return colours;
    }

    public void setColours(List<String> colours) {
        this.colours = colours;
    }

    public void setIngredientsLists(List<Ingredients> ingredientsLists) {
        this.ingredientsLists = ingredientsLists;
    }

    public void addColour(String colour){this.colours.add(colour);}

    public void addIngredient(Ingredients  ingredient){
        this.ingredientsLists.add(ingredient);
    }
}
