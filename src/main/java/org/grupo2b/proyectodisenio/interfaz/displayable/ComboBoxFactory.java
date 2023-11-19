package org.grupo2b.proyectodisenio.interfaz.displayable;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class ComboBoxFactory <T extends Displayable> implements Callback<ListView<T>, ListCell<T>> {
    @Override
    public ListCell<T> call(ListView<T> claseListView) {
        return new ListCell<>(){
            @Override
            protected void updateItem(T item ,boolean empty){
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setGraphic(null);
                } else {
                    setText(item.getDisplayString());
                }
            }
        };
    }
}
