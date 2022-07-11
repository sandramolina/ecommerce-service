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

        //Generate Ratings
        Rating rating1 = new Rating(4.5, 4500);
        ratingsRepository.save(rating1);

        Rating rating2 = new Rating(3.5, 600);
        ratingsRepository.save(rating2);

        Rating rating3 = new Rating(5.0, 600);
        ratingsRepository.save(rating3);

        //Generate Colours
        Colours red1 = new Colours("Passion Red", "https://raw.githubusercontent.com/sandramolina/assets/main/colors/color-red.png");
        coloursRepository.save(red1);

        Colours blue1 = new Colours("React Blue", "https://raw.githubusercontent.com/sandramolina/assets/main/colors/color-react-blue.png");
        coloursRepository.save(blue1);

        Colours green1 = new Colours("Emerald", "https://raw.githubusercontent.com/sandramolina/assets/main/colors/color-emerald.png");
        coloursRepository.save(green1);

        //Generate Ingredients
        Ingredients fragrance = new Ingredients("Fragrance");
        ingredientsRepository.save(fragrance);

        Ingredients arganOil = new Ingredients("Argan Oil");
        ingredientsRepository.save(arganOil);

        Ingredients water = new Ingredients("Water");
        ingredientsRepository.save(water);

        Product superLipstickStar = Product.builder()
                .title("Super Lipstick STAR")
                .stock(5600)
                .price(Money.parse("GBP 18.99"))
                .productCategory("LIPS")
                .image("https://raw.githubusercontent.com/sandramolina/assets/main/products/lipBalm.png")
                .shortDescription("Our #1 lipstick now with pure, creamy color and incredible shine. Lips are instantly smoother and more voluminous-looking.")
                .longDescription("Your favorite feel-good, look-great lipstick, now with medium to full-coverage color—and zero shimmer. Universally-flattering, shimmer-free color, in seven creamy shades")
                .rating(new Rating())
                .ingredients(new ArrayList<>())
                .colours(new ArrayList<>())
                .build();


        productRepository.save(superLipstickStar);
        superLipstickStar.setRating(rating1);
        superLipstickStar.addIngredient(fragrance);
        superLipstickStar.addColour(red1);
        superLipstickStar.addColour(blue1);
        superLipstickStar.addColour(green1);
        productRepository.save(superLipstickStar);


//        Product lipstick = Product.builder()
//                .title("Super Bomb Lips")
//                .stock(600)
//                .price(Money.parse("GBP 23.87"))
//                .productCategory("LIPS")
//                .image("https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg")
//                .shortDescription("This is the short one")
//                .longDescription("This is the long one")
//                .rating(new Rating())
//                .ingredients(new ArrayList<>())
//                .colours(new ArrayList<>())
//                .build();
//
//        productRepository.save(lipstick);


    }
}

