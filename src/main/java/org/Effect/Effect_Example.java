package org.Effect;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.effect.DisplacementMap;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.net.URL;
import java.util.ArrayList;

public class Effect_Example extends Application {
    StackPane stackPane01 = null;
    StackPane stackPane02 = null;
    StackPane stackPane03 = null;
    StackPane stackPane04 = null;
    StackPane stackPane05 = null;
    AnchorPane root = null;
    TranslateTransition paneRum = null;
    TranslateTransition tt1 = null;
    TranslateTransition tt2 = null;
    TranslateTransition tt3 = null;
    TranslateTransition tt4 = null;
    ImageView imageButton = null;
    Pane pane = new Pane();
    DisplacementMap ds = new DisplacementMap();

    @Override
    public void start(Stage stage) throws Exception {

        ImageView image1 = new ImageView(getImage(0));
        ImageView image2 = new ImageView(getImage(1));
        ImageView image3 = new ImageView(getImage(2));
        ImageView image4 = new ImageView(getImage(3));
        ImageView image5 = new ImageView(getImage(4));

        stackPane01 = new StackPane();
        stackPane01.getChildren().add(image1);
        stackPane02 = new StackPane();
        stackPane02.getChildren().add(image2);
        stackPane03 = new StackPane();
        stackPane03.getChildren().add(image3);
        stackPane04 = new StackPane();
        stackPane04.getChildren().add(image4);
        stackPane05 = new StackPane();
        stackPane05.getChildren().add(image5);


        root = new AnchorPane();
//        root.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        root.setPrefWidth(1500);
        root.setPrefHeight(750);
        Rectangle rectangle = new Rectangle(1500, 750);
        GaussianBlur gaussianBlur = new GaussianBlur();
        gaussianBlur.setRadius(60);
        rectangle.setEffect(gaussianBlur);
        URL url = getClass().getResource("image/05.png");
        rectangle.setFill(new ImagePattern(new Image(url.toExternalForm())));

        //加入button
        URL url1 = getClass().getResource("image/06.png");

        imageButton = new ImageView(new Image(url1.toExternalForm(), 200, 200, false, true));
        rumAnimation();
        imageOnclick();

        root.getChildren().addAll(rectangle, stackPane01, stackPane02, stackPane03, stackPane04, imageButton);
        setIamgePosition();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("動畫上下分割");
//        stage.setWidth(1200);
//        stage.setHeight(800);
        pane.translateXProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
//                System.out.println(t1);
                double num = 500;
                imageButton.setOpacity(1-(t1.doubleValue()/num));

            }
        });
        stackPane01.translateXProperty().addListener(new ChangeListener<Number>() {
            int num2 = 0;
            double i =  gaussianBlur.getRadius();//抓取當前透明度的值
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                double num = stackPane01.getWidth()/100*-1;//讓他變正數,且除以100
                int percent = (int) (t1.doubleValue()/num);//這樣當前跑的值/num ＝ 當前百分比

                System.out.println(percent);
                if (percent>num2){//每增加一個百分點讓模糊降低
                    gaussianBlur.setRadius(i--);//讓模糊漸漸歸零
                    num2++;
                }

            }
        });


        stage.show();

    }
    //監聽image,讓他跟button一樣效果
    private void imageOnclick() {
        imageButton.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Glow glow = new Glow();
                imageButton.setEffect(glow);
                System.out.println("sss");
            }
        });
        imageButton.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("sssd");
                imageButton.setEffect(null);
            }
        });
        imageButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                paneRum.play();
                imageButton.setEffect(ds);
                tt1.play();
                tt2.play();
                tt3.play();
                tt4.play();
            }
        });
    }
    //將圖片加入
    ArrayList<Image> imageLsit = new ArrayList<>();

    private Image getImage(int num) {

        for (int i = 1; i <= 5; i++) {
            URL url = getClass().getResource(String.format("image/0%s.png", i));
            Image image = new Image(url.toExternalForm(), 700, 500, true, true);
            imageLsit.add(image);
        }
        return imageLsit.get(num);
    }

    //跑動畫
    private void rumAnimation() {


        tt1 = new TranslateTransition();
        tt2 = new TranslateTransition();
        tt3 = new TranslateTransition();
        tt4 = new TranslateTransition();
        paneRum = new TranslateTransition();

        paneRum.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                imageButton.setVisible(false);
            }
        });

        paneRum.setFromX(0);
        paneRum.setToX(500);
        paneRum.setDuration(Duration.seconds(0.5));
        paneRum.setNode(pane);

        tt1.setToX(-700);
        tt1.setDuration(Duration.seconds(2));
        tt1.setNode(stackPane01);

        tt2.setToY(-700);
        tt2.setDuration(Duration.seconds(2));
        tt2.setNode(stackPane02);

        tt3.setToY(700);
        tt3.setDuration(Duration.seconds(2));
        tt3.setNode(stackPane03);

        tt4.setToX(700);
        tt4.setDuration(Duration.seconds(2));
        tt4.setNode(stackPane04);


    }
    //圖片放置在AnchorPane內的相對位置
    private void setIamgePosition() {
        AnchorPane.setLeftAnchor(stackPane01, 0.0);
        AnchorPane.setTopAnchor(stackPane01, 200.0);
        AnchorPane.setTopAnchor(stackPane02, 0.0);
        AnchorPane.setLeftAnchor(stackPane02, 150.0);
        AnchorPane.setTopAnchor(stackPane04, 50.0);
        AnchorPane.setRightAnchor(stackPane04, 0.0);
        AnchorPane.setBottomAnchor(stackPane03, 0.0);
        AnchorPane.setLeftAnchor(stackPane03, root.getPrefWidth() / 3);
        AnchorPane.setLeftAnchor(imageButton, root.getPrefWidth() / 2 - 50);
        AnchorPane.setTopAnchor(imageButton, root.getPrefHeight() / 2 - 80);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
