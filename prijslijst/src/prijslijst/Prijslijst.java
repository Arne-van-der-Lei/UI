/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prijslijst;

import database.DB;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import static prijslijst.Prijslijst.hallo;
import static prijslijst.Prijslijst.m;

/**
 *
 * @author arne.vanderlei
 */
public class Prijslijst {
    
    public static JMenu m; 
    public static Map<String,Float> hallo;
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Prijslijst.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Prijslijst.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Prijslijst.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Prijslijst.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        DB db = new DB();
        
        hallo = db.getString();
        
        JFrame frame = new JFrame();
        JPanel p = new JPanel(new GridLayout(1, 1));
        m = new JMenu("prijs: ");
        JMenuBar mb = new JMenuBar();
        JComboBox b = new JComboBox(new DefaultComboBoxModel(hallo.keySet().toArray()));
        b.addItemListener(new Prijslijst.Event());
        frame.setTitle("UIManager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 80);
        
        mb.add(m);
        p.add(b);
        frame.setJMenuBar(mb);
        frame.add(p);
        frame.setVisible(true);
    }
    
    public static class Event implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {
            m.setText( "prijs: " + hallo.get(e.getItem().toString()) + " euro");//ok
        }
        
    }
    
    
}
