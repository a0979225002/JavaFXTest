package org.example;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App2 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Stage s1 = new Stage();
        s1.initStyle(StageStyle.DECORATED);//默認樣式
        s1.setTitle("S1");
        s1.show();

        Stage s2 = new Stage();
        s2.initStyle(StageStyle.TRANSPARENT);//透明樣式
        s2.setTitle("S2");
        s2.show();

        Stage s3 = new Stage();
        s3.initStyle(StageStyle.UNDECORATED);//隱藏
        s3.setTitle("S3");
        s3.show();

        Stage s4 = new Stage();
        s4.initStyle(StageStyle.UNIFIED);//無標題title,但按鈕存在
        s4.setTitle("S4");
        s4.show();

        Stage s5 = new Stage();
        s5.initStyle(StageStyle.UTILITY);//只有一個按鈕打叉,其他最大化,最小化按鈕都消失
        s5.setTitle("S5");
        s5.show();

//        s3.close();//關閉單一窗口
//        Platform.exit();//關閉全部窗口


    }

    public static void main(String[] args) {
        launch(args);
    }
}
