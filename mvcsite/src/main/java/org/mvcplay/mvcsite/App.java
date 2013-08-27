package org.mvcplay.mvcsite;

import org.mvcplay.mvcsite.view.MainView;

public class App 
{
    public static void main( String[] args )
    {
        final MainController mainController = new MainController();
        App app = new App();
        app.startApplication(mainController);
    }

	public void startApplication(final MainController mainController) {
		final MainView mainview = new MainView(mainController);
		mainController.setView(mainview);
		mainController.takeControl();
	}
}
