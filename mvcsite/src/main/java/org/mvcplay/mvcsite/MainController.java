package org.mvcplay.mvcsite;

import org.mvcplay.mvcsite.model.DataController;
import org.mvcplay.mvcsite.model.ModelContainer;
import org.mvcplay.mvcsite.view.MainView;
import javax.swing.SwingUtilities;
public class MainController {

	private MainView view;
	private DataController dataController;
	private ModelContainer model;
	public MainController()
	{
		dataController = new DataController();
	}
	protected MainController(final DataController subController){
		dataController = subController;
	}
	public void setView(MainView mainview) {
		view = mainview;
	}

	public void takeControl() {
		view.show();
		model = dataController.fetchModel();
		
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
			
				view.showModel(model);	
			}	
		});
		

		
	}

	public MainView getView() {
	
		return view;
	}

}
