/**
 * This class reads a shape file.  For the format of this shape file, see the assignment description.
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 *
 * @author Liz Simpson
 *
 */

import javafx.scene.paint.Color;
import java.io.*;
import java.util.Scanner;

public class ReadShapeFile {

/**
 * @param in Scanner stream taken from a file, includes data to make a triangle object.
 * @return newTriangle is a Triangle object which is then added to a queue in the ReadDataFile method line 193.
 */
	public static Triangle createTriangle(Scanner in) {
		int x = in.nextInt();
		int y = in.nextInt();
		int vx = in.nextInt();
		int vy = in.nextInt();			
		boolean isFilled = in.nextBoolean();
		int width = in.nextInt();
		int height = in.nextInt();
		double r = in.nextInt();
		r=r/255.0;
		double g = in.nextInt();
		g=g/255.0;
		double b = in.nextInt();
		b=b/255.0;
		int insertionTime = in.nextInt();
		
		Color colour = new Color(r, g, b, 1.0);
		boolean pulses = in.nextBoolean();
		
		Triangle newTriangle = new Triangle(insertionTime, x, y, vx, vy, width, height, colour, isFilled, pulses);
		System.out.println(newTriangle.toString());
		
		return newTriangle;
	}
	
	/**
	 * @param in Scanner stream taken from a file, includes data to make a circle object.
	 * @return newCircle is a Circle object which is then added to a queue in the ReadDataFile method line 193.
	 */
	public static Circle createCircle(Scanner in) {
		int x = in.nextInt();
		int y = in.nextInt();
		int vx = in.nextInt();
		int vy = in.nextInt();
		boolean isFilled = in.nextBoolean();
		int diameter = in.nextInt();
		
		double r = in.nextInt();
		r=r/255.0;
		double g = in.nextInt();
		g=g/255.0;
		double b = in.nextInt();
		b=b/255.0;
		Color colour = new Color(r, g, b, 1.0);
		
		int insertionTime = in.nextInt();
		boolean pulses = in.nextBoolean();	
		
		Circle newCircle = new Circle(insertionTime, x,  y,  vx,  vy,  diameter,  colour,  isFilled, pulses);
		System.out.println(newCircle.toString());
		
		return newCircle;
	}
	
	/**
	 * @param in Scanner stream taken from a file, includes data to make a oval object.
	 * @return newOval is an Oval object which is then added to a queue in the ReadDataFile method line 193.
	 */
	public static Oval createOval(Scanner in) {
		int x = in.nextInt();
		int y = in.nextInt();
		int vx = in.nextInt();
		int vy = in.nextInt();
		boolean isFilled = in.nextBoolean();
		int width = in.nextInt();
		int height = in.nextInt();
		
		double r = in.nextInt();
		r=r/255.0;
		double g = in.nextInt();
		g=g/255.0;
		double b = in.nextInt();
		b=b/255.0;
		Color colour = new Color(r, g, b, 1.0);
		
		int insertionTime = in.nextInt();
		boolean pulses = in.nextBoolean();	
		
		Oval newOval = new Oval(insertionTime, x, y, vx, vy, width, height, colour, isFilled, pulses );
		System.out.println(newOval.toString());
		
		return newOval;
}

	/**
	 * @param in Scanner stream taken from a file, includes data to make a square object.
	 * @return newSquare is a Square object which is then added to a queue in the ReadDataFile method line 193.
	 */
	public static Square createSquare(Scanner in) {
		int x = in.nextInt();
		int y = in.nextInt();
		int vx = in.nextInt();
		int vy = in.nextInt();
		boolean isFilled = in.nextBoolean();
		int side = in.nextInt();
		
		double r = in.nextInt();
		r=r/255.0;
		double g = in.nextInt();
		g=g/255.0;
		double b = in.nextInt();
		b=b/255.0;
		Color colour = new Color(r, g, b, 1.0);

		int insertionTime = in.nextInt();
		boolean pulses = in.nextBoolean();	
		
		Square newSquare = new Square(insertionTime, x,  y,  vx,  vy,  side,  colour,  isFilled, pulses );
		System.out.println(newSquare.toString());
		
		return newSquare;
	}

	/**
	 * @param in Scanner stream taken from a file, includes data to make a rect object - rectangle.
	 * @return newRect is a Rect object which is then added to a queue in the ReadDataFile method - line 193.
	 */	
	public static Rect createRect(Scanner in) {
		int x = in.nextInt();
		int y = in.nextInt();
		int vx = in.nextInt();
		int vy = in.nextInt();
		boolean isFilled = in.nextBoolean();
		int width = in.nextInt();
		int height = in.nextInt();
		
		double r = in.nextInt();
		r=r/255.0;
		double g = in.nextInt();
		g=g/255.0;
		double b = in.nextInt();
		b=b/255.0;
		Color colour = new Color(r, g, b, 1.0);
		
		int insertionTime = in.nextInt();
		boolean pulses = in.nextBoolean();	
		
		Rect newRect = new Rect(insertionTime, x, y, vx, vy, width, height, colour, isFilled, pulses );
		System.out.println(newRect.toString());
		
		return newRect;
}
	/**
	 * Reads the data file used by the program and returns the constructed queue
	 * filled with the shape objects created by the respective constructors.
	 * @param in the scanner of the file
	 * @return the queue represented by the data file
	 */
	private static Queue readDataFile(Scanner in) {
		Queue shapeQueue = new Queue();
		String input;
		while(in.hasNextLine()) {
			input = in.next();
			if (input.equals("circle")) {
				shapeQueue.enqueue(createCircle(in));
			}else if (input.equals("oval")) {
				shapeQueue.enqueue(createOval(in));
			}else if (input.equals("rect")) {
				shapeQueue.enqueue(createRect(in));
			}else if (input.equals("square")) {
				shapeQueue.enqueue(createSquare(in));
			}else if (input.equals("triangle")) {
				shapeQueue.enqueue(createTriangle(in));
			}
		}
		return shapeQueue;
	}

	/**
	 * Method to read the file and return a queue of shapes from this file. The
	 * program should handle the file not found exception here and shut down the
	 * program gracefully.
	 * 
	 * @param filename the name of the file
	 * @return the queue of shapes from the file
	 */
	public static Queue readFile(String filename) {
	  File file = new File(filename);
		
		Scanner in;
		
		try {
			in = new Scanner(file);
			return ReadShapeFile.readDataFile(in);
		} catch (FileNotFoundException e) {
			System.out.println("Sorry, that file is not found");
			System.exit(0);
			return new Queue();
		}	   
	}
}