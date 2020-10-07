package org.Animation;

import com.jfoenix.controls.JFXButton;
import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Date;

public class Animation01 extends Application {
    boolean status = true;
    @Override
    public void start(Stage stage) throws Exception {


        JFXButton bu = new JFXButton("播放");
        bu.setPrefHeight(300);
        bu.setPrefWidth(300);
        bu.setBorder(new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID,null,new BorderWidths(2))));

        TranslateTransition tt = new TranslateTransition();
        tt.setDuration(Duration.seconds(1));
        tt.setNode(bu);
        tt.setFromX(0);
        tt.setToX(600);

        TranslateTransition tt2 = new TranslateTransition();
        tt2.setDuration(Duration.seconds(5));//動畫時間
        tt2.setNode(bu);//需要有動畫的元件
        tt2.setFromX(600);//開始動畫的位置
        tt2.setToX(0);//結束動畫的位置


        //每一毫秒呼叫一次,可以做一些簡單的ui動畫
        //比如時間,每秒更新一次ui介面
        //旋轉物體等....
        AnimationTimer animationTimer = new AnimationTimer() {
            int i = 1;
            @Override
            public void handle(long l) {
                System.out.println(l/1000000);


                Duration duration = new Duration(l/1000000);

                System.out.println(duration.toSeconds());
                System.out.println(Thread.currentThread().getName());

                System.out.println("i:"+i++);

                bu.setRotate(bu.getRotate()+6);//選轉button

            }
        };
        //當TranslateTransition的動畫結束時，關閉animationTimer
        tt.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//                animationTimer.stop();
            }
        });

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(bu);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setWidth(1500);
        stage.setHeight(900);
        stage.centerOnScreen();
        stage.setTitle("JAVA-AnimationTimer");
        stage.show();


        bu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (status){
                    tt.play();
                    animationTimer.start();//開始運行每奈秒更新一次ui
                    status = false;
                }else {
                    tt2.play();
                    animationTimer.stop();//結束運行
                    status = true;
                }

            }
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}
