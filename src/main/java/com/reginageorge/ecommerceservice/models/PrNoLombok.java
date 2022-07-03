package com.reginageorge.ecommerceservice.models;

import com.reginageorge.ecommerceservice.enums.IngredientsList;
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
    @Column(name = "price")
    private Money price;

    @Column(name = "ingredients")
    private List<IngredientsList> ingredientsLists;

    public PrNoLombok() {
    }

    public PrNoLombok(String title, Money price) {
        this.title = title;
        this.price = price;
        this.ingredientsLists = new ArrayList<>();
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

    public List<IngredientsList> getIngredientsLists() {
        return ingredientsLists;
    }

    public void setIngredientsLists(List<IngredientsList> ingredientsLists) {
        this.ingredientsLists = ingredientsLists;
    }

        public void addIngredient(IngredientsList ingredient){
        this.ingredientsLists.add(ingredient);
    }
}
