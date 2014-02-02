/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package draftsimulator;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Will
 */
public class DisplayPack 
        implements MouseListener {
    ArrayList<Card> list;
    static ArrayList<Card> hand;
    JPanel layout;
    JFrame f;
    DraftSimulator ds;
    public DisplayPack(String n,DraftSimulator d)
    {
        f = new JFrame(n);
        ds = d;
        Container c = f.getContentPane();
        
        layout = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(0,0,0,10);
        
        AvacynList as = new AvacynList();
        list = as.getPack();     
        hand = new ArrayList<Card>();
        
        for(Card card:list)
        {
            JPanel p = card.getPanel();
            p.addMouseListener(this);
            layout.add(p,constraints);
        }
        //try{Thread.sleep(3000);}catch(Exception e){System.out.println(e);}
        c.add(new JScrollPane(layout));
        f.pack();
    }
    public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        public void mouseClicked(MouseEvent e) {
        try{
        for(Card card:list)
        {
            if(card.getPanel()==e.getSource())
                        {
                            list.remove(list.indexOf(card));
                            layout.remove(card.getPanel());
                            layout.repaint();
                            hand.add(card);
                            ds.switchPacks();
                        }
        }
        }catch(Exception error)
        {}
        }
}   