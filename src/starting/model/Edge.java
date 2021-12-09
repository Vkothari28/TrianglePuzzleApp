package starting.model;

public class Edge {
	int x1,x2,y1,y2; // these values will be assigned based on the string left right or down based on of the node's height width and location
	protected Node node1;
	protected Node node2;
	protected int Color; // has to be 1 2 or 3, look for an easier way
	public boolean isSelected;
	String where; // where the edge is top right, left or bottom
	String EdgeName;
	
	public Edge(String EdgeName,Node nodeEin, Node nodeZwei, int Color, String where) {
		this.EdgeName=EdgeName;
		this.node1=nodeEin;
		this.node2=nodeZwei;
		this.Color=Color;
		this.where=where; 
		this.isSelected=false;
		// will make a try catch later to prevent a player from entering anything else except right, left or bottom
	
		if(where.equals("right")) {
			this.x1 =  nodeEin.getLocation().getrow()+nodeEin.width;//startNode.GetRow()+startNode.width;
			this.y1 = nodeEin.getLocation().getcol()+nodeEin.height;
			this.x2 = nodeZwei.getLocation().getrow()+nodeZwei.width/2;
			this.y2 = nodeZwei.getLocation().getcol();
		}
		
		
			else if(where.equals("left")) {
	 this.x1 = nodeEin.getLocation().getrow();
		this.y1 =  nodeEin.getLocation().getcol() +nodeEin.height;//startNode.GetCol()+startNode.height;
		this.x2 = nodeZwei.getLocation().getrow()+nodeZwei.width/2;
		this.y2 =nodeZwei.getLocation().getcol();
 }
		
		
			else if( where.equals("bottom")){
				this.x1 =  nodeEin.getLocation().getrow()+nodeEin.width;
				this.y1 = nodeEin.getLocation().getcol()+nodeEin.height/2;
				this.x2 = nodeZwei.getLocation().getrow();
				this.y2=nodeZwei.getLocation().getcol() +nodeZwei.height/2;
				
//				this.x1 = startNode.GetRow()+startNode.width;
//				this.y1 = startNode.GetCol()+startNode.height/2;
//				this.x2 = endNode.GetRow();
//				this.y2 = endNode.GetCol()+endNode.height/2;
				
			}
		
		
	
	
	}
	
	public String getName() {
		return this.EdgeName;
	}
	
	/*
	 * getter function returns the 1st node of the edge
	 */
	public boolean getSelected() {
		return this.isSelected;
	}
	public void setSelected(boolean b) {
		this.isSelected=b;
	}
	
	
	public Node getNode1() {
		return this.node1;
	}
	
	/*
	 * getter function returns the 2nd node of the edge
	 */
	public Node getNode2() {
		return this.node2;
	}
	
	/*
	 * Setter function to set the color 
	 * @param Color: the color to be assigned to the edge
	 */
	
	// can remove this function later when swap controller is designed
	public void setColor(int Color) {
		if(Color<=3 && Color!=0) {
			this.Color=Color;
		}
	}
		/*
		 * Function to return the color of the edge 
		 * returns an int 
		 */
		public int getColor() {
			return this.Color;
		}
		
		public int getX1() {
			return this.x1;
		}
		
		public int getX2() {
			return this.x2;
		}
		
		public int getY1() {
			return this.y1;
		}
		
		public int getY2() {
			return this.y2;
		}
		
		public boolean contains(Node node) {
			if(this.node1.getNum()==(node.getNum()) ||this.node2.getNum()==node.getNum()) {
				return true; 
			}
			return false;
			
		}
		
	
		
	}
	


