package org.Effect;

import com.jfoenix.controls.JFXButton;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Shadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.function.Consumer;

/**
 * Shadow() 將組建整個變陰影
 */
public class Effect03_Shadow extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        HBox hBox = new HBox(200);
        hBox.setAlignment(Pos.CENTER);
        Rectangle rectangle = new Rectangle(150, 150);
        rectangle.setFill(Color.LIGHTPINK);
        JFXButton button = new JFXButton("測試");
        button.setFont(new Font(20));
        Label label = new Label("this is 你好");
        label.setFont(new Font(20));
        Circle circle = new Circle(75);
        circle.setFill(Color.LIGHTBLUE);

        hBox.getChildren().addAll(button, label, rectangle, circle);

        hBox.getChildren().forEach(new Consumer<Node>() {
            @Override
            public void accept(Node node) {
                node.setEffect(getEffect());
            }
        });


        AnchorPane.setRightAnchor(hBox, 50.0);
        AnchorPane.setLeftAnchor(hBox, 50.0);
        AnchorPane.setTopAnchor(hBox, 300.0);

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(hBox);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setHeight(900);
        stage.setWidth(1200);
        stage.setTitle("Effect 各類效果");

        stage.show();


    }
    private Effect getEffect(){

        Shadow shadow = new Shadow();
        shadow.setColor(Color.DEEPPINK);
        shadow.setHeight(100);
        shadow.setWidth(100);

        shadow.setBlurType(BlurType.GAUSSIAN);
        shadow.setRadius(100);

        return shadow;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
