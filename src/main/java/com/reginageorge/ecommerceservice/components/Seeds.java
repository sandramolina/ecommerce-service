package com.reginageorge.ecommerceservice.components;

import com.reginageorge.ecommerceservice.models.Colours;
import com.reginageorge.ecommerceservice.models.Ingredients;
import com.reginageorge.ecommerceservice.models.Product;
import com.reginageorge.ecommerceservice.models.Rating;
import com.reginageorge.ecommerceservice.repositories.ColoursRepository;
import com.reginageorge.ecommerceservice.repositories.IngredientsRepository;
import com.reginageorge.ecommerceservice.repositories.ProductRepository;
import com.reginageorge.ecommerceservice.repositories.RatingsRepository;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Profile("!test")
@Component
public class Seeds implements ApplicationRunner {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    IngredientsRepository ingredientsRepository;

    @Autowired
    ColoursRepository coloursRepository;

    @Autowired
    RatingsRepository ratingsRepository;

    public Seeds() {
    }

    @Override
    public void run(ApplicationArguments args) {

        Rating rating1 = new Rating(4.5, 4500);
        ratingsRepository.save(rating1);
        Rating rating2 = new Rating(3.5, 600);
        ratingsRepository.save(rating2);

        Product superLipGloss = Product.builder()
                .title("Super Lip Gloss STAR")
                .stock(5600)
                .price(Money.parse("GBP 18.99"))
                .productCategory("LIPS")
                .image("https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg")
                .shortDescription("This is the short one")
                .longDescription("This is the long one")
                .rating(new Rating())
                .ingredients(new ArrayList<>())
                .colours(new ArrayList<>())
                .build();


        productRepository.save(superLipGloss);
        superLipGloss.setRating(rating1);
        productRepository.save(superLipGloss);


        Product lipstick = Product.builder()
                .title("Super Bomb Lips")
                .stock(600)
                .price(Money.parse("GBP 23.87"))
                .productCategory("LIPS")
                .image("https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg")
                .shortDescription("This is the short one")
                .longDescription("This is the long one")
                .rating(new Rating())
                .ingredients(new ArrayList<>())
                .colours(new ArrayList<>())
                .build();

        productRepository.save(lipstick);
        Colours red1 = new Colours("Passion Red", "https://raw.githubusercontent.com/sandramolina/assets/main/colors/color-red.png");
        coloursRepository.save(red1);
        lipstick.addColour(red1);
        Ingredients fragance = new Ingredients("Fragance");
        ingredientsRepository.save(fragance);
        lipstick.addIngredient(fragance);
        productRepository.save(lipstick);


    }
}

