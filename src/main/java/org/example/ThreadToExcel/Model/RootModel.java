package org.example.ThreadToExcel.Model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class RootModel {

    private SimpleIntegerProperty m1Math;
    private SimpleIntegerProperty m2Math;
    private SimpleIntegerProperty c1Math;
    private SimpleIntegerProperty c2Math;
    private SimpleDoubleProperty myProgress;
    private SimpleStringProperty myProgressStatus;
    private SimpleIntegerProperty nowMin;

    public RootModel(){
        this.m1Math = new SimpleIntegerProperty();
        this.m2Math = new SimpleIntegerProperty();
        this.c1Math = new SimpleIntegerProperty();
        this.c2Math = new SimpleIntegerProperty();
        this.myProgress = new SimpleDoubleProperty();
        this.myProgressStatus = new SimpleStringProperty();
        this.nowMin = new SimpleIntegerProperty();
    }

    public int getNowMin() {
        return nowMin.get();
    }

    public SimpleIntegerProperty nowMinProperty() {
        return nowMin;
    }

    public void setNowMin(int nowMin) {
        this.nowMin.set(nowMin);
    }

    public String getMyProgressStatus() {
        return myProgressStatus.get();
    }

    public SimpleStringProperty myProgressStatusProperty() {
        return myProgressStatus;
    }

    public void setMyProgressStatus(String myProgressStatus) {
        this.myProgressStatus.set(myProgressStatus);
    }

    public double getMyProgress() {
        return myProgress.get();
    }

    public SimpleDoubleProperty myProgressProperty() {
        return myProgress;
    }

    public void setMyProgress(double myProgress) {
        this.myProgress.set(myProgress);
    }

    public int getM1Math() {
        return m1Math.get();
    }

    public SimpleIntegerProperty m1MathProperty() {
        return m1Math;
    }

    public void setM1Math(int m1Math) {
        this.m1Math.set(m1Math);
    }

    public int getM2Math() {
        return m2Math.get();
    }

    public SimpleIntegerProperty m2MathProperty() {
        return m2Math;
    }

    public void setM2Math(int m2Math) {
        this.m2Math.set(m2Math);
    }

    public int getC1Math() {
        return c1Math.get();
    }

    public SimpleIntegerProperty c1MathProperty() {
        return c1Math;
    }

    public void setC1Math(int c1Math) {
        this.c1Math.set(c1Math);
    }

    public int getC2Math() {
        return c2Math.get();
    }

    public SimpleIntegerProperty c2MathProperty() {
        return c2Math;
    }

    public void setC2Math(int c2Math) {
        this.c2Math.set(c2Math);
    }
}
