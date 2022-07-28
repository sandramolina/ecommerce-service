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

        Rating rating3 = new Rating(3.8, 600);
        ratingsRepository.save(rating3);

        Rating rating4 = new Rating(4.5, 1200);
        ratingsRepository.save(rating3);

        Rating rating5 = new Rating(2.5, 869);
        ratingsRepository.save(rating3);

        Rating rating6 = new Rating(3.5, 362);
        ratingsRepository.save(rating3);

        Rating rating7 = new Rating(4.5, 58);
        ratingsRepository.save(rating3);

        Rating rating8 = new Rating(5.0, 458);
        ratingsRepository.save(rating3);

        //Generate Colours
        Colours red1 = new Colours("Passion Red", "https://raw.githubusercontent.com/sandramolina/assets/main/colors/color-red.png");
        coloursRepository.save(red1);

        Colours blue1 = new Colours("React Blue", "https://raw.githubusercontent.com/sandramolina/assets/main/colors/color-react-blue.png");
        coloursRepository.save(blue1);

        Colours green1 = new Colours("Emerald", "https://raw.githubusercontent.com/sandramolina/assets/main/colors/color-emerald.png");
        coloursRepository.save(green1);

        Colours rosyMauve = new Colours("Rosy Mauve", "https://raw.githubusercontent.com/sandramolina/assets/main/colors/color-rosy-maeve.png");
        coloursRepository.save(rosyMauve);

        Colours hotPink = new Colours("Hot Pink", "https://raw.githubusercontent.com/sandramolina/assets/main/colors/color-hot-pink.png");
        coloursRepository.save(hotPink);

        Colours getNude = new Colours("Get Nude", "https://raw.githubusercontent.com/sandramolina/assets/main/colors/color-getnude.png");
        coloursRepository.save(getNude);

        //TODO assign img to black
        Colours black = new Colours("Carbon Black", "https://raw.githubusercontent.com/sandramolina/assets/main/colors/color-getnude.png");
        coloursRepository.save(black);

        //TODO assign img to brown
        Colours brown = new Colours("Brownie", "https://raw.githubusercontent.com/sandramolina/assets/main/colors/color-getnude.png");
        coloursRepository.save(brown);

        //Generate Ingredients
        Ingredients fragrance = new Ingredients("Fragrance");
        ingredientsRepository.save(fragrance);

        Ingredients arganOil = new Ingredients("Argan Oil");
        ingredientsRepository.save(arganOil);

        Ingredients water = new Ingredients("Water");
        ingredientsRepository.save(water);

        Ingredients polybutene = new Ingredients("Polybutene");
        ingredientsRepository.save(polybutene);

        Ingredients diisostearyl = new Ingredients("Diisostearyl");
        ingredientsRepository.save(diisostearyl);

        Ingredients silica = new Ingredients("Silica");
        ingredientsRepository.save(silica);

        Ingredients cetearyl_alcohol = new Ingredients("Cetearyl Alcohol");
        ingredientsRepository.save(cetearyl_alcohol);

        Ingredients malate = new Ingredients("Malate");
        ingredientsRepository.save(malate);


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
        superLipstickStar.addIngredient(silica);
        superLipstickStar.addIngredient(malate);
        superLipstickStar.addColour(red1);
        superLipstickStar.addColour(blue1);
        superLipstickStar.addColour(green1);
        productRepository.save(superLipstickStar);

        Product superLipstickSoDramatic = Product.builder()
                .title("Super Lipstick SO Dramatic!")
                .stock(1000)
                .price(Money.parse("GBP 13.55"))
                .productCategory("LIPS")
                .image("https://raw.githubusercontent.com/sandramolina/assets/main/products/lipstick_01.png")
                .shortDescription("Our #1 lipstick now with pure, creamy color and incredible shine. Lips are instantly smoother and more voluminous-looking.")
                .longDescription("Your favorite feel-good, look-great lipstick, now with medium to full-coverage color—and zero shimmer. Universally-flattering, shimmer-free color, in seven creamy shades")
                .rating(new Rating())
                .ingredients(new ArrayList<>())
                .colours(new ArrayList<>())
                .build();

        //TODO how can I setup the same ingredient/color to different products
        productRepository.save(superLipstickSoDramatic);
        superLipstickSoDramatic.setRating(rating2);
        superLipstickSoDramatic.addIngredient(water);
        superLipstickSoDramatic.addIngredient(cetearyl_alcohol);
        superLipstickSoDramatic.addColour(hotPink);
        superLipstickSoDramatic.addColour(getNude);
        superLipstickSoDramatic.addColour(rosyMauve);
        productRepository.save(superLipstickSoDramatic);

        Product superMascara = Product.builder()
                .title("Super Mascara STAR")
                .stock(1000)
                .price(Money.parse("GBP 10.55"))
                .productCategory("EYES")
                .image("https://github.com/sandramolina/assets/blob/main/products/mascara.png")
                .shortDescription("Our #1 mascara now with pure, creamy color and incredible shine. Lips are instantly smoother and more voluminous-looking.")
                .longDescription("Your favorite feel-good, look-great mascara, now with medium to full-coverage color—and zero shimmer. Universally-flattering, shimmer-free color, in seven creamy shades")
                .rating(new Rating())
                .ingredients(new ArrayList<>())
                .colours(new ArrayList<>())
                .build();

                //TODO once I fix the issue, assign colors and ingredients
        productRepository.save(superMascara);

        //TODO assign img to this product
        Product superEyeshadow = Product.builder()
                .title("Super Eyeshadow Palette")
                .stock(1000)
                .price(Money.parse("GBP 15.99"))
                .productCategory("EYES")
                .image("")
                .shortDescription("Our brand new Eyeshadow now with pure, creamy color and incredible shine. Eyes are instantly smoother and more voluminous-looking.")
                .longDescription("Your favorite feel-good, look-great eyeshadow, now with medium to full-coverage color—and zero shimmer. Universally-flattering, shimmer-free color, in seven creamy shades")
                .rating(new Rating())
                .ingredients(new ArrayList<>())
                .colours(new ArrayList<>())
                .build();

        //TODO once I fix the issue, assign colors and ingredients
        productRepository.save(superEyeshadow);

        //TODO assign img to this product
        Product faceFoundation = Product.builder()
                .title("Flawless Foundation")
                .stock(1000)
                .price(Money.parse("GBP 50.99"))
                .productCategory("FACE")
                .image("")
                .shortDescription("Looking flawless babe")
                .longDescription("Your favorite feel-good, look-great eyeshadow, now with medium to full-coverage color—and zero shimmer. Universally-flattering, shimmer-free color, in seven creamy shades")
                .rating(new Rating())
                .ingredients(new ArrayList<>())
                .colours(new ArrayList<>())
                .build();

        //TODO once I fix the issue, assign colors and ingredients
        productRepository.save(faceFoundation);

        //TODO assign img to this product
        Product concealer = Product.builder()
                .title("Flawless Concealer")
                .stock(1000)
                .price(Money.parse("GBP 50.99"))
                .productCategory("FACE")
                .image("")
                .shortDescription("Looking flawless babe but under the eyes")
                .longDescription("Your favorite feel-good, look-great concealer, now with medium to full-coverage color—and zero shimmer. Universally-flattering, shimmer-free color, in seven creamy shades")
                .rating(new Rating())
                .ingredients(new ArrayList<>())
                .colours(new ArrayList<>())
                .build();

        //TODO once I fix the issue, assign colors and ingredients
        productRepository.save(concealer);

        //TODO assign img to this product
        Product nailColor = Product.builder()
                .title("Flawless Nail Color")
                .stock(1000)
                .price(Money.parse("GBP 9.99"))
                .productCategory("NAILS")
                .image("")
                .shortDescription("Looking flawless babe but on the nails")
                .longDescription("Your favorite feel-good, look-great nail color, now with medium to full-coverage color—and zero shimmer. Universally-flattering, shimmer-free color, in seven creamy shades")
                .rating(new Rating())
                .ingredients(new ArrayList<>())
                .colours(new ArrayList<>())
                .build();

        //TODO once I fix the issue, assign colors and ingredients
        productRepository.save(nailColor);

        //TODO assign img to this product
        Product nailAccesory = Product.builder()
                .title("Nail Clipper")
                .stock(1000)
                .price(Money.parse("GBP 7.99"))
                .productCategory("NAILS")
                .image("")
                .shortDescription("Looking flawless babe but on the nails")
                .longDescription("Your favorite feel-good, look-great nail clipper, now with medium to full-coverage color—and zero shimmer. Universally-flattering, shimmer-free color, in seven creamy shades")
                .rating(new Rating())
                .ingredients(new ArrayList<>())
                .colours(new ArrayList<>())
                .build();

        //TODO once I fix the issue, assign colors and ingredients
        productRepository.save(nailAccesory);

    }
}

