/*
 * TCSS 305
 * Assignment 5 ¨C PowerPaint
 */

package tools;

import java.awt.Shape;
import java.awt.geom.RectangularShape;

/**
 * This is a class for drawing rectangle or ellipse.
 * 
 * @author Qing Bai
 * @version 21 February 2015
 */
public abstract class AbstractRectEllipseTool implements Tool {
    
    /**
     * This is a rectangular shape that can be either rectangle or ellipse.
     */
    private final RectangularShape myShape;
    
    /**
     * This is start x coordinate.
     */
    private int myStartX;
    
    /**
     * This is start y coordinate.
     */
    private int myStartY;
    
    /**
     * This is a constructor of this class.
     * 
     * @param theShape is a rectangular shape used to initialize this instance 
     */
    public AbstractRectEllipseTool(final RectangularShape theShape) {
        myShape = theShape;
        myStartX = 0;
        myStartY = 0;
    }
    
    /**
     * This initializes this rectangular shape with the given coordinates.
     * 
     * @param theX is x coordinate of start point of this rectangular shape
     * @param theY is y coordinate of start point of this rectangular shape
     */
    @Override
    public void start(final int theX, final int theY) {
        myStartX = theX;
        myStartY = theY;
        myShape.setFrame(myStartX, myStartY, 0, 0);
    }

    /**
     * This passes coordinates of current end point to this rectangular shape.
     * 
     * @param theX is x coordinate of current end point of rectangular shape
     * @param theY is y coordinate of current end point of rectangular shape
     * @return a rectangular shape ending with current end point
     */
    @Override
    public Shape drawing(final int theX, final int theY) {
        myShape.setFrameFromDiagonal(myStartX, myStartY, theX, theY);
        return myShape;
    }
    
    /**
     * This finalizes this rectangular shape with the given coordinates.
     * 
     * @param theX is x coordinate of final end point of this rectangular shape
     * @param theY is y coordinate of final end point of this rectangular shape
     * @return the finished rectangular shape
     */
    public Shape end(final int theX, final int theY) {
        myShape.setFrameFromDiagonal(myStartX, myStartY, theX, theY);
        return (Shape) myShape.clone();
    }
}