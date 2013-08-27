package org.mvcplay.mvcsite;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.SwingUtilities;

import org.junit.Before;
import org.junit.Test;
import org.mvcplay.mvcsite.model.DataController;
import org.mvcplay.mvcsite.model.ModelContainer;
import org.mvcplay.mvcsite.view.MainView;

import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
import org.mockito.Mock;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.*;


public class MainControllerTest {
	/*
	MainController controller;
	@Before
	public void setup(){
		controller= new MainController();
	}
	*/
	@Test
	public void testSetView() {
		final MainController controller = new MainController();
		MainView mainview = mock(MainView.class);
		controller.setView(mainview);
		MainView view = controller.getView();
		assertThat(view,is(mainview));
		
	}

	@Test
	public void testTakeControl() throws AWTException {
		DataController dataMock = mock(DataController.class);
		final MainController controller = new MainController(dataMock);
		MainView mainview = mock(MainView.class);
		controller.setView(mainview);
		controller.takeControl();
		new Robot().waitForIdle();
		verify(mainview).show();
		verify(dataMock).fetchModel();
		verify(mainview).showModel(any(ModelContainer.class));
		verifyNoMoreInteractions(mainview);
	}
	@Test
	public void testTakeControlUpdatesViewInEdit() throws AWTException{
		DataController dataMock = mock(DataController.class);
		final MainController controller = new MainController(dataMock);
		MainView mainview = new EditTestMainView(controller);
		controller.setView(mainview);
		
		controller.takeControl();
		new Robot().waitForIdle();
		
		assertThat(mainview.wasCalledFromEdit(),is(true));
	}
private static class EditTestMainView extends MainView{

	private boolean calledFromEdit = false;

	@Override
	public Boolean wasCalledFromEdit() {
		// TODO Auto-generated method stub
		return calledFromEdit;
	}

	@Override
	public void showModel(ModelContainer a) {
		if(SwingUtilities.isEventDispatchThread())
		{
			this.calledFromEdit = true;
		}
		super.showModel(a);
	}

	public EditTestMainView(MainController controller) {
		super(controller);

	}
	

}
}
