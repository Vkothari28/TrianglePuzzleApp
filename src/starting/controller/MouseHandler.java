package starting.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import starting.model.Edge;
import starting.model.Model;
import starting.model.Node;
import starting.view.TrianglePuzzleApp;

public class MouseHandler extends MouseAdapter {

	TrianglePuzzleApp app;
	Model model;
	
	public MouseHandler(Model m, TrianglePuzzleApp app) {
		this.model = m;
		this.app = app;
	}
	
	@Override
    public void mousePressed(MouseEvent e) {
		System.out.println("You clicked" +e.getPoint());
		
	}
	
}