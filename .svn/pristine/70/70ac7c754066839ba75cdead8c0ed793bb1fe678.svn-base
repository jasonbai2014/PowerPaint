/*
 * TCSS 305
 * Assignment 5 ¨C PowerPaint
 */

package drawing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

/**
 * This is a class used to create a small icon for the color chooser. This class borrows 
 * the idea from http://www.codebeach.com/2007/06/creating-dynamic-icons-in-java.html
 * 
 * @author Qing Bai
 * @version 21 February 2015
 */
public final class ColorIcon implements Icon {
    
    /**
     * This is a default width of this icon.
     */
    public static final int WIDTH = 12;
    
    /**
     * This is a default height of this icon.
     */
    public static final int HEIGHT = 12;
    
    /**
     * This is the color of this icon.
     */
    private final Color myColor;
    
    /**
     * This constructor creates a small icon with the given color.
     * 
     * @param theColor is a given color for the icon
     */
    public ColorIcon(final Color theColor) {
        myColor = theColor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void paintIcon(final Component theComponent, final Graphics theGraphics,  
                          final int theX, final int theY) {
        theGraphics.setColor(myColor);
        theGraphics.fillRect(theX, theY, WIDTH - 1, HEIGHT - 1);
        
        theGraphics.setColor(Color.BLACK);
        theGraphics.drawRect(theX, theY, WIDTH - 1, HEIGHT - 1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getIconWidth() {
        return WIDTH;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getIconHeight() {
        return HEIGHT;
    }

}
