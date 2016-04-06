/*
 * TCSS 305
 * Assignment 5 �C PowerPaint
 */

package gui;

import drawing.CanvasDrawing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.JPanel;

import tools.PencilTool;
import tools.Tool;

/**
 * This class is used as canvas in this program.
 * 
 * @author Qing Bai
 * @version 21 February 2015
 */
@SuppressWarnings("serial")
public final class PowerPaintCanvas extends JPanel {
    
    /**
     * This is a default background color of this canvas.
     */
    private static final Color BACKGROUND_COLOR = Color.WHITE;
    
    /**
     * This is a preferred size of this canvas.
     */
    private static final Dimension PREFERRED_SIZE = new Dimension(400, 200);
    
    /**
     * This is grid spacing used for grids on this canvas.
     */
    private static final int GRID_SPACING = 10;
    
    /**
     * This shows whether or not this canvas has grids. If true, the canvas has grids.
     * Otherwise, it doesn't have grids.
     */
    private boolean myGridsVisible;
    
    /**
     * This is a line width used for current drawing.
     */
    private int myCurrentLineWidth;
    
    /**
     * This is a color used for current drawing.
     */
    private Color myCurrentColor;
    
    /**
     * This is a current drawing.
     */
    private Shape myCurrentDrawing;
    
    /**
     * This is used to indicate whether or not there is a current drawing ready for use.
     */
    private boolean myCurrentDrawingAvailable;
    
    /**
     * This is a tool used for current drawing.
     */
    private Tool myCurrentTool;
    
    /**
     * This contains all shapes removed from the canvas.
     */
    private Stack<CanvasDrawing> myRemovedDrawings;
    
    /**
     * This contains all shapes that have been drawn on this canvas.
     */
    private List<CanvasDrawing> myOldDrawings;

    /**
     * This is a constructor of this class.
     */
    public PowerPaintCanvas() {
        super();
        setBackground(BACKGROUND_COLOR);
        setPreferredSize(PREFERRED_SIZE);
        setup();
    }
    
    /**
     * This initializes all instance fields.
     */
    private void setup() {
        myOldDrawings = new ArrayList<CanvasDrawing>();
        myRemovedDrawings = new Stack<CanvasDrawing>();
        myGridsVisible = false;
        myCurrentDrawingAvailable = false;
        myCurrentDrawing = new Path2D.Double();
        myCurrentLineWidth = 1;
        myCurrentColor = Color.BLACK;
        myCurrentTool = new PencilTool();
    }
    
    /**
     * This method paints shapes and draws grids if applicable.
     * 
     * @param theGraphics is the graphics object used for painting.
     */
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D pen2D = (Graphics2D) theGraphics;
        pen2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                               RenderingHints.VALUE_ANTIALIAS_ON);
        final int size = myOldDrawings.size();
        
        for (int i = 0; i < size; i++) {
            final CanvasDrawing drawing = myOldDrawings.get(i);
            pen2D.setPaint(drawing.getColor());
            pen2D.setStroke(new BasicStroke(drawing.getLineWidth()));
            pen2D.draw(drawing.getShape());
        }
        
        // current drawing is always on top of other drawings
        if (myCurrentDrawingAvailable) {
            pen2D.setPaint(myCurrentColor);
            pen2D.setStroke(new BasicStroke(myCurrentLineWidth));
            pen2D.draw(myCurrentDrawing);
        }
        
        // grids is on top of all drawings
        if (myGridsVisible) {
            pen2D.setPaint(Color.GRAY);
            pen2D.setStroke(new BasicStroke(1));
            drawGrids(pen2D);
        }
    }
    
    /**
     * This method draws grids on this canvas.
     * 
     * @param theGraphics is the graphics object used for painting.
     */
    private void drawGrids(final Graphics2D theGraphics) {
        final Line2D line = new Line2D.Double();
        final int height = getHeight();
        final int width = getWidth();
        // draw horizontal lines
        for (int i = GRID_SPACING; i < height; i += GRID_SPACING) {
            line.setLine(0, i, width, i);
            theGraphics.draw(line);
        }
        // draw vertical lines
        for (int i = GRID_SPACING; i < width; i += GRID_SPACING) {
            line.setLine(i, 0, i, height);
            theGraphics.draw(line);
        }  
    }
    
    /**
     * This method adds the newest drawing to a collection that contains all previous drawings.
     * 
     * @param theCurrentShape is the newest shape drawn on this canvas
     */
    public void addToOldDrawing(final Shape theCurrentShape) {
        if (theCurrentShape != null && myCurrentLineWidth > 0 
            && !myCurrentColor.equals(Color.WHITE)) {
            myOldDrawings.add(new CanvasDrawing(theCurrentShape, myCurrentColor, 
                              myCurrentLineWidth));
            myCurrentDrawingAvailable = false;
        }
    }
    
    /**
     * This method undoes one drawing on this canvas.
     */
    public void undoChange() {
        if (isUndoable()) {
            final CanvasDrawing drawing = myOldDrawings.remove(myOldDrawings.size() - 1);
            myRemovedDrawings.push(drawing);
            repaint();
        }
    }
    
    /**
     * This method checks whether or not there are drawings that can be undoed.
     * 
     * @return true if there is at least one drawing. Otherwise, false
     */
    public boolean isUndoable() {
        return !myOldDrawings.isEmpty();
    }
    
    /**
     * This method redoes one drawing on this canvas.
     */
    public void redoChange() {
        if (isRedoable()) {
            final CanvasDrawing drawing = myRemovedDrawings.pop();
            myOldDrawings.add(drawing);
            repaint();
        }
    }
    
    /**
     * This method checks whether or not there are drawings that can be redoed.
     * 
     * @return true if there is at least one drawing. Otherwise, false
     */
    public boolean isRedoable() {
        return !myRemovedDrawings.isEmpty();
    }
    
    
    /**
     * This method removes all drawings on this canvas.
     */
    public void clearCanvas() {
        myOldDrawings.clear();
        myRemovedDrawings.clear();
        repaint();
    }
    
    /**
     * This one sets whether or not this canvas has grids. If true is passed in, this canvas
     * has grids. Otherwise, the canvas doesn't have grids.
     * 
     * @param theGridsVisible is a boolean value to determine if this canvas has grids or not
     */
    public void setGridsVisible(final boolean theGridsVisible) {
        myGridsVisible = theGridsVisible;
    }
    
    /**
     * This sets a current color used to draw on this canvas.
     * 
     * @param theColor is a given color for current drawing
     */
    public void setCurrentColor(final Color theColor) {
        // if no valid color is passed in, this canvas still uses previous color
        if (theColor != null) {
            myCurrentColor = theColor;
        }
    }
    
    /**
     * This sets a current line width used to draw on this canvas.
     * 
     * @param theCurrentLineWidth is a given line width for current drawing
     */
    public void setCurrentLineWidth(final int theCurrentLineWidth) {
        myCurrentLineWidth = theCurrentLineWidth;
    }
    
    /**
     * This sets a current drawing to this canvas.
     * 
     * @param theCurrentDrawing is current drawing
     */
    public void setCurrentDrawing(final Shape theCurrentDrawing) {
        if (theCurrentDrawing != null && myCurrentLineWidth > 0
            && !myCurrentColor.equals(Color.WHITE)) {
            myCurrentDrawing = theCurrentDrawing;
            myCurrentDrawingAvailable = true;
        }
    }
    
    /**
     * This sets a current tool to this canvas.
     * 
     * @param theTool is the tool for current drawing
     */
    public void setCurrentTool(final Tool theTool) {
        myCurrentTool = theTool;
    }
    
    /**
     * This returns current tool.
     * 
     * @return current tool
     */
    public Tool getCurrentTool() {
        return myCurrentTool;
    }
}
