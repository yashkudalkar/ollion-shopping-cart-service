package com.ollion.service.shoppingcart;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ollion.service.shoppingcart.domain.Cart;
import com.ollion.service.shoppingcart.domain.Item;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Configuration
public class ShoppingCartAppDataConfiguration {

    @Bean
    public List<Cart> carts() {
        Cart cartOne = Cart.builder().id(1).userID(101).build();
        Cart cartTwo = Cart.builder().id(2).userID(102).build();
        Cart cartThree = Cart.builder().id(2).userID(103).build();

        cartOne.setItems(Arrays.asList(
                Item.builder().id(1).name("Sample product one").price(BigDecimal.valueOf(19.99)).quantity(1).build(),
                Item.builder().id(1).name("Sample product two").price(BigDecimal.valueOf(20.00)).quantity(1).build()
        ));

        return Arrays.asList(cartOne,cartTwo,cartThree);
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
