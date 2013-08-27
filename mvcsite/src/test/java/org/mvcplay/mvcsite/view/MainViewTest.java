package org.mvcplay.mvcsite.view;

import static org.junit.Assert.*;

import javax.swing.JFrame;

import org.junit.Test;
import org.mvcplay.mvcsite.MainController;
import static org.mockito.Mockito.*;
public class MainViewTest {

	@Test
	public void testMainViewNeedsController()
	{
	
		try{
			new MainView(null);
			fail("Should have complained about missing controller.");
		}catch(final IllegalArgumentException e){
			
		}
	
	}
	@Test
	public void testShow() {
		final MainController controller = new MainController();
		final MainView view = new MainView(controller );
		JFrame frame = mock(JFrame.class);
		view.setMainFrame(frame);
		view.show();
		verify(frame).setVisible(true);
		verifyNoMoreInteractions(frame);
}

}
