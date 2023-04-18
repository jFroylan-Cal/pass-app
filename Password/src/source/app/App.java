package source.app;

import gui.window;

public class App {
	
	PasswordGenerator passGen;

	public void generatePassword() {
		passGen = new PasswordGenerator();
		showWindow();
		
	}
	private void showWindow() {
		window principalWindow = new window();
	    principalWindow.setTypeOfPassword(passGen);
		principalWindow.setVisible(true);
	}
}
