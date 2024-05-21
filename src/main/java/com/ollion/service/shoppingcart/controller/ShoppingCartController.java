package com.ollion.service.shoppingcart.controller;

import com.ollion.service.shoppingcart.domain.Cart;
import com.ollion.service.shoppingcart.domain.Item;
import com.ollion.service.shoppingcart.exception.CartNotFoundException;
import com.ollion.service.shoppingcart.exception.ItemNotFoundException;
import com.ollion.service.shoppingcart.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ollion.service.shoppingcart.common.ShoppingCartConstants.CHECKOUT_MESSAGE;

@RestController()
@RequestMapping("/cart")
public class ShoppingCartController {

    private final CartService cartService;

    public ShoppingCartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public ResponseEntity<Object> pingCart() {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/items")
    public Cart addItemsToCart(@RequestHeader(value = "x-user-id") Integer userId,
                               @RequestBody List<Item> items) throws CartNotFoundException {
        return this.cartService.addItemsToCart(userId, items);
    }

    @DeleteMapping("/items/{itemId}")
    public Cart removeItemFromCart(@RequestHeader(value = "x-user-id") Integer userId,
                                   @PathVariable Integer itemId) throws CartNotFoundException, ItemNotFoundException {
        return this.cartService.removeItemFromCart(userId, itemId);
    }

    @GetMapping("/checkout")
    public String checkout(@RequestHeader(value = "x-user-id") Integer userId) throws CartNotFoundException {
        return String.format(CHECKOUT_MESSAGE, this.cartService.getCartByUserId(userId).getTotalPrice());
    }

}
