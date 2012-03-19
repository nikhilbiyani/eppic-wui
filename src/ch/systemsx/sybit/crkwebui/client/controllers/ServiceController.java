package ch.systemsx.sybit.crkwebui.client.controllers;

import ch.systemsx.sybit.crkwebui.shared.model.RunJobData;

/**
 * This is the controller used to contact with the server
 * @author srebniak_a
 *
 */
public interface ServiceController
{
	/**
	 * Loads initial setttings.
	 */
	public abstract void loadSettings();
	
	/**
	 * Submits the job to the server.
	 * @param runJobData input parameters
	 */
	public abstract void runJob(RunJobData runJobData);
	
	/**
	 * Retrieves results of processing for selected job id - the results type depends on the status of the job on the server.
	 * @param jobId job id
	 * @param debug retrieve detailed information
	 */
	public abstract void getResultsOfProcessing(String jobId, boolean debug);
	
	/**
	 * Retrieves the status data for the current jobs.
	 * @param jobId job identifier
	 * @param debug retrieve detailed information
	 */
	public abstract void getCurrentStatusData(String jobId, boolean debug);
	
	/**
	 * Retrieves list of all jobs for current session id.
	 */
	public abstract void getJobsForCurrentSession();

	/**
	 * Retrieves residues information for selected interface.
	 * @param jobId selected job id
	 * @param interfaceUid selected interface uid
	 * @param interfaceId selected interface id
	 */
	public abstract void getInterfaceResidues(String jobId, int interfaceUid, int interfaceId);

	/**
	 * Retrieves all the residues for all interfaces for specified job.
	 * @param jobId selected job identifier
	 * @param pdbScoreUid uid of selected pdb score item
	 */
	public abstract void getAllResidues(String jobId, int pdbScoreUid);
	
	/**
	 * Stops the execution of specified running job.
	 * @param jobToStop job to stop
	 * @param debug retrieve detailed information
	 */
	public abstract void stopJob(String jobToStop, boolean debug);
	
	/**
	 * Unties specified job from the current session id.
	 * @param jobToDelete identifier of the job to remove
	 */
	public abstract void deleteJob(String jobToDelete);

	/**
	 * Unties all the jobs which are attached to the current session.
	 */
	public abstract void untieJobsFromSession();
}
