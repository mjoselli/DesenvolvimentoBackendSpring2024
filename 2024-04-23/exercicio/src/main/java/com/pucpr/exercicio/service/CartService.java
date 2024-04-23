package com.pucpr.exercicio.service;

import com.pucpr.exercicio.entity.Cart;
import com.pucpr.exercicio.entity.Inventory;
import com.pucpr.exercicio.entity.Item;
import com.pucpr.exercicio.repository.CartRepository;
import com.pucpr.exercicio.repository.InventoryRepository;
import com.pucpr.exercicio.repository.ItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private InventoryRepository inventoryRepository;
    
    @Transactional
    public Cart createCart(String username) {
        Cart cart = new Cart();
        cart.setUsername(username);
        cart.setDate(new Date());
        return cartRepository.save(cart);
    }

    public Iterable<Cart> findAll() {
        return cartRepository.findAll();
    }

    public Cart findById(Long id) {
        return cartRepository
                .findById(id)
                .orElse(null);
    }

    @Transactional
    public void deleteById(Long id) {
        cartRepository.deleteById(id);
    }

    @Transactional
    public Item addItemToCart(Long cartId, Item item) {
        Inventory inventory = inventoryRepository.findAll().stream()
                .findFirst().orElse(null);
        if (inventory == null) {
            return null;
        }
        Item itemInventory = inventory.getItems().stream()
                .filter(i -> i.getName().equals(item.getName()))
                .findFirst()
                .orElse(null);
        if (itemInventory == null) {
            return null;
        }
        if (itemInventory.getQuantity() < item.getQuantity()) {
            return null;
        }
        return cartRepository.findById(cartId).map(cart -> {
            itemInventory.setQuantity(itemInventory.getQuantity() - item.getQuantity());
            itemRepository.save(itemInventory);
            item.setCart(cart);
            return itemRepository.save(item);
        }).orElse(null);
    }
    @Transactional
    public void removeItemFromCart(Long cartId, Long itemId) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        if (cart == null) {
            return;
        }
        Item item = itemRepository.findById(itemId).orElse(null);
        if (item == null) {
            return;
        }
        cart.getItems().remove(item);
        cartRepository.save(cart);
    }

    public Iterable<Item> findAllItemsFromCart(Long cartId) {
        return cartRepository
                .findById(cartId)
                .orElseThrow().getItems();
    }

    public Item findItemFromCart(Long cartId, Long itemId) {
        return cartRepository
                .findById(cartId)
                .orElseThrow()
                .getItems()
                .stream()
                .filter(item -> item.getUid().equals(itemId))
                .findFirst()
                .orElse(null);
    }
}
