package ch.systemsx.sybit.crkwebui.client.callbacks;

import ch.systemsx.sybit.crkwebui.client.controllers.MainController;
import ch.systemsx.sybit.crkwebui.shared.model.ApplicationSettings;

import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * This is the callback used to handle the response from the server when trying to retrieve initial settings
 * @author srebniak_a
 *
 */
public class GetSettingsCallback implements AsyncCallback<ApplicationSettings>
{
	private MainController mainController;

	public GetSettingsCallback(MainController mainController) {
		this.mainController = mainController;
	}

	@Override
	public void onFailure(Throwable caught) 
	{
		mainController.updateStatusLabel(MainController.CONSTANTS.callback_get_settings_error(), true);
	}

	@Override
	public void onSuccess(ApplicationSettings result)
	{
		if (result != null)
		{
			mainController.setSettings(result);
			mainController.setNrOfSubmissions(result.getNrOfJobsForSession());
			mainController.setMainView();
			mainController.runMyJobsAutoRefresh();
			History.fireCurrentHistoryState();
		}
		else 
		{
			mainController.updateStatusLabel(MainController.CONSTANTS.callback_get_settings_error() + " - incorrect type", true);
		}
	}
}
