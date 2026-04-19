package views;

import javax.swing.*;
import controllers.InvitadoController;
import models.Invitado;

public class InvitadoView extends JPanel {

	private InvitadoController controller;

	public InvitadoView(InvitadoController controller) {

		this.controller = controller;

		setLayout(null);

		JLabel lblNombre = new JLabel("Ingrese nombre:");
		lblNombre.setBounds(20, 20, 150, 20);
		add(lblNombre);

		JTextField txtNombre = new JTextField();
		txtNombre.setBounds(180, 20, 150, 20);
		add(txtNombre);

		JLabel lblCel = new JLabel("Ingrese número celular:");
		lblCel.setBounds(20, 60, 180, 20);
		add(lblCel);

		JTextField txtCel = new JTextField();
		txtCel.setBounds(180, 60, 150, 20);
		add(txtCel);

		JLabel lblGenero = new JLabel("Género:");
		lblGenero.setBounds(20, 100, 100, 20);
		add(lblGenero);

		String[] generos = {"Masculino", "Femenino"};
		JComboBox<String> comboGenero = new JComboBox<>(generos);
		comboGenero.setBounds(180, 100, 150, 20);
		add(comboGenero);

		JLabel lblFecha = new JLabel("Fecha de nacimiento:");
		lblFecha.setBounds(20, 140, 180, 20);
		add(lblFecha);

		JTextField txtFecha = new JTextField();
		txtFecha.setBounds(180, 140, 150, 20);
		add(txtFecha);

		JLabel lblDir = new JLabel("Dirección:");
		lblDir.setBounds(20, 180, 100, 20);
		add(lblDir);

		JTextField txtDir = new JTextField();
		txtDir.setBounds(180, 180, 150, 20);
		add(txtDir);

		JCheckBox chkTerminos = new JCheckBox("Aceptar términos y condiciones");
		chkTerminos.setBounds(20, 220, 250, 20);
		add(chkTerminos);

		JButton btnGuardar = new JButton("Registrar");
		btnGuardar.setBounds(120, 260, 120, 30);
		add(btnGuardar);

		btnGuardar.addActionListener(e -> {

			if (!chkTerminos.isSelected()) {
				JOptionPane.showMessageDialog(this, "Debe aceptar los términos");
				return;
			}

			controller.registrarInvitado(
					txtNombre.getText(),
					txtCel.getText(),
					comboGenero.getSelectedItem().toString(),
					txtFecha.getText(),
					txtDir.getText()
			);

			JOptionPane.showMessageDialog(this, "Invitado registrado");
		});
	}
}