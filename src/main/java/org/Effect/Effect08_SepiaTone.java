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
 * SepiaTone() 照片濾鏡效果,棕褐色
 */
public class Effect08_SepiaTone extends Application {
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
        URL url1 = getClass().getResource("image/game02.jpg");
        ImageView image1 = new ImageView(url1.toExternalForm());
        image1.setFitWidth(500);
        image1.setPreserveRatio(true);
        image1.setEffect(getEffect());

        AnchorPane.setRightAnchor(hBox, 50.0);
        AnchorPane.setLeftAnchor(hBox, 50.0);
        AnchorPane.setTopAnchor(hBox, 100.0);
        AnchorPane.setBottomAnchor(image1,50.0);
        AnchorPane.setLeftAnchor(image1,700.0);

        AnchorPane root = new AnchorPane();
        root.setBackground(new Background(new BackgroundFill(Color.BLACK,null,null)));
        root.getChildren().addAll(hBox,image1);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setHeight(900);
        stage.setWidth(1600);
        stage.setTitle("Effect 各類效果");

        stage.show();
    }

    private Effect getEffect() {
        SepiaTone sepiaTone = new SepiaTone();
        sepiaTone.setLevel(0.5);//max 1
        return sepiaTone;
    }
    public static void main(String[] args) {
        launch(args);
    }
}
