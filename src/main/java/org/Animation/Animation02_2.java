package org.Animation;

import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.DisplacementMap;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animation02_2 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        JFXButton button1 = new JFXButton("button01");
        JFXButton button2 = new JFXButton("button02");
        setButton(button1);
        setButton(button2);
        Pane pane = new Pane();//建立一個透明物件

        StackPane stackPane = new StackPane();
        stackPane.setPrefWidth(400);
        stackPane.setPrefHeight(400);
        stackPane.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, null, new BorderWidths(2))));

        HBox hBox1 = new HBox();
        //將hBox組建放入stackPane中,他會自動根據stackPane來自動填滿大小
        //如果要強制減少裡面組建的大小可以使用setMax寬或高
//        hBox1.setMaxWidth(350);
//        hBox1.setMaxHeight(350);
        hBox1.setAlignment(Pos.CENTER);//hBox內部組件置中
        hBox1.getChildren().addAll(new JFXButton("測試1"));
        //設置背景顏色
        hBox1.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, null, null)));

        HBox hBox2 = new HBox();
        //將hBox組建放入stackPane中,他會自動根據stackPane來自動填滿大小
        //如果要強制減少裡面組建的大小可以使用setMax寬或高
//        hBox2.setMaxWidth(350);
//        hBox2.setMaxHeight(350);

        hBox2.setAlignment(Pos.CENTER);//hBox內部組件置中
        hBox2.getChildren().addAll(new JFXButton("測試2"));
        hBox2.setBackground(new Background(new BackgroundFill(Color.BLANCHEDALMOND, null, null)));
        hBox2.setBorder(new Border(new BorderStroke(Color.AQUA, BorderStrokeStyle.SOLID, null, new BorderWidths(5))));

//        hBox2.setTranslateX(200);


        TranslateTransition tt = new TranslateTransition();
        tt.setDuration(Duration.seconds(3));
        tt.setNode(pane);


        //效果,能讓特定方向的物件消失
        DisplacementMap disMAp = new DisplacementMap();
        disMAp.setWrap(false);
        hBox2.setEffect(disMAp);

        //讓他往左移動,移動時配合讓hBox2百分比消失達到跑馬燈效果
        pane.translateXProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                disMAp.setOffsetX((t1.doubleValue()/400)*2);


                hBox2.setTranslateX(t1.doubleValue());
            }
        });
        /**
         * 注意:
         * 如果下層的hBox1要能點擊按鈕,還是需把上層的hBox2刪除
         * DisplacementMap這個類只是單純的把該物件隱藏掉,簡單說就是透明效果
         * 因此當看不到hBox2時下層的hBox1依舊無法點擊自己的按鈕
         */
        //當動畫跑完會調用這裡的東西
        tt.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//                stackPane.getChildren().remove(hBox2);//方法1：直接移除該物件

//                hBox2.setVisible(false);//方法2：更改為不可見

            }
        });

//        AnimationTimer animationTimer = new AnimationTimer() {
//            double dd = -1;
//            @Override
//            public void handle(long l) {
//                dd--;
//
//                disMAp.setOffsetX(dd/500);
//                disMAp.setWrap(true);
//                hBox2.setEffect(disMAp);
//            }
//        };

//        animationTimer.start();
        stackPane.getChildren().addAll(hBox1, hBox2);

        AnchorPane view = new AnchorPane();
        view.getChildren().addAll(button1, button2, stackPane);

        AnchorPane.setTopAnchor(stackPane, 200.0);
        AnchorPane.setLeftAnchor(stackPane, 500.0);

        AnchorPane.setLeftAnchor(button2, 500.0);

        view.requestFocus();

        Scene scene = new Scene(view);


        stage.setScene(scene);
        stage.setTitle("跑馬燈");
        stage.setHeight(900);
        stage.setWidth(1500);
        stage.centerOnScreen();

        stage.show();

        /**
         * button1 & button2
         * 設置hBox2往左位移
         * 然後可以回來的動態效果
         * 可作漢堡元件效果
         */
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                tt.setFromX(0);
                tt.setToX(stackPane.getPrefWidth());

                tt.play();
            }
        });
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                tt.setFromX(stackPane.getPrefWidth());
                tt.setToX(0);

                tt.play();
            }
        });
    }


    public void setButton(JFXButton button) {
        button.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1.5))));
        button.setMinSize(150, 50);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
