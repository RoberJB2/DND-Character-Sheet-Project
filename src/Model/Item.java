package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Robert J.
 * @author Ellie R.
 * @version %I%
 * @since 1.0
 */
import java.lang.String;
import java.io.Serializable;
import java.util.Objects;

public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    
    // required fields
    private final String itemName;
    private final String itemDesc;
    private final float itemWeight;
    
    // optional fields
    private int quantity;
    private String itemCategory;

    /**
     * Default Item constructor with parameters
     * 
     * @param itemName
     * @param itemDesc
     * @param itemWeight
     * @param quantity1 
     */
    public Item(String itemName, String itemDesc, float itemWeight, int quantity1) {
        this(itemName, itemDesc, itemWeight, 1, "Miscellaneous");
    }
    /**
     * Default item constructor.
     */
    public Item() {
        this("Default", "No description", 0.0f, 1, "Miscellaneous");
    }
    /**
     * Constructor for item with parameters.
     * Initializes all items with a name, description, weight, quantity
     * and item category.
     * 
     * @param itemName
     * @param itemDesc
     * @param itemWeight
     * @param quantity
     * @param itemCategory 
     */
    public Item(String itemName, String itemDesc, float itemWeight, 
                int quantity, String itemCategory) {
        if (itemWeight < 0) itemWeight = 0;
        if (quantity < 1) quantity = 1;
        
        this.itemName = Objects.requireNonNull(itemName, "Item name cannot be null");
        this.itemDesc = itemDesc;
        this.itemWeight = itemWeight;
        this.quantity = quantity;
        this.itemCategory = itemCategory;
    }

    
    /**
     * Getter for item name.
     * 
     * @return the item's name.
     */
    public String getItemName() {
        return itemName;
    }
    /**
     * Getter for item description.
     * 
     * @return The item description.
     */
    public String getItemDesc() {
        return itemDesc;
    }
    /**
     * Getter for item weight.
     * 
     * @return The item weight.
     */
    public float getItemWeight() {
        return itemWeight;
    }
    /**
     * Getter for item quantity.
     * 
     * @return Item quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter for item quantity
     * 
     * @param quantity, holdsd the value for quantity
     */
    public void setQuantity(int quantity) {
        if (quantity < 0) quantity = 1;
        this.quantity = quantity;
    }


    /**
     * Overrides equals to give an item a name and category
     * 
     * @param o
     * @return The item's name and category
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return itemName.equals(item.itemName) && 
               itemCategory.equals(item.itemCategory);
    }
    /**
     * Overrides the hashCode function
     * 
     * @return Object hash, with its name and category
     */
    @Override
    public int hashCode() {
        return Objects.hash(itemName, itemCategory);
    }

    /**
     * Overwrited the toString function so that items can be easily
     * transferred into a json file
     * 
     * @return string
     */
    @Override
    public String toString() {
        return "Item{" +
               "name='" + itemName + '\'' +
               ", category='" + itemCategory + '\'' +
               ", weight=" + itemWeight +
               ", quantity=" + quantity +
               '}';
    }

    /**
     * 
     * @return double, Total item weight.
     */
    public double getTotalWeight() {
        return itemWeight * quantity;
    }

}