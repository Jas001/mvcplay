package org.mvcplay.mvcsite;


import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mvcplay.mvcsite.view.MainView;

public class AppTest {

	@Test
	public void testStartApplication() {
		final App app = new App();
		
		MainController mainController = mock(MainController.class);
		
		//call program.
		app.startApplication(mainController);
		
		//verifies.
		verify(mainController).setView(isA(MainView.class));
		verify(mainController).takeControl();
		verifyNoMoreInteractions(mainController);
	}


}
