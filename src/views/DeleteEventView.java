package views;

import javax.swing.*;
import controllers.DeleteEventController;
import javax.swing.table.DefaultTableModel;

public class DeleteEventView extends JPanel {

    private DeleteEventController controller;
    private JTable table;

    public DeleteEventView(DeleteEventController controller, DefaultTableModel model) {

        this.controller = controller;
        this.table = new JTable(model); // 🔥 FALTABA ESTO

        setLayout(null);

        JLabel lbl = new JLabel("Selecciona un evento y elimínalo");
        lbl.setBounds(20, 20, 300, 20);
        add(lbl);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(20, 50, 400, 150);
        add(scroll);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(150, 220, 120, 30);
        add(btnEliminar);

        btnEliminar.addActionListener(e -> {
            int fila = table.getSelectedRow();

            if (fila != -1) {
                controller.eliminarEvento(fila);
                JOptionPane.showMessageDialog(this, "Evento eliminado");
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona un evento");
            }
        });
    }
}