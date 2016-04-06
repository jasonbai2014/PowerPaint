/*
 * TCSS 305
 * Assignment 5 �C PowerPaint
 */

package tools;

import java.awt.Shape;
import java.awt.geom.Line2D;

/**
 * This is a class for line tool in this program.
 * 
 * @author Qing Bai
 * @version 21 February 2015
 */
public final class LineTool implements Tool {
    
    /**
     * This is a line.
     */
    private final Line2D myLine;
    
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
     */
    public LineTool() {
        myLine = new Line2D.Double();
        myStartX = 0;
        myStartY = 0;
    }

    /**
     * This initializes this line with the given coordinates.
     * 
     * @param theX is x coordinate of start point of this line
     * @param theY is y coordinate of start point of this line
     */
    @Override
    public void start(final int theX, final int theY) {
        myStartX = theX;
        myStartY = theY;
        myLine.setLine(myStartX, myStartY, myStartX, myStartY);
    }
    
    /**
     * This passes coordinates of current end point to this line.
     * 
     * @param theX is x coordinate of current end point of this line
     * @param theY is y coordinate of current end point of this line
     * @return a line ending with current end point
     */
    @Override
    public Shape drawing(final int theX, final int theY) {
        myLine.setLine(myStartX, myStartY, theX, theY);
        return myLine;
    }
    
    /**
     * This finalizes this line with the given coordinates.
     * 
     * @param theX is x coordinate of final end point of this line
     * @param theY is y coordinate of final end point of this line
     * @return the finished line
     */
    @Override
    public Shape end(final int theX, final int theY) {
        myLine.setLine(myStartX, myStartY, theX, theY);
        return (Shape) myLine.clone();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "Line";
    }
}
