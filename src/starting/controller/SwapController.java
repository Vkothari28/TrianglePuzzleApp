package starting.controller;

import java.util.ArrayList;

import starting.model.Edge;
import starting.model.Model;
import starting.model.Node;
import starting.model.Triangle;
import starting.view.TrianglePuzzleApp;

public class SwapController {
	
	TrianglePuzzleApp app;
	Model model;

	
	public SwapController(TrianglePuzzleApp tpA,Model mode ) {
		this.model=mode;
		this.app=tpA;
	}
	
	
	public static void enableSwap(TrianglePuzzleApp app) {
		app.getBtnSwapButton().setEnabled(true);
	}
	
	public static void disableSwap(TrianglePuzzleApp app) {
		app.getBtnSwapButton().setEnabled(false);
	}
	
	public static void enableUnselect(TrianglePuzzleApp app) {
		app.getBtnUnselectAllButton().setEnabled(true);
	}
	
	public static void disableUnselect(TrianglePuzzleApp app) {
		app.getBtnUnselectAllButton().setEnabled(false);
	}
	
	




	
	
	public void swap() {
		
			model.SwapEdges();
			
			app.setPlayerMovesLabel(model.getmoves());
			
			app.setScore(model.getScore());
			
			if(model.isWinnerCondition()) {
				System.out.println("Congratulations You have won!"); 
				
				disableSwap(app);
				disableUnselect(app);
				app.repaint();
			}else {
				disableSwap(app);
				disableUnselect(app);
				app.repaint();
			}
			
	
	}
}

	
/*
 * public void swap() { int numEdgesSelected = 0; ArrayList<Edge> edgesSelected
 * = new ArrayList<Edge>(); for(int i = 0; i < model.puzzle.getEdges().size();
 * i++) { if(model.puzzle.getEdges().get(i).getSelected() == true) {
 * numEdgesSelected++; edgesSelected.add(model.puzzle.getEdges().get(i)); } }
 * if(numEdgesSelected == 2) { for(int j = 0; j < edgesSelected.size()-1; j++) {
 * if(edgesSelected.get(j).getNode2() == edgesSelected.get(j+1).getNode2() ||
 * edgesSelected.get(j).getNode2() == edgesSelected.get(j+1).getNode1() ||
 * edgesSelected.get(j).getNode1() == edgesSelected.get(j+1).getNode2() ||
 * edgesSelected.get(j).getNode1() == edgesSelected.get(j+1).getNode1()) { int
 * temp = edgesSelected.get(j).getColor();
 * edgesSelected.get(j).setColor(edgesSelected.get(j+1).getColor());
 * edgesSelected.get(j+1).setColor(temp); int moves = model.puzzle.getMoves();
 * model.puzzle.setMoves(moves + 1); int score = model.puzzle.getScore();
 * model.puzzle.setScore(score - 1); SelectNodeController unselectAllController
 * = new SelectNodeController(model, app); unselectAllController.UnselectAll();
 * } } } if(numEdgesSelected == 3) { for(int k = 0; k < edgesSelected.size()-2;
 * k++) { if((edgesSelected.get(k).getNode2() ==
 * edgesSelected.get(k+1).getNode2() || edgesSelected.get(k).getNode2() ==
 * edgesSelected.get(k+1).getNode1() || edgesSelected.get(k).getNode1() ==
 * edgesSelected.get(k+1).getNode2() || edgesSelected.get(k).getNode1() ==
 * edgesSelected.get(k+1).getNode1()) && (edgesSelected.get(k).getNode2() ==
 * edgesSelected.get(k+2).getNode2() || edgesSelected.get(k).getNode2() ==
 * edgesSelected.get(k+2).getNode1() || edgesSelected.get(k).getNode1() ==
 * edgesSelected.get(k+2).getNode2() || edgesSelected.get(k).getNode1() ==
 * edgesSelected.get(k+2).getNode1()) && (edgesSelected.get(k+1).getNode2() ==
 * edgesSelected.get(k+2).getNode2() || edgesSelected.get(k+1).getNode2() ==
 * edgesSelected.get(k+2).getNode1() || edgesSelected.get(k+1).getNode1() ==
 * edgesSelected.get(k+2).getNode2() || edgesSelected.get(k+1).getNode1() ==
 * edgesSelected.get(k+2).getNode1())) { for(int q = 0; q <
 * model.puzzle.getTriangles().size(); q++) {
 * if(model.puzzle.getTriangles().get(q).getIsSelected() == true) { int tempOne
 * = edgesSelected.get(k).getColor(); int tempTwo =
 * edgesSelected.get(k+1).getColor(); int tempThree =
 * edgesSelected.get(k+2).getColor(); edgesSelected.get(k).setColor(tempTwo);
 * edgesSelected.get(k+1).setColor(tempThree);
 * edgesSelected.get(k+2).setColor(tempOne); int moves =
 * model.puzzle.getMoves(); model.puzzle.setMoves(moves + 1); int score =
 * model.puzzle.getScore(); model.puzzle.setScore(score - 1);
 * SelectNodeController unselectAllController = new SelectNodeController(model,
 * app); unselectAllController.UnselectAll(); break; } else if(q == 5) { int
 * tempOne = edgesSelected.get(k).getColor(); int tempTwo =
 * edgesSelected.get(k+1).getColor(); int tempThree =
 * edgesSelected.get(k+2).getColor(); edgesSelected.get(k).setColor(tempThree);
 * edgesSelected.get(k+1).setColor(tempOne);
 * edgesSelected.get(k+2).setColor(tempTwo); int moves =
 * model.puzzle.getMoves(); model.puzzle.setMoves(moves + 1); int score =
 * model.puzzle.getScore(); model.puzzle.setScore(score - 1);
 * SelectNodeController unselectAllController = new SelectNodeController(model,
 * app); unselectAllController.UnselectAll(); } } } } } int
 * numCompletedTriangles = 0; for(int z = 0; z <
 * model.puzzle.getTriangles().size(); z++) {
 * if(model.puzzle.getTriangles().get(z).getLeft().getColor() ==
 * model.puzzle.getTriangles().get(z).getTop().getColor() &&
 * model.puzzle.getTriangles().get(z).getLeft().getColor() ==
 * model.puzzle.getTriangles().get(z).getBottom().getColor()) {
 * if(model.puzzle.getTriangles().get(z).getIsSelected() != true) {
 * model.puzzle.getTriangles().get(z).setSelected(true);
 * if(model.puzzle.getTriangles().get(z).bonusAdded() == false) {
 * model.puzzle.setScore(model.puzzle.getScore() + 10);
 * model.puzzle.getTriangles().get(z).setBonus(true); } } else
 * if(model.puzzle.getTriangles().get(z).getIsSelected() == true) {
 * if(model.puzzle.getTriangles().get(z).bonusAdded() != true) {
 * model.puzzle.getTriangles().get(z).setBonus(true);
 * model.puzzle.setScore(model.puzzle.getScore() + 10); } }
 * numCompletedTriangles++; } else
 * if(model.puzzle.getTriangles().get(z).getIsSelected() == true) {
 * model.puzzle.getTriangles().get(z).setSelected(false);
 * if(model.puzzle.getTriangles().get(z).bonusAdded() == true) {
 * model.puzzle.getTriangles().get(z).setBonus(false);
 * model.puzzle.setScore(model.puzzle.getScore() - 10); } } }
 * if(numCompletedTriangles == 6) { System.out.println("Congrats! You won!");
 * //app.popupVictoryPanel(); } app.getPanel().repaint(); }
 * 
 * }
 * 
 * 
 */