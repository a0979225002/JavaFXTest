package org.example.ThreadToExcel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.ThreadToExcel.Controller.RootController;

public class MainApp extends Application {
    AnchorPane root;
    RootController rootController;

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("RootLayout.fxml"));
        root = loader.load();
        rootController = loader.getController();
        rootController.setMainApp(this);
        root.getChildren().addAll(rootController.getProgerssBar());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
