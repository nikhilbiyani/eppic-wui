package ch.systemsx.sybit.crkwebui.client.gui;

import ch.systemsx.sybit.crkwebui.client.controllers.ApplicationContext;
import ch.systemsx.sybit.crkwebui.client.controllers.EventBusManager;
import ch.systemsx.sybit.crkwebui.client.events.ApplicationWindowResizeEvent;
import ch.systemsx.sybit.crkwebui.client.handlers.ApplicationWindowResizeHandler;

import com.extjs.gxt.ui.client.Style.Scroll;
import com.extjs.gxt.ui.client.widget.LayoutContainer;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.google.gwt.user.client.Window;

/**
 * Scrollable wrapper of main view.
 * @author adam
 */
public class MainViewWrapper extends LayoutContainer
{
	public MainViewWrapper(MainViewPort mainViewPort)
	{
		this.addStyleName("eppic-panel-with-gray-background");
		this.setLayout(new FlowLayout());
		this.setScrollMode(selectScrollType(Window.getClientWidth(), Window.getClientHeight()));
		this.setSize(Window.getClientWidth(),
					 Window.getClientHeight());
		this.add(mainViewPort);
		
		initializeEventsListeners();
	}
	
	/**
	 * Events listeners initialization.
	 */
	private void initializeEventsListeners()
	{
		EventBusManager.EVENT_BUS.addHandler(ApplicationWindowResizeEvent.TYPE, new ApplicationWindowResizeHandler() {
			
			@Override
			public void onResizeApplicationWindow(ApplicationWindowResizeEvent event) {
				setSize(Window.getClientWidth(),
				    	Window.getClientHeight());
				
				setScrollMode(selectScrollType(Window.getClientWidth(), Window.getClientHeight()));
			}
		});
	}
	
	/**
	 * Select correct type of the scroll based on the size of client window and minimum values of 
	 * width and height.
	 *  
	 * @param width width of client window
	 * @param height height of client window
	 * @return scroll type
	 */
	private Scroll selectScrollType(int width,
									int height)
	{
		Scroll scrollType = Scroll.NONE;
		
		if((width < ApplicationContext.getAdjustedWindowData().getWindowWidth()) &&
		   (height < ApplicationContext.getAdjustedWindowData().getWindowHeight()))
		{
			scrollType = Scroll.AUTO;
		}
		else if(width < ApplicationContext.getAdjustedWindowData().getWindowWidth())
		{
			scrollType = Scroll.AUTOX;
		}
		else if(height < ApplicationContext.getAdjustedWindowData().getWindowHeight())
		{
			scrollType = Scroll.AUTOY;
		}
		
		return scrollType;
	}
}