package starting;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import starting.controller.ExitController;
import starting.model.Model;
import starting.view.TrianglePuzzleApp;

public class Main {
	public static void main(String[] args) {
		
		Model m = new Model();
		
TrianglePuzzleApp app = new TrianglePuzzleApp(m);
		
		app.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent we) {
				new ExitController(app).confirmExit();
			}
		});
		
		app.setVisible(true);
	}

}
	

