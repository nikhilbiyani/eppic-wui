package ch.systemsx.sybit.crkwebui.client;

import java.util.List;

import model.PDBScoreItem;
import ch.systemsx.sybit.crkwebui.shared.model.ApplicationSettings;
import ch.systemsx.sybit.crkwebui.shared.model.StatusData;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("crk")
public interface CrkWebService extends RemoteService 
{
	public String greetServer(String name) throws IllegalArgumentException;
	
	public String test(String test); 
	
	public boolean checkIfDataProcessed(String id);
	
	public StatusData getStatusData(String id);
	
	public PDBScoreItem getResultData(String id);

	public String killJob(String id);

	public List<StatusData> getJobsForCurrentSession();

	public String untieJobsFromSession();

	public ApplicationSettings getSettings();
	
}
