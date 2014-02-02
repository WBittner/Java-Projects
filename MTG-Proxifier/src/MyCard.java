/**
 *
 * @author Will
 */
public class MyCard {
    public String name;
    public int cvc;
    public String color; 
    public MyPanel panel; 
    
    public MyCard(String n)
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