package controllers;

import javax.swing.table.DefaultTableModel;

public class DeleteEventController {

    private EventListController eventListController;

    public DeleteEventController(EventListController eventListController) {
        this.eventListController = eventListController;
    }

    public void eliminarEvento(int fila) {
        eventListController.eliminarEvento(fila);
    }
}
