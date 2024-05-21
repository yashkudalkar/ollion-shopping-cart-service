package com.ollion.service.shoppingcart.exception;

import static com.ollion.service.shoppingcart.common.ShoppingCartConstants.CART_NOT_FOUND_MESSAGE;

public class CartNotFoundException extends Exception{

    public CartNotFoundException() {
        super(CART_NOT_FOUND_MESSAGE);
    }
}
