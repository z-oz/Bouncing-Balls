import java.awt.Color;

import edu.princeton.cs.algs4.StdDraw;

public class Ball {
	private static double minX;
	private static double minY;
	private static double maxX;
	private static double maxY;

	private Point center;
	private double radius;
	// Every time the ball moves, its x position changes by vX;
	private double vX;
	// Every time the ball moves, its y position changes by vY;
	private double vY;
	private Color color;

	
	/**
	 * Sets the minimum and maximum x and y values of the screen on which the balls appear.
	 * The bottom left of the screen is at (<code>minX</code>, <code>minY</code>) while the
	 * top right is at (<code>maxX</code>, <code>maxY</code>).
	 * @param minX the leftmost x value
	 * @param minY the bottommost y value
	 * @param maxX the rightmost x value
	 * @param maxY the topmost y value
	 */
	public static void setScreen(double minX, double minY, double maxX, double maxY) {
		Ball.minX = minX;
		Ball.minY = minY;
		Ball.maxX = maxX;
		Ball.maxY = maxY;
	}
	
	/**
	 * Constructs a ball.
	 * @param centerX the x coordinate of the center of the ball
	 * @param centerY the y coordinate of the center of the ball
	 * @param r the radius of the ball
	 * @param vX the velocity of the ball along the x-axis
	 * @param vY the velocity of the ball along the y-axis
	 * @param col the color of the ball
	 */
	public Ball(double centerX, double centerY, double r, double vX, double vY, Color col) {
		center = new Point(centerX, centerY);
		radius = r;
		this.vX = vX;
		this.vY = vY;
		color = col;
	}
	
	/**
	 * Moves the ball (changes its position) by vX along the x-axis
	 * and by vY along the y-axis.  Additionally, if the ball has
	 * reached one of the edges of the screen it changes the velocity
	 * to reflect that the ball has bounced off the edge.
	 */
	public void move() {
		double xValue = center.getX();
		double yValue = center.getY();
		center.moveTo(vX, vY);
		if (xValue + radius + vX> maxX) {
			vX = -vX;	
		} else if (xValue - radius + vX < minX) {
			vX = -vX;
		}
		if (yValue + radius + vY > maxY) {
			vY = -vY;
		} else if (yValue - radius + vY < minY) {
			vY = -vY;
		}
	}
	
	/**
	 * Determines if <code>this</code> has collided with <code>b2</code>.
	 * @param b2 the other <code>Ball</code>
	 * @return <code>true</code> if <code>this</code> has collided with
	 * <code>b2</code>.
	 */
	public boolean collision(Ball b2) {
		double center_dist = this.center.distance(b2.center);
		if (center_dist <= b2.radius + this.radius) {
			return true;
		} else
			return false;
	}
	
	/**
	 * Draws the <code>Ball</code> on the screen.
	 */
	public void draw() {
		StdDraw.setPenColor(color);
		StdDraw.filledCircle(center.getX(), center.getY(), radius);
	}

	public static int length() {
		// Auto-generated method stub
		return 0;
	}
}
