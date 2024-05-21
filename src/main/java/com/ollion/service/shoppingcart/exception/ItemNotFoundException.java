package com.ollion.service.shoppingcart.exception;

import static com.ollion.service.shoppingcart.common.ShoppingCartConstants.ITEM_NOT_FOUND_MESSAGE;

public class ItemNotFoundException extends Exception {

    public ItemNotFoundException() {
        super(ITEM_NOT_FOUND_MESSAGE);
    }
}
