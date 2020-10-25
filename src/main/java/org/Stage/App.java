package org.Stage;

import com.jfoenix.controls.JFXButton;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
    private Stage primaryStage;
    private static Scene scene;
    public static AnchorPane anchorPane = null;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;

//        primaryStage.setOpacity(0.1);//設置透明度
        primaryStage.setAlwaysOnTop(true);//永遠置頂
//        primaryStage.initStyle(StageStyle.TRANSPARENT);//標題列隱藏透明化
        primaryStage.setWidth(500);//設置寬度
        primaryStage.setHeight(500);//設置高度
        primaryStage.setX(700);//設置初始開啟後在螢幕中顯示的位置
        primaryStage.setY(700);//設置初始開啟後在螢幕中顯示的位置

        //監聽當前x軸的位置
        //Property關鍵字,可監聽各種屬性,做更改
        primaryStage.xProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                System.out.println("X軸位置:" + t1);
            }
        });
        primaryStage.yProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                System.out.println("Y軸位置:"+t1);
            }
        });

        StackPane stackPane = new StackPane();
        Scene scene = new Scene(stackPane,800,600);

        primaryStage.setScene(scene);

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}