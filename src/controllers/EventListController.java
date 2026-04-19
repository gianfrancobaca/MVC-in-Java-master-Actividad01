package controllers;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import core.Controller;
import models.SchedulerIO;
import views.EventListView;
import javax.swing.JTable;


/**
 * Responsible for {@link EventListView} behavior.
 */
public class EventListController extends Controller 
{
	//-----------------------------------------------------------------------
	//		Attributes
	//-----------------------------------------------------------------------
	private EventListView eventListView;
	private DefaultTableModel model;
	
	
	//-----------------------------------------------------------------------
	//		Methods
	//-----------------------------------------------------------------------
	@Override
	public void run() {

		model = new DefaultTableModel(getNameColumns(), 0);
		eventListView = new EventListView(this);
		eventListView.setModel(model);

		// 🔥 AQUÍ VA LO QUE TE DIJE
		addView("EventListView", eventListView);

		// 4. Cargar datos
		loadEvents();
	}

	public void loadEvents() {
		try {
			SchedulerIO schedulerIO = new SchedulerIO();
			Vector<Vector<Object>> data = schedulerIO.getEvents();

			for (Vector<Object> row : data) {
				model.addRow(row);
			}

			model.fireTableDataChanged(); // 🔥 CLAVE
			System.out.println("Filas cargadas desde archivo: " + data.size()); // ✅ aquí

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Adds a new row in a {@link JTable} with the values informed.
	 * 
	 * @param values Values to be add in {@link JTable}
	 */
	public void addNewRow(Object[] values) 
	{
		model.addRow(values);
	}
	
	
	//-----------------------------------------------------------------------
	//		Getters
	//-----------------------------------------------------------------------
	/**
	 * Gets the {@link EventListView view associated with this controller}.
	 * 
	 * @return View associated with this controller
	 */
	public EventListView getView()
	{
		return eventListView;
	}
	
	/**
	 * Returns the names of the columns of the events list.
	 * 
	 * @return Table metadata in a list
	 */
	public Vector<String> getNameColumns() 
	{
		Vector<String> nameColumns = new Vector<String>();
		
		nameColumns.add("Date");
		nameColumns.add("Description");
		nameColumns.add("Frequency");
		nameColumns.add("E-mail");
		nameColumns.add("Alarm");
		
		return nameColumns;
	}

	/**
	 * Returns events list data.
	 * 
	 * @return Table data in a list of lists (matrix)
	 */
	public Vector<Vector<Object>> getDataColumns() 
	{
		Vector<Vector<Object>> dataColumns = null;

		try {
			SchedulerIO schedulerIO = new SchedulerIO();
			schedulerIO.attach(eventListView);
			dataColumns = schedulerIO.getEvents();
		} catch (Exception ex) { }

		return dataColumns;
	}

	public void eliminarEvento(int fila) {
		model.removeRow(fila);
	}

	public DefaultTableModel getTableModel() {
		return model;
	}

}
