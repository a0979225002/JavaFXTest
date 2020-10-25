package org.example.ThreadToExcel.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class ParameterModel {
    private SimpleIntegerProperty m1;
    private SimpleIntegerProperty m2;
    private SimpleIntegerProperty c1;
    private SimpleIntegerProperty c2;

    public ParameterModel(){
        this.m1 = new SimpleIntegerProperty();
        this.m2 = new SimpleIntegerProperty();
        this.c1 = new SimpleIntegerProperty();
        this.c2 = new SimpleIntegerProperty();
    }

    public int getM1() {
        return m1.get();
    }

    public SimpleIntegerProperty m1Property() {
        return m1;
    }

    public void setM1(int m1) {
        this.m1.set(m1);
    }

    public int getM2() {
        return m2.get();
    }

    public SimpleIntegerProperty m2Property() {
        return m2;
    }

    public void setM2(int m2) {
        this.m2.set(m2);
    }

    public int getC1() {
        return c1.get();
    }

    public SimpleIntegerProperty c1Property() {
        return c1;
    }

    public void setC1(int c1) {
        this.c1.set(c1);
    }

    public int getC2() {
        return c2.get();
    }

    public SimpleIntegerProperty c2Property() {
        return c2;
    }

    public void setC2(int c2) {
        this.c2.set(c2);
    }
}
