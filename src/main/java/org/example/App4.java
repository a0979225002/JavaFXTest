package org.example;

import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.util.concurrent.locks.Condition;

public class App4 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("當前Thread:"+Thread.currentThread().getName());//同Thread

        //作用當程式執行時,會自動更新ui介面
        //注意:使用時別使用需要大量效能的動作，比如下載,不然程式會卡死
        //會耗費大量效能動作需使用其他方法
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("當前Thread:"+Thread.currentThread().getName());//同Thread

                int i =1;

                while (i<10){
                    try {
                        Thread.sleep(1000);//停頓1秒鐘
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("i="+i);
                    i++;
                }
            }
        });
        Platform.setImplicitExit(false);//讓程序即使關閉,也在後台偷偷跑,惡意工程師

        //檢查這台電腦是否支持某些功能
        boolean b = Platform.isSupported(ConditionalFeature.SCENE3D);
        System.out.println("是否支持3D"+b);
        boolean b2 = Platform.isSupported(ConditionalFeature.FXML);
        System.out.println("是否支持FXML"+b2);

        stage.show();
        Platform.exit();//使用:(Platform.setImplicitExit(false))需調用這串,才會正式關閉
    }

    public static void main(String[] args) {
        launch(args);
    }
}
