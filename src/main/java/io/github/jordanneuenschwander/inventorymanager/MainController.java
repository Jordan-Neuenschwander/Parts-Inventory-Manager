package io.github.jordanneuenschwander.inventorymanager;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.Optional;

/**
 * This class handles all the logic involved with execution of the MainView.
 * It stores the <code>Inventory</code> model used to store the data generated during program execution
 *
 * @author Jordan Neuenschwander
 * @version 1.0
 */
public class MainController {

    /**
     * The <code>Inventory</code> model used to store all data generated during execution
     */
    private static Inventory inventory = new Inventory();

    /**
     * The text box that is used for user input search strings for the parts table
     */
    @FXML
    private TextField textPartSearchMain;

    /**
     * The parts table
     */
    @FXML
    private TableView<Part> tablePartsMain;

    /**
     * Table column that holds the part id
     */
    @FXML
    private TableColumn<Part, Number> columnPartIdMain;

    /**
     * Table column that holds the part name
     */
    @FXML
    private TableColumn<Part, String> columnPartNameMain;

    /**
     * Table column that holds the part stock
     */
    @FXML
    private TableColumn<Part, Number> columnPartStockMain;

    /**
     * Table column that holds the part cost per unit
     */
    @FXML
    private TableColumn<Part, Number> columnPartCPUMain;

    /**
     * The text box that is used for user input search strings for the products table
     */
    @FXML
    private TextField textProductSearchMain;
    /**
     * The products table
     */
    @FXML
    private TableView<Product> tableProductsMain;

    /**
     * Table column that holds the product id
     */
    @FXML
    private TableColumn<Product, Number> columnProdIdMain;

    /**
     * Table column that holds the product name
     */
    @FXML
    private TableColumn<Product, String> columnProdNameMain;

    /**
     * Table column that holds the product stock
     */
    @FXML
    private TableColumn<Product, Number> columnProdStockMain;

    /**
     * Table column that holds the product cost per unit
     */
    @FXML
    private TableColumn<Product, Number> columnProdCPUMain;

    /**
     * This method binds the table columns to the data they will be displaying and initializes the tables
     */
    public void initialize() {
        textPartSearchMain.textProperty().addListener((observable, oldValue, newValue) ->
                partSearch()
        );

        textProductSearchMain.textProperty().addListener((observable, oldValue, newValue) ->
                prodSearch()
        );



        tablePartsMain.getItems().setAll(inventory.getAllParts());
        tablePartsMain.isEditable();
        columnPartIdMain.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()));
        columnPartNameMain.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        columnPartStockMain.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getStock()));
        columnPartCPUMain.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrice()));

        tableProductsMain.getItems().setAll(inventory.getAllProducts());
        columnProdIdMain.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()));
        columnProdNameMain.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        columnProdStockMain.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getStock()));
        columnProdCPUMain.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrice()));
    }

    /**
     * This method adds the supplied <code>InHouse</code> object to the all parts list
     *
     * @param newPart InHouse part to be added
     */
    public void addPart(InHouse newPart) {
        inventory.addPart(newPart);
        refreshTables();
    }

    /**
     * This method adds the supplied <code>OutSourced</code> object to the all parts list
     *
     * @param newPart OutSourced part to be added
     */
    public void addPart(OutSourced newPart) {
        inventory.addPart(newPart);
        refreshTables();
    }

    /**
     * This method replaces the <code>InHouse</code> object present in the all parts list with a new <code>InHouse</code> object.
     *
     * @param index the index where modPart was stored
     * @param modPart InHouse part to replace old part
     */
    public void modifyPart(int index, InHouse modPart) {
        inventory.updatePart(index, modPart);
        refreshTables();
    }

    /**
     * This method replaces the <code>OutSourced</code> object present in the all parts list with a new <code>OutSourced</code> object.
     *
     * @param index the index where modPart was stored
     * @param modPart OutSourced part to replace old part
     */
    public void modifyPart(int index, OutSourced modPart) {
        inventory.updatePart(index, modPart);
        refreshTables();
    }

    /**
     * This method replaces the <code>Product</code> object present in the all products list with a new <code>Product</code> object.
     *
     * @param index the index where modProduct was stored
     * @param modProduct product to replace old part
     */
    public void modifyProduct(int index, Product modProduct) {
        inventory.updateProduct(index, modProduct);
        refreshTables();
    }

    /**
     * This method adds the supplied <code>Product</code> object to the all products list
     *
     * @param newProduct product to be added
     */
    public void addProduct(Product newProduct) {
        inventory.addProduct(newProduct);
        refreshTables();
    }

    /**
     * Refreshes the tables to display new data
     */
    public void refreshTables() {
        tablePartsMain.getItems().setAll(inventory.getAllParts());
        tableProductsMain.getItems().setAll(inventory.getAllProducts());
    }

    /**
     * Prompts the user if they are sure they want to exit the program and then exits upon confirmation
     *
     * @param event thrown when a user clicks on the exit button
     */
    @FXML
    void onClickExit(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Exit Confirmation");
        a.setContentText("Are you sure you want to exit?");

        Optional<ButtonType> result = a.showAndWait();
        if (result.isPresent() && (result.get() == ButtonType.OK)) {
            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
        }

    }

    /**
     * Sets the scene to the PartsView and calls a method in the {@link io.github.jordanneuenschwander.inventorymanager.PartController} that sets the parts view to add parts mode
     *
     * @param event thrown when the user clicks on the add part button
     *
     * @throws Exception NullPointerException when the <code>FXMLLoader</code> can not find the fxml file
     * @throws Exception IOException if <code>FXMLLoader</code> attempts to load a null value
     */
    @FXML
    void onClickPartAdd(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PartView.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(fxmlLoader.load(), 395, 491));

        PartController partController = fxmlLoader.getController();
        partController.addView();
    }

    /**
     * Prompts the user for confirmation on a delete action. Upon confirmation removes the part selected in the parts table from the all parts list
     *
     * @param event thrown when a user clicks the delete part button
     */
    @FXML
    void onClickPartDel(ActionEvent event) {
        Part selected = tablePartsMain.getSelectionModel().getSelectedItem();

        if (selected == null) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error - No Part Selected");
            a.setContentText("You have not selected a part to delete from the parts table.");
            a.show();
        } else {
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setTitle("Delete Confirmation");
            a.setContentText("Are you sure you want to delete " + selected.getStock() + " of " + selected.getName() + "?");

            Optional<ButtonType> result = a.showAndWait();
            if (result.isPresent() && (result.get() == ButtonType.OK)) {
                inventory.deletePart(selected);
                tablePartsMain.getSelectionModel().clearSelection();
                refreshTables();
            }
        }
    }

    /**
     * Sets the view to the part view and passes the currently selected <code>Part</code> and its index to the <code>PartController</code>
     *
     * @param event thrown when a user clicks the modify part button
     *
     * @throws Exception NullPointerException when the <code>FXMLLoader</code> can not find the fxml file
     * @throws Exception IOException if <code>FXMLLoader</code> attempts to load a null value
     */
    @FXML
    void onClickPartMod(ActionEvent event) throws Exception {
        Part selected = tablePartsMain.getSelectionModel().getSelectedItem();

        if(selected == null){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error - No Part Selected");
            a.setContentText("You have not selected a part to modify from the table.");
            a.show();
        }
        else {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PartView.fxml"));
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();

            stage.setScene(new Scene(fxmlLoader.load(), 395, 491));

            PartController partController = fxmlLoader.getController();
            partController.modifyView(inventory.getAllParts().indexOf(selected), selected);
            tablePartsMain.getSelectionModel().clearSelection();
        }
    }

    /**
     * Sets the view to the product view and passes a copy of the <code>Inventory</code> model to the <code>ProdController</code>
     *
     * @param event thrown when a user clicks on the add product button
     *
     * @throws Exception NullPointerException when the <code>FXMLLoader</code> can not find the fxml file
     * @throws Exception IOException if <code>FXMLLoader</code> attempts to load a null value
     */
    @FXML
    void onClickProdAdd(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ProdView.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(fxmlLoader.load(), 1055, 651));

        ProdController prodController = fxmlLoader.getController();
        prodController.addView(inventory);
    }

    /**
     * Prompts the user for confirmation on a delete action. Upon confirmation removes the product selected in the product table from the all products list
     * Can not remove products that have a non-empty associated parts list
     *
     * @param event thrown when a user clicks the delete part button
     */
    @FXML
    void onClickProdDel(ActionEvent event) {
        Product selected = tableProductsMain.getSelectionModel().getSelectedItem();
        Alert a = new Alert(Alert.AlertType.ERROR);

        if (selected == null) {
            a.setTitle("Error - No Product Selected");
            a.setContentText("You have not selected a product to delete from the products table.");
            a.show();
        }
        else if (!selected.getAllAssociatedParts().isEmpty()){
            a.setTitle("Error - Product Has Associated Parts");
            a.setContentText("The product you have selected still has associated parts. Please clear the associated parts table from the modify product window before deleting a product.");
            a.show();
        }
        else {
            a.setAlertType(Alert.AlertType.CONFIRMATION);
            a.setTitle("Delete Confirmation");
            a.setContentText("Are you sure you want to delete " + selected.getStock() + " of " + selected.getName() + "?");

            Optional<ButtonType> result = a.showAndWait();
            if (result.isPresent() && (result.get() == ButtonType.OK)) {
                inventory.deleteProduct(selected);
                tableProductsMain.getSelectionModel().clearSelection();
                refreshTables();
            }
        }
    }

    /**
     * Sets the view to the product view and passes the currently selected <code>Product</code> and its index to the <code>ProdController</code>
     *
     * @param event thrown when a user clicks the modify product button
     *
     * @throws Exception NullPointerException when the <code>FXMLLoader</code> can not find the fxml file
     * @throws Exception IOException if <code>FXMLLoader</code> attempts to load a null value
     */
    @FXML
    void onClickProdMod(ActionEvent event) throws Exception {
        Product selected = tableProductsMain.getSelectionModel().getSelectedItem();

        if(selected == null){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error - No Product Selected");
            a.setContentText("You have not selected a product to modify from the table.");
            a.show();
            return;
        }
        else {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ProdView.fxml"));
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.setScene(new Scene(fxmlLoader.load(), 1055, 651));

            ProdController prodController = fxmlLoader.getController();
            prodController.modifyView(inventory.getAllProducts().indexOf(selected), selected, inventory);

            tableProductsMain.getSelectionModel().clearSelection();
        }
    }

    /**
     * This method searches the parts table for a user input string
     * It can find partial or exact part matches and exact part id matches
     *
     *
     * RUNTIME ERROR
     * The runtime error that was present within this method involved the use of RegEx symbols within the search bar. For most regex expressions
     * the search procedure would function correctly and return the proper objects that matched that search string. The runtime error occurred when a part was present
     * in the parts table and a user entered the string "*". The * was the only instance of regex that I could get to crash the program.
     * I decided that even though the functionality of searching for say [^d] was convenient and potentially useful, the safe execution of the program was at risk if I allowed
     * user generated regex expressions to be input into the code.
     * I solved this runtime error by parsing the input string and replacing symbols with invalid. This causes the search function to not find the part it is searching for
     * and to return an error. This introduces issues with valid part names that contain symbols
     *
     *
     *
     * 1st revision: I've chosen a new way to implement this fix. Instead of replacing symbols with the text "invalid", the program now throws an error stating that the
     * search string is invalid and cannot contain anything other than digits and letters. This is a much better fix because if the new error is reached, the partSearch function
     * immediately returns. This prevents the program from executing a potentially dangerous string.
     *
     */
    @FXML
    void partSearch() {
        String findMe = textPartSearchMain.getText();

        if (!findMe.isEmpty() && !findMe.matches("[a-zA-Z0-9]+")) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Invalid Search");
            a.setContentText("Search strings should only contain letters and digits");
            a.show();
            return;
        }

        int findId = -1;

        ObservableList<Part> foundParts = FXCollections.observableArrayList();

        if (findMe.isEmpty()) {
            tablePartsMain.getItems().setAll(inventory.getAllParts());
        } else {
            try {
                findId = Integer.parseInt(findMe);
            } catch (Exception e) {
            }

            if (findId >= 0) {
                foundParts = inventory.lookupPart(findId);
                tablePartsMain.getItems().setAll(foundParts);
                if (foundParts.isEmpty()) {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setTitle("Error - No Part Found");
                    if (findMe.length() < 500) {
                        a.setContentText("No part found for the search string " + findMe);
                    } else {
                        a.setContentText("No part found for the search string");
                    }
                    a.show();
                }
            } else {
                foundParts = inventory.lookupPart(findMe);
                tablePartsMain.getItems().setAll(foundParts);
                if (foundParts.isEmpty()) {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setTitle("Error - No Product Found");
                    a.setContentText("No product found for the search string " + findMe);
                    a.show();
                }
            }
        }
    }

    /**
     * This method searches the products table for a user input string
     * It can find partial or exact part matches and exact part id matches
     *
     */
    @FXML
    void prodSearch() {
        try {
            String findMe = textProductSearchMain.getText();

            if (!findMe.isEmpty() && !findMe.matches("[a-zA-Z0-9]+")) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Invalid Search");
                a.setContentText("Search strings should only contain letters and digits");
                a.show();
                return;
            }

            int findId = -1;

            ObservableList<Product> foundProducts = FXCollections.observableArrayList();

            if (findMe.isEmpty()) {
                tableProductsMain.getItems().setAll(inventory.getAllProducts());
            } else {
                try {
                    findId = Integer.parseInt(findMe);
                } catch (Exception e) {
                }

                if (findId >= 0) {
                    foundProducts = inventory.lookupProduct(findId);
                    tableProductsMain.getItems().setAll(foundProducts);
                    if (foundProducts.isEmpty()) {
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setTitle("Error - No Part Found");
                        a.setContentText("No part found for the search string " + findMe);
                        a.show();
                    }
                } else {
                    foundProducts = inventory.lookupProduct(findMe);
                    tableProductsMain.getItems().setAll(foundProducts);
                    if (foundProducts.isEmpty()) {
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setTitle("Error - No Product Found");
                        a.setContentText("No product found for the search string " + findMe);
                        a.show();
                    }
                }
            }
        }
            catch(Exception e) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Error - No Product Found");
                a.setContentText("No product found for the search string ");
                a.show();
                tableProductsMain.getItems().setAll();
            }
    }
}