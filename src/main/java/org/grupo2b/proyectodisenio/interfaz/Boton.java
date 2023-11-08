package org.grupo2b.proyectodisenio.interfaz;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class Boton extends StackPane {
    @FXML
    private Rectangle background;
    @FXML
    private Label text;
    private boolean isFixedSize=false;
    private double width=100;
    private double heigth=100;

    public Boton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("botonCustom.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(Boton.this);
        fxmlLoader.load();
    }

    @FXML
    public void initialize(){
        setText("Le");
    }

    public void setText(String text){
        this.text.setText(text);
        this.text.autosize();
        if(!isFixedSize) {
            //background.resize();
            background.setWidth(background.getParent().getBoundsInLocal().getWidth());
            background.setHeight(background.getParent().getBoundsInLocal().getHeight());
            System.out.println(background.getParent().getBoundsInLocal().getWidth() + "" + background.getParent().getBoundsInLocal().getHeight());
        }
    }
    public String getText(){
        return this.text.getText();
    }
    public boolean getIsFixedSize(){
        return isFixedSize;
    }
    public void setIsFixedSize(boolean b){
        isFixedSize=b;
    }
}
