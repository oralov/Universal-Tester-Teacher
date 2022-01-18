package main;

import UI.MainWindow;
import UI.MainMenu;
import UI.ActivationPanel;

public class main {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActivationPanel activation = new ActivationPanel();
		MainWindow window = new MainWindow();
		MainMenu menu = new MainMenu();
		window.add(menu);
		window.setVisible(true);

	}

}
