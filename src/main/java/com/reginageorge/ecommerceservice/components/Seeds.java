package com.reginageorge.ecommerceservice.components;

import com.reginageorge.ecommerceservice.enums.IngredientsList;
import com.reginageorge.ecommerceservice.models.Ingredients;
import com.reginageorge.ecommerceservice.models.PrNoLombok;
import com.reginageorge.ecommerceservice.models.Product;
import com.reginageorge.ecommerceservice.repositories.IngredientsRepository;
import com.reginageorge.ecommerceservice.repositories.PrNoLombokRepository;
import com.reginageorge.ecommerceservice.repositories.ProductRepository;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import java.util.ArrayList;
import java.util.List;

@Profile("!test")
@Component
public class Seeds implements ApplicationRunner {

    @Autowired
    PrNoLombokRepository prNoLombokRepository;

    @Autowired
    IngredientsRepository ingredientsRepository;

    public Seeds() {
    }

    @Override
    public void run(ApplicationArguments args) {

        PrNoLombok lipGloss = new PrNoLombok("Super Lip Gloss", Money.parse("GBP 13.87"),550);
        lipGloss.setProductCategory("LIPS");
        lipGloss.setImage("https://raw.githubusercontent.com/sandramolina/rick-and-morty-app/main/public/not_found.png");
        lipGloss.setShortDescription("Our #1 gloss—now with pure, creamy color and incredible shine. Lips are instantly smoother and more voluminous-looking.");
        lipGloss.setLongDescription("Your favorite feel-good, look-great lip gloss, now with medium to full-coverage color—and zero shimmer. Universally-flattering, shimmer-free color, in seven creamy shades");
        lipGloss.addColour("Passion Red");
        lipGloss.addColour("Ruby Woo");
        lipGloss.addColour("Emerald");
        Ingredients fragrance = new Ingredients("Fragrance");
        Ingredients water = new Ingredients("Water");
        ingredientsRepository.save(fragrance);
        ingredientsRepository.save(water);
        lipGloss.addIngredient(fragrance);
        lipGloss.addIngredient(water);
        prNoLombokRepository.save(lipGloss);

        PrNoLombok superLipGloss = new PrNoLombok("Super Lip Gloss STAR", Money.parse("GBP 18.99"),650);
        superLipGloss.setProductCategory("LIPS");
        superLipGloss.setImage("https://cdn.shopify.com/s/files/1/0341/3458/9485/products/FB_HOL2021_I_T2PRODUCT_CONCRETE_GLOSS_BOMB_HEAT_CLOSED_LAVENDER_SAVAGE_1200x1500_d9cf3fcb-3888-4bf9-8ce8-a333017a95cc.jpg?v=1646689585");
        superLipGloss.setShortDescription("Our #1 gloss—now with pure, creamy color and incredible shine. Lips are instantly smoother and more voluminous-looking.");
        superLipGloss.setLongDescription("Your favorite feel-good, look-great lip gloss, now with medium to full-coverage color—and zero shimmer. Universally-flattering, shimmer-free color, in seven creamy shades");
        superLipGloss.addColour("Passion Red");
        superLipGloss.addColour("Ruby Woo");
        superLipGloss.addColour("Emerald");
        Ingredients oil = new Ingredients("oil");
        ingredientsRepository.save(oil);
        superLipGloss.addIngredient(oil);
        prNoLombokRepository.save(superLipGloss);

        Product lipstick = Product.builder()
                .title("Super Bomb Lips")
                .price(Money.parse("GBP 23.87"))
                .productCategory("Lips")
                .image("https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg")
                .shortDescription("This is the short one")
                .longDescription("This is the long one")
                .rating(4.5)
                .rate_count(150)
                .ingredients(new ArrayList<>())
                .build();

        //lipstick.addColor("Red");
        productRepository.save(lipstick);
        Ingredients fragance = new Ingredients("Fragance");
        ingredientsRepository.save(fragance);
        //fragance.addProduct(lipstick);
        ingredientsRepository.save(fragance);
        lipstick.addIngredient(fragance);
        productRepository.save(lipstick);


    }
}

