package starting.controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;







import starting.view.TrianglePuzzleApp;

public class ExitController {
	
	TrianglePuzzleApp tpa;
	public ExitController(TrianglePuzzleApp tpa) {
		this.tpa=tpa;
	}
	public void confirmExit() {
		int a= JOptionPane.showConfirmDialog (tpa, "Do you wish to exit Application?") ;
		if(a==JOptionPane.YES_OPTION) {
			tpa.setVisible(false);
			tpa.dispose();
		}
		
		else if(a==JOptionPane.NO_OPTION) {
			
		}
		System.out.println(a);
		System.out.println(JOptionPane.NO_OPTION);
		}
		
	}

	
