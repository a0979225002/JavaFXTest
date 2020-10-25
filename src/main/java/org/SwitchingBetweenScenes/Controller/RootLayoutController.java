package org.SwitchingBetweenScenes.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import org.SwitchingBetweenScenes.MainApp;
import org.SwitchingBetweenScenes.Model.Data;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RootLayoutController implements Initializable {
    @FXML
    private Label label;
    @FXML
    private AnchorPane scene_01;

    public void open_second_scene(ActionEvent actionEvent) throws IOException {
        AnchorPane scene_02 = FXMLLoader.load(MainApp.class.getResource("SecondScene.fxml"));
        scene_01.getChildren().removeAll();
        scene_01.getChildren().setAll(scene_02);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (Data.text.equals("")) {
            label.setText("Hello,I'm scene One!");
        }else {
            label.setText(Data.text);
            Data.text = "";
        }
    }
}
