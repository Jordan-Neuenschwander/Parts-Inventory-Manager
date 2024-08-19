module io.github.wander.inventorymanager {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens io.github.wander.inventorymanager to javafx.fxml;
    exports io.github.wander.inventorymanager;
}