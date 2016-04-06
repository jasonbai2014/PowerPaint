/*
 * TCSS 305
 * Assignment 5 ¨C PowerPaint
 */

package tools;

import java.awt.Shape;

/**
 * This is an interface for all drawing tools in this program.
 * 
 * @author Qing Bai
 * @version 21 February 2015
 */
public interface Tool {
    
    /**
     * This initializes a drawing with the given coordinates.
     * 
     * @param theX is x coordinate of start point of a drawing
     * @param theY is y coordinate of start point of a drawing
     */
    void start(final int theX, final int theY);
    
    /**
     * This passes coordinates of current end point to a drawing.
     * 
     * @param theX is x coordinate of current end point of a drawing
     * @param theY is y coordinate of current end point of a drawing
     * @return a drawing ending with current end point
     */
    Shape drawing(final int theX, final int theY);
    
    /**
     * This finalizes a drawing with the given coordinates.
     * 
     * @param theX is x coordinate of final end point of a drawing
     * @param theY is y coordinate of final end point of a drawing
     * @return the finished drawing
     */
    Shape end(final int theX, final int theY);
    
    /**
     * Returns name of this tool.
     * 
     * @return name of this tool.
     */
    String getName();
}
