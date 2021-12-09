package starting.model;

import java.util.ArrayList;

public class Triangle {
	
	Edge Top;
	Edge Left;
	Edge Bottom;
	public boolean isSelected;
	public boolean bonus;
	
	
	

	public Triangle(Edge Top, Edge Left, Edge Bottom) {
		this.Top=Top;
		this.Left= Left;
		this.Bottom=Bottom;
		this.isSelected=false;
		
		
		
				
	}
	
	public boolean getIsSelected() {
		return this.isSelected;
	}
	
	public Edge getLeft() {
		return this.Left;
	}
	
	public Edge getTop() {
		return this.Top;
	}
	
	public Edge getBottom() {
		return this.Bottom;
	}
	public void setSelected(boolean b) {
		this.isSelected=b;
	}
	
	// Function to give points if a triangle is a single color aka if all the edges are of the same color
	public boolean givePoints() {
		
	if((this.Top.getColor()==this.Bottom.getColor()) &&(this.Top.getColor()==this.Left.getColor())&&(this.Left.getColor()==this.Bottom.getColor()) ) {
		return true;
	}

	return false;
	
	
}
	
	public boolean bonusAdded() {
		return this.bonus;
	}
	
	public void setBonus(boolean b) {
		this.bonus=b;
	}
	
}
