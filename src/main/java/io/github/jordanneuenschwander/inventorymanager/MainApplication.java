package io.github.jordanneuenschwander.inventorymanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/* The Javadoc folder is located in the base folder of this project */

/**
 * The main class that is used to handle program execution. It loads the main view.
 * FUTURE ENHANCEMENT
 * Currently, if a user adds a new part or product that is identical except for its stock value to an existing part or product in the lists
 * the program will create a new entry in the list for this object.
 * A future improvement would be to check for this duplication and increase or decrease the stock amount of the original part instead of creating the duplicate entry.
 * This would allow for better control of the inventory because as it stands now a user could represent an overstocked item as multiple duplicate objects
 * that all fall within the acceptable stock ranges. For example, a part that has min = 1 max = 30 stock = 36 will not be added to the list
 * but a user could add 2 parts listed as min=1 max=30 stock=18 to avoid the stock limits
 * */


public class MainApplication extends Application {

    /**
     * The method that is called when the program starts and is used to handle program execution
     *
     * @param args the arguments passed to the program on execution
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * This method is called upon program execution. It sets up the window that the program will begin in.
     * All further logic is handled by the controllers once the window is set.
     *
     * @param primaryStage the window that the program is given upon execution
     *
     * @throws Exception NullPointerException when the <code>FXMLLoader</code> can not find the fxml file
     * @throws Exception IOException if <code>FXMLLoader</code> attempts to load a null value
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("MainView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1055, 364);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}