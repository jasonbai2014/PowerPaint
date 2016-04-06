/*
 * TCSS 305
 * Assignment 5 ¨C PowerPaint
 */

package gui;

import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

/**
 * This is a class used to create a tool menu.
 * 
 * @author Qing Bai
 * @version 21 February 2015
 */
@SuppressWarnings("serial")
public final class PowerPaintToolMenu extends JMenu {
    
    /**
     * This is a constructor used to create this menu.
     * 
     * @param theActionsList is a list containing actions for tools
     */
    public PowerPaintToolMenu(final List<Action> theActionsList) {
        super("Tools");
        setMnemonic(KeyEvent.VK_T);
        addFunctionalTools(theActionsList);
    }
    
    /**
     * This creates and adds functional tools with the given actions to this menu.
     * 
     * @param theActionsList contains a list of actions for tools
     */
    private void addFunctionalTools(final List<Action> theActionsList) {
        final ButtonGroup buttonGroup = new ButtonGroup();
        
        for (final Action action : theActionsList) {
            final JMenuItem item = new JRadioButtonMenuItem(action);
            buttonGroup.add(item);
            add(item);
        }  
    }
}
