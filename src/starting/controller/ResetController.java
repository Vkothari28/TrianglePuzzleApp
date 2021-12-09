package starting.controller;

import java.util.ArrayList;
import java.util.HashMap;

import starting.model.Edge;
import starting.model.Location;
import starting.model.Model;
import starting.model.Node;
import starting.model.Triangle;
import starting.view.TrianglePuzzleApp;

public class ResetController {

	TrianglePuzzleApp app;
	Model model;
	
	public ResetController(Model m, TrianglePuzzleApp app) {
		this.model = m;
		this.app = app;
	}
	
	public void process() {
		model.getSelectedNodes().clear();
		model.getSwappingEdges().clear();
		model.puzzle.getNodes().clear();
		model.puzzle.getEdges().clear();
		model.puzzle.hashEdges().clear();
		model.puzzle.getTriangles().clear();
		model.puzzle.winningConfig.clear();
		/*model.puzzle.getNodes().add(new Node(new Location(242,60),16,16,0)); // node1 
		
		
		
		model.puzzle.getNodes().add(new Node(new Location(192,147),16,16,1)); //node 2
		model.puzzle.getNodes().add(new Node(new Location(292,147),16,16,2));//node 3
		
		
		model.puzzle.getNodes().add(new Node(new Location(142,234),16,16,3)); //node 4
		model.puzzle.getNodes().add(new Node(new Location(242,234),16,16,4));//node 5
		model.puzzle.getNodes().add(new Node(new Location(342,234),16,16,5));//node 6
		
		model.puzzle.getNodes().add(new Node(new Location(92,321),16,16,6));//node 7
		model.puzzle.getNodes().add(new Node(new Location(192,321),16,16,7));//node 8
		model.puzzle.getNodes().add(new Node(new Location(292,321),16,16,8)); //node 9
		model.puzzle.getNodes().add(new Node(new Location(392,321),16,16,9)); //node 10

		
		
		/// red =1 green =2 blue =3
		model.puzzle.getEdges().add( new Edge("01",model.puzzle.getNodes().get(0), model.puzzle.getNodes().get(1), 1,"left"));
		model.puzzle.getEdges().add( new Edge("02",model.puzzle.getNodes().get(0), model.puzzle.getNodes().get(2), 1,"right"));
		model.puzzle.getEdges().add( new Edge("12",model.puzzle.getNodes().get(1), model.puzzle.getNodes().get(2), 2,"bottom"));
		model.puzzle.getEdges().add( new Edge("13",model.puzzle.getNodes().get(1), model.puzzle.getNodes().get(3), 1,"left"));
		model.puzzle.getEdges().add( new Edge("14",model.puzzle.getNodes().get(1), model.puzzle.getNodes().get(4), 3,"right"));
		model.puzzle.getEdges().add( new Edge("24",model.puzzle.getNodes().get(2), model.puzzle.getNodes().get(4), 3,"left"));
		model.puzzle.getEdges().add( new Edge("25",model.puzzle.getNodes().get(2), model.puzzle.getNodes().get(5), 1,"right"));
		model.puzzle.getEdges().add( new Edge("34",model.puzzle.getNodes().get(3), model.puzzle.getNodes().get(4), 2,"bottom"));
		model.puzzle.getEdges().add( new Edge("45",model.puzzle.getNodes().get(4), model.puzzle.getNodes().get(5), 2,"bottom"));
		model.puzzle.getEdges().add( new Edge("36",model.puzzle.getNodes().get(3), model.puzzle.getNodes().get(6), 1,"left"));
		model.puzzle.getEdges().add( new Edge("37",model.puzzle.getNodes().get(3), model.puzzle.getNodes().get(7), 3,"right"));
		model.puzzle.getEdges().add( new Edge("47",model.puzzle.getNodes().get(4), model.puzzle.getNodes().get(7), 3,"left"));
		model.puzzle.getEdges().add( new Edge("48",model.puzzle.getNodes().get(4), model.puzzle.getNodes().get(8), 3,"right"));
		model.puzzle.getEdges().add( new Edge("58",model.puzzle.getNodes().get(5), model.puzzle.getNodes().get(8), 3,"left"));
		model.puzzle.getEdges().add( new Edge("59",model.puzzle.getNodes().get(5), model.puzzle.getNodes().get(9), 1,"right"));
		model.puzzle.getEdges().add( new Edge("67",model.puzzle.getNodes().get(6), model.puzzle.getNodes().get(7), 2,"bottom"));
		model.puzzle.getEdges().add( new Edge("78",model.puzzle.getNodes().get(7), model.puzzle.getNodes().get(8), 2,"bottom"));
		model.puzzle.getEdges().add( new Edge("89",model.puzzle.getNodes().get(8), model.puzzle.getNodes().get(9), 2,"bottom"));
		
		
		
		
		
		for(Edge e: model.puzzle.getEdges()) {
			model.puzzle.hashEdges().put(e.getName(), e);
		}
			/*
			 * model.puzzle.getTriangles().add(new Triangle(model.puzzle.getEdges().get(0),model.puzzle.getEdges().get(1),model.puzzle.getEdges().get(2)));
			 * model.puzzle.getTriangles().add(new Triangle(model.puzzle.getEdges().get(3),model.puzzle.getEdges().get(4),model.puzzle.getEdges().get(5)));
			 * model.puzzle.getTriangles().add(new Triangle(model.puzzle.getEdges().get(index)))
			 */
		
		/*model.puzzle.getTriangles().add(new Triangle(model.puzzle.getEdges().get(0),model.puzzle.getEdges().get(1),model.puzzle.getEdges().get(2)));
		model.puzzle.getTriangles().add(new Triangle(model.puzzle.getEdges().get(3),model.puzzle.getEdges().get(4),model.puzzle.getEdges().get(7)));
		model.puzzle.getTriangles().add(new Triangle(model.puzzle.getEdges().get(5),model.puzzle.getEdges().get(6),model.puzzle.getEdges().get(8)));
		model.puzzle.getTriangles().add(new Triangle(model.puzzle.getEdges().get(9),model.puzzle.getEdges().get(10),model.puzzle.getEdges().get(15)));
		model.puzzle.getTriangles().add(new Triangle(model.puzzle.getEdges().get(11),model.puzzle.getEdges().get(12),model.puzzle.getEdges().get(16)));
		model.puzzle.getTriangles().add(new Triangle(model.puzzle.getEdges().get(13),model.puzzle.getEdges().get(14),model.puzzle.getEdges().get(17)));
		
		// winning configuration
		model.puzzle.winningConfig.put(model.puzzle.getTriangles().get(0), 1); //red 
		model.puzzle.winningConfig.put(model.puzzle.getTriangles().get(1),3); //blue
		model.puzzle.winningConfig.put(model.puzzle.getTriangles().get(2),2); //green
		model.puzzle.winningConfig.put(model.puzzle.getTriangles().get(3),2);//green
		model.puzzle.winningConfig.put(model.puzzle.getTriangles().get(4),1);//green
		model.puzzle.winningConfig.put(model.puzzle.getTriangles().get(5),3); //red*/
		model.getPuzzle().createPuzzle();
		model.setMoves(0);
		model.setScore(0);
		model.setcanSwap();
		app.setPlayerMovesLabel(0);
	
		app.setScore(0);
		app.repaint();
		
		
	}
}
