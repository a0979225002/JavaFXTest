package org.SwitchingBetweenScenes.Controller;

import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import org.SwitchingBetweenScenes.MainApp;
import org.SwitchingBetweenScenes.Model.Data;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SecondSceneController implements Initializable {
    public AnchorPane scene_02;
    public TextArea data_text;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void go_back(ActionEvent actionEvent) throws IOException {
        AnchorPane scene_01 = FXMLLoader.load(MainApp.class.getResource("RootLayout.fxml"));
        scene_02.getChildren().removeAll();
        scene_02.getChildren().setAll(scene_01);
    }

    public void pass_data(ActionEvent actionEvent) {
        Data.text = data_text.getText();
        data_text.clear();
    }
}
