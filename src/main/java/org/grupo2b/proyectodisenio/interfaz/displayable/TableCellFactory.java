package org.grupo2b.proyectodisenio.interfaz.displayable;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import org.grupo2b.proyectodisenio.logica.documento.TipoDocumento;

import java.util.function.Function;

public class TableCellFactory<S,T> implements Callback<TableColumn<S,T>, TableCell<S,T>>{
    Function<T, String> function;
    public TableCellFactory(Function<T, String> function){
        this.function = function;
    }


    @Override
    public TableCell<S, T> call(TableColumn<S, T> param) {
        return new TableCell<>(){
            @Override
            protected void updateItem(T item, boolean empty){
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(null);
                } else {
                    setText(function.apply(item)); // or any custom formatting you want
                }
            }
        };
    }
}
