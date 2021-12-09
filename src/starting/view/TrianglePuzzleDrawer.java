package starting.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

import javax.swing.JPanel;

import starting.model.TrianglePuzzle;
import starting.model.Edge;
import starting.model.Model;
import starting.model.Node;


public class TrianglePuzzleDrawer extends JPanel {

	Model model;
	
	/**
	 * Create the panel.
	 */
	public TrianglePuzzleDrawer(Model model) {
		this.model = model;
	}
	
	public void edgePainting(Edge edge,Graphics2D g) {
		if(edge.getColor()==1) {
			g.setColor(Color.RED);
			g.drawLine(edge.getX1(), edge.getY1(), edge.getX2(), edge.getY2());
		}else if(edge.getColor()==2) {
			g.setColor(new Color(0,153,76));
			g.drawLine(edge.getX1(), edge.getY1(), edge.getX2(), edge.getY2());
		}else if(edge.getColor()==3) {
			g.setColor(new Color(0,128,255));
			g.drawLine(edge.getX1(), edge.getY1(), edge.getX2(), edge.getY2());
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		if(model==null) {return;}

		TrianglePuzzle puzzle = model.getPuzzle();
		ArrayList<Node> selectedNodes = model.getSelectedNodes();
		
		for(Node node:puzzle.getNodes()) {
			g2.setColor(new Color(0,76,153));
			Rectangle rectBack = new Rectangle(node.getLocation().getrow(),node.getLocation().getcol(),node.getWidth(),node.getHeight());
			g2.fillRect(rectBack.x, rectBack.y, rectBack.width, rectBack.height);
			
			Rectangle rect = new Rectangle(node.getLocation().getrow()+1,node.getLocation().getcol()+1,node.getWidth()-2,node.getHeight()-2);
			boolean isSelected = false;
			for(Node selectnode:selectedNodes) {
				if(node.equals(selectnode)) {
					g.setColor(Color.black);
					isSelected = true;
					break;
				}
			}
			
			if(!isSelected) {
				g2.setColor(Color.white);
			}
			
			g2.fillRect(rect.x, rect.y, rect.width, rect.height);
		}
		
//edges drawing
		ArrayList<Edge> edges = puzzle.getEdges();
		
		g2.setStroke(new BasicStroke(3.5f));
		for(Edge edge:edges) {
			edgePainting(edge, g2);
		}
		//System.out.println(model.getSwappingEdges().values());
		ArrayList<Edge> swapEdges = (ArrayList<Edge>) model.getSwappingEdges().values()
                .stream()
                .collect(Collectors.toList());

		if(swapEdges.size()>=2) {
			//g2.setStroke(new BasicStroke(15f));
			for(Edge edge:swapEdges) {
				edgePainting(edge, g2);
			}
			
		}

		

	}



		// do the math and figure out WHERE to draw all the boxes (nodes) lines (edges)
		
		// DRAW ENTIRE PUZZLE HERE...
		
		



}


