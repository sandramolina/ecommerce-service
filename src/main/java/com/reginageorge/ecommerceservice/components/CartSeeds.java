package com.reginageorge.ecommerceservice.components;

import com.reginageorge.ecommerceservice.models.CartItem;
import com.reginageorge.ecommerceservice.models.Product;
import com.reginageorge.ecommerceservice.repositories.CartItemsRepository;
import com.reginageorge.ecommerceservice.repositories.ProductRepository;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Profile("!test")
//@Component
public class CartSeeds implements ApplicationRunner {

    @Autowired
    CartItemsRepository cartItemsRepository;

    @Autowired
    ProductRepository productRepository;

    public CartSeeds() {
    }

    @Override
    public void run(ApplicationArguments args) {

        Product superLipGloss = Product.builder()
                .title("Super Lip Gloss STAR")
                .stock(5600)
                .price(Money.parse("GBP 18.99"))
                .productCategory("LIPS")
                .image("https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg")
                .shortDescription("This is the short one")
                .longDescription("This is the long one")
                .rating(4.5)
                .ingredients(new ArrayList<>())
                .colours(new ArrayList<>())
                .build();

        productRepository.save(superLipGloss);

        CartItem cartItem = CartItem.builder()
                .product(new Product())
                .count(2)
                .build();
        cartItem.setProduct(superLipGloss);
        cartItemsRepository.save(cartItem);
    }
}
