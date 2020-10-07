package org.example;

import com.jfoenix.controls.JFXButton;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class App6 extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        //打開該網頁,程式跑到這裡就會使用默認的瀏覽器打開該網頁
        HostServices host = getHostServices();
        host.showDocument("https://gnn.gamer.com.tw/detail.php?sn=203927");

        //創利視圖
        StackPane stackPane = new StackPane();

        JFXButton button = new JFXButton("測試按鈕");
        button.setPrefSize(300,300);
        button.setFont(new Font(30));

        //更改按鈕邊匡樣式
        button.setBorder(new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID,new CornerRadii(5),new BorderWidths(1))));

        //getChildren():將按鈕元件加入視圖中
        stackPane.getChildren().addAll(button);

        //視圖由下而上 Stage>Scene>Node 需照順序加入
        Scene scene = new Scene(stackPane);

        //更改該視圖內滑鼠的樣式
        File file = new File("../cursor.png");

        URL url = getClass().getResource("image/cursoor.png");

        //設置圖片大小
        Image image = new Image(url.toExternalForm(),200,200,false,false);
        scene.setCursor(new ImageCursor(image));//傳入圖片模式
//        scene.setCursor(Cursor.cursor(url.toExternalForm()));//傳入url模式
        stage.setTitle("Scene(場景) example");
        stage.setWidth(1200);
        stage.setHeight(800);

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
