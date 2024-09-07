	package edu.uwm.cs351;

/**
 * A point in two-dimensional Euclidean space.
 * This class is immutable.
 */
public class Point {
	private final double x, y;
	
	public Point(double x,double y){
		
		this.x = x;
		this.y = y;
	}
	
	public double x() {
		
		return x;
	}
	
	public double y() {
		
		return y;
	}

	public int intX() {
		
		return (int) Math.round(x);
		
	}
	
    public int intY() {
		
		return (int) Math.round(y);
		
	}
    
    public double distance(Point other) {
    	double dx,dy;
    	dx = this.x - other.x();
    	dy = this.y - other.y();
    	return Math.sqrt(dx*dx + dy*dy);
    	
    }
	// TODO implement this class
	
    @Override 
    public String toString() {
    	return "("+ x + ","+ y + ")";
    	
    }
    
    @Override 
    public boolean equals(Object obj) {
    	if(obj instanceof Point)
    	{
    		Point p = (Point) obj;
    		return(p.x == x) && (p.y ==y);
    	}
    	else
    		return false;
    	
    }
    
    @Override 
    public int hashCode() {
    	return (int) (7*x + 23 * y);
    	
    }
    
    
}
