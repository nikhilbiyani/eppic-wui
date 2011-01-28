package ch.systemsx.sybit.crkwebui.client.gui;

import ch.systemsx.sybit.crkwebui.client.controllers.MainController;
import ch.systemsx.sybit.crkwebui.client.data.ResultsData;

import com.extjs.gxt.ui.client.widget.TabItem;

public class OverViewTabItem extends TabItem
{
	private OverviewPanel overviewPanel;
	
	public OverViewTabItem(MainController mainController,
						   ResultsData resultsData)
	{
		this.setText("Overview");
		this.setBorders(false);
		overviewPanel = new OverviewPanel(mainController, resultsData);
		this.add(overviewPanel);
	}
	
	public OverviewPanel getOverviewPanel()
	{
		return overviewPanel;
	}
}