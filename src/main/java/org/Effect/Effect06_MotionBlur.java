package org.Effect;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.Effect;
import javafx.scene.effect.MotionBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.net.URL;
import java.util.function.Consumer;

/**
 * MotionBlur() 動態模糊效果
 */
public class Effect06_MotionBlur extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        HBox hBox = new HBox(100);
        hBox.setAlignment(Pos.CENTER);
        Rectangle rectangle = new Rectangle(150, 150);
        rectangle.setFill(Color.LIGHTPINK);

        URL url = getClass().getResource("image/cursoor.png");
        Image image = new Image(url.toExternalForm(), 700, 700, true, true);
        Label label = new Label("this is 你好");
        label.setFont(new Font(20));
        Circle circle = new Circle(75);
        circle.setFill(Color.LIGHTBLUE);

        hBox.getChildren().addAll(new ImageView(image), label, rectangle, circle);

        hBox.getChildren().forEach(new Consumer<Node>() {
            @Override
            public void accept(Node node) {
                node.setEffect(getEffect());
            }
        });

        AnchorPane.setRightAnchor(hBox, 50.0);
        AnchorPane.setLeftAnchor(hBox, 50.0);
        AnchorPane.setTopAnchor(hBox, 100.0);

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(hBox);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setHeight(900);
        stage.setWidth(1500);
        stage.setTitle("Effect 各類效果");

        stage.show();
    }

    private Effect getEffect() {
        MotionBlur motionBlur = new MotionBlur();
        motionBlur.setAngle(90);//要模糊的方位 0~360 or +-0 ~ +-90
        motionBlur.setRadius(63);//min 0 max 63 模糊範圍
        return motionBlur;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
