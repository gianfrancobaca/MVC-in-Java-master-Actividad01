package views;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import controllers.EventListController;
import core.Model;
import core.View;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import models.Invitado;


/**
 * View responsible for the list of events.
 */
public class EventListView extends JPanel implements View
{
	//-----------------------------------------------------------------------
	//		Attributes
	//-----------------------------------------------------------------------
	@SuppressWarnings("unused")
	private EventListController eventListController;
	private JTable table;


	//-----------------------------------------------------------------------
	//		Constructor
	//-----------------------------------------------------------------------
	/**
	 * It will show the list of saved events.
	 *
	 * @param eventListController Controller responsible for this view
	 * @param table Table with saved events
	 */


	public EventListView(EventListController eventListController) {
		this.eventListController = eventListController;
		this.table = new JTable(); // 🔥 FALTABA ESTO
		make_frame();
	}


	//-----------------------------------------------------------------------
	//		Methods
	//-----------------------------------------------------------------------
	@Override
	public void update(Model model, Object data)
	{
		if (data != null) {
			String notice = (String) data;
			JOptionPane.showMessageDialog(this, notice);
		}
	}

	public void setModel(DefaultTableModel model) {
		table.setModel(model);
	}

	/**
	 * Creates view's frame.
	 */
	private void make_frame()
	{
		setLayout(new BorderLayout());

		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);
	}

	public void eliminarEvento(int fila) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.removeRow(fila);
	}

}
