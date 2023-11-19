package org.grupo2b.proyectodisenio.interfaz.displayable;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.util.function.Function;

public class ComboBoxCellFactory<T> implements Callback<ListView<T>, ListCell<T>> {
    Function<T, String> function;
    public ComboBoxCellFactory(Function<T, String> function){
        this.function = function;
    }
    @Override
    public ListCell<T> call(ListView<T> claseListView) {
        return new ListCell<>(){
            @Override
            protected void updateItem(T item ,boolean empty){
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setGraphic(null);
                } else {
                    setText(function.apply(item));
                }
            }
        };
    }
}
