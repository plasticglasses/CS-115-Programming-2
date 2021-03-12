

/**
 * Square.java
 * @version 1.0.0
 * Originally written by Liz Simpson
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * Square is a shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of
 * the Square's bounding rectangle.
 * The shape can pulse (grow and shrink in size) or remain a fixed size.
 */

public class Square extends ClosedShape {
	 //The side length of the square
		private int side;

	    /**
	     * Creates a square.
	     * @param x The display component's x position.
	     * @param y The display component's y position.
	     * @param vx The display component's x velocity.
	     * @param vy The display component's y velocity.
	     * @param side The width and height of the square.
	     * @param colour The line colour or fill colour.
	     * @param isFilled True if the square is filled with colour, false if opaque.
	     * @param pulses True if the square pulses, false if the square stays a fixed size.
	     */
	    public Square (int insertionTime, int x, int y, int vx, int vy, int side, Color colour, boolean isFilled, boolean pulses ) {
	    	super (insertionTime, x, y, vx, vy, colour, isFilled, pulses);
	    	this.side = side;
	    	
	    }
	    
	    
	    /**
	     * Method to convert a circle to a string.
	     */
	    public String toString () {
	    	String result = "This is a square\n";
	    	result += super.toString ();
	    	result += "Its side length is " + this.side + "\n";
	    	return result;
	    }
	    
	    /**
	     * @param Resets the height length.
	     */
	    public void setHeight (int height) {
	    	this.side = height;
	    }
	    
	    /**
	     * @param Resets the width length.
	     */
	    public void setWidth (int height) {
	    	this.side = height;
	    }
	    
	    /**
	     * @return The side length of the square.
	     */
	    public int getHeight() {
	    	return side;
	    }
	    
	    /**
	     * @param Resets the side length.
	     */
	    public int getWidth () {
	    	return side;
	    }
	    
	    
	    /**
	     * Draw the square on the screen.
	     * @param g The graphics object of the scene component.
	     */
	    public void draw (GraphicsContext g) {
	    	g.setFill( colour );
	    	g.setStroke( colour );
	    	if (isFilled) {
	    		g.fillRect( xPos, yPos, side, side );
	    	} 
	    	else {
	    		g.strokeRect( xPos, yPos, side, side );
		    }
	    }
}
