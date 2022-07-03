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

@Profile("!test")
@Component
public class Seeds implements ApplicationRunner {

//    @Autowired
//    ProductRepository productRepository;
//
//    @Autowired
//    IngredientsRepository ingredientsRepository;

    @Autowired
    PrNoLombokRepository prNoLombokRepository;

    public Seeds() {
    }

    @Override
    public void run(ApplicationArguments args) {

        PrNoLombok lipBalm = new PrNoLombok("Super balm", Money.parse("GBP 23.87"));
        lipBalm.addIngredient(IngredientsList.FRAGANCE);
        prNoLombokRepository.save(lipBalm);
//
//        Product lipstick = Product.builder()
//                .title("Super Bomb Lips")
//                .price(Money.parse("GBP 23.87"))
//                .productCategory("Lips")
//                .image("https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg")
//                .shortDescription("This is the short one")
//                .longDescription("This is the long one")
//                .rating(4.5)
//                .rate_count(150)
//                .build();
        //lipstick.addColor("Red");
        //productRepository.save(lipstick);
        //Ingredients fragance = new Ingredients("Fragance");
        //ingredientsRepository.save(fragance);
        //fragance.addProduct(lipstick);
        //ingredientsRepository.save(fragance);
        //lipstick.addIngredient(fragance);
        //productRepository.save(lipstick);

    }
}

