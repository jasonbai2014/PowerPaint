/*
 * TCSS 305
 * Assignment 5 �C PowerPaint
 */

package tools;

import java.awt.Shape;
import java.awt.geom.Path2D;

/**
 * This is a class for pencil tool in this program.
 * 
 * @author Qing Bai
 * @version 21 February 2015
 */
public final class PencilTool implements Tool {
    
    /**
    * This is a path.
    */
    private final Path2D myPath;
    
    /**
     * This is a constructor of this class.
     */
    public PencilTool() {
        myPath = new Path2D.Double();
    }
    
    /**
     * This initializes this path with the given coordinates.
     * 
     * @param theX is x coordinate of start point of this path
     * @param theY is y coordinate of start point of this path
     */
    @Override
    public void start(final int theX, final int theY) {
        myPath.moveTo(theX, theY);
    }
    
    /**
     * This passes coordinates of current end point to this path.
     * 
     * @param theX is x coordinate of current end point of this path
     * @param theY is y coordinate of current end point of this path
     * @return a path ending with current end point
     */
    @Override
    public Shape drawing(final int theX, final int theY) {
        myPath.lineTo(theX, theY);
        return myPath; 
    }
    
    /**
     * This finalizes this path with the given coordinates.
     * 
     * @param theX is x coordinate of final end point of this path
     * @param theY is y coordinate of final end point of this path
     * @return the finished path
     */
    public Shape end(final int theX, final int theY) {
        myPath.lineTo(theX, theY);
        final Shape path = (Shape) myPath.clone();
        myPath.reset();
        return path;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "Pencil";
    }
}
