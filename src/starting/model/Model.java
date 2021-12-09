package starting.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import starting.model.Edge;
import starting.model.Triangle;

public class Model {
	public TrianglePuzzle puzzle;
	
	int moves;
	int score=0;
	int TriangleScore;
	String swapType = "";
	boolean canSwap;
	ArrayList<Node> SelectedNodes= new ArrayList<Node>();
	HashMap<String, Edge> swappingEdges = new HashMap<String, Edge>();
	public boolean hasWon=false;
	
	//ArrayList<Triangle> triCopy= (ArrayList<Triangle>) puzzle.getTriangles();

	//String swapResult;
	
	public Model() {
		puzzle = new TrianglePuzzle();
		hasWon=false;
	}
	
	
	
	public int getScore() {
		return this.score;
	}
	public int getmoves() {
		return this.moves;
	}
	
	public void setMoves(int m) {
		this.moves=m;
	}
	
	public void setScore(int s) {
		this.score=s;
	}
	
	public TrianglePuzzle getPuzzle() { return puzzle; }
	
	
	public void setTriangleCreationScore(int s) {
		this.TriangleScore=s;
		
	}
	
	public boolean getSwap() {
		return this.canSwap;
	}
	
	
	
	public ArrayList<Node> getSelectedNodes(){
		return this.SelectedNodes;
	}
	
	public void setSelectedNodes(Node sn) {
		SelectedNodes.add(sn);
		setcanSwap();
	}
	
	public HashMap<String, Edge> getSwappingEdges(){
		return this.swappingEdges;
	}
	
	public void SelectNode(Node n) {
		SelectedNodes.add(n);
	}
		
	
	
	public void UnselectNode(Node n) {
		SelectedNodes.remove(n);
		setcanSwap();
	}
	
	
	public int calculateScore(ArrayList<Triangle> triangles) {
		int sum=0;
		for (Triangle triangle : triangles) {

			if (triangle.Left.getColor()==(triangle.Top.getColor())
					&& triangle.Top.getColor()==(triangle.Bottom.getColor())
					&& triangle.Left.getColor()==(triangle.Bottom.getColor())
					) {
				sum += 10;
			}
		}
		return sum;
	}

	public void setcanSwap() {
		if (SelectedNodes.size() == 3) {

			String edge1 = "" + SelectedNodes.get(0).getNum() + SelectedNodes.get(1).getNum();
			String edge2 = "" + SelectedNodes.get(1).getNum() + SelectedNodes.get(2).getNum();
			String edge3 = "" + SelectedNodes.get(0).getNum() + SelectedNodes.get(2).getNum();

			String FlippedEdge1 = "" + SelectedNodes.get(1).getNum() + SelectedNodes.get(0).getNum();
			String FlippedEdge2 = "" + SelectedNodes.get(2).getNum() + SelectedNodes.get(1).getNum();
			String FlippedEdge3 = "" + SelectedNodes.get(2).getNum() + SelectedNodes.get(0).getNum();

			HashMap<String, Edge> edges =puzzle.hashEdges;
			int edgeTrack = 0;

			for (Map.Entry<String, Edge> entry : edges.entrySet()) {
				if (entry.getKey().equals(edge1) || entry.getKey().equals(FlippedEdge1) || entry.getKey().equals(edge2)
						|| entry.getKey().equals(FlippedEdge2) || entry.getKey().equals(edge3)
						|| entry.getKey().equals(FlippedEdge3)) {
					edgeTrack++;
					swappingEdges.put(entry.getKey(), entry.getValue());
				}
			}
				
			if (edgeTrack < 2) {
				swapType = "";
				canSwap = false;
				swappingEdges.clear();

			}
			
			 if (edgeTrack == 2) {
				swapType = "normal";
				canSwap = true;
			} else {
				swapType = "triangle";
				canSwap = true;
			}
		} else {
			swapType = "";
			swappingEdges.clear();
			canSwap = false;
		}
	}

	
	public void SwapEdges() {

		int scoreChangebefore = 0;
		int scoreChangeafter = 0;

		ArrayList<Triangle> triangles = puzzle.triangles;
		System.out.println("hash"+puzzle.hashEdges.toString());
		System.out.println("normal:"+puzzle.edges);
		HashMap<String, Edge> edges = puzzle.hashEdges;
		ArrayList<String> swapEdgeName = new ArrayList<String>();

		scoreChangebefore = calculateScore(triangles);
		System.out.println("swapping"+swappingEdges.entrySet());
		for (Map.Entry<String, Edge> swap : swappingEdges.entrySet()) {
			swapEdgeName.add(swap.getKey());
		}

		if (swapType.equals("normal")) {

			int colorTempString =0;
			Edge NormalEdge1 = edges.get(swapEdgeName.get(0));
			Edge NormalEdge2 = edges.get(swapEdgeName.get(1));
			colorTempString = NormalEdge1.getColor();
			NormalEdge1.setColor(NormalEdge2.getColor());
			NormalEdge2.setColor(colorTempString);

			moves++;
		} else if (swapType.equals("triangle")) {
			int colorTempString1 =0;
			int colorTempString2 = 0;

			EdgesSort(swapEdgeName.get(0), swapEdgeName.get(1));
			EdgesSort(swapEdgeName.get(1), swapEdgeName.get(2));
			EdgesSort(swapEdgeName.get(0), swapEdgeName.get(1));
			Edge TriEdge1 = edges.get(swapEdgeName.get(0));
			Edge TriEdge2 = edges.get(swapEdgeName.get(1));
			Edge TriEdge3 = edges.get(swapEdgeName.get(2));

			colorTempString1 = TriEdge1.getColor();
			colorTempString2 = TriEdge2.getColor();
			TriEdge1.setColor(TriEdge3.getColor());
			TriEdge2.setColor(colorTempString1);
			TriEdge3.setColor(colorTempString2);

			moves++;
		}

		scoreChangeafter = calculateScore(triangles);
		score += scoreChangeafter - scoreChangebefore - 1;

		SelectedNodes.clear();
		swappingEdges.clear();

		isWinnerCondition();

	}

	public void EdgesSort(String edgeName1, String edgeName2) {
		int edge1 = (int) edgeName1.charAt(0) + (int) edgeName1.charAt(1);
		int edge2 = (int) edgeName2.charAt(0) + (int) edgeName2.charAt(1);
		if (edge1 > edge2) {
			String tempString = "";
			tempString = edgeName1;
			edgeName1 = edgeName2;
			edgeName2 = tempString;
		}

	}

	/*public void Reset() {
		SelectedNodes.clear();
		swappingEdges.clear();
		HashMap<String, Edge> edges = puzzle.hashEdges;
		edges.clear();
		ArrayList<Triangle> triangles = puzzle.triangles;
		triangles.clear();

		for (Map.Entry<String, Edge> entry : hashCopy.entrySet()) {
			edges.put(entry.getKey(), new Edge(entry.getKey(),entry.getValue().node1, entry.getValue().node2,
					entry.getValue().getColor(), entry.getValue().where));
		}

		for (int i = 0; i < edgeCopy.size(); i = i + 3) {
			String edge1 = edgeCopy.get(i).EdgeName;
			String edge2 = edgeCopy.get(i + 1).EdgeName;
			String edge3 = edgeCopy.get(i + 2).EdgeName;
			puzzle.triangles.add(new Triangle(edges.get(edge1), edges.get(edge2), edges.get(edge3)));

		}

		canSwap = false;
		swapType = "";
		score = 0;
		moves = 0;
	}*/
	
	public boolean isWinnerCondition() {

		int winnerTriInx = 0;

		for (Triangle triangle : puzzle.triangles) {
			if(triangle.givePoints()){
				winnerTriInx++;
			} 
			else {
				return false;
			}
		}
		return true;

	}

}





