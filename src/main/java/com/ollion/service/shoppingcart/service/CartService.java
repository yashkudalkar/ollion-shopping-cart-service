package com.ollion.service.shoppingcart.service;

import com.ollion.service.shoppingcart.domain.Cart;
import com.ollion.service.shoppingcart.domain.Item;
import com.ollion.service.shoppingcart.exception.CartNotFoundException;
import com.ollion.service.shoppingcart.exception.ItemNotFoundException;
import lombok.NonNull;

import java.util.List;

public interface CartService {

    @NonNull Cart addItemsToCart(@NonNull final Integer userId, @NonNull final List<Item> items) throws CartNotFoundException;

    @NonNull Cart removeItemFromCart(@NonNull final Integer userId, @NonNull final Integer itemId) throws CartNotFoundException, ItemNotFoundException;

    @NonNull Cart getCartByUserId(@NonNull Integer userId) throws CartNotFoundException;
}
