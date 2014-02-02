/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package draftsimulator;

/**
 *
 * @author Will
 */
public class Card {
    public String name;
    public int cvc;
    public String color; 
    public MyPanel panel; 
    
    /*public Card(String n)
    {
        String s=n.trim();
        if(s.indexOf(" ")!=-1)
            s = s.replaceAll(" ","_");
       
        name = s;
        panel = new MyPanel(this);
    }*/
    
    public Card(String n)
    {
        String s=n.trim();
        if(s.indexOf(" ")!=-1)
            s = s.replaceAll(" ","_");
        int breaker = s.indexOf("-");
        String a = s.substring(0,breaker);
        name = a;
        s = s.substring(breaker+1); 
        a = s.substring(0,1);
        cvc = Integer.parseInt(a);
        s = s.substring(1);
        color = s;
        
        panel = new MyPanel(this);
    }
    public MyPanel getPanel()
    {
        return panel;
    }
    public String getName()
    {
        return name;
    }
    public String toString()
    {
        return "Name: " + name + ".";
    }
}



//4800120258040823 8/13 361 