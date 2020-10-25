package org.Stage;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class App3 extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        Stage s1 = new Stage();
        s1.setTitle("S1");
        s1.show();

        Stage s2 = new Stage();
        s2.setTitle("S2");
        s2.initOwner(s1);//讓s2綁定到s1底下,s1是s2的user
        s2.initModality(Modality.WINDOW_MODAL);//這樣才會生效
        //適用場景,當s1開啟s2視窗時,讓s2視窗除非關閉,不然s1視窗都無法再點擊使用
        s2.show();

        Stage s3 = new Stage();
//        s3.initModality(Modality.APPLICATION_MODAL);//只能點擊這個視窗,其他視窗都無法使,會以提示音
        s3.setTitle("S3");
        s3.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
