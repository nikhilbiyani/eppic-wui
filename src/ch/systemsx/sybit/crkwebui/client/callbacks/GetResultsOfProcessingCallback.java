package ch.systemsx.sybit.crkwebui.client.callbacks;

import ch.systemsx.sybit.crkwebui.client.controllers.AppPropertiesManager;
import ch.systemsx.sybit.crkwebui.client.controllers.MainController;
import ch.systemsx.sybit.crkwebui.shared.model.PDBScoreItem;
import ch.systemsx.sybit.crkwebui.shared.model.ProcessingData;
import ch.systemsx.sybit.crkwebui.shared.model.ProcessingInProgressData;

import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Callback used to handle the response from the server when retrieving results of processing.
 * @author srebniak_a
 *
 */
public class GetResultsOfProcessingCallback implements AsyncCallback<ProcessingData>
{
	private MainController mainController;
	private String jobId;

	public GetResultsOfProcessingCallback(MainController mainController,
			String jobId) 
	{
		this.mainController = mainController;
		this.jobId = jobId;
	}

	@Override
	public void onFailure(Throwable caught) 
	{
		String errorText = AppPropertiesManager.CONSTANTS.callback_get_results_of_processing_error() + " " + caught.getMessage();
		mainController.updateStatusLabel(errorText, true);
		mainController.getMainViewPort().unmask();
	}

	@Override
	public void onSuccess(ProcessingData result) 
	{
		if(result != null)
		{
			if(mainController.getSelectedJobId().equals(jobId))
			{
				if(result instanceof ProcessingInProgressData)
				{
					ProcessingInProgressData statusData = (ProcessingInProgressData) result;
					mainController.displayStatusView(statusData);
				}
				else if(result instanceof PDBScoreItem)
				{
					PDBScoreItem resultsData = (PDBScoreItem) result;
					mainController.setPDBScoreItem(resultsData);
					mainController.cleanResiduesForInterface();
					
					mainController.getAllResidues(jobId, resultsData.getUid());
					mainController.displayResultView(resultsData);
				}
				else
				{
					mainController.updateStatusLabel(AppPropertiesManager.CONSTANTS.callback_get_results_of_processing_error() + " - incorrect type ", true);
					mainController.cleanCenterPanel();
				}
			}
			
			mainController.getJobsForCurrentSession();
		}
		else
		{
			mainController.showMessage(AppPropertiesManager.CONSTANTS.callback_job_not_found_error(), "Id=" + jobId + " not found on the server");
			History.newItem("");
		}
		
		mainController.getMainViewPort().unmask();
	}

}
