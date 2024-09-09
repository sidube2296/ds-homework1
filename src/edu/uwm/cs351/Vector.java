package edu.uwm.cs351;

/**
 * A linear translation within two-dimensional space.
 * This class is immutable.
 */
public class Vector {

	private final double deltax, deltay;
	
	/**
	 * Instantiates a new zero vector (no change).
	 */
	public Vector(){
		
		deltax = 0.0;
		deltay = 0.0;
	}
	
	/**
	 * Instantiates a new vector with specified delta values.
	 *
	 * @param dx the initial deltax value
	 * @param dy the initial deltay value
	 */
	public Vector(double dx, double dy){
		
		this.deltax = dx;
		this.deltay = dy;
	}
	
	/**
	 * Instantiates a new unit vector with specified angle θ(theta) in the format (cos θ, sin θ) by using Math function
	 *
	 * @param theta the angle to construct, in radians
	 */
	public Vector(double theta){
		
		this.deltax = Math.cos(theta);
		this.deltay = Math.sin(theta);
	}
	
	/**
	 * Instantiates a new vector between two points.
	 * If applied to the first point, the result is the second point.
	 *
	 * @param p the first point
	 * @param q the second point
	 */
	public Vector(Point p, Point q){
		
		this.deltax = q.x() - p.x();
		this.deltay = q.y() - p.y();
		
	}
	
	/**
	 * Getter for deltax field.
	 *
	 * @return the current deltax value
	 */
	public double dx(){return this.deltax;}
	
	/**
	 * Getter for deltay field.
	 *
	 * @return the current deltay value
	 */
	public double dy(){return this.deltay;}
	
	/**
	 * Translates the parameter point by this vector.
	 * Calculated new points by adding x and y co-ordinate of the point to the deltax and deltay co-ordinates respectively.
	 * 
	 * @param p the point to translate
	 * @return the  translated point
	 */
	
	public Point move(Point p){
		
		double newpointx =  p.x()+this.deltax;
		double newpointy = p.y()+this.deltay;
		return new Point(newpointx, newpointy);
		
	}
	
	/**
	 * Adds the parameter vector with this vector.
	 * Calculated new vectors by adding deltax and deltay co-ordinate of the vector to the deltax and deltay co-ordinates of current vector respectively.
	 * 
	 * @param v the vector to add
	 * @return the vector sum
	 */
	
	public Vector add(Vector v){
		
		double newvectorx = v.deltax + this.deltax;
		double newvectory = v.deltay + this.deltay;
		return new Vector(newvectorx, newvectory);
		
	}
	
	/**
	 * Takes the dot product of this vector and the parameter vector.
	 * Calculated dot vectors by multiplying deltax and deltay co-ordinate of the vector to the deltax and deltay co-ordinates of current vector respectively.
	 *
	 * @param v the other vector
	 * @return the dot product
	 */
	public double dot(Vector v){
		
		double ans = this.deltax * v.deltax + this.deltay * v.deltay;
		return ans;
	}
	
	/**
	 * Scales this vector by the parameter.
	 * Calculated new vectors by multiplying the constant value to the deltax and deltay co-ordinates of current vector respectively.
	 *
	 * @param s the constant to scale by
	 * @return the scaled vector
	 */
	public Vector scale(double s){
		
		double scalex = s*this.deltax;
		double scaley = s*this.deltay;
		return new Vector(scalex,scaley);
	}
	
	/**
	 * Finds the magnitude of this vector.
	 *
	 * @return how long this vector is (never negative).
	 */
	public double magnitude(){
		
		double square = deltax*deltax + deltay*deltay;
		return Math.sqrt(square);
	}
	
	/**
	 * Normalizes this vector.
	 *
	 * @return a vector with the same angle but magnitude of one.
	 */
	public Vector normalize(){
		double mag = magnitude();
		if (mag == 0.0) {return new Vector(0,0);}
		double nor_x = deltax/mag;
		double nor_y = deltay/mag;
		return new Vector( nor_x, nor_y);
	}
	
	/**
	 * Rotates this vector clockwise by the parameter angle (in radians).
	 * 
	 * @param theta the angle to rotate (in radians)
	 * @return the rotated vector
	 */
	public Vector rotate(double theta){
		
		double newangle = theta + angle();
		double xNew = Math.cos(newangle);
		double yNew = Math.sin(newangle);
		double org_mag=magnitude();
		return new Vector(xNew,yNew).scale(org_mag);
		
	}
	
	/**
   	 * Gets the string representation of the point in a format <deltax,deltay>
   	 * 
   	 * @return the deltax and deltay co-ordinate of the points
   	 */
	
	@Override
	public String toString(){return "<" + deltax + ","+ deltay + ">";}

	/*
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	 @Override 
	 
	 public boolean equals(Object o) {
	        if (o == null) {
	            return false;
	        } 
	        
	        if (o instanceof Vector) {
	            Vector v = (Vector) o;
	            return (this == o) || (this.deltax == v.deltax && this.deltay == v.deltay);
	        }

	        return false;
	    }
	
	 /**
	 * Gets the hashcode of the point with the formula : 11*dx +19*dy
	 * 
	 * @return the hashcode of the point
	 */
	 
	@Override
	public int hashCode(){return (int) (11*deltax + 19*deltay);}

	/**
	 * Compute the angle of this vector, in radians,
	 * clockwise from the x-axis.
	 * 
	 * @return the angle in range [0,2Pi)
	 */
	
	public double angle() { 
		double magn = magnitude();
		if (magn == 0.0) return 0;
		double alpha = Math.acos(dx()/magn);
		if(dy() < 0) alpha = 2*Math.PI-alpha;
		return alpha;}// in range [0-2PI]
}
