package org.Panit_Coler;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;

public class LinearGradient01 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(10));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++){
                Rectangle rectangle = new Rectangle(200,200);
                rectangle.setFill(Paint.valueOf("#EDEDED"));
                gridPane.add(rectangle,j,i);
            }
        }

        //漸層顏色 0 ＝ 開始 , 0.5 = 中間 , 1 = 結尾
        Stop[] stops = new Stop[]{
                new Stop(0,Color.valueOf("#3238b0")),
                new Stop(0.5,Color.valueOf("#e7225e")),
                new Stop(1,Color.valueOf("#35da63"))
        };

        Stop[] stops2 = new Stop[]{
                new Stop(0,Color.valueOf("#3238b0")),
                new Stop(0.3,Color.valueOf("#e7225e")),
                new Stop(0.6,Color.valueOf("#23c7d6")),
                new Stop(1,Color.valueOf("#35da63"))
        };

        Stop[] stops3 = new Stop[]{
                new Stop(0.2,Color.valueOf("#3238b0")),
                new Stop(0.4,Color.valueOf("#e7225e")),
                new Stop(0.6,Color.valueOf("#23c7d6")),
                new Stop(0.8,Color.valueOf("#35da63"))
        };

        ArrayList<Paint> colorList = new ArrayList<>();
        //漸層顏色
        LinearGradient lg1 = new LinearGradient(0,0,200,200,false, CycleMethod.NO_CYCLE,stops);
        colorList.add(lg1);

        LinearGradient lg2 = new LinearGradient(0,0,200,200,false, CycleMethod.NO_CYCLE,stops2);
        colorList.add(lg2);

        LinearGradient lg3 = new LinearGradient(0,200,200,200,false, CycleMethod.NO_CYCLE,stops3);
        colorList.add(lg3);

        Label label = new Label("為什麼有這樣的想法，\n因為我一直認為，\n80歲以上的老人，\n不需要限制他們食物清淡");
        label.setTextFill(colorList.get(0));
        label.setFont(new Font(50));


        for (int i =0 ; i < colorList.size() ; i++){

            Rectangle rectangle = (Rectangle) gridPane.getChildren().get(i);

            rectangle.setFill(colorList.get(i));
        }

        AnchorPane root = new AnchorPane();
        AnchorPane.setLeftAnchor(gridPane,50.0);
        AnchorPane.setRightAnchor(gridPane,50.0);
        AnchorPane.setBottomAnchor(label,50.0);
        AnchorPane.setLeftAnchor(label,350.0);
        AnchorPane.setRightAnchor(label,100.0);
        root.getChildren().addAll(gridPane,label);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("漸變塗層顏色,使雃色漸層效果");
        stage.setWidth(1200);
        stage.setHeight(900);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
