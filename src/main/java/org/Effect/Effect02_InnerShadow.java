package org.Effect;

import com.jfoenix.controls.JFXButton;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.function.Consumer;

/**
 * InnerShadow() 內部陰影 Example
 */
public class Effect02_InnerShadow extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        HBox hBox = new HBox(200);
        hBox.setAlignment(Pos.CENTER);
        Rectangle rectangle = new Rectangle(150, 150);
        rectangle.setFill(Color.LIGHTPINK);
        Label label = new Label("this is Text 你好");
        label.setFont(Font.font(null, FontWeight.BOLD,50));
        label.setTextFill(Color.ALICEBLUE);
        Circle circle = new Circle(75);
        circle.setFill(Color.LIGHTBLUE);

        hBox.getChildren().addAll( label, rectangle, circle);

        //對hBox內全部組件加入陰影效果
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
        InnerShadow is = new InnerShadow();
        is.setColor(Color.valueOf("0x3b596d"));
        is.setOffsetX(5);
        is.setOffsetY(5);

        DropShadow ds = new DropShadow();
        ds.setOffsetY(10);
        ds.setOffsetX(10);
        ds.setColor(Color.valueOf("#27272755"));

        //內陰影+外陰影
        is.setInput(ds);//講兩個Effect加在一起使用

        return is;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
