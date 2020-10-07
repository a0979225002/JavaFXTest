package org.Panit_Coler;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * panit API
 * https://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Paint.html
 */
public class Panit01 extends Application {
    @Override
    public void start(Stage stage) throws Exception {


        GridPane grid = new GridPane();//網狀佈局
        grid.setHgap(10);//設置網格寬度
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(20));

        grid.setBackground(new Background(new BackgroundFill(Paint.valueOf("#00CACA55"), new CornerRadii(10), null)));

        //建立矩形
        for (int i = 0; i < 5; i++) {//共五排
            for (int j = 0; j < 5; j++) {//一排5個矩形
                Rectangle rec = new Rectangle(150, 150);//創建一個矩形
                rec.setFill(Paint.valueOf("#EDEDED"));
                grid.add(rec, j, i);
                //           行  列
            }
        }

        ArrayList<Color> list = new ArrayList<Color>();

        list.add(Color.valueOf("#01B468"));
        list.add(Color.valueOf("#01B46855"));// 55 半透明,ff不透明,00全透明
        list.add(Color.valueOf("02B468"));
        list.add(Color.CADETBLUE);
        list.add(new Color(136.0 / 255, 255.0 / 255, 0.0 / 255, 1));//因為他是使用百分比,所以使用除法將所要的rgb轉成百分比
        list.add(Color.rgb(136, 255, 0, 0.3));

        for (int i = 0; i < list.size(); i++) {
            Rectangle rec = (Rectangle) grid.getChildren().get(i);
            rec.setFill(list.get(i));

        }

        HBox root = new HBox();
        root.getChildren().addAll(grid);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Panit&Color");
        stage.setWidth(1000);
        stage.setHeight(900);
        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
