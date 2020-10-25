package org.example.ThreadToExcel.Controller;


import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.example.ThreadToExcel.MainApp;
import org.example.ThreadToExcel.Model.RootModel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class RootController implements Initializable {


    public Label nowHour;
    public Label nowMin;
    public Label runHour;
    public Label runMin;
    public Label m1Math;
    public Label m2Math;
    public Label c2Math;
    public Label c1Math;
    private VBox vBox;

    ParameterController parameterController;
    RootModel rootModel;
    MainApp mainApp;
    int min;
    //建立dialog視窗;
    Stage stage = new Stage();

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        rootModel = new RootModel();
        rootModel.setMyProgressStatus("待機中......");

        rootModel.setNowMin(0);
        min = rootModel.getNowMin();

        nowMin.setText(rootModel.getNowMin()+"");

        AnchorPane layout = null;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("parameterLayout.fxml"));
            layout = loader.load();
            parameterController = loader.getController();
            parameterController.setRootController(this);

        } catch (IOException e) {
            e.printStackTrace();
        }

        //初始化一個dialog
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.setTitle("請輸入參數");


        m1Math.setText(rootModel.getM1Math() + "");
        m2Math.setText(rootModel.getM2Math() + "");
        c1Math.setText(rootModel.getC1Math() + "");
        c2Math.setText(rootModel.getC2Math() + "");

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        min++;
                        nowMin.setText(min+"");
                    }
                });
            }
        }, 0, 1000);

    }

    //加入進度條
    public VBox getProgerssBar() {
        vBox = new VBox(5);
        vBox.setAlignment(Pos.CENTER);
        ProgressBar progressBar = new ProgressBar();
        progressBar.setPrefWidth(350);
        progressBar.setPrefHeight(30);
        progressBar.setProgress(rootModel.getMyProgress());//進度條狀態目前進度為零
        Label label = new Label(rootModel.getMyProgressStatus());
        label.setFont(new Font(20));
        label.setTextFill(Color.WHITE);
        vBox.getChildren().addAll(progressBar, label);

        AnchorPane.setLeftAnchor(vBox, 30.0);
        AnchorPane.setTopAnchor(vBox, 220.0);

        return vBox;
    }

    //運行button
    @FXML
    public void executionButton(ActionEvent actionEvent) {

    }


    @FXML
    public void parameterButton(ActionEvent actionEvent) throws IOException {
        stage.show();
    }

    public void closeDailog() {
        stage.close();
    }

}
