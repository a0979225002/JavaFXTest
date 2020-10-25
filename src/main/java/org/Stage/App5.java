package org.Stage;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class App5 extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        Screen screen = Screen.getPrimary();

        /**
         * 螢幕解析度Dpi = 132.0
         */
        double dpi = screen.getDpi();
        System.out.println("螢幕解析度Dpi = "+dpi);//獲得此用戶螢幕的解析度Dpi


        Rectangle2D rec = screen.getBounds();//獲得螢幕大小

        Rectangle2D rec2 = screen.getVisualBounds();//獲得螢幕可視範圍的大小

        /**
         * //獲得螢幕大小
         * 左上角x = 0.0 左上角y = 0.0
         * 右上角x = 1792.0 右上角x = 1120.0
         * 寬度 = 1792.0 高度 = 1120.0
         */
        System.out.println("左上角x = " + rec.getMinX() + " " + "左上角y = " + rec.getMinY());
        System.out.println("右上角x = " + rec.getMaxX() + " " + "右上角y = " + rec.getMaxY());
        System.out.println("寬度 = " + rec.getWidth() + " " + "高度 = " + rec.getHeight());

        /**
         * //獲得螢幕可視範圍的大小
         * 左上角x = 0.0 左上角y = 23.0
         * 右上角x = 1792.0 右上角y = 1058.0
         * 寬度 = 1792.0 高度 = 1035.0
         */
        System.out.println("左上角x = " + rec2.getMinX() + " " + "左上角y = " + rec2.getMinY());
        System.out.println("右上角x = " + rec2.getMaxX() + " " + "右上角y = " + rec2.getMaxY());
        System.out.println("寬度 = " + rec2.getWidth() + " " + "高度 = " + rec2.getHeight());


        Platform.exit();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
