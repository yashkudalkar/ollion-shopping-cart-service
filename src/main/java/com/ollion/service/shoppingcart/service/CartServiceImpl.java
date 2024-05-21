package com.ollion.service.shoppingcart.service;

import com.ollion.service.shoppingcart.domain.Cart;
import com.ollion.service.shoppingcart.domain.Item;
import com.ollion.service.shoppingcart.exception.CartNotFoundException;
import com.ollion.service.shoppingcart.exception.ItemNotFoundException;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{
    private final List<Cart> carts;

    public CartServiceImpl(List<Cart> carts) {
        this.carts = carts;
    }
    @Override
    public @NonNull Cart addItemsToCart(@NonNull final Integer userId, @NonNull final List<Item> items) throws CartNotFoundException {
        Cart currentUserCart = getCartByUserId(userId);
        currentUserCart.addAllItem(items);
        return currentUserCart;
    }

    @Override
    public Cart removeItemFromCart(@NonNull Integer userId, @NonNull Integer itemId) throws CartNotFoundException, ItemNotFoundException {
        Cart currentUserCart = getCartByUserId(userId);
        Item itemToDelete = currentUserCart.getItem(itemId);
        currentUserCart.removeItem(itemToDelete);
        return currentUserCart;
    }
    public Cart getCartByUserId(@NonNull Integer userId) throws CartNotFoundException {
        return this.carts.stream()
                .filter(cart -> cart.getUserID() == userId)
                .findFirst()
                .orElseThrow(CartNotFoundException::new);
    }
}