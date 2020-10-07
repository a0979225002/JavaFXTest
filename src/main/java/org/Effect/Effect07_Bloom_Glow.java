package org.Effect;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.net.URL;
import java.util.function.Consumer;

/**
 * Bloom() & Glow() 發光物件
 */
public class Effect07_Bloom_Glow extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        HBox hBox = new HBox(100);
        hBox.setAlignment(Pos.CENTER);
        Rectangle rectangle = new Rectangle(150, 150);
        rectangle.setFill(Color.LIGHTPINK);

        URL url = getClass().getResource("image/cursoor.png");
        Image image = new Image(url.toExternalForm(), 700, 700, true, true);
        Label label = new Label("this is 你好");
        label.setFont(Font.font(null, FontWeight.BOLD,50));
        label.setTextFill(Color.BLUE);
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
        root.setBackground(new Background(new BackgroundFill(Color.BLACK,null,null)));
        root.getChildren().addAll(hBox);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setHeight(900);
        stage.setWidth(1600);
        stage.setTitle("Effect 各類效果");

        stage.show();
    }
    private Effect getEffect() {
        Bloom bloom = new Bloom();//自體發光
        bloom.setThreshold(0.5);//min:1 max:0

        Glow glow = new Glow();//自體發光,感覺這個比較好看
        glow.setLevel(0.3);// min:0 max:1

        DropShadow ds = new DropShadow();

        ds.setColor(Color.WHITE);
        ds.setHeight(50);
        ds.setWidth(50);

        glow.setInput(ds);

        return glow;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
