package com.reginageorge.ecommerceservice.models;

import javax.persistence.*;

@Entity
@Table(name = "colours")
public class Colours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long colour_id;

    private String colourName;

    private String colourImage;

    public Colours() {
    }

    //TODO how to setup a default value
    public Colours(String colourName, String colourImage) {
        this.colourName = colourName;
        this.colourImage = colourImage;
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
