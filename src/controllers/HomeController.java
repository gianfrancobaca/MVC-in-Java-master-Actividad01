package controllers;

import core.Controller;
import views.*;


/**
 * Main controller. It will be responsible for program's main screen behavior.
 */
public class HomeController extends Controller {

	private HomeView homeView;

	private EventListController eventListController = new EventListController();
	private NewEventController newEventController = new NewEventController(eventListController);
	private InvitadoController invitadoController = new InvitadoController();
	private DeleteEventController deleteEventController = new DeleteEventController(eventListController);

	private InvitadoView invitadoView = new InvitadoView(invitadoController);
	private DeleteEventView deleteEventView;
	private BuscarEventController buscarEventController;
	private BuscarEventView buscarEventView;

	@Override
	public void run() {

		eventListController.run();      // 🔥 SIEMPRE primero
		newEventController.run();

		deleteEventController = new DeleteEventController(eventListController);

		deleteEventView = new DeleteEventView(
				deleteEventController,
				eventListController.getTableModel()
		);

		buscarEventController = new BuscarEventController(
				eventListController.getTableModel()
		);

		buscarEventView = new BuscarEventView(buscarEventController);

		homeView = new HomeView(this, mainFrame);
		addView("HomeView", homeView);

		mainFrame.setVisible(true);
	}
	public EventListView getEventListView() {
		return eventListController.getView();
	}

	public NewEventView getNewEventView() {
		return newEventController.getView();
	}

	public InvitadoView getInvitadoView() {
		return invitadoView;
	}

	public DeleteEventView getDeleteEventView() {
		return deleteEventView;
	}
	public BuscarEventView getBuscarEventView() {
		return buscarEventView;
	}
}