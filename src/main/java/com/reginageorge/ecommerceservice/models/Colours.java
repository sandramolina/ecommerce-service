package com.reginageorge.ecommerceservice.models;

import javax.persistence.*;

@Entity
@Table(name = "colours")
public class Colours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ingredient_id;

    private String colourName;

    private String colourImage;

    public Colours() {
    }

    public Colours(String colourName, String colourImage) {
        this.colourName = colourName;
        this.colourImage = colourImage;
    }

    public Long getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(Long ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public String getColourName() {
        return colourName;
    }

    public void setColourName(String colourName) {
        this.colourName = colourName;
    }

    public String getColourImage() {
        return colourImage;
    }

    public void setColourImage(String colourImage) {
        this.colourImage = colourImage;
    }
}
