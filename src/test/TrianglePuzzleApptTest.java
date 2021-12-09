package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.Test;

import starting.Main;
import starting.controller.ExitController;
import starting.controller.ResetController;
import starting.controller.SelectNodeController;
import starting.controller.SwapController;
import starting.model.Edge;
import starting.model.Model;
import starting.model.Node;
import starting.model.Triangle;
import starting.view.TrianglePuzzleApp;

public class TrianglePuzzleApptTest {
	Model model= new Model();
	Main m= new Main();

	TrianglePuzzleApp myApp= new TrianglePuzzleApp(model);
	SwapController sc=new SwapController(myApp, model);
	
	SelectNodeController selC= new SelectNodeController(model,myApp);
	
	@Test
	public void TestApp() {
		
		
		
		assertNotNull(m);
		

		
		
		for(Edge e: model.getPuzzle().getEdges()) {
			assertEquals(e.isSelected,false);
			assertNotNull(e.getNode1());
			assertEquals(e.getNode1().getSelected(),false);
			assertEquals(e.getNode2().getSelected(),false);
			assertNotNull(e.getNode2());
			
		}
		for(Triangle t:model.getPuzzle().getTriangles()) {
			assertEquals(t.givePoints(),false);
			
			assertEquals(model.getScore(),0);
		}
		
		
		Point p= new Point(242,60);
	
		ArrayList<Node> nodeList=model.getPuzzle().getNodes();
		//selC.NodeClick(p);
		selC.NodeClick(new Point(nodeList.get(0).getLocation().getrow(),nodeList.get(0).getLocation().getcol()));
		selC.NodeClick(new Point(nodeList.get(1).getLocation().getrow(),nodeList.get(1).getLocation().getcol()));
		selC.NodeClick(new Point(nodeList.get(2).getLocation().getrow(),nodeList.get(2).getLocation().getcol()));
		selC.UnselectAll();
		//assertEquals(model.getSwap(),false);
		assertEquals(model.getSwappingEdges().size(),0);
		assertEquals(model.getSwap(),false);
		selC.NodeClick(new Point(nodeList.get(0).getLocation().getrow(),nodeList.get(0).getLocation().getcol()));
		selC.NodeClick(new Point(nodeList.get(1).getLocation().getrow(),nodeList.get(1).getLocation().getcol()));
		selC.NodeClick(new Point(nodeList.get(2).getLocation().getrow(),nodeList.get(2).getLocation().getcol()));
		assertEquals(model.getSwappingEdges().size(),3);
		assertEquals(model.getSwap(),true);
		
		ArrayList<Edge> swappingtest= new ArrayList<Edge>();
		assertEquals(model.getSwappingEdges().size(),3);
		for(String s:model.getSwappingEdges().keySet()) {
			swappingtest.add(model.getSwappingEdges().get(s));
		}
		
		assertEquals(swappingtest.size(),3);
		System.out.println("ST"+swappingtest);
		assertEquals(model.getSelectedNodes().size(),3);
		assertEquals(model.getSwap(),true);
		sc.swap();
		assertEquals(model.getSwappingEdges().size(),0);
		
		
		
		
	}
	
	@Test
	public void TestUnselectController() {
		
		ArrayList<Node> nodeList=model.getPuzzle().getNodes();
		selC.NodeClick(new Point(nodeList.get(0).getLocation().getrow(),nodeList.get(0).getLocation().getcol()));
		selC.NodeClick(new Point(nodeList.get(1).getLocation().getrow(),nodeList.get(1).getLocation().getcol()));
		selC.NodeClick(new Point(nodeList.get(2).getLocation().getrow(),nodeList.get(2).getLocation().getcol()));
		selC.NodeClick(new Point(nodeList.get(0).getLocation().getrow(),nodeList.get(0).getLocation().getcol()));
		selC.NodeClick(new Point(nodeList.get(1).getLocation().getrow(),nodeList.get(1).getLocation().getcol()));
		selC.NodeClick(new Point(nodeList.get(2).getLocation().getrow(),nodeList.get(2).getLocation().getcol()));
		 assertEquals(model.getSelectedNodes().size(),0);
	}
	@Test
	public void TestResetController() {
		ResetController rc= new ResetController(model, myApp);
		
		rc.process();
		
		assertEquals(model.getSelectedNodes().size(),0);
		
		//ExitController ex= new ExitController(myApp);
		//ex.confirmExit();
		Main m= new Main();
		
		
	}

}
