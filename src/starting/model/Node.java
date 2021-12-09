package starting.model;

import java.awt.Point;

public class Node {
	
	int width;
	int height;
	int num;
	boolean isSelected=false;
	Location location;
	
	public Node( Location location,int width, int height, int num) {
	this.width=width;
	this.height=height;
	this.num=num;	
	this.location=location;
	this.isSelected=false;
		
	}
	
public int getWidth() {
	return this.width;
}
public int getHeight() {
	return this.height;
}
public int getNum() {
	return this.num;
}



public Location getLocation() {
	return this.location;
}



public boolean getSelected() {
	return this.isSelected;
}

public void SetSelected(boolean b) {
	this.isSelected=b;
}


public boolean crosses(Point point) {
	int pointX = point.x;
	int pointY = point.y;
	int row=location.row;
	int col=location.col;
	
	return (pointX>=row)&&(pointX<=row+width)&&(pointY>=col)&&(pointY<=col+height);
}
}


