package views;

import javax.swing.*;
import controllers.BuscarEventController;

public class BuscarEventView extends JPanel {

    public BuscarEventView(BuscarEventController controller) {

        setLayout(null);

        JLabel lbl = new JLabel("Buscar evento:");
        lbl.setBounds(20, 20, 150, 20);
        add(lbl);

        JTextField txtBuscar = new JTextField();
        txtBuscar.setBounds(150, 20, 150, 20);
        add(txtBuscar);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(150, 60, 100, 30);
        add(btnBuscar);

        btnBuscar.addActionListener(e -> {
            int fila = controller.buscar(txtBuscar.getText());

            if (fila != -1) {
                JOptionPane.showMessageDialog(this, "Encontrado en fila: " + fila);
            } else {
                JOptionPane.showMessageDialog(this, "Evento no encontrado");
            }
        });
    }
}