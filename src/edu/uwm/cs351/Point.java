package edu.uwm.cs351;

/**
 * @author siddhi2218
 * A point in two-dimensional Euclidean space.
 * This class is immutable.
 */

public class Point implements Cloneable{
	private final double x;
	final double y;
	
	/**
	 * Generates a new point with specified cordinates.
	 *
	 * @param x the x co-ordinate of the point
	 * @param y the y co-ordinate of the point
	 */
	
	public Point(double x,double y){
		this.x = x;       
		this.y = y;
	}
	
	/**
	 * Gets the x co-ordinate of the point.
	 *
	 * @return the x co-ordinate
	 */
	
	public double x() {return x;}
	
	/**
	 * Gets the y co-ordinate of the point.
	 *
	 * @return the y co-ordinate
	 */
	
	public double y() {return y;}
	
	/**
	 * Gets the rounded x co-ordinate of the point.
	 *
	 * @return the rounded x co-ordinate
	 */

	public int intX() {return (int) Math.round(x);}
	
	/**
	 * Gets the rounded y co-ordinate of the point.
	 *
	 * @return the rounded y co-ordinate
	 */
	
    public int intY() {return (int) Math.round(y);}
    
    /**
	 * Calculates the Euclidean distance from the current point to other point.
	 * 
	 * @param other the other point
	 * @return the distance between the two points
	 */
    
    public double distance(Point other) {
    	double distx,disty;
    	distx = this.x - other.x();
    	disty = this.y - other.y();
    	return Math.sqrt(distx*distx + disty*disty);
    	
    }
    /**
   	 * Compares the location of the point to another object for equality 
   	 * 
   	 * @param o an object with which this point is compared
   	 * @return Return true if the other point’s coordinates are exactly the same
   	 */
    
    @Override 
    public boolean equals(Object o) {
    	if(o instanceof Point)
    	{
    		Point p = (Point) o;
    		return(p.x==x) && (p.y==y);
    	}
    	else
    		return false;
    }
    
    /**
   	 * Gets the hashcode of the point with the formula : 7*x +23*y
   	 * 
   	 * @return the hashcode of the point
   	 */
    
    @Override 
    public int hashCode() {return (int) (7*x + 23*y);}
    
    /**
   	 * Gets the string representation of the point in a format (x,y)
   	 * 
   	 * @return the x and y co-ordinate of the points
   	 */
    
    @Override 
    public String toString() {return "("+ x + ","+ y + ")";}
     
}
