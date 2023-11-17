package org.grupo2b.proyectodisenio.interfaz;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class AltaPolizaEligiendoPolizaControlador {
    @FXML private ResourceBundle resources;
    @FXML private URL location;
    @FXML private Button botonVolver;
    @FXML private Button idBotonInicio;
    @FXML private Button botonCancelar;
    @FXML private Button botonConfirmar;

    @FXML private TableView<tablaTipoCobertura> tablaConTipoCobertura;
    @FXML private TableColumn<tablaTipoCobertura, String> columnaCheck;
    @FXML private TableColumn<tablaTipoCobertura, String> columnaDescripcion;
    @FXML private TableColumn<tablaTipoCobertura, String> columnaTipoCobertura;
    private final ObservableList<tablaTipoCobertura> tipoCoberturaList = FXCollections.observableArrayList();
    @FXML void irInterfazInicio(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ProdSegurosVentanaPrincipal.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("EL ASEGURADO");
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    @FXML void volver(ActionEvent event) {}
    @FXML void cancelar(ActionEvent event) {}
    @FXML void confirmar(ActionEvent event) {}
    @FXML void initialize() {
        assert botonVolver != null : "fx:id=\"botonVolver\" was not injected: check your FXML file 'AltaPolizaEligiendoPoliza.fxml'.";
        assert columnaCheck != null : "fx:id=\"columnaCheck\" was not injected: check your FXML file 'AltaPolizaEligiendoPoliza.fxml'.";
        assert columnaDescripcion != null : "fx:id=\"columnaDescripcion\" was not injected: check your FXML file 'AltaPolizaEligiendoPoliza.fxml'.";
        assert columnaTipoCobertura != null : "fx:id=\"columnaTipoCobertura\" was not injected: check your FXML file 'AltaPolizaEligiendoPoliza.fxml'.";
        assert idBotonInicio != null : "fx:id=\"idBotonInicio\" was not injected: check your FXML file 'AltaPolizaEligiendoPoliza.fxml'.";
        assert tablaConTipoCobertura != null : "fx:id=\"tablaConTipoCobertura\" was not injected: check your FXML file 'AltaPolizaEligiendoPoliza.fxml'.";

        columnaCheck.setCellValueFactory(new PropertyValueFactory<>("checkBox"));
        columnaTipoCobertura.setCellValueFactory(new PropertyValueFactory<>("tipoCobertura"));
        columnaDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        columnaDescripcion.setCellFactory(WRAPPING_CELL_FACTORY);

        tablaTipoCobertura tipo1 = new tablaTipoCobertura("Responsabilidad Civil","Dirigida hacia terceros transportados y no transportados, con límite de $23.000.000 en la Argentina y $3.200.000 para países limítrofes");
        tablaTipoCobertura tipo2 = new tablaTipoCobertura("Resp. Civil, Robo o incendio total","Resp. Civil + Robo Total (apoderamiento ilegítimo del vehículo con violencia) + Incendio Total (daños provocados por incendio o explosión interna o externa, siempre que haya fuego)");
        tablaTipoCobertura tipo3 = new tablaTipoCobertura("Todo Total","Resp. Civil + Robo Total, Hurto Total (apoderamiento ilegítimo del vehículo sin violencia) + Incendio Total + Destrucción Total (los restos no deben superar el 20% del valor del vehículo)");
        tablaTipoCobertura tipo4 = new tablaTipoCobertura("Terceros Completos","Resp. Civil + Robo Parcial, Hurto Total y Parcial (incluye partes integrantes del vehículo Ej.: partes fijas y accesorios) + Incendio Total y Parcial + Destrucción Total.");
        tablaTipoCobertura tipo5 = new tablaTipoCobertura("Todo Riesgo con Franquicia","Resp. Civil + Robo, Hurto é Incendio Total y Parcial + Daños Totales y Parciales (incluye daños parciales con una franquicia a cargo del asegurado)");
        tipoCoberturaList.addAll(tipo1,tipo2,tipo3,tipo4,tipo5);
        tablaConTipoCobertura.setItems(tipoCoberturaList);
        for (tablaTipoCobertura t: tipoCoberturaList) {
            t.getCheckBox().setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                }
            });
        }
    }
    public class tablaTipoCobertura {
        CheckBox checkBox;
        String tipoCobertura;
        String descripcion;
        public tablaTipoCobertura(String tipoCobertura, String descripcion) {
            this.checkBox = new CheckBox();
            this.tipoCobertura = tipoCobertura;
            this.descripcion = descripcion;
        }
        public CheckBox getCheckBox() {return checkBox;}
        public void setCheckBox(CheckBox checkBox) {this.checkBox = checkBox;}
        public String getTipoCobertura() {return tipoCobertura;}
        public void setTipoCobertura(String tipoCobertura) {this.tipoCobertura = tipoCobertura;}
        public String getDescripcion() {return descripcion;}
        public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
    }
    public static final Callback<TableColumn<tablaTipoCobertura,String>, TableCell<tablaTipoCobertura,String>> WRAPPING_CELL_FACTORY =
            new Callback<TableColumn<tablaTipoCobertura,String>, TableCell<tablaTipoCobertura,String>>() {
                @Override public TableCell<tablaTipoCobertura,String> call(TableColumn<tablaTipoCobertura,String> param) {
                    TableCell<tablaTipoCobertura,String> tableCell = new TableCell<tablaTipoCobertura,String>() {
                        @Override protected void updateItem(String item, boolean empty) {
                            if (item == getItem()) return;
                            super.updateItem(item, empty);
                            if (item == null) {
                                super.setText(null);
                                super.setGraphic(null);
                            } else {
                                super.setText(null);
                                Label l = new Label(item);
                                l.setWrapText(true);
                                VBox box = new VBox(l);
                                l.heightProperty().addListener((observable,oldValue,newValue)-> {
                                    box.setPrefHeight(newValue.doubleValue()+7);
                                    Platform.runLater(()->this.getTableRow().requestLayout());
                                });
                                super.setGraphic(box);
                            }
                        }
                    };
                    return tableCell;
                }
            };
}
