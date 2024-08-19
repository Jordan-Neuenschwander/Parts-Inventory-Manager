package io.github.wander.inventorymanager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * This class serves as a model for the inventory of the warehouse. It stores the <code>Part</code> and <code>Product</code> objects that are present in the inventory
 * in the allParts and allProducts list.
 *
 * @author Jordan Neuenschwander
 * @version 1.0
 */
public class Inventory {
    /**
     * A list of the <code>Part</code> objects that are currently present in the inventory
     */
    private static final ObservableList<Part> allParts  = FXCollections.observableArrayList();

    /**
     * A list of the <code>Product</code> objects that are currently present in the inventory
     */
    private static final ObservableList<Product> allProducts  = FXCollections.observableArrayList();

    /**
     * Adds a <code>Part</code> to the <code>allParts</code> list
     *
     * @param newPart the part to be added
     */
    public static void addPart(Part newPart) {
        allParts.add(newPart);
    }
    /**
     * Adds a <code>Product</code> to the <code>allProducts</code> list
     *
     * @param newProduct the product to be added
     */
    public static void addProduct(Product newProduct) {
        allProducts.add(newProduct);
    }

    /**
     * Searches the <code>allParts</code> list for a part id that exactly matches a supplied part id
     *
     * @param partId the full id of the part to find
     *
     * @return list of all the <code>Part</code> objects that have an id that exactly matches the supplied part id
     */
    public static ObservableList<Part> lookupPart(int partId) {
        ObservableList<Part> foundParts = FXCollections.observableArrayList();

        for (int i = 0; i < allParts.size(); i++) {
            if (allParts.get(i).getId() == partId) {
                foundParts.add(allParts.get(i));
            }
        }
        return foundParts;
    }

    /**
     * Searches the <code>allProducts</code> list for a product id that exactly matches a supplied product id
     *
     * @param productId the full id of the product to find
     *
     * @return list of all the <code>Product</code> objects that have an id that exactly matches the supplied product id
     */
    public static ObservableList<Product> lookupProduct(int productId) {
        ObservableList<Product> foundProducts = FXCollections.observableArrayList();

        for (int i = 0; i < allProducts.size(); i++) {
            if (allProducts.get(i).getId() == productId) {
                foundProducts.add(allProducts.get(i));
            }
        }
        return foundProducts;
    }

    /**
     * Searches the <code>allParts</code> list for a part name that partially or exactly matches the provided name
     *
     * @param partName the partial or complete name of the part to find
     *
     * @return list of all the <code>Part</code> objects that have a name that partially or exactly matches the supplied part name
     */
    public static ObservableList<Part> lookupPart(String partName) {
        ObservableList<Part> foundParts = FXCollections.observableArrayList();

        for (int i = 0; i < allParts.size(); i++) {
            if (allParts.get(i).getName().matches(partName + "[^ ]*")) {
                foundParts.add(allParts.get(i));
            }
        }
        return foundParts;
    }

    /**
     * Searches the <code>allProducts</code> list for a product name that partially or exactly matches a supplied product name
     *
     * @param productName the full id of the product to find
     *
     * @return list of all the <code>Product</code> objects that have a name that partially or exactly matches the supplied product name
     */
    public static ObservableList<Product> lookupProduct(String productName) {
        ObservableList<Product> foundProducts = FXCollections.observableArrayList();

        for (int i = 0; i < allProducts.size(); i++) {
            if (allProducts.get(i).getName().matches(productName + "[^ ]*")) {
                foundProducts.add(allProducts.get(i));
            }
        }
        return foundProducts;
    }

    /**
     * Replaces the <code>Part</code> at an index with a new <code>Part</code> object
     *
     * @param index the index of the <code>Part</code> to be replaced
     * @param selectedPart the <code>Part</code> to be inserted into the list
     */
    public static void updatePart(int index, Part selectedPart) {
        allParts.set(index, selectedPart);
    }

    /**
     * Replaces the <code>Product</code> at an index with a new <code>Product</code> object
     *
     * @param index the index of the <code>Product</code> to be replaced
     * @param selectedProduct the <code>Product</code> to be inserted into the list
     */
    public static void updateProduct(int index, Product selectedProduct) {
        allProducts.set(index, selectedProduct);
    }

    /**
     * removes the selected <code>Part</code> from the list
     *
     * @param deletePart the <code>Part</code> to be removed
     */
    public static void deletePart(Part deletePart) {
        allParts.remove(deletePart);
    }

    /**
     * removes the selected <code>Product</code> from the list
     *
     * @param deleteProduct the <code>Product</code> to be removed
     */
    public static void deleteProduct(Product deleteProduct) {
        allProducts.remove(deleteProduct);
    }

    /**
     * Gets the <code>allParts</code> list
     *
     * @return the list of all parts currently in inventory
     */
    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    /**
     * Gets the <code>allProducts</code> list
     *
     * @return the list of all products currently in inventory
     */
    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }
}