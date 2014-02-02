/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package draftsimulator;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author William
 */
public class ThreePackSimulator {
    
     public ArrayList<Card> deck;
     
     public static void main(String args[])
     {
         ThreePackSimulator tps = new ThreePackSimulator();
         tps.next();
     }
     
     public ThreePackSimulator()
     {
         deck = new ArrayList<Card>();
     }
     
     public void next()
    {
        if(deck.isEmpty())
        {
            JOptionPane.showMessageDialog(new JFrame("Loading"),"Loading first pack!");
            new DraftSimulator(this);
        }
        /*else if(deck.size()==14)
        {
            JOptionPane.showMessageDialog(new JFrame("Loading"),"Loading second pack!");
            new DraftSimulator(this);
        }
        else if(deck.size()==28)
        {
            JOptionPane.showMessageDialog(new JFrame("Loading"),"Loading last pack!");
            new DraftSimulator(this);
        }*/
        else
        {
            JOptionPane.showMessageDialog(new JFrame("Loading"),"Loading deck!");
            JFrame frame = new JFrame("Deck");
            frame.setPreferredSize(new Dimension(400,600));
            frame.setLayout(new BorderLayout());
            //Container c = frame.getContentPane();
            /*JPanel layout = new JPanel(new GridBagLayout());
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.insets = new Insets(0,0,0,10);
            for(Card card:deck)
            {
                JPanel p = card.getPanel();
                layout.add(p,constraints);
            }
            c.add(new JScrollPane(layout));
            frame.setVisible(true);
            frame.pack();*/
            JLayeredPane layeredPane = new JLayeredPane();
            layeredPane.setBounds(0,0,400,600);
            int x = 0;
            for(Card card:deck)
            {
            	layeredPane.add(card.getPanel(),new Integer(x+1),x+1);
            }
            frame.add(layeredPane, BorderLayout.CENTER);
            frame.setVisible(true);
            frame.pack();
        }
            
    }
}
