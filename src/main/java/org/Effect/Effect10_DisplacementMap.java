package org.Effect;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DisplacementMap;
import javafx.scene.effect.Effect;
import javafx.scene.effect.FloatMap;
import javafx.scene.effect.Reflection;
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
 * DisplacementMap() 隱藏
 */
public class Effect10_DisplacementMap extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        HBox hBox = new HBox(100);
        hBox.setAlignment(Pos.CENTER);
        Rectangle rectangle = new Rectangle(150, 150);
        rectangle.setFill(Color.LIGHTPINK);

        URL url = getClass().getResource("image/cursoor.png");
        Image image = new Image(url.toExternalForm(), 500, 500, true, true);
        ImageView imageView = new ImageView(image);
        Image image2 = new Image(url.toExternalForm(), 500, 500, true, true);
        ImageView imageView2 = new ImageView(image);

//        imageView.setRotate(30);
        Label label = new Label("this is 你好");
        label.setFont(Font.font(null, FontWeight.BOLD, 50));
        label.setTextFill(Color.LIGHTBLUE);
        Circle circle = new Circle(75);
        circle.setFill(Color.LIGHTBLUE);

        hBox.getChildren().addAll(imageView, label, rectangle, circle);

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
        image1.setRotate(30);
        image1.setEffect(getEffect());
        image1.setRotate(0);

        AnchorPane.setRightAnchor(hBox, 50.0);
        AnchorPane.setLeftAnchor(hBox, 50.0);
        AnchorPane.setTopAnchor(hBox, 100.0);
        AnchorPane.setBottomAnchor(image1, 50.0);
        AnchorPane.setLeftAnchor(image1, 700.0);

        AnchorPane root = new AnchorPane();
        root.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        root.getChildren().addAll(hBox, image1);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setHeight(900);
        stage.setWidth(1600);
        stage.setTitle("Effect 各類效果");

        stage.show();
    }

    private Effect getEffect() {
        int w = 500;
        int h = 500;
        //寬高需大於等於要位移的物件寬高
        FloatMap fmap = new FloatMap(w,h);//須給予寬高,
        float value = 0.1f;
        for (int i = 0; i < fmap.getWidth(); i++) {
        //中間一半對切
//            for (int j = 0; j < fmap.getHeight(); j++) {
////                //當前高度小於一半時
////                //往右偏移0.3百分比
//                float temp = 0;
//                if(j<h/2){
//
//                    temp = value;
//                //如果高度大於一半時
//                //往左偏移0.3百分比
//                }else {
//                    temp = value*-1;
//                }
//                fmap.setSamples(i,j,temp,0);
////                // setSamples(x軸,y軸,x軸,y軸)
////                //當前的x,y軸位置往你想要的位置偏移x,y軸
//            }

        }
        //斜對角切
        for (int i = 0 ; i <fmap.getHeight() ; i++){
            for (int j = 0 ; j <fmap.getWidth(); j ++){
             float temp = 0;
                if (j>=i){
                    temp = value;
                    fmap.setSamples(j,i,temp,temp);
                }else if (j<=i){
                    temp = value*-1;
                    fmap.setSamples(j,i,temp,temp);
                }
            }
        }
        DisplacementMap dm = new DisplacementMap();
//        dm.setOffsetY(0.5);//百分之50不可見
//        dm.setWrap(true);//將不可見的部分顯示
        dm.setMapData(fmap);


        return dm;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
