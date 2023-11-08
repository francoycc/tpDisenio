package org.grupo2b.proyectodisenio.interfaz;

import javafx.animation.FillTransition;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.io.IOException;

public class Knob extends AnchorPane {
    @FXML
    private Rectangle background;
    @FXML
    private Rectangle knob;

    boolean isOn = false;

    TranslateTransition translation;
    FillTransition transition;

    public Knob() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("switch.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(Knob.this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        initElements();
    }

    void initElements(){
        translation = new TranslateTransition(Duration.millis(200), knob);
        transition = new FillTransition(Duration.millis(100), background);
        transition.setInterpolator(Interpolator.LINEAR);

        background.onMouseClickedProperty().set(event -> switchState());
        knob.onMouseClickedProperty().set(event -> switchState());
    }

    // you have to make public getters and setters to expose a
    // component property to the outer fxml templates

    public boolean getIsOn() {
        return isOn;
    }

    public void setIsOn(boolean value) {
        isOn = value;

        // update view
        if (isOn) {
            translation.stop();
            transition.stop();
            translation.setToX(40-18);
            translation.play();
            transition.setFromValue((Color) background.getFill());
            transition.setToValue((Color)Paint.valueOf("#0C8CE9"));
            transition.play();
           //background.setFill(Paint.valueOf("#0C8CE9"));
        } else {
            translation.stop();
            transition.stop();
            translation.setToX(0);
            translation.play();
            transition.setFromValue((Color) background.getFill());
            transition.setToValue((Color)Paint.valueOf("#d9d9d9"));
            transition.play();
            //background.setFill(Paint.valueOf("#d9d9d9"));
        }
    }

    public void switchState() {
        setIsOn(!isOn);

        System.out.println("Switch pressed");
    }
}