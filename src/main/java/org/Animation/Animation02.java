package org.Animation;

import com.jfoenix.controls.JFXButton;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.DisplacementMap;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animation02 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        JFXButton button1 = new JFXButton("button01");
        JFXButton button2 = new JFXButton("button02");
        setButton(button1);
        setButton(button2);
        Pane pane = new Pane();//模擬數據,查看動畫資訊

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
        tt.setFromX(0);
        tt.setDuration(Duration.seconds(3));
        tt.setToX(stackPane.getPrefWidth());
        tt.setNode(pane);
        tt.setInterpolator(Interpolator.TANGENT(Duration.seconds(3),1,Duration.seconds(10),1));//設置進入時和出去時的動畫效果
        tt.setCycleCount(Animation.INDEFINITE);//當跑完動畫,持續接著跑

        //效果,能讓特定方向的物件消失
        DisplacementMap disMAp = new DisplacementMap();
        disMAp.setWrap(true);
//        disMAp.setOffsetX(-0.5);
        hBox2.setEffect(disMAp);

        //監聽移動x軸動作
        pane.translateXProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {

                System.out.println(t1.intValue());//查看移動距離

//                hBox2.setTranslateX(t1.intValue());


                disMAp.setOffsetX(-(t1.doubleValue()/stackPane.getPrefWidth()));
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

        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
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
