package ch.systemsx.sybit.crkwebui.client.callbacks;

import ch.systemsx.sybit.crkwebui.client.controllers.MainController;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class TestCallback implements AsyncCallback 
{
	private MainController mainController;
	
	public TestCallback(MainController mainController)
	{
		this.mainController = mainController;
	}
	
	@Override
	public void onFailure(Throwable caught) 
	{
		mainController.showError("Error during getting data from server");
	}

	@Override
	public void onSuccess(Object result) 
	{
		if((result != null) && (result instanceof String))
		{
			String resultData = (String)result;
			Window.alert(resultData);
		}
		else
		{
			mainController.showError("Error during getting data from server");
		}
	}


}