package views;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import controllers.EventListController;
import core.Model;
import core.View;

public class InvitadoView extends JPanel {

	private ArrayList<Invitado> invitados = new ArrayList<>();

	public InvitadoView() {
		setLayout(null);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(20, 20, 100, 20);
		add(lblNombre);

		JTextField txtNombre = new JTextField();
		txtNombre.setBounds(120, 20, 150, 20);
		add(txtNombre);

		JLabel lblCel = new JLabel("Celular:");
		lblCel.setBounds(20, 60, 100, 20);
		add(lblCel);

		JTextField txtCel = new JTextField();
		txtCel.setBounds(120, 60, 150, 20);
		add(txtCel);

		JButton btnGuardar = new JButton("Registrar");
		btnGuardar.setBounds(120, 100, 120, 25);
		add(btnGuardar);

		btnGuardar.addActionListener(e -> {
			Invitado i = new Invitado(
					txtNombre.getText(),
					txtCel.getText(),
					"Masculino"
			);

			invitados.add(i);
			JOptionPane.showMessageDialog(this, "Invitado registrado");
		});
	}
}