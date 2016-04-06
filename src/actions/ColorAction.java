/*
 * TCSS 305
 * Assignment 5 ¨C PowerPaint
 */

package actions;

import drawing.ColorIcon;
import gui.PowerPaintCanvas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JColorChooser;

/**
 * This action class is for color chooser menu item.
 * 
 * @author Qing Bai
 * @version 21 February 2015
 */
@SuppressWarnings("serial")
public final class ColorAction extends AbstractAction {
    
    /**
     * This is the canvas.
     */
    private final PowerPaintCanvas myCanvas;
    
    /**
     * This constructor creates an action to change color of current drawing
     * on the canvas.
     * 
     * @param theCanvas is the canvas
     */
    public ColorAction(final PowerPaintCanvas theCanvas) {
        super("Color...", new ColorIcon(Color.BLACK));
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_C);
        myCanvas = theCanvas;
    }
    
    /**
     * This sets up the color used to draw on the canvas.
     * 
     * @param theEvent is the event
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        final Color currentColor = JColorChooser.showDialog(null, "Select a color", 
                                                            Color.BLACK);
        if (currentColor != null) {
            myCanvas.setCurrentColor(currentColor);
            putValue(Action.SMALL_ICON, new ColorIcon(currentColor));
        }
    }

}
