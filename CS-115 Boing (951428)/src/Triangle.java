
/**
 * Triangle.java
 * @author Elizabeth Simpson, 951428
 * @version 2.0.0 
 * CSC-115 (Daniel Archambault and Liam O’Reilly)
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * Triangle is a shape that can be drawn to the screen, either filled with colour
 * or opaque. Its position is determined by the upper left corner of the
 * polygon.
 * The shape can pulse (grow and shrink in size) or remain a fixed size.
 */

	/**
	 * Creates a triangle
	 * 
	 * @param x The top left display component's x position.
	 * @param y The top left display component's y position.
	 * @param vxThe display component's x velocity.
	 * @param vy The display component's y velocity.
	 * @param width the horizontal length of the triangle.
	 * @param height the vertical side length of the triangle
	 * @param colour The line colour or fill colour.
	 * @param isFilled True if the circle is filled with colour, false if opaque.
	 * @param pulses True if the triangle is pulsing, false if the triangle does not pulse.
	 */

public class Triangle extends ClosedShape {
	
	private int height;
	private int width;
	
	protected Triangle(int insertionTime, int x, int y, int vx, int vy, int width, int height, Color colour, boolean isFilled, boolean pulses ) {
		super(insertionTime, x, y, vx, vy, colour, isFilled, pulses);
		this.height = height;
		this.width = width;
		makeTriangle();
	}
	
	private int nPoints = 3; // triangle has 3 points
	protected double xPoints[] = new double[4]; // holds all the x coordinates
	protected double yPoints[]=new double[4]; //holds all the y coordinates
	
	 /**
	  * @override from closed shape
	  * Takes in a direction and a velocity and moves the shape
	  * in that direction on unit and makes the new triangle.
	  */
	 public void move () {
		 xPos += xVec;
		 yPos += yVec;
		 makeTriangle();
	}

	 public void makeTriangle() {
		//bottom left triangle point
		this.xPoints[0] = xPos;
		this.yPoints[0] = yPos;
		
		//bottom right triangle point
		this.xPoints[1] = xPos + width;
		this.yPoints[1] = yPos;
		
		//top tip of the triangle
		this.xPoints[2] = xPos;
		this.yPoints[2] = yPos + height;
		
		//connects the top of the triangle to the starting coordinate
		this.xPoints[3] = xPos;
		this.yPoints[3] = yPos;
 }
	 
	/**
	 * Method to convert the triangle to a string.
	 */
	public String toString() {
		String result = "This is a triangle\n";
		result += super.toString();
		result += "It has 3 points " + "\n";
		result += "It has sides of length " + this.height + "\n";
		return result;
	}

	/**
	 * @return The width of the triangle
	 */
	public int getWidth() {
		return width;
	}
	/**
	 * @return The height of the triangle
	 */
	public int getHeight() {                 
		return height;
	}
	
    /**
     * @param Resets the height length.
     */
    public void setHeight (int height) {
    	this.height = height;
    }
    
    /**
     * @param resets the width length.
     */
    public void setWidth(int width) {
    	this.width = width;
    }

	/**
	 * Draw the triangle.
	 * 
	 * @param g The graphics object of the drawable component.
	 */
	public void draw(GraphicsContext g) {
		g.setFill(colour);
		g.setStroke(colour);
		if (isFilled) {
			g.fillPolygon(xPoints, yPoints, nPoints);
		} else {
			g.strokePolyline(xPoints, yPoints, nPoints);
		}
	}
}

