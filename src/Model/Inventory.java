package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.Serializable;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * @author Robert J., Ellie R.
 * @version 1.0
 */
public class Inventory implements Serializable {

    private static final long serialVersionUID = 1L;
    private final List<Item> items;
    
    /**
     * Creates the arrayList that holds the items in the inventory
     */
    public Inventory() {
        
         this.items = new ArrayList<>();
    }
       
    /**
     * This adds a new item including its name, description, weight, and amount
     * or quantity
     * 
     * @param newItem, stores the new item
     */
    public void addItem(Item newItem) {
        Objects.requireNonNull(newItem, "Cannot add null item to inventory");
        items.add(new Item(
                newItem.getItemName(),
                newItem.getItemDesc(),
                newItem.getItemWeight(),
                newItem.getQuantity()
        ));
    }
    
    /**
     * Removes an item from the players inventory and all of its relevant data.
     * This also specifies the amount of the item to remove
     * 
     * @param itemToRemove, tells the program which item to remove
     * @param quantityToRemove , tells he program how much of the item to remove
     */
    public void removeItem(Item itemToRemove, int quantityToRemove) {
        if (quantityToRemove < 1) {
            throw new IllegalArgumentException("Cannot remove negative items");
        }

        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            Item existingItem = iterator.next();
            if ((existingItem.equals(itemToRemove))) {
                if (existingItem.getQuantity() < quantityToRemove) {
                    existingItem.setQuantity(0);
                }

                int newQuantity = existingItem.getQuantity() - quantityToRemove;
                if (newQuantity > 0) {
                    existingItem.setQuantity(newQuantity);
                } else {
                    iterator.remove();
                }
                return;
            }
        }
        throw new IllegalArgumentException("Item not found");
    }
}

