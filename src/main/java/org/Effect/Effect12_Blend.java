package org.Effect;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.Effect;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.net.URL;
import java.util.function.Consumer;

/**
 * Blend()
 */
public class Effect12_Blend extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        HBox hBox = new HBox(30);
        Button button = new Button("Button");
        button.setPrefWidth(200);
        button.setPrefHeight(200);
        URL url = getClass().getResource("image/02.png");
        ImageView image = new ImageView(new Image(url.toExternalForm()));
        image.setFitWidth(800);
        image.setPreserveRatio(true);//同步寬高縮放
        hBox.getChildren().addAll(button,image);



        HBox hBox2 = new HBox(30);
        Button button2 = new Button("Button");
        button2.setPrefWidth(200);
        button2.setPrefHeight(200);
        URL url2 = getClass().getResource("image/02.png");
        ImageView image2 = new ImageView(new Image(url2.toExternalForm()));
        image2.setFitWidth(800);
        image2.setPreserveRatio(true);//同步寬高縮放
        hBox2.getChildren().addAll(button2,image2);
        hBox2.setTranslateY(30);
        hBox2.setEffect(getEffect());

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(hBox,hBox2);

        AnchorPane root = new AnchorPane();
//        root.setBackground(new Background(new BackgroundFill(Color.BLACK,null,null)));
        AnchorPane.setLeftAnchor(stackPane,150.0);
        AnchorPane.setTopAnchor(stackPane,150.0);
        root.getChildren().addAll(stackPane);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setHeight(900);
        stage.setWidth(1600);
        stage.setTitle("Effect 各類效果");

        stage.show();
    }
    private Effect getEffect() {
        Blend blend = new Blend();
        blend.setMode(BlendMode.COLOR_DODGE);
        blend.setOpacity(0.5);

        return blend;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
