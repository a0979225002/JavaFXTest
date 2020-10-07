package org.Panit_Coler;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.example.App;

import java.io.File;
import java.net.URL;

public class imagePanit02 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        URL url = getClass().getResource("image/gamekiala.png");
        Image image = new Image(url.toExternalForm());

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setBackground(new Background(new BackgroundFill(Color.GREEN,new CornerRadii(20),null)));
        for (int i = 0; i < 3; i++){

            Rectangle rectangle = new Rectangle(300,300);

            rectangle.setFill(Paint.valueOf("#EDEDED"));

            gridPane.add(rectangle,i,0);

        }

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(new Circle(150),new Polygon(150,0,0,300,300,300));

        AnchorPane root = new AnchorPane();
        AnchorPane.setLeftAnchor(gridPane,50.0);
        AnchorPane.setRightAnchor(gridPane,50.0);
        AnchorPane.setTopAnchor(hBox,400.0);
        AnchorPane.setLeftAnchor(hBox,250.0);
        AnchorPane.setRightAnchor(hBox,250.0);
        root.getChildren().addAll(gridPane,hBox);


        /**
         * new ImagePattern(Image.class,X軸,Y軸,父類的百分比縮放寬,高,是否要讓圖片也照比例縮放)
         * 父類的百分比縮放:會百分比壓縮父類的寬高,放入圖片
         * 比如設0.1,0.1 將會產出100張同樣的圖出來(在父類的範圍內)
         * 參數最後一個,如果不讓比例縮放
         * 圖片將會自動比照原寬度
         */
        Rectangle rectangle = (Rectangle) gridPane.getChildren().get(0);
        rectangle.setFill(new ImagePattern(image));//將加載的圖片放入圓形中

        Rectangle rectangle2 = (Rectangle) gridPane.getChildren().get(1);
        //因為Rectangle 寬高是300*300 ,這裡讓圖片變成因為Rectangle的長寬的一半 150*150 所以有4張
        rectangle2.setFill(new ImagePattern(image,0,0,0.5,0.5,true));//將加載的圖片放入圓形中

        Rectangle rectangle3 = (Rectangle) gridPane.getChildren().get(2);
        rectangle3.setFill(new ImagePattern(image,-300,0,750,750,false));//將加載的圖片放入圓形中

        Circle circle = (Circle) hBox.getChildren().get(0);
        circle.setFill(new ImagePattern(image,0,0,750,750,false));

        Polygon polygon = (Polygon) hBox.getChildren().get(1);
        polygon.setFill(new ImagePattern(image,-450,50,1000,1000,false));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("加載圖片後更改圖片顏色 ImagePattern");
        stage.setWidth(1200);
        stage.setHeight(1000);



        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
