package starting.controller;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


import starting.view.TrianglePuzzleApp;

import starting.model.Model;
import starting.model.Node;
import starting.model.TrianglePuzzle;

public class SelectNodeController {

	Model model;
	TrianglePuzzleApp app;
	

	public SelectNodeController(Model model, TrianglePuzzleApp app) {
		this.model = model;
		this.app = app;
	}


public void NodeClick(Point point) {
	TrianglePuzzle puzzle = model.getPuzzle();
	ArrayList<Node> selectedNodes = model.getSelectedNodes();

	if (!model.isWinnerCondition()) {
		for (Node node : puzzle.getNodes()) {
			
		
			if (node.crosses(point)) {

				boolean isSelected = false;
				for (Node selectednode : selectedNodes) {
					if (selectednode.equals(node)) {
						model.UnselectNode(node);
						
						if(selectedNodes.size()==0) {
							SwapController.disableUnselect(app);
						}
						
						if (model.getSwap()) {
							SwapController.enableSwap(app);
						} else {
							SwapController.disableSwap(app);
						}
						isSelected = true;
						break;
					}
				}

				if (!isSelected) {
					if(selectedNodes.size()==0) {
					SwapController.enableUnselect(app);;
					}
					model.setSelectedNodes(node);
					if (model.getSwap()) {
						SwapController.enableSwap(app);
					} else {
						SwapController.disableSwap(app);
					}
				}
				
				app.repaint();
			}
		}
	}
	System.out.println("Selected"+selectedNodes);
}
	/*TrianglePuzzle tp= model.getPuzzle();
	
	ArrayList<Node> SelectedNodes= model.getSelectedNodes();
	System.out.println("Starting"+model.getSelectedNodes());
	System.out.println("Clicked on"+point);
	
	
	
	
		for (Node node :tp.getNodes()) {
			if (node.crosses(point)) {
				if(!model.getSelectedNodes().contains(node)) {
					model.SelectNode(node);
					node.SetSelected(true);
					app.repaint();
					return;
				}
				
		
				else if(model.getSelectedNodes().contains(node)) {
					
						model.UnselectNode(node);
						node.SetSelected(false);
						app.repaint();
					}
						
	
	
	

}
				
				
}
		
		}*/

public void UnselectAll() {
	/*List<Node> SelectedNodes= model.getSelectedNodes();
	SelectedNodes.clear();
	
	app.repaint();*/
	
	if(model != null) {
		int i = 0;
		//ArrayList<starting.model.Node> mylist=model.puzzle.getNodes();
		for(Node nodes : model.puzzle.getNodes()) {
			if(model.puzzle.getNodes().get(i).getSelected() == true) {
				model.puzzle.getNodes().get(i).SetSelected(false);
			}
			i++;
		}
		for(int j = 0; j < model.puzzle.getEdges().size(); j++) {
			model.puzzle.getEdges().get(j).setSelected(false);
		}
	}
	model.getSelectedNodes().clear();
	model.getSwappingEdges().clear();
	model.setcanSwap();
	app.validate();
	app.repaint();
	
}
	
}









	/*public void ClickNode(Point point) {

		TrianglePuzzle puzzle = model.getPuzzle();
		ArrayList<Node> selectedNodes = model.getSelectedNodes();

		if (!model.isWinnerCondition()) {
			for (Node node : puzzle) {
				if (node.contains(point)) {

					boolean isSelected = false;
					for (Node selectednode : selectedNodes) {
						if (selectednode.equals(node)) {
							model.unSelectNode(node);
							
							if(selectedNodes.size()==0) {
								SwapController.disableUnselect(app);
							}
							
							if (model.getAvailableSwap()) {
								SwapController.enableSwap(app);
							} else {
								SwapController.disableSwap(app);
							}
							isSelected = true;
							break;
						}
					}

					if (!isSelected) {
						if(selectedNodes.size()==0) {
							SwapController.enableUnselect(app);;
						}
						model.setSelectedNode(node);
						if (model.getAvailableSwap()) {
							SwapController.enableSwap(app);
						} else {
							SwapController.disableSwap(app);
						}
					}

					app.repaint();
				}
			}
		}

	}
}*/
