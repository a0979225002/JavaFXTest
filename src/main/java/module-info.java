module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires fontawesomefx;
    requires com.jfoenix;

    opens org.example to javafx.fxml;
    exports org.example;
    exports org.Animation;
    exports org.Panit_Coler;
    exports org.Effect;
}