
import java.util.ArrayList;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * 
 * @author Dr D. Archambault, Modified for JAVAFX by Dr J. L. Jones, Modified by Elizabeth Simpson, 951428
 * 
 */
public class BouncingShapesWindow {

	private static final int ANIMATION_DELAY = 10;
	private static final String FRAME_TITLE = "Shape Booooiiinggg Frame";

	private GraphicsContext gc;
	private Queue shapesToAdd;
	private ArrayList<ClosedShape> activeShapes;
	private int currentTime = 0;
	private boolean flag = true;
	private int pulseInterval = 0;

	private String filename;

	public BouncingShapesWindow(GraphicsContext gc, String filename) {
		this.gc = gc;

		activeShapes = new ArrayList<ClosedShape>();
		this.initShapes(filename);
		this.insertShapes();
		drawShapes();
		actionPerformed();
	}

	private void drawShapes() {
		for (ClosedShape s : activeShapes) {
			s.draw(gc);
		}
	}

	private void initShapes(String filename) {
		shapesToAdd = ReadShapeFile.readFile(filename);
	}

	private void insertShapes() {
		// no more shapes to add, we are done
		if (shapesToAdd.isEmpty()) {
			return;
		}

		// add shapes if needed
		ClosedShape current = (ClosedShape) shapesToAdd.peek();
		while (!shapesToAdd.isEmpty() && (current.getInsertionTime() <= currentTime * ANIMATION_DELAY)) {
			activeShapes.add(current);
			shapesToAdd.dequeue();
			if (!shapesToAdd.isEmpty()) {
				current = (ClosedShape) shapesToAdd.peek();
			}
		}
	}

	public void actionPerformed() {
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(5), ae -> onTime()));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}

	private void onTime() {
		currentTime++;
		double h = gc.getCanvas().getHeight();
		double w = gc.getCanvas().getWidth();
		gc.clearRect(0, 0, w, h);
		moveShapes();
		pulseShapes();
		insertShapes();
		drawShapes();
	}
	
	public void pulseShapes() {
		//pulseInterval = 0; resets the counter so that the shape can start to increase again
		if (pulseInterval ==100) {
			pulseInterval = 0;
		}
		for (ClosedShape s : activeShapes) {
			if (s.pulses) {
				int currentWidth = s.getWidth();
				int currentHeight = s.getHeight();
				
				int changeSize = 7;//the height, width increase or decrease by this amount
				
				//this if statement makes sure that no shape goes into a size of negative value.
				//without this, smaller triangles will be draw pointing the wrong way
				if (currentWidth == 0 || currentHeight == 0) {
					s.setHeight(currentHeight += changeSize);
					s.setWidth(currentWidth += changeSize);
				} else {
					//this switch statement changes the height and the width of the shape
					//depending on the pulse interval which is a count of how many times 
					//the for loop has run through every object in the queue, 
					//incremented after the for loop has been completed.
					switch (pulseInterval) {
					case (0):
						s.setHeight(currentHeight += changeSize);
						s.setWidth(currentWidth += changeSize);
						break;
					case (10):
						s.setHeight(currentHeight += changeSize);
						s.setWidth(currentWidth += changeSize);
						break;
					case (20):
						s.setHeight(currentHeight += changeSize);
						s.setWidth(currentWidth += changeSize);
						break;
					case (30):
						s.setHeight(currentHeight += changeSize);
						s.setWidth(currentWidth += changeSize);
						break;
					case (40):
						s.setHeight(currentHeight += changeSize);
						s.setWidth(currentWidth += changeSize);
						break;
					case (50):
						s.setHeight(currentHeight -= changeSize);
						s.setWidth(currentWidth -=changeSize);
						break;
					case (60):
						s.setHeight(currentHeight -= changeSize);
						s.setWidth(currentWidth -= changeSize);
						break;
					case (70):
						s.setHeight(currentHeight -= changeSize);
						s.setWidth(currentWidth -= changeSize);
						break;
					case (80):
						s.setHeight(currentHeight -= changeSize);
						s.setWidth(currentWidth -= changeSize);
						break;
					case (90):
						s.setHeight(currentHeight -= changeSize);
						s.setWidth(currentWidth -= changeSize);
						break;
					case (100):
						s.setHeight(currentHeight -= changeSize);
						s.setWidth(currentWidth -= changeSize);
					break;
					default:
						if (pulseInterval > 100) {
							pulseInterval = -1;
						}
					}
				}
			}
		}
		if (!activeShapes.isEmpty()){
			pulseInterval++;
		}
	}

	public void moveShapes() {
		double dimsY = gc.getCanvas().getHeight();
		double dimsX = gc.getCanvas().getWidth();
		for (ClosedShape s : activeShapes) {
			s.move();

			// Move us back in and bounce if we went outside the drawing area.
			if (s.outOfBoundsX(dimsX)) {
				s.putInBoundsX(dimsX);
				s.bounceX();
			}

			if (s.outOfBoundsY(dimsY)) {
				s.putInBoundsY(dimsY);
				s.bounceY();
			}
		}
	}
}
