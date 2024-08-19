package io.github.wander.inventorymanager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * This class is used as a model for a product stored in the warehouse. It stores data and functions relevant to a product currently in inventory.
 *
 * @author Jordan Neuenschwander
 * @version 1.0
 */
public class Product {
    /**
     * This is a list of the all the parts associated with the product
     */

    private ObservableList<Part> associatedParts;

    /**
     * The id of the product
     */
    private int id;

    /**
     * The name of the product
     */
    private String name;

    /**
     * The cost of the product per unit
     */
    private double price;

    /**
     * The current inventory level of the product
     */
    private int stock;

    /**
     * The minimum stock level allowed
     */
    private int min;

    /**
     * The maximum stock level allowed
     */
    private int max;

    /**
     * This constructs a new instance of the <code>Product</code> object with an empty associated parts list
     *
     * @param newId the id number of the product
     * @param newName the name of the product
     * @param newPrice the price of the product
     * @param newStock the current inventory levels of the product
     * @param newMin the minimum stock allowed
     * @param newMax the maximum stock allowed
     */
    public Product(int newId, String newName, double newPrice, int newStock, int newMin, int newMax){
        associatedParts = FXCollections.observableArrayList();
        id = newId;
        name = newName;
        price = newPrice;
        stock = newStock;
        min = newMin;
        max = newMax;
    }

    /**
     * This constructs a new instance of the <code>Product</code> object that uses a supplied associated parts table
     *
     * @param newAssociatedParts the list of all <Code>Part</Code> objects associated with this product
     * @param newId the id number of the product
     * @param newName the name of the product
     * @param newPrice the price of the product
     * @param newStock the current inventory levels of the product
     * @param newMin the minimum stock allowed
     * @param newMax the maximum stock allowed
     */
    public Product(ObservableList<Part> newAssociatedParts, int newId, String newName, double newPrice, int newStock, int newMin, int newMax){
        associatedParts = newAssociatedParts;
        id = newId;
        name = newName;
        price = newPrice;
        stock = newStock;
        min = newMin;
        max = newMax;
    }

    /**
     * Sets the id of the product
     *
     * @param newId id to set
     */
    public void setId(int newId){
        id = newId;
    }

    /**
     * Sets the name of the product
     *
     * @param newName name to set
     */
    public void setName(int newName){
        id = newName;
    }

    /**
     * Sets the cost per unit of the product
     *
     * @param newPrice cost to set
     */
    public void setPrice(int newPrice){
        id = newPrice;
    }

    /**
     * Sets the current inventory level of the product
     *
     * @param newStock the stock to set
     */
    public void setStock(int newStock){
        id = newStock;
    }

    /**
     * Sets the minimum stock allowed
     *
     * @param newMin min to set
     */
    public void setMin(int newMin){
        id = newMin;
    }

    /**
     * Sets the maximum stock allowed
     *
     * @param newMax max to set
     */
    public void setMax(int newMax){
        id = newMax;
    }

    /**
     * Gets the id of this product
     *
     * @return int id of the product
     */
    public int getId(){
        return id;
    }

    /**
     * Gets the name of this product
     *
     * @return string of the product name
     */
    public String getName(){
        return name;
    }

    /**
     * Gets the cost per unit of this product
     *
     * @return the price of the product
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the current inventory level of this product
     *
     * @return int current stock level
     */
    public int getStock() {
        return stock;
    }

    /**
     * Gets the minimum stock allowed for this product
     *
     * @return int minimum stock allowed
     */
    public int getMin() {
        return min;
    }

    /**
     * Gets the maximum stock allowed for this product
     *
     * @return int maximum stock allowed
     */
    public int getMax() {
        return max;
    }

    /**
     * Adds a <code>Part</code> object to the <code>associatedParts</code> list
     *
     * @param part the part to be added to the list
     */
    public void addAssociatedPart(Part part){
        associatedParts.add(part);
    }
    /**
     * Removes a <code>Part</code> object from the <code>associatedParts</code> list
     *
     * @param part the part to be removed from the list
     */
    public void deleteAssociatedPart(Part part){
        associatedParts.remove(part);
    }

    /**
     * Gets the list of parts associated with this product
     *
     * @return the <code>associatedParts</code> list
     */
    public ObservableList<Part> getAllAssociatedParts(){
        return associatedParts;
    }
}