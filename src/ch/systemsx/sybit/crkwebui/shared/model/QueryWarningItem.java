package ch.systemsx.sybit.crkwebui.shared.model;

import java.io.Serializable;

import model.QueryWarningItemDB;

public class QueryWarningItem implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int uid;
	
	private String text;
	
	private HomologsInfoItem homologsInfoItem;
	
	public QueryWarningItem() 
	{
		
	}
	
	public void setHomologsInfoItem(HomologsInfoItem homologsInfoItem) {
		this.homologsInfoItem = homologsInfoItem;
	}

	public HomologsInfoItem getHomologsInfoItem() {
		return homologsInfoItem;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getUid() {
		return uid;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
	
	public static QueryWarningItem create(QueryWarningItemDB queryWarningItemDB)
	{
		QueryWarningItem warningItem = new QueryWarningItem();
		warningItem.setText(queryWarningItemDB.getText());
		warningItem.setUid(queryWarningItemDB.getUid());
		return warningItem;
	}

}