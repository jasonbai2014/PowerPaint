/*
 * TCSS 305
 * Assignment 5 ¨C PowerPaint
 */

package gui;

import java.util.List;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 * This is a class used to create a tool bar for tools.
 * 
 * @author Qing Bai
 * @version 21 February 2015
 */
@SuppressWarnings("serial")
public final class PowerPaintToolBar extends JToolBar {
    
    /**
     * This is a constructor used to create this tool bar.
     * 
     * @param theActionsList is a list containing actions for tools
     */
    public PowerPaintToolBar(final List<Action> theActionsList) {
        super();
        addFunctionalTools(theActionsList);
    }
    
    /**
     * This creates and adds functional tools with the given actions to this tool bar.
     * 
     * @param theActionsList contains a list of actions for tools
     */
    private void addFunctionalTools(final List<Action> theActionsList) {
        final ButtonGroup buttonGroup = new ButtonGroup();
        
        for (final Action action : theActionsList) {
            final JToggleButton toolButton = new JToggleButton(action);
            buttonGroup.add(toolButton);
            add(toolButton);
        }
    }
}
