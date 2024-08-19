module io.github.jordanneuenschwander.inventorymanager {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens io.github.jordanneuenschwander.inventorymanager to javafx.fxml;
    exports io.github.jordanneuenschwander.inventorymanager;
}