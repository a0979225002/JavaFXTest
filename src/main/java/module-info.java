module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires fontawesomefx;
    requires com.jfoenix;
    requires poi;

    opens org.SwitchingBetweenScenes.Controller to javafx.fxml;
    opens org.example.ThreadToExcel.Controller to javafx.fxml;

    exports org.Stage;
    exports org.example.ThreadToExcel;
    exports org.Animation;
    exports org.Panit_Coler;
    exports org.Effect;
    exports org.SwitchingBetweenScenes;
}