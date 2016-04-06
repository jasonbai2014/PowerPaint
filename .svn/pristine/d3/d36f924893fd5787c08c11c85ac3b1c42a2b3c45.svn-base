/*
 * TCSS 305
 * Assignment 5 ¨C PowerPaint
 */

package actions;

import gui.PowerPaintCanvas;

import java.awt.event.ActionEvent;
import java.util.Locale;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import tools.Tool;

/**
 * This action class is for all tool buttons.
 * 
 * @author Qing Bai
 * @version 21 February 2015
 */
@SuppressWarnings("serial")
public final class ToolAction extends AbstractAction {
    
    /**
     * This is the canvas.
     */
    private final PowerPaintCanvas myCanvas;
    
    /**
     * This is the tool for this action.
     */
    private final Tool myTool;
    
    /**
     * This creates an action instance with the given name of tool and tool for the canvas.
     * 
     * @param theCanvas is where this action functions
     * @param theTool is tool function this action has
     */
    public ToolAction(final PowerPaintCanvas theCanvas, final Tool theTool) {
        super();
        final String toolName = theTool.getName();
        final String imgLocation = "images/" + toolName.toLowerCase(Locale.US) + "_bw.gif";
        
        putValue(Action.NAME, toolName);
        putValue(Action.SMALL_ICON, new ImageIcon(imgLocation));
        putValue(Action.MNEMONIC_KEY, Integer.valueOf(toolName.charAt(0)));
        putValue(Action.SELECTED_KEY, true);
        myCanvas = theCanvas;
        myTool = theTool;
    }
    
    /**
     * This method assigns appropriate tool to the canvas.
     * 
     * @param theEvent is theEvent
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myCanvas.setCurrentTool(myTool);
    }
}
