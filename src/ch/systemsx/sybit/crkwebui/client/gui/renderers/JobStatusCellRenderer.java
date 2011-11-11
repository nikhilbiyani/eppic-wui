package ch.systemsx.sybit.crkwebui.client.gui.renderers;

import ch.systemsx.sybit.crkwebui.shared.model.StatusOfJob;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.Grid;

/**
 * @author srebniak_a
 *
 */
public class JobStatusCellRenderer extends DefaultCellRenderer 
{
	public Object render(final BaseModel model, 
						 String property,
						 ColumnData config, 
						 final int rowIndex, 
						 final int colIndex,
						 ListStore<BaseModel> store, 
						 final Grid<BaseModel> grid) 
	{
		String value = (String) model.get(property);
		String color = "black";

		if (value == null) {
			return value;
		} else if (value.equals(StatusOfJob.ERROR)) {
			color = "red";
		} else if (value.equals(StatusOfJob.FINISHED)) {
			color = "green";
		} else {
			return value;
		}

		return "<span qtitle='"
				+ grid.getColumnModel().getColumnById(property).getHeader()
				+ "' qtip='" + value
				+ "' style='font-weight: bold;color:" + color + "'>"
				+ value + "</span>";
	}
}