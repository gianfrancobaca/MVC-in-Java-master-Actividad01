package controllers;

import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JOptionPane;


public class BuscarEventController {

    private DefaultTableModel model;

    public BuscarEventController(DefaultTableModel model) {
        this.model = model;
    }

    public int buscar(String texto) {

        for (int i = 0; i < model.getRowCount(); i++) {
            String desc = model.getValueAt(i, 1).toString();

            if (desc.toLowerCase().contains(texto.toLowerCase())) {
                return i;
            }
        }

        return -1;
    }
    }
