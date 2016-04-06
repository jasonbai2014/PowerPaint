/*
 * TCSS 305
 * Assignment 5 ¨C PowerPaint
 */

package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * This is a class used to create a file menu.
 * 
 * @author Qing Bai
 * @version 21 February 2015
 */
@SuppressWarnings("serial")
public final class PowerPaintFile extends JMenu {
    
    /**
     * This is the canvas used in this program.
     */
    private final PowerPaintCanvas myCanvas;
    
    /**
     * This is the frame used in this program.
     */
    private final JFrame myFrame;
    
    /**
     * This is the undo all changes menu item.
     */
    private final JMenuItem myUndoAllChanges;
    
    /**
     * This is the undo menu item.
     */
    private final JMenuItem myUndoChange;
    
    /**
     * This is the redo menu item.
     */
    private final JMenuItem myRedoChange;
    
    /**
     * This is the exit menu item.
     */
    private final JMenuItem myExit;
    
    
    /**
     * This is a constructor used to create this menu.
     * 
     * @param theCanvas is the canvas used in this program
     * @param theFrame is the frame used in this program
     */
    public PowerPaintFile(final PowerPaintCanvas theCanvas, final JFrame theFrame) {
        super("File");
        setMnemonic(KeyEvent.VK_F);
        myCanvas = theCanvas;
        myFrame = theFrame;
        myUndoAllChanges = new JMenuItem("Undo all changes", KeyEvent.VK_U);
        myUndoChange = new JMenuItem("Undo");
        myRedoChange = new JMenuItem("Redo");
        myExit = new JMenuItem("Exit", KeyEvent.VK_X);
        setup();
    }
    
    /**
     * This sets up the menu with functional menu items.
     */
    private void setup() {
        myUndoAllChanges.addActionListener(new UndoAllChangesListener());
        myUndoChange.addActionListener(new UndoChangeListener());
        myRedoChange.addActionListener(new RedoChangeListener());
        myExit.addActionListener(new ExitListener());
        
        myUndoChange.setEnabled(false);
        myUndoAllChanges.setEnabled(false);
        myRedoChange.setEnabled(false);
        
        myUndoChange.setAccelerator(KeyStroke.getKeyStroke("ctrl Z"));
        myRedoChange.setAccelerator(KeyStroke.getKeyStroke("ctrl Y"));
        
        add(myUndoAllChanges);
        add(myUndoChange);
        add(myRedoChange);
        addSeparator();
        add(myExit);
    }
    
    /**
     * This is an inner class for the listener of the undo all changes menu item.
     */
    private class UndoAllChangesListener implements ActionListener {
        /**
         * This allows the menu item to clear all drawings on the canvas.
         * 
         * @param theEvent is the event
         */
        public void actionPerformed(final ActionEvent theEvent) {
            myCanvas.clearCanvas();
            myUndoChange.setEnabled(false);
            myUndoAllChanges.setEnabled(false);
            myRedoChange.setEnabled(false);
        }
    }
    
    /**
     * This is an inner class for the listener of the undo menu item.
     */
    private class UndoChangeListener implements ActionListener {
        /**
         * This allows the menu item to undo one drawing.
         * 
         * @param theEvent is the event
         */
        public void actionPerformed(final ActionEvent theEvent) {
            myCanvas.undoChange();
            // checks if there are more drawings that can be undoed
            final boolean canUndo = myCanvas.isUndoable();
            myRedoChange.setEnabled(true);
            myUndoChange.setEnabled(canUndo);
            myUndoAllChanges.setEnabled(canUndo);
        }
    }
    
    /**
     * This is an inner class for the listener of the redo menu item.
     */
    private class RedoChangeListener implements ActionListener {
        /**
         * This allows the menu item to redo one drawing.
         * 
         * @param theEvent is the event
         */
        public void actionPerformed(final ActionEvent theEvent) {
            myCanvas.redoChange();
            myRedoChange.setEnabled(myCanvas.isRedoable());
            myUndoChange.setEnabled(true);
            myUndoAllChanges.setEnabled(true);
        }
    }
    
    /**
     * This is an inner class for the listener of the exit menu item.
     */
    private class ExitListener implements ActionListener {
        /**
         * This allows the menu item to close the window and exit the program.
         * 
         * @param theEvent is the event
         */
        public void actionPerformed(final ActionEvent theEvent) {
            myFrame.dispose();
        }
    }
}
