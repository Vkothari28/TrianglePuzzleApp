package starting.model;

import java.util.ArrayList;
import java.util.HashMap;

import starting.model.Edge;
import starting.model.Node;



public class TrianglePuzzle{
	
	public HashMap<Triangle, Integer> winningConfig=new HashMap<Triangle,Integer>();
	ArrayList<Node> nodes= new ArrayList<Node>();		
	ArrayList<Edge> edges= new ArrayList<Edge>();
	ArrayList<Triangle> triangles= new ArrayList<Triangle>();
	ArrayList<Node> SelectedNodes= new ArrayList<Node>();
	
	HashMap<String, Edge> hashEdges= new HashMap<String, Edge>();
	
	
	public TrianglePuzzle() {
	
		this.createPuzzle();
	
	
	}
	public void createPuzzle() {
	// adds node to existing nodes	
	nodes.add(new Node(new Location(242,60),16,16,0)); // node1 
	
	
	
	nodes.add(new Node(new Location(192,147),16,16,1)); //node 2
	nodes.add(new Node(new Location(292,147),16,16,2));//node 3
	
	
	nodes.add(new Node(new Location(142,234),16,16,3)); //node 4
	nodes.add(new Node(new Location(242,234),16,16,4));//node 5
	nodes.add(new Node(new Location(342,234),16,16,5));//node 6
	
	nodes.add(new Node(new Location(92,321),16,16,6));//node 7
	nodes.add(new Node(new Location(192,321),16,16,7));//node 8
	nodes.add(new Node(new Location(292,321),16,16,8)); //node 9
	nodes.add(new Node(new Location(392,321),16,16,9)); //node 10

	
	/// red =1 green =2 blue =3
	edges.add( new Edge("01",nodes.get(0), nodes.get(1), 1,"left")); //0
	edges.add( new Edge("02",nodes.get(0), nodes.get(2), 1,"right"));//1
	edges.add( new Edge("12",nodes.get(1), nodes.get(2), 2,"bottom"));//2
	edges.add( new Edge("13",nodes.get(1), nodes.get(3), 1,"left"));//3
	edges.add( new Edge("14",nodes.get(1), nodes.get(4), 3,"right"));//4
	edges.add( new Edge("24",nodes.get(2), nodes.get(4), 3,"left"));//5
	edges.add( new Edge("25",nodes.get(2), nodes.get(5), 1,"right"));//6
	edges.add( new Edge("34",nodes.get(3), nodes.get(4), 2,"bottom"));//7
	edges.add( new Edge("45",nodes.get(4), nodes.get(5), 2,"bottom"));//8
	edges.add( new Edge("36",nodes.get(3), nodes.get(6), 1,"left"));//9
	edges.add( new Edge("37",nodes.get(3), nodes.get(7), 3,"right"));//10
	edges.add( new Edge("47",nodes.get(4), nodes.get(7), 3,"left"));//11
	edges.add( new Edge("48",nodes.get(4), nodes.get(8), 3,"right"));//12
	edges.add( new Edge("58",nodes.get(5), nodes.get(8), 3,"left"));//13
	edges.add( new Edge("59",nodes.get(5), nodes.get(9), 1,"right"));//14
	edges.add( new Edge("67",nodes.get(6), nodes.get(7), 2,"bottom"));//15
	edges.add( new Edge("78",nodes.get(7), nodes.get(8), 2,"bottom"));//16
	edges.add( new Edge("89",nodes.get(8), nodes.get(9), 2,"bottom"));//17
	
	
	
	
	
	for(Edge e: edges) {
		hashEdges.put(e.getName(), e);
	}
		/*
		 * triangles.add(new Triangle(edges.get(0),edges.get(1),edges.get(2)));
		 * triangles.add(new Triangle(edges.get(3),edges.get(4),edges.get(5)));
		 * triangles.add(new Triangle(edges.get(index)))
		 */
	
	/*//simplifying
	for(int i=0;i<16;i+=3) {
		triangles.add(new Triangle(edges.get(i),edges.get(i+1),edges.get(i+2)));
	}* incorrect*/
	
	triangles.add(new Triangle(edges.get(0),edges.get(1),edges.get(2)));
	triangles.add(new Triangle(edges.get(3),edges.get(4),edges.get(7)));
	triangles.add(new Triangle(edges.get(5),edges.get(6),edges.get(8)));
	triangles.add(new Triangle(edges.get(9),edges.get(10),edges.get(15)));
	triangles.add(new Triangle(edges.get(11),edges.get(12),edges.get(16)));
	triangles.add(new Triangle(edges.get(13),edges.get(14),edges.get(17)));

	// winning configuration
	///winningConfig.put(triangles.get(0), 1); //red 
	//winningConfig.put(triangles.get(1),3); //blue
	//winningConfig.put(triangles.get(2),2); //green
	//winningConfig.put(triangles.get(3),2);//green
	//winningConfig.put(triangles.get(4),1);//green
	//winningConfig.put(triangles.get(5),3); //red
	
	
	
	
	}
	
	
	public HashMap<String,Edge>hashEdges(){
		return this.hashEdges;
	}
	public ArrayList<Edge> getEdges(){
		return this.edges;
	}
	
	public ArrayList<Node> getNodes(){
		return this.nodes;
	}
	
	public ArrayList<Triangle> getTriangles(){
		return this.triangles;
	}
}
	
	
	
		
		
	
	
	
	
	
	



