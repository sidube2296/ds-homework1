package edu.uwm.cs351;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

/**
 * A class of two-dimensional moving disks (filled-in circles).
 * Each ball has a color used when rendering it.
 * A ball can be "active" which means it moves in the direction of its movement
 * vector.  Inactive balls simply rotate every step of execution.
 */
public class Ball implements Cloneable {
	/** Default radius for Ball objects. */
	public static final int DEFAULT_RADIUS = 15;
	
	private Point location;
	private int radius;
	private Vector move;
	private Color color;
	private volatile boolean active;
	
	/**
	 * Instantiates a new ball with specified properties.
	 *
	 * @param loc the initial location
	 * @param vector the initial vector
	 * @param col the color
	 */
	public Ball(Point loc, Vector vector, Color col){
		location = loc;
		radius = DEFAULT_RADIUS;
		move = vector;
		color = col;
		active = false;}
	
	
	/**
	 * Gets the location.
	 *
	 * @return the current location
	 */
	public Point getLoc(){return location;}
	
	/**
	 * Gets the radius.
	 *
	 * @return the radius
	 */
	public int getRadius(){return radius;}
	
	/**
	 * Return the current movement of the ball.
	 *
	 * @return the current movement
	 */
	public Vector getMove(){return move;}
	
	/**
	 * Set the radius of this ball.
	 * @param r new radius, must be positive.
	 */
	public void setRadius(int r) {
		if (r <= 0) throw new IllegalArgumentException("radius must be positive, not " + r);
		radius = r;
	}
	
	/**
	 * Launches the ball by setting active to true.
	 */
	public void launch(){active=true;}
	
	
	/**
	 * If ball is active: moves location by the current movement.
	 * If ball is not active: rotates vector by Math.PI/24.
	 */
	public void step(){
		if (active == true){
			double new_loc_dx = getMove().dx();
			double new_loc_dy = getMove().dy();
			new Point(location.x()+ new_loc_dx , location.x()+ new_loc_dy);
			}
		else
			{
			Vector v = new Vector();
			v.rotate(Math.PI/24);
			}
	}
	
	
	/**
	 * Checks if ball is at or outside BOUNDS dimension and moving further out,
	 * and reflects movement if so.  If the ball isn't moving further out, the
	 * movement isn't reflected.
	 * @param bounds dimension of area to check (all four walls), must not be null
	 */
	public void bounceWalls(Dimension bounds){
		// TODO
	}
	
	/**
	 * Checks if colliding with the parameter ball.
	 *
	 * @param other the other ball
	 * @return true if colliding
	 */
	public boolean isColliding(Ball other){
		double dist = Math.sqrt((other.x()-this.x()));
		
	}
	
	/**
	 * Calculates new vectors for this and the parameter ball using normal and
	 * tangent vectors, then calls step() on both until no longer colliding.
	 * 
	 * @param other the other ball
	 */
	public void bounce(Ball other){
		Vector my_unit_normal = new Vector(location, other.getLoc()).normalize();
		Vector other_unit_normal = new Vector(other.getLoc(), location).normalize();
		Vector my_normal = my_unit_normal.scale(move.dot(my_unit_normal));
		Vector other_normal = other_unit_normal.scale(other.move.dot(other_unit_normal));
		Vector my_tangent = move.add(my_normal.scale(-1));
		Vector other_tangent = other.move.add(other_normal.scale(-1));
		
		move = my_tangent.add(other_normal);
		other.move = other_tangent.add(my_normal);

		while (isColliding(other)){
			step();
			other.step();}
	}
	
	/**
	 * Draws the ball, and if non-active also draws its vector.
	 *
	 * @param g the Graphics context on which to draw
	 */
	public void draw(Graphics g){
		g.setColor(color);
		g.fillOval(location.intX() - radius, location.intY() - radius, radius * 2, radius * 2);
		if (!active){
			Vector standard_vec = move.normalize().scale(radius * 2);
			g.setColor(Color.RED);
			g.drawLine(location.intX(), location.intY(), standard_vec.move(location).intX(), standard_vec.move(location).intY());
		}
	}
	
	/* Make a Ball with the same features as this ball.
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Ball clone() {
		//clone a Location object 
		Ball answer;
		
		try {
			answer = (Ball) super.clone();
		}
		catch (CloneNotSupportedException e)
		{
			throw new RuntimeException
			("This class does not implement Cloneable.");
			}
		return answer;
		
		// return null; // TODO: cast the result of super.clone() (see textbook).
	}
}
