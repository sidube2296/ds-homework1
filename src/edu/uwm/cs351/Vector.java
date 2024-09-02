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
		// TODO
	}
	
	/**
	 * Instantiates a new vector with specified delta values.
	 *
	 * @param dx the initial deltax value
	 * @param dy the initial deltay value
	 */
	public Vector(double dx, double dy){
		// TODO
	}
	
	/**
	 * Instantiates a new unit vector with specified angle.
	 *
	 * @param theta the angle to construct, in radians
	 */
	public Vector(double theta){
		// TODO
	}
	
	/**
	 * Instantiates a new vector between two points.
	 * If applied to the first point, the result is the second point.
	 *
	 * @param p the first point
	 * @param q the second point
	 */
	public Vector(Point p, Point q){
		// TODO
	}
	
	/**
	 * Getter for deltax field.
	 *
	 * @return the current deltax value
	 */
	public double dx(){
		// TODO
	}
	
	/**
	 * Getter for deltay field.
	 *
	 * @return the current deltay value
	 */
	public double dy(){
		// TODO
	}
	
	/**
	 * Translates the parameter point by this vector.
	 *
	 * @param p the point to translate
	 * @return the  translated point
	 */
	public Point move(Point p){
		// TODO
	}
	
	/**
	 * Adds the parameter vector with this vector.
	 *
	 * @param v the vector to add
	 * @return the vector sum
	 */
	public Vector add(Vector v){
		// TODO
	}
	
	/**
	 * Takes the dot product of this vector and the parameter vector.
	 *
	 * @param v the other vector
	 * @return the dot product
	 */
	public double dot(Vector v){
		// TODO
	}
	
	/**
	 * Scales this vector by the parameter.
	 *
	 * @param s the constant to scale by
	 * @return the scaled vector
	 */
	public Vector scale(double s){
		// TODO
	}
	
	/**
	 * Finds the magnitude of this vector.
	 *
	 * @return how long this vector is (never negative).
	 */
	public double magnitude(){
		// TODO
	}
	
	/**
	 * Normalizes this vector.
	 *
	 * @return a vector with the same angle but magnitude of one.
	 */
	public Vector normalize(){
		// TODO
	}
	
	/**
	 * Rotates this vector clockwise by the parameter angle (in radians).
	 * 
	 * @param theta the angle to rotate (in radians)
	 * @return the rotated vector
	 */
	public Vector rotate(double theta){
		// TODO
	}
	
	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString(){
		// TODO
	}

	/*
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o){
		// TODO
	}
	
	/*
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode(){
		// TODO
	}

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
