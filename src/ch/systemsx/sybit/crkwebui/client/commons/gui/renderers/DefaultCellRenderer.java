package ch.systemsx.sybit.crkwebui.client.commons.gui.renderers;

import ch.systemsx.sybit.crkwebui.client.commons.util.EscapedStringGenerator;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.widget.grid.ColumnData;
import com.extjs.gxt.ui.client.widget.grid.Grid;
import com.extjs.gxt.ui.client.widget.grid.GridCellRenderer;

/**
 * Default cell renderer.
 * @author srebniak_a
 */
public class DefaultCellRenderer implements GridCellRenderer<BaseModel> {

	@Override
	public Object render(BaseModel model, String property, ColumnData config,
			int rowIndex, int colIndex, ListStore<BaseModel> store,
			Grid<BaseModel> grid) {
		
		Object value = model.get(property);
		
		if((value != null) &&
		   (value instanceof String))
		{
			value = EscapedStringGenerator.generateEscapedString((String)value);
		}
		
		return value;
	}

}