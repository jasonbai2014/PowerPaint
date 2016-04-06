/*
 * TCSS 305
 * Assignment 5 ¨C PowerPaint
 */

package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * This is a class used to create a help menu.
 * 
 * @author Qing Bai
 * @version 21 February 2015
 */
@SuppressWarnings("serial")
public final class PowerPaintHelp extends JMenu {
    
    /**
     * This is a constructor used to create this menu.
     */
    public PowerPaintHelp() {
        super("Help");
        setMnemonic(KeyEvent.VK_H);
        add(createAbout());
    }
    
    /**
     * This creates a menu item showing information about this program.
     * 
     * @return a menu item for about
     */
    private JMenuItem createAbout() {
        final JMenuItem about = new JMenuItem("About...", KeyEvent.VK_A);
        
        about.addActionListener(new ActionListener() {
            /**
             * This shows a message dialog.
             * 
             * @param theEvent is the event
             */
            public void actionPerformed(final ActionEvent theEvent) {
                JOptionPane.showMessageDialog(null, "TCSS 305 PowerPaint Winter 2015", "About",
                                              JOptionPane.INFORMATION_MESSAGE, 
                                              new ImageIcon("images/w.png"));
            }
        });
        
        return about;
    }
}
