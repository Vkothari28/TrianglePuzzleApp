package starting.model;

public class Location {
	
	int col ;
	int row;
	
	public Location(int row,int col ) {
		this.col=col;
		this.row=row;
		
	}

	
	public int getrow() {
		return this.row;
		
	}
	
	public int getcol() {
		return this.col;
	}
}
