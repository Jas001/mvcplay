package org.mvcplay.mvcsite.view;

import org.mvcplay.mvcsite.MainController;
import org.mvcplay.mvcsite.model.ModelContainer;

import javax.swing.JFrame;
public class MainView {

	private JFrame mainFrame;

	public MainView(MainController controller) {
		if(controller==null){
			throw new IllegalArgumentException("Maincontroller cannot be null.");
		}
	
		setMainFrame(new JFrame());
	}

	public void show() {
		mainFrame.setVisible(true);
		
	}

	protected void setMainFrame(JFrame jFrame) {
		mainFrame = jFrame;
	}

	public void showModel(ModelContainer a) {
		// TODO Auto-generated method stub
		
	}

	public Boolean wasCalledFromEdit() {
		// TODO Auto-generated method stub
		return null;
	}

}
