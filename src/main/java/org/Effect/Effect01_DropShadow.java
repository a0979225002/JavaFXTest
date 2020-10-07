package org.Effect;

import com.jfoenix.controls.JFXButton;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.function.Consumer;

/**
 * 物件外部陰影example
 */
public class Effect01_DropShadow extends Application {
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


        //加入陰影
//        button.setEffect(getEffect());//JFXButton無法生效加入陰影
        /**
         * 如果hbox有背景顏色,那Effect類將會對hBox做影響
         * 如果hbox沒有背景顏色,那將會對hbox內的組件做影響
         */
//        hBox.setEffect(getEffect());


        hBox.getChildren().addAll(button, label, rectangle, circle);

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

    //載入物件陰影
    public Effect getEffect() {

        DropShadow ds = new DropShadow();
        ds.setColor(Color.valueOf("#220088"));
//        ds.setWidth(100);//設置寬度
        ds.setOffsetX(10);//偏移
        ds.setOffsetY(10);
        ds.setRadius(50);//角度圓角向外擴散,漸淡效果
        ds.setSpread(0.1);//陰影透明度,0~1 末認為0

        ds.setBlurType(BlurType.GAUSSIAN);//各種模糊設置
        return ds;
    }
}
