package org.example.ThreadToExcel.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import org.example.ThreadToExcel.Model.ParameterModel;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

public class ParameterController implements Initializable {
    public RootController rootController;

    public TextField m1Text;
    public TextField c1Text;
    public TextField m2Text;
    public TextField c2Text;

    public ParameterModel parameterModel;


    public void setRootController(RootController rootController) {
        System.out.println("setRootController:" + rootController);
        System.out.println("setRootController" + this);
        this.rootController = rootController;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        parameterModel = new ParameterModel();

        m1Text.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>() {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change) {

                String value = change.getText();

                if (value.matches("[0-9]*")){
                    return change;
                }else {
                    return null;
                }
            }
        }));
        m2Text.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>() {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change) {

                String value = change.getText();

                if (value.matches("[0-9]*")){
                    return change;
                }else {
                    return null;
                }
            }
        }));
        c1Text.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>() {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change) {

                String value = change.getText();

                if (value.matches("[0-9]*")){
                    return change;
                }else {
                    return null;
                }
            }
        }));
        c2Text.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>() {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change) {

                String value = change.getText();

                if (value.matches("[0-9]*")){
                    return change;
                }else {
                    return null;
                }
            }
        }));
        m1Text.setTextFormatter(new TextFormatter<String>(new UnaryOperator<TextFormatter.Change>() {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change) {

                String value = change.getText();

                if (value.matches("[0-9]*")){
                    return change;
                }else {
                    return null;
                }
            }
        }));
    }


    public void addButton(ActionEvent actionEvent) {
        String m1 = m1Text.getText().trim();
        String m2 = m2Text.getText().trim();
        String c1 = c1Text.getText().trim();
        String c2 = c2Text.getText().trim();
        System.out.println(m1);


        if (!m1.isEmpty()&&!m2.isEmpty()&&!c1.isEmpty()&&!c2.isEmpty()){
            parameterModel.setM1(Integer.valueOf(m1));
            parameterModel.setM2(Integer.valueOf(m2));
            parameterModel.setC1(Integer.valueOf(c1));
            parameterModel.setC2(Integer.valueOf(c2));

            rootController.m1Math.setText(parameterModel.getM1()+"");
            rootController.m2Math.setText(parameterModel.getM2()+"");
            rootController.c1Math.setText(parameterModel.getC1()+"");
            rootController.c2Math.setText(parameterModel.getC2()+"");

            m1Text.setText("");
            m2Text.setText("");
            c1Text.setText("");
            c2Text.setText("");


            rootController.closeDailog();
        }

    }

    public void closeButton(ActionEvent actionEvent) {
        System.out.println("closeButton:" + rootController);
        rootController.closeDailog();
    }
}
