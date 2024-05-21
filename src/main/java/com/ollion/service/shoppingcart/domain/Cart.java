package com.ollion.service.shoppingcart.domain;

import com.ollion.service.shoppingcart.exception.ItemNotFoundException;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Cart {
    private int id;
    private int userID;
    @Builder.Default
    private List<Item> items = new ArrayList<>();

    @Builder.Default
    private BigDecimal totalPrice = BigDecimal.ZERO;


    public void calculateTotalPrice() {
        totalPrice = items.stream()
                .map(item -> item.getPrice().multiply(new BigDecimal(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void setItems(List<Item> items) {
        this.items = items;
        calculateTotalPrice();
    }

    public void addAllItem(List<Item> items) {
        List<Item> newItems = new ArrayList<>(this.items);
        newItems.addAll(items);
        this.items = newItems;
        calculateTotalPrice();
    }

    public void removeItem(Item item) {
        this.items.remove(item);
        calculateTotalPrice();
    }

    public Item getItem(Integer itemId) throws ItemNotFoundException {
        return items.stream().filter(item -> item.getId() == itemId)
                .findFirst()
                .orElseThrow(ItemNotFoundException::new);
    }
}

