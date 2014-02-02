/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package draftsimulator;

import java.util.ArrayList;

import javax.swing.JPanel;



/**
 *
 * @author Will
 */
public class DraftSimulator {

    /**
     * @param args the command line arguments
     */
     DisplayPack dp1,dp2,dp3,dp4,dp5,dp6,dp7,dp8;
     static int numPacks;
     ThreePackSimulator tps;
             
    public DraftSimulator(ThreePackSimulator tp)
    {
        tps = tp;
        dp1 = new DisplayPack("Pack One",this);
        dp2 = new DisplayPack("Pack Two",this);
        dp3 = new DisplayPack("Pack Three",this);
        dp4 = new DisplayPack("Pack Four",this);
        dp5 = new DisplayPack("Pack Five",this);
        dp6 = new DisplayPack("Pack Six",this);
        dp7 = new DisplayPack("Pack Seven",this);
        dp8 = new DisplayPack("Pack Eight",this);
        
        dp1.f.setVisible(true);
    }
    public void switchPacks()
    {
        if(dp1.f.isVisible())
        {
            dp1.f.setVisible(false);
            removeCard(dp2.list,dp2.layout);
            removeCard(dp3.list,dp3.layout);
            removeCard(dp4.list,dp4.layout);
            removeCard(dp5.list,dp5.layout);
            removeCard(dp6.list,dp6.layout);
            removeCard(dp7.list,dp7.layout);
            removeCard(dp8.list,dp8.layout);
            dp2.f.setVisible(true);
        }
        else if(dp2.f.isVisible())
        {
            dp2.f.setVisible(false);
            removeCard(dp1.list,dp1.layout);
            removeCard(dp3.list,dp3.layout);
            removeCard(dp4.list,dp4.layout);
            removeCard(dp5.list,dp5.layout);
            removeCard(dp6.list,dp6.layout);
            removeCard(dp7.list,dp7.layout);
            removeCard(dp8.list,dp8.layout);
            dp3.f.setVisible(true);
        }
        else if(dp3.f.isVisible())
        {
            dp3.f.setVisible(false);
            removeCard(dp2.list,dp2.layout);
            removeCard(dp1.list,dp1.layout);
            removeCard(dp4.list,dp4.layout);
            removeCard(dp5.list,dp5.layout);
            removeCard(dp6.list,dp6.layout);
            removeCard(dp7.list,dp7.layout);
            removeCard(dp8.list,dp8.layout);
            dp4.f.setVisible(true);
        }
        else if(dp4.f.isVisible())
        {
            dp4.f.setVisible(false);
            removeCard(dp2.list,dp2.layout);
            removeCard(dp3.list,dp3.layout);
            removeCard(dp1.list,dp1.layout);
            removeCard(dp5.list,dp5.layout);
            removeCard(dp6.list,dp6.layout);
            removeCard(dp7.list,dp7.layout);
            removeCard(dp8.list,dp8.layout);
            dp5.f.setVisible(true);
        }
        else if(dp5.f.isVisible())
        {
            dp5.f.setVisible(false);
            removeCard(dp2.list,dp2.layout);
            removeCard(dp3.list,dp3.layout);
            removeCard(dp4.list,dp4.layout);
            removeCard(dp1.list,dp1.layout);
            removeCard(dp6.list,dp6.layout);
            removeCard(dp7.list,dp7.layout);
            removeCard(dp8.list,dp8.layout);
            dp6.f.setVisible(true);
        }    
        else if(dp6.f.isVisible())
        {
            dp6.f.setVisible(false);
            removeCard(dp2.list,dp2.layout);
            removeCard(dp3.list,dp3.layout);
            removeCard(dp4.list,dp4.layout);
            removeCard(dp5.list,dp5.layout);
            removeCard(dp1.list,dp1.layout);
            removeCard(dp7.list,dp7.layout);
            removeCard(dp8.list,dp8.layout);
            if(dp6.list.isEmpty())
            {
                addHand();  
            }
                
            else
                dp7.f.setVisible(true);
        }
        else if(dp7.f.isVisible())
        {
            dp7.f.setVisible(false);
            removeCard(dp2.list,dp2.layout);
            removeCard(dp3.list,dp3.layout);
            removeCard(dp4.list,dp4.layout);
            removeCard(dp5.list,dp5.layout);
            removeCard(dp6.list,dp6.layout);
            removeCard(dp1.list,dp1.layout);
            removeCard(dp8.list,dp8.layout);            
            dp8.f.setVisible(true);
        }
        else if(dp8.f.isVisible())
        {
            dp8.f.setVisible(false);
            removeCard(dp2.list,dp2.layout);
            removeCard(dp3.list,dp3.layout);
            removeCard(dp4.list,dp4.layout);
            removeCard(dp5.list,dp5.layout);
            removeCard(dp6.list,dp6.layout);
            removeCard(dp7.list,dp7.layout);
            removeCard(dp1.list,dp1.layout);
            dp1.f.setVisible(true);
        }
    }
    public void removeCard(ArrayList<Card> list,JPanel layout)
    {
        if(list.size()>10)
        {
            int i = list.size()-1;
            layout.remove(list.get(i).getPanel());
            list.remove(i);
            layout.repaint();
        }
            
        else if(list.size()>=1)
        {
            int i =(int) Math.random()*list.size();
            layout.remove(list.get(i).getPanel());
            list.remove(i);
            layout.repaint();
        }
    }
    public void addHand()
    {
        tps.deck.addAll(dp1.hand);
        tps.next();
    }
}
