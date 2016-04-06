/*
 * TCSS 305
 * Assignment 5 ¨C PowerPaint
 */

package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This is a class used to create a option menu.
 * 
 * @author Qing Bai
 * @version 21 February 2015
 */
@SuppressWarnings("serial")
public final class PowerPaintOption extends JMenu {
    
    /**
     * This is major tick spacing of the slider bar.
     */
    public static final int MAJOR_TICK = 5;
    
    /**
     * This is minor tick spacing of the slider bar.
     */
    public static final int MINOR_TICK = 1;
    
    /**
     * This is the maximum value of the slider bar.
     */
    public static final int SLIDER_BAR_MAXIMUM_VALUE = 20;
    
    /**
     * This is the initial value of the slider bar.
     */
    public static final int SLIDER_BAR_INITIAL_VALUE = 1;
    
    /**
     * This is the canvas used in this program.
     */
    private final PowerPaintCanvas myCanvas;
    
    /**
     * This is a constructor used to create this menu.
     * 
     * @param theCanvas is the canvas used in this program
     */
    public PowerPaintOption(final PowerPaintCanvas theCanvas) {
        super("Options");
        setMnemonic(KeyEvent.VK_O);
        myCanvas = theCanvas;
        add(createCheckBox());
        add(createSliderBarMenu());
    }
    
    /**
     * This creates a menu item that contains a check box. The check box determines whether or
     * not grids will show on the canvas.
     * 
     * @return a menu item for check box
     */
    private JMenuItem createCheckBox() {
        final JMenuItem checkBox = new JCheckBoxMenuItem("Grid");
        checkBox.setMnemonic(KeyEvent.VK_G);
        checkBox.addActionListener(new ActionListener() {
            /**
             * This shows grids on the canvas.
             * 
             * @param theEvent is the event
             */
            public void actionPerformed(final ActionEvent theEvent) {
                myCanvas.setGridsVisible(checkBox.isSelected());
                myCanvas.repaint();
            }
        });
        
        return checkBox;
    }
    
    /**
     * This creates a menu that contains a slider bar. The slider bar determines line width of
     * drawings on the canvas.
     * 
     * @return a menu that contains a slider bar
     */
    private JMenu createSliderBarMenu() {
        final JMenu submenu = new JMenu("Thickness");
        submenu.setMnemonic(KeyEvent.VK_T);
        final JSlider slider = new JSlider(0, SLIDER_BAR_MAXIMUM_VALUE, 
                                           SLIDER_BAR_INITIAL_VALUE);
        slider.setMajorTickSpacing(MAJOR_TICK);
        slider.setMinorTickSpacing(MINOR_TICK);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);
        slider.addChangeListener(new ChangeListener() {
            /**
             * This steps up current line width for current drawing.
             * 
             * @param theEvent is the event
             */
            public void stateChanged(final ChangeEvent theEvent) {
                myCanvas.setCurrentLineWidth(slider.getValue());
            }
        });
        submenu.add(slider);
        
        return submenu;
    }
}
